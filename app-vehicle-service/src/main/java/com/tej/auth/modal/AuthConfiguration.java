package com.tej.auth.modal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class AuthConfiguration {
	
	@Autowired
	private Environment environment;
	
	public String getDefaultModel() {
		return environment.getProperty("url");
	}
	
	public String getMinimumRent() {
		return environment.getProperty("url");
	}


}
