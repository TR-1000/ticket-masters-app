package com.ross.multiply.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(final CorsRegistry registry) {
		registry.addMapping("/**").allowedOriginPatterns("http://localhost:3000");
	}
}
