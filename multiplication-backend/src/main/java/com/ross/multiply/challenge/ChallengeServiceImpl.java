package com.ross.multiply.challenge;

import org.springframework.stereotype.Service;

import com.ross.multiply.user.User;

@Service
public class ChallengeServiceImpl implements ChallengeService {
	
	

	@Override
	public ChallengeAttempt verifyAttempt(ChallengeAttemptDTO attemptDTO) {
		// Check if answer is correct
		boolean isCorrect = attemptDTO.getAnswer() == attemptDTO.getFactorA() * attemptDTO.getFactorB();
		
		User user = new User(null, attemptDTO.getUsername());
		
		ChallengeAttempt checkedAttempt = new ChallengeAttempt(
				null, 
				user.getUsername(), 
				attemptDTO.getFactorA(), 
				attemptDTO.getFactorB(), 
				attemptDTO.getAnswer(),
				isCorrect
		);
		
		return checkedAttempt;
	}
	
	

}
