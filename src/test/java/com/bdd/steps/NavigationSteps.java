package com.bdd.steps;

import com.bdd.pages.IndexPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

@SuppressWarnings("serial")
public class NavigationSteps extends ScenarioSteps{
	IndexPage page;
	
	@Step
	public void go_to_page() {
		page.getPage();
	}
	
	@Step
	public void check_page() {
		page.checkForUserAgentAndPassword();
	}
	
	@Step 
	public void enter_correct_passcode() {
		page.enterCorrectPasscode();
	}
	
	@Step
	public void enter_incorrect_passcode() {
		page.enterIncorrectPasscode();
	}
	
	@Step
	public void click_submit() {
		page.clickSubmitButton();
	}
	
	@Step
	public String checkStatus() {
		return page.checkStatus();
	
	}
	
	@Step
	public void driver_close() {
		page.close_driver();
	}
}
	

