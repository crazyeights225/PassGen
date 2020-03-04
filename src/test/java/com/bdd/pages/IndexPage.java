package com.bdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;

import com.bdd.pages.BasePage;

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
	
	public void enterCorrectPasscode() {
		String password_xpath="//h2[@id='password']";
		String password_field_xpath="//input[@id='passcode']";
		String password=find(By.xpath(password_xpath)).getText().replace("Password: ", "");
		find(By.xpath(password_field_xpath)).sendKeys(password);
	}
	
	public void enterIncorrectPasscode() {
		String password_field_xpath="//input[@id='passcode']";
		find(By.xpath(password_field_xpath)).sendKeys("incorrectpassword");
	}
	
	public void clickSubmitButton() {
		String button_xpath="//input[@value='Submit']";
		find(By.xpath(button_xpath)).click();
	}
	
	public String checkStatus() {
		String status_xpath="//h1[@id='status-txt']";
		return find(By.xpath(status_xpath)).getText();
	}
	
	public void close_driver() {
		super.closeDriver();
	}
	
}
