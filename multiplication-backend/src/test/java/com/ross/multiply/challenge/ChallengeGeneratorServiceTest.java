package com.ross.multiply.challenge;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ChallengeGeneratorServiceTest {
	
	private ChallengeGeneratorService challengeGeneratorService;
	
	@Spy
	private static Random random;
	
	
	@BeforeEach
	public void setUp() {
		challengeGeneratorService = new ChallengeGeneratorServiceImpl(random);
	}

	@Test
	public void generateRandomFactorIsBetweenExpectedLimits() {
		// to generate random numbers between 11 and 99 get a random number between 0 and 89 and add 11 to it.
		given(random.nextInt(89)).willReturn(20, 30);
		
		// when a challenge is generated
		Challenge challenge = challengeGeneratorService.randomChallenge();
		
		// then the challenge contains expected factors
		then(challenge).isEqualTo(new Challenge(31, 41));
	}
	
}
