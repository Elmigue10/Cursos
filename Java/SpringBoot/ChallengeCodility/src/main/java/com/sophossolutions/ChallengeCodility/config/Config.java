package com.sophossolutions.ChallengeCodility.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Value("${security.codility.token}")
	private String token;
	
	@Value("${server.codility.uri}")
	private String uri;

	public String getToken() {
		return token;
	}
	
	public String getUri() {
		return uri;
	}
}
