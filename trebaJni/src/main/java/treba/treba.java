/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package treba;

public class treba implements trebaConstants {
	public static void setFsm_counts(final SWIGTYPE_p_double value) {
		trebaJNI.fsm_counts_set(SWIGTYPE_p_double.getCPtr(value));
	}

	public static SWIGTYPE_p_double getFsm_counts() {
		final long cPtr = trebaJNI.fsm_counts_get();
		return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
	}

	public static void setFsm_totalcounts(final SWIGTYPE_p_double value) {
		trebaJNI.fsm_totalcounts_set(SWIGTYPE_p_double.getCPtr(value));
	}

	public static SWIGTYPE_p_double getFsm_totalcounts() {
		final long cPtr = trebaJNI.fsm_totalcounts_get();
		return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
	}

	public static void setFsm_finalcounts(final SWIGTYPE_p_double value) {
		trebaJNI.fsm_finalcounts_set(SWIGTYPE_p_double.getCPtr(value));
	}

	public static SWIGTYPE_p_double getFsm_finalcounts() {
		final long cPtr = trebaJNI.fsm_finalcounts_get();
		return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
	}

	public static void setFsm_counts_spin(final SWIGTYPE_p__Bool value) {
		trebaJNI.fsm_counts_spin_set(SWIGTYPE_p__Bool.getCPtr(value));
	}

	public static SWIGTYPE_p__Bool getFsm_counts_spin() {
		final long cPtr = trebaJNI.fsm_counts_spin_get();
		return (cPtr == 0) ? null : new SWIGTYPE_p__Bool(cPtr, false);
	}

	public static void setHmm_counts_trans(final SWIGTYPE_p_double value) {
		trebaJNI.hmm_counts_trans_set(SWIGTYPE_p_double.getCPtr(value));
	}

	public static SWIGTYPE_p_double getHmm_counts_trans() {
		final long cPtr = trebaJNI.hmm_counts_trans_get();
		return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
	}

	public static void setHmm_counts_emit(final SWIGTYPE_p_double value) {
		trebaJNI.hmm_counts_emit_set(SWIGTYPE_p_double.getCPtr(value));
	}

	public static SWIGTYPE_p_double getHmm_counts_emit() {
		final long cPtr = trebaJNI.hmm_counts_emit_get();
		return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
	}

	public static void setHmm_totalcounts_trans(final SWIGTYPE_p_double value) {
		trebaJNI.hmm_totalcounts_trans_set(SWIGTYPE_p_double.getCPtr(value));
	}

	public static SWIGTYPE_p_double getHmm_totalcounts_trans() {
		final long cPtr = trebaJNI.hmm_totalcounts_trans_get();
		return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
	}

	public static void setHmm_totalcounts_emit(final SWIGTYPE_p_double value) {
		trebaJNI.hmm_totalcounts_emit_set(SWIGTYPE_p_double.getCPtr(value));
	}

	public static SWIGTYPE_p_double getHmm_totalcounts_emit() {
		final long cPtr = trebaJNI.hmm_totalcounts_emit_get();
		return (cPtr == 0) ? null : new SWIGTYPE_p_double(cPtr, false);
	}

	public static void setHmm_counts_spin(final SWIGTYPE_p__Bool value) {
		trebaJNI.hmm_counts_spin_set(SWIGTYPE_p__Bool.getCPtr(value));
	}

	public static SWIGTYPE_p__Bool getHmm_counts_spin() {
		final long cPtr = trebaJNI.hmm_counts_spin_get();
		return (cPtr == 0) ? null : new SWIGTYPE_p__Bool(cPtr, false);
	}

	public static void setG_obsarray(final observations value) {
		trebaJNI.g_obsarray_set(observations.getCPtr(value), value);
	}

	public static observations getG_obsarray() {
		final long cPtr = trebaJNI.g_obsarray_get();
		return (cPtr == 0) ? null : new observations(cPtr, false);
	}

	public static double output_convert(final double x) {
		return trebaJNI.output_convert(x);
	}

	public static double input_convert(final double x) {
		return trebaJNI.input_convert(x);
	}

	public static String file_to_mem(final String name) {
		return trebaJNI.file_to_mem(name);
	}

	public static int char_in_array(final char c, final String array) {
		return trebaJNI.char_in_array(c, array);
	}

	public static int line_count_elements(final SWIGTYPE_p_p_char ptr) {
		return trebaJNI.line_count_elements(SWIGTYPE_p_p_char.getCPtr(ptr));
	}

	public static String line_to_int_array(final String ptr, final SWIGTYPE_p_p_int line, final SWIGTYPE_p_int size) {
		return trebaJNI.line_to_int_array(ptr, SWIGTYPE_p_p_int.getCPtr(line), SWIGTYPE_p_int.getCPtr(size));
	}

	public static void hmm_print(final hmm hmm) {
		trebaJNI.hmm_print(hmm.getCPtr(hmm), hmm);
	}

	public static hmm hmm_init(final int num_states, final int alphabet_size) {
		final long cPtr = trebaJNI.hmm_init(num_states, alphabet_size);
		return (cPtr == 0) ? null : new hmm(cPtr, false);
	}

	public static void hmm_destroy(final hmm hmm) {
		trebaJNI.hmm_destroy(hmm.getCPtr(hmm), hmm);
	}

	public static void hmm_randomize(final hmm hmm, final int bakis, final int uniform) {
		trebaJNI.hmm_randomize(hmm.getCPtr(hmm), hmm, bakis, uniform);
	}

	public static void hmm_to_log2(final hmm hmm) {
		trebaJNI.hmm_to_log2(hmm.getCPtr(hmm), hmm);
	}

	public static hmm hmm_read_file(final String filename) {
		final long cPtr = trebaJNI.hmm_read_file(filename);
		return (cPtr == 0) ? null : new hmm(cPtr, false);
	}

	public static double train_viterbi_bw_hmm(final hmm hmm, final observations o) {
		return trebaJNI.train_viterbi_bw_hmm(hmm.getCPtr(hmm), hmm, observations.getCPtr(o), o);
	}

	public static double train_viterbi_hmm(final hmm hmm, final observations o, final int maxiterations, final double maxdelta) {
		return trebaJNI.train_viterbi_hmm(hmm.getCPtr(hmm), hmm, observations.getCPtr(o), o, maxiterations, maxdelta);
	}

	public static void viterbi_hmm(final hmm hmm, final observations o, final int algorithm) {
		trebaJNI.viterbi_hmm(hmm.getCPtr(hmm), hmm, observations.getCPtr(o), o, algorithm);
	}

	public static void generate_words_hmm(final hmm hmm, final int numwords) {
		trebaJNI.generate_words_hmm(hmm.getCPtr(hmm), hmm, numwords);
	}

	public static double train_bw_hmm(final hmm hmm, final observations o, final int maxiterations, final double maxdelta) {
		return trebaJNI.train_bw_hmm(hmm.getCPtr(hmm), hmm, observations.getCPtr(o), o, maxiterations, maxdelta);
	}

	public static double gibbs_sampler_fsm(final wfsa fsm, final observations o, final double beta, final int num_states, final int maxiter, final int burnin,
			final int lag) {
		return trebaJNI.gibbs_sampler_fsm(wfsa.getCPtr(fsm), fsm, observations.getCPtr(o), o, beta, num_states, maxiter, burnin, lag);
	}

	public static double gibbs_sampler_hmm(final hmm hmm, final observations o, final double beta_e, final double beta_t, final int num_states,
			final int maxiter, final int burnin, final int lag) {
		return trebaJNI.gibbs_sampler_hmm(hmm.getCPtr(hmm), hmm, observations.getCPtr(o), o, beta_e, beta_t, num_states, maxiter, burnin, lag);
	}

	public static hmm gibbs_counts_to_hmm(final hmm hmm, final SWIGTYPE_p_unsigned_int gibbs_sampled_counts_trans,
			final SWIGTYPE_p_unsigned_int gibbs_sampled_counts_emit, final SWIGTYPE_p_unsigned_int gibbs_counts_sampled_states, final int alphabet_size,
			final int num_states, final double beta_t, final double beta_e) {
		final long cPtr = trebaJNI.gibbs_counts_to_hmm(hmm.getCPtr(hmm), hmm, SWIGTYPE_p_unsigned_int.getCPtr(gibbs_sampled_counts_trans),
				SWIGTYPE_p_unsigned_int.getCPtr(gibbs_sampled_counts_emit), SWIGTYPE_p_unsigned_int.getCPtr(gibbs_counts_sampled_states), alphabet_size,
				num_states, beta_t, beta_e);
		return (cPtr == 0) ? null : new hmm(cPtr, false);
	}

	public static wfsa gibbs_counts_to_wfsa(final wfsa fsm, final SWIGTYPE_p_unsigned_int gibbs_sampled_counts,
			final SWIGTYPE_p_unsigned_int gibbs_counts_sampled_states, final int alphabet_size, final int num_states, final double beta, final double ANbeta) {
		final long cPtr = trebaJNI.gibbs_counts_to_wfsa(wfsa.getCPtr(fsm), fsm, SWIGTYPE_p_unsigned_int.getCPtr(gibbs_sampled_counts),
				SWIGTYPE_p_unsigned_int.getCPtr(gibbs_counts_sampled_states), alphabet_size, num_states, beta, ANbeta);
		return (cPtr == 0) ? null : new wfsa(cPtr, false);
	}

	public static gibbs_state_chain gibbs_init_fsm(final observations o, final int num_states, final int alphabet_size, final SWIGTYPE_p_int obslen) {
		final long cPtr = trebaJNI.gibbs_init_fsm(observations.getCPtr(o), o, num_states, alphabet_size, SWIGTYPE_p_int.getCPtr(obslen));
		return (cPtr == 0) ? null : new gibbs_state_chain(cPtr, false);
	}

	public static gibbs_state_chain gibbs_init_hmm(final observations o, final int num_states, final int alphabet_size, final SWIGTYPE_p_int obslen) {
		final long cPtr = trebaJNI.gibbs_init_hmm(observations.getCPtr(o), o, num_states, alphabet_size, SWIGTYPE_p_int.getCPtr(obslen));
		return (cPtr == 0) ? null : new gibbs_state_chain(cPtr, false);
	}

	public static void interrupt_sigproc() {
		trebaJNI.interrupt_sigproc();
	}

	public static void spinlock_lock(final SWIGTYPE_p__Bool ptr) {
		trebaJNI.spinlock_lock(SWIGTYPE_p__Bool.getCPtr(ptr));
	}

	public static void spinlock_unlock(final SWIGTYPE_p__Bool ptr) {
		trebaJNI.spinlock_unlock(SWIGTYPE_p__Bool.getCPtr(ptr));
	}

	public static double rand_double() {
		return trebaJNI.rand_double();
	}

	public static int rand_int_range(final int from, final int to) {
		return trebaJNI.rand_int_range(from, to);
	}

	public static wfsa wfsa_read_file(final String filename) {
		final long cPtr = trebaJNI.wfsa_read_file(filename);
		return (cPtr == 0) ? null : new wfsa(cPtr, false);
	}

	public static void wfsa_print(final wfsa fsm) {
		trebaJNI.wfsa_print(wfsa.getCPtr(fsm), fsm);
	}

	public static void wfsa_to_file(final wfsa fsm, final String filename) {
		trebaJNI.wfsa_to_file(wfsa.getCPtr(fsm), fsm, filename);
	}

	public static void wfsa_randomize_deterministic(final wfsa fsm, final int uniform) {
		trebaJNI.wfsa_randomize_deterministic(wfsa.getCPtr(fsm), fsm, uniform);
	}

	public static void wfsa_randomize_nondeterministic(final wfsa fsm, final int bakis, final int uniform) {
		trebaJNI.wfsa_randomize_nondeterministic(wfsa.getCPtr(fsm), fsm, bakis, uniform);
	}

	public static wfsa wfsa_init(final int num_states, final int alphabet_size) {
		final long cPtr = trebaJNI.wfsa_init(num_states, alphabet_size);
		return (cPtr == 0) ? null : new wfsa(cPtr, false);
	}

	public static wfsa wfsa_copy(final wfsa fsm) {
		final long cPtr = trebaJNI.wfsa_copy(wfsa.getCPtr(fsm), fsm);
		return (cPtr == 0) ? null : new wfsa(cPtr, false);
	}

	public static void wfsa_destroy(final wfsa fsm) {
		trebaJNI.wfsa_destroy(wfsa.getCPtr(fsm), fsm);
	}

	public static void wfsa_to_log2(final wfsa fsm) {
		trebaJNI.wfsa_to_log2(wfsa.getCPtr(fsm), fsm);
	}

	public static double wfsa_sum_prob(final wfsa fsm, final int state) {
		return trebaJNI.wfsa_sum_prob(wfsa.getCPtr(fsm), fsm, state);
	}

	public static int wfsa_random_transition(final wfsa fsm, final int state, final SWIGTYPE_p_int symbol, final SWIGTYPE_p_double prob) {
		return trebaJNI.wfsa_random_transition(wfsa.getCPtr(fsm), fsm, state, SWIGTYPE_p_int.getCPtr(symbol), SWIGTYPE_p_double.getCPtr(prob));
	}

	public static void generate_words(final wfsa fsm, final int numwords) {
		trebaJNI.generate_words(wfsa.getCPtr(fsm), fsm, numwords);
	}

	public static int obssortcmp(final SWIGTYPE_p_p_observations a, final SWIGTYPE_p_p_observations b) {
		return trebaJNI.obssortcmp(SWIGTYPE_p_p_observations.getCPtr(a), SWIGTYPE_p_p_observations.getCPtr(b));
	}

	public static int observations_alphabet_size(final observations ohead) {
		return trebaJNI.observations_alphabet_size(observations.getCPtr(ohead), ohead);
	}

	public static SWIGTYPE_p_p_observations observations_to_array(final observations ohead, final SWIGTYPE_p_int numobs) {
		final long cPtr = trebaJNI.observations_to_array(observations.getCPtr(ohead), ohead, SWIGTYPE_p_int.getCPtr(numobs));
		return (cPtr == 0) ? null : new SWIGTYPE_p_p_observations(cPtr, false);
	}

	public static observations observations_uniq(final observations ohead) {
		final long cPtr = trebaJNI.observations_uniq(observations.getCPtr(ohead), ohead);
		return (cPtr == 0) ? null : new observations(cPtr, false);
	}

	public static observations observations_sort(final observations ohead) {
		final long cPtr = trebaJNI.observations_sort(observations.getCPtr(ohead), ohead);
		return (cPtr == 0) ? null : new observations(cPtr, false);
	}

	public static void observations_destroy(final observations ohead) {
		trebaJNI.observations_destroy(observations.getCPtr(ohead), ohead);
	}

	public static observations observations_read(final String filename) {
		final long cPtr = trebaJNI.observations_read(filename);
		return (cPtr == 0) ? null : new observations(cPtr, false);
	}

	public static double loglikelihood_all_observations_fsm(final wfsa fsm, final observations o) {
		return trebaJNI.loglikelihood_all_observations_fsm(wfsa.getCPtr(fsm), fsm, observations.getCPtr(o), o);
	}

	public static double loglikelihood_all_observations_hmm(final hmm hmm, final observations o) {
		return trebaJNI.loglikelihood_all_observations_hmm(hmm.getCPtr(hmm), hmm, observations.getCPtr(o), o);
	}

	public static double trellis_backward(final trellis trellis, final SWIGTYPE_p_int obs, final int length, final wfsa fsm) {
		return trebaJNI.trellis_backward(trellis.getCPtr(trellis), trellis, SWIGTYPE_p_int.getCPtr(obs), length, wfsa.getCPtr(fsm), fsm);
	}

	public static double trellis_viterbi(final trellis trellis, final SWIGTYPE_p_int obs, final int length, final wfsa fsm) {
		return trebaJNI.trellis_viterbi(trellis.getCPtr(trellis), trellis, SWIGTYPE_p_int.getCPtr(obs), length, wfsa.getCPtr(fsm), fsm);
	}

	public static double trellis_forward_fsm(final trellis trellis, final SWIGTYPE_p_int obs, final int length, final wfsa fsm) {
		return trebaJNI.trellis_forward_fsm(trellis.getCPtr(trellis), trellis, SWIGTYPE_p_int.getCPtr(obs), length, wfsa.getCPtr(fsm), fsm);
	}

	public static double trellis_forward_hmm(final trellis trellis, final SWIGTYPE_p_int obs, final int length, final hmm hmm) {
		return trebaJNI.trellis_forward_hmm(trellis.getCPtr(trellis), trellis, SWIGTYPE_p_int.getCPtr(obs), length, hmm.getCPtr(hmm), hmm);
	}

	public static trellis trellis_init(final observations o, final int num_states) {
		final long cPtr = trebaJNI.trellis_init(observations.getCPtr(o), o, num_states);
		return (cPtr == 0) ? null : new trellis(cPtr, false);
	}

	public static void trellis_print(final trellis trellis, final wfsa fsm, final int obs_len) {
		trebaJNI.trellis_print(trellis.getCPtr(trellis), trellis, wfsa.getCPtr(fsm), fsm, obs_len);
	}

	public static void forward_print_path(final trellis trellis, final wfsa fsm, final int obs_len) {
		trebaJNI.forward_print_path(trellis.getCPtr(trellis), trellis, wfsa.getCPtr(fsm), fsm, obs_len);
	}

	public static void backward_print_path(final trellis trellis, final wfsa fsm, final int obs_len) {
		trebaJNI.backward_print_path(trellis.getCPtr(trellis), trellis, wfsa.getCPtr(fsm), fsm, obs_len);
	}

	public static void viterbi_print_path(final trellis trellis, final wfsa fsm, final int obs_len) {
		trebaJNI.viterbi_print_path(trellis.getCPtr(trellis), trellis, wfsa.getCPtr(fsm), fsm, obs_len);
	}

	public static void viterbi(final wfsa fsm, final observations o, final int algorithm) {
		trebaJNI.viterbi(wfsa.getCPtr(fsm), fsm, observations.getCPtr(o), o, algorithm);
	}

	public static void forward_fsm(final wfsa fsm, final observations o, final int algorithm) {
		trebaJNI.forward_fsm(wfsa.getCPtr(fsm), fsm, observations.getCPtr(o), o, algorithm);
	}

	public static void forward_fsm_to_file(final wfsa fsm, final observations o, final int algorithm, final String filename) {
		trebaJNI.forward_fsm_to_file(wfsa.getCPtr(fsm), fsm, observations.getCPtr(o), o, algorithm, filename);
	}

	public static void forward_hmm(final hmm hmm, final observations o, final int algorithm) {
		trebaJNI.forward_hmm(hmm.getCPtr(hmm), hmm, observations.getCPtr(o), o, algorithm);
	}

	public static void backward_fsm(final wfsa fsm, final observations o, final int algorithm) {
		trebaJNI.backward_fsm(wfsa.getCPtr(fsm), fsm, observations.getCPtr(o), o, algorithm);
	}

	public static void backward_hmm(final hmm hmm, final observations o, final int algorithm) {
		trebaJNI.backward_hmm(hmm.getCPtr(hmm), hmm, observations.getCPtr(o), o, algorithm);
	}

	public static double train_viterbi(final wfsa fsm, final observations o, final int maxiterations, final double maxdelta) {
		return trebaJNI.train_viterbi(wfsa.getCPtr(fsm), fsm, observations.getCPtr(o), o, maxiterations, maxdelta);
	}

	public static double train_baum_welch(final wfsa fsm, final observations o, final int maxiterations, final double maxdelta, final int vb) {
		return trebaJNI.train_baum_welch(wfsa.getCPtr(fsm), fsm, observations.getCPtr(o), o, maxiterations, maxdelta, vb);
	}

	public static double train_bw(final wfsa fsm, final observations o, final int maxiterations, final double maxdelta) {
		return trebaJNI.train_bw(wfsa.getCPtr(fsm), fsm, observations.getCPtr(o), o, maxiterations, maxdelta);
	}

	public static double train_viterbi_bw(final wfsa fsm, final observations o) {
		return trebaJNI.train_viterbi_bw(wfsa.getCPtr(fsm), fsm, observations.getCPtr(o), o);
	}

	public static SWIGTYPE_p_void trellis_fill_bw(final SWIGTYPE_p_void threadargs) {
		final long cPtr = trebaJNI.trellis_fill_bw(SWIGTYPE_p_void.getCPtr(threadargs));
		return (cPtr == 0) ? null : new SWIGTYPE_p_void(cPtr, false);
	}

	public static int main(final int argc, final SWIGTYPE_p_p_char argv) {
		return trebaJNI.main(argc, SWIGTYPE_p_p_char.getCPtr(argv));
	}

	public static wfsa dffa_to_wfsa(final dffa dffa) {
		final long cPtr = trebaJNI.dffa_to_wfsa(dffa.getCPtr(dffa), dffa);
		return (cPtr == 0) ? null : new wfsa(cPtr, false);
	}

	public static dffa dffa_state_merge(final observations o, final double alpha, final int test, final int recursive) {
		final long cPtr = trebaJNI.dffa_state_merge(observations.getCPtr(o), o, alpha, test, recursive);
		return (cPtr == 0) ? null : new dffa(cPtr, false);
	}

	public static dffa dffa_mdi(final observations o, final double alpha) {
		final long cPtr = trebaJNI.dffa_mdi(observations.getCPtr(o), o, alpha);
		return (cPtr == 0) ? null : new dffa(cPtr, false);
	}

	public static dffa observations_to_dffa(final observations o) {
		final long cPtr = trebaJNI.observations_to_dffa(observations.getCPtr(o), o);
		return (cPtr == 0) ? null : new dffa(cPtr, false);
	}

	public static dffa dffa_init(final int num_states, final int alphabet_size) {
		final long cPtr = trebaJNI.dffa_init(num_states, alphabet_size);
		return (cPtr == 0) ? null : new dffa(cPtr, false);
	}

	public static int dffa_chi2_test(final dffa dffa, final int qu, final int qv, final double alpha) {
		return trebaJNI.dffa_chi2_test(dffa.getCPtr(dffa), dffa, qu, qv, alpha);
	}

	public static void log1plus_taylor_init_wrapper() {
		trebaJNI.log1plus_taylor_init_wrapper();
	}

	public static void log1plus_init_wrapper() {
		trebaJNI.log1plus_init_wrapper();
	}

	public static void log1plus_free_wrapper() {
		trebaJNI.log1plus_free_wrapper();
	}

	public static void setPrior(final double prior) {
		trebaJNI.setPrior(prior);
	}

	public static void setT0(final int t0) {
		trebaJNI.setT0(t0);
	}

}
