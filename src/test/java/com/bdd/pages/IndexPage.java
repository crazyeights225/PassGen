package com.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;

@NamedUrls({
	@NamedUrl(name="index.page", url="http://localhost:8080/")
})

public class IndexPage extends BasePage {
	public IndexPage(WebDriver driver) {
		super(driver);
	}
	
	public void getPage() {
		open("index.page", withParameters());
		maximize();
	}
	
	public void checkForUserAgentAndPassword() {
		String user_agent_xpath="//h2[@id='useragent']";
		String password_xpath="//h2[@id='password']";
		find(By.xpath(user_agent_xpath));
		find(By.xpath(password_xpath));
	}
	
}
