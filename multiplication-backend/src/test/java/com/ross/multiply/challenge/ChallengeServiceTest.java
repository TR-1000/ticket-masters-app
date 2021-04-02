package com.ross.multiply.challenge;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.BDDAssertions.*; 
public class ChallengeServiceTest {
	
	private ChallengeService challengeService;
	
	@BeforeEach
	public void setUp() {
		challengeService = new ChallengeServiceImpl();
	}
	
	@Test
	public void checkCorrectAttemptTest() {
		// given
		ChallengeAttemptDTO attempDTO = new ChallengeAttemptDTO("john_doe", 60, 50, 3000);
		
		// when
		ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attempDTO);
		
		//then
		then(resultAttempt.isCorrect()).isTrue();
	}
	
	@Test
	public void checkingAttemptTest() {
		// given
		ChallengeAttemptDTO attemptDTO = new ChallengeAttemptDTO("john_doe", 60, 50, 5000);
		
		// when
		ChallengeAttempt resultAttempt = challengeService.verifyAttempt(attemptDTO);
		
		//then
		then(resultAttempt.isCorrect()).isFalse();
		
	}
}
