/**
 * This file is part of SADL, a library for learning Probabilistic deterministic timed-transition Automata.
 * Copyright (C) 2013-2015  the original author or authors.
 *
 * SADL is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * SADL is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with SADL.  If not, see <http://www.gnu.org/licenses/>.
 */

package sadl.run.smac;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sadl.constants.AnomalyInsertionType;
import sadl.input.TimedInput;
import sadl.input.TimedWord;
import sadl.models.TauPTA;
import sadl.utils.MasterSeed;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 * 
 * @author Timo Klerx
 *
 */
public class SmacDataGenerator implements Serializable {
	private static Logger logger = LoggerFactory.getLogger(SmacDataGenerator.class);

	/**
	 * 
	 */
	private static final long serialVersionUID = -6230657726489919272L;

	// just for parsing the one silly smac parameter
	@Parameter()
	private final List<String> rest = new ArrayList<>();

	String dataString;

	Path outputDir = Paths.get("output");
	private static final double ANOMALY_PERCENTAGE = 0.1;
	private static final int TRAIN_SIZE = 10000;
	private static final int TEST_SIZE = 5000;

	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		final SmacDataGenerator sp = new SmacDataGenerator();
		new JCommander(sp, args);
		sp.dataString = args[0];
		logger.info("Running {} with args={}", sp.getClass().getSimpleName(), Arrays.toString(args));
		sp.run();
	}

	private void run() throws IOException, InterruptedException {
		if (Files.notExists(outputDir)) {
			Files.createDirectories(outputDir);
		}
		Files.walk(outputDir).filter(p -> !Files.isDirectory(p)).forEach(p -> {
			try {
				logger.info("Deleting file {}", p);
				Files.delete(p);
			} catch (final Exception e) {
				e.printStackTrace();
			}
		});
		int k = 0;
		// parse timed sequences
		final TimedInput trainingTimedSequences = TimedInput.parseAlt(Paths.get(dataString), 1);
		final Random r = MasterSeed.nextRandom();
		final List<TimedWord> trainSequences = new ArrayList<>();
		final List<TimedWord> testSequences = new ArrayList<>();
		final TauPTA pta = new TauPTA(trainingTimedSequences);
		final DecimalFormat df = new DecimalFormat("00");
		logger.info("Finished TauPTA creation.");
		while (k < 100) {
			for (final AnomalyInsertionType type : AnomalyInsertionType.values()) {
				if (type != AnomalyInsertionType.NONE && type != AnomalyInsertionType.ALL) {
					final TauPTA anomaly = SerializationUtils.clone(pta);
					logger.info("inserting Anomaly Type {}", type);
					anomaly.makeAbnormal(type);
					for (int i = 0; i < TRAIN_SIZE; i++) {
						trainSequences.add(pta.sampleSequence());
					}
					// PTAs of Type 2 and 4 always produce abnormal sequences
					// it is possible to sample abnormal and normal sequences with abnormal ptas of the other types (1,3,5).
					// but I don't know how the distribution is so to be fair, i sample all anomalies the same
					for (int i = 0; i < TEST_SIZE; i++) {
						if (r.nextDouble() < ANOMALY_PERCENTAGE) {
							boolean wasAnormal = false;
							TimedWord seq = null;
							while (!wasAnormal) {
								seq = anomaly.sampleSequence();
								wasAnormal = seq.isAnomaly();
							}
							testSequences.add(seq);
						} else {
							testSequences.add(pta.sampleSequence());
						}
					}
					final TimedInput trainset = new TimedInput(trainSequences);
					final TimedInput testset = new TimedInput(testSequences);
					final Path outputFile = outputDir.resolve(Paths.get(df.format(k) + "_smac_mix_type" + type.getTypeIndex() + ".txt"));
					final BufferedWriter bw = Files.newBufferedWriter(outputFile, StandardCharsets.UTF_8);
					trainset.toFile(bw, true);
					bw.write('\n');
					bw.write("?????????????????????????");
					bw.write('\n');
					testset.toFile(bw, true);
					bw.close();
					logger.info("Wrote file #{} ({})", k, outputFile);
					k++;
				}
			}
		}
	}

}
