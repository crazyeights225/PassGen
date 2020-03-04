package com.secureauth.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;


import org.apache.log4j.Logger;

import com.secureauth.utilities.LoggerTrace;

public class SecureAuthGenerator {
	private Map user_agents = new HashMap<String, String>();
	private Logger logger=LoggerTrace.getInstance().getLogger("file");
	
	public SecureAuthGenerator() {
		
	}
	
	public String getIndexJson() {
		String ua=generateUserAgent();
		String passcode=getPasscode();
		return String.format("{\"user_agent\": \"%s\", \"password\": \"%s\"}", ua, passcode);
	}
	
	public String generateUserAgent() {
		return RandomStringUtils.randomAlphabetic(3);
	}
	
	public String getPasscode() {
		 String passcode=RandomStringUtils.randomAlphabetic(10);
		 logger.info(String.format("Password Generated: %s", passcode));
		 return passcode;
	}
	
	public boolean verifyCode(String ua, String code) {
		return true;
	}
}
