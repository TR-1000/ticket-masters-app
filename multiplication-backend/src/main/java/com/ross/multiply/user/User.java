package com.ross.multiply.user;

import lombok.*;

/* 
 * Class for stores user information
 * */

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {
	private Long id;
	private String username;
}
