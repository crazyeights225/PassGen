package com.secureauth;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.secureauth.model.SecureAuthGenerator;

import org.json.JSONObject;

public class TestGenerator {
	@Test
	public void testUniquePasscodes() {
		SecureAuthGenerator generator=new SecureAuthGenerator();
		String password1 = generator.getPasscode();
		String password2 = generator.getPasscode();
		assertNotEquals(password1, password2);
	}
	
	@Test
	public void testUniqueUserAgents() {
		SecureAuthGenerator generator=new SecureAuthGenerator();
		String ua1=generator.generateUserAgent();
		String ua2=generator.generateUserAgent();
		assertNotEquals(ua1, ua2);
	}
	
	@Test
	public void testSuccessfulLogin() {
		SecureAuthGenerator generator=new SecureAuthGenerator();
		String jsonString=generator.getIndexJson();
		JSONObject obj=new JSONObject(jsonString);
		String ua=obj.getString("user_agent");
		String pass=obj.getString("password");
		assertTrue(generator.verifyCode(ua, pass));
	}
	
	@Test
	public void testFailedLogin() {
		SecureAuthGenerator generator=new SecureAuthGenerator();
		String jsonString=generator.getIndexJson();
		JSONObject obj=new JSONObject(jsonString);
		String ua=obj.getString("user_agent");
		//String pass=obj.getString("password");
		assertFalse(generator.verifyCode(ua, "thisisincorrect"));
	}
	
}
