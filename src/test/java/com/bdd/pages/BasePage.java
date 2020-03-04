package com.bdd.pages;

import net.serenitybdd.core.pages.PageObject;

import org.openqa.selenium.WebDriver;

public class BasePage extends PageObject{
	public BasePage() {
		super();
	}
	
	public BasePage(WebDriver driver) {
		super(driver);
	}
	
	public void maximize() {
		getDriver().manage().window().maximize();
	}
	
	public void closeDriver() {
		getDriver().close();
	}
}
