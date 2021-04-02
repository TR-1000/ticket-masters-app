package com.ross.multiply.challenge;

public interface ChallengeService {
	/*
	 * Verifies attempt is correct or not.
	 * 
	 * @return the ChallengeAttempt object
	 * 
	 */

	ChallengeAttempt verifyAttempt(ChallengeAttemptDTO resultAttempt);
}
