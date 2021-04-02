package com.ross.multiply;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import lombok.var;

@SpringBootApplication
public class MultiplyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiplyApplication.class,args);
	}
	
	
	/**
	* Changing JSON property naming to be snake-case
	* instead of camel-case, declare a custom ObjectMapper in app configuration
	* that will be loaded instead of the default.
	* Normally, this bean declaration would be in a separated class annotated with @Configuration, 
	* but this is a quick example
	* 
	**/
	@Bean
	public ObjectMapper objectMapper() {
		var om = new ObjectMapper();
		om.setPropertyNamingStrategy(
				PropertyNamingStrategy.SNAKE_CASE);
		return om;
	}
	


}
