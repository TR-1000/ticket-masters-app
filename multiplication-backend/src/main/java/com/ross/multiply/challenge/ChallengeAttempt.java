package com.ross.multiply.challenge;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ChallengeAttempt {
	private Long id;
	private String username;
	private int factorA;
	private int factorB;
	private int resultAttempt;
	private boolean correct;
}
