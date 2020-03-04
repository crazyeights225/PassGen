package com.secureauth;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.jknack.handlebars.Template;
import com.secureauth.model.SecureAuthGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/")
public class SecureAuthController {
	SecureAuthGenerator generator=new SecureAuthGenerator();
	@Autowired
	private SecureAuthTemplateLoader templateLoader;
	
	@RequestMapping(value="/", method=RequestMethod.GET, produces="text/html")
	public String getIndexTemplate(HttpServletRequest request, HttpServletResponse response) throws JsonParseException, JsonMappingException, IOException {
		JsonNode jsonNode=new ObjectMapper().readValue(generator.getIndexJson(), JsonNode.class);
		Template template=templateLoader.getTemplate("index");
		return template.apply(templateLoader.getContext(jsonNode));
	}
		
	@RequestMapping(value="/verify", method=RequestMethod.POST)
	public String verifyPasscode(@RequestParam(value="useragent") String ua, @RequestParam(value="passcode") String pass, HttpServletResponse response) throws IOException {
		String response_json="{\"color\": \"%s\", \"status\": \"%s\"}";
		if(generator.verifyCode(ua, pass)) {
			response_json=String.format(response_json, "green", "Success");
		}else {
			response_json=String.format(response_json, "red", "Failure");
		}
		JsonNode jsonNode=new ObjectMapper().readValue(response_json, JsonNode.class);
		Template template=templateLoader.getTemplate("success");
		return template.apply(templateLoader.getContext(jsonNode));
	}
}
