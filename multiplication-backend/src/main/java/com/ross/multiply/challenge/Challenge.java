package com.ross.multiply.challenge;

import lombok.*;

/** 
 * This class generates a random multiplication challenge for the user to solve
 **/

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Challenge {
	private int factorA;
	private int factorB;
}
