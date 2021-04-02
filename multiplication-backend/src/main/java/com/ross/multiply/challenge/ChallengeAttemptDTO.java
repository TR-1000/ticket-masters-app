package com.ross.multiply.challenge;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Value;

/*
 * Answer from User 
 * 
 * */
@Value
@AllArgsConstructor
public class ChallengeAttemptDTO {
	@NotBlank
	String username;
	@Min(1) @Max(99)
	int factorA, factorB;
	@Positive(message="Answer can't be negative")
	int answer;
	
	// all args constructor for final fields
	ChallengeAttemptDTO(){
		this.username = "";
		
		this.factorA = 1;
		this.factorB = 1;
		
		this.answer = 0;
		}
}
