package com.bdd.stories;


import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.AfterStories;

import net.serenitybdd.jbehave.SerenityStory;
import net.thucydides.core.annotations.Steps;
import com.bdd.steps.NavigationSteps;

public class NavigationStory extends SerenityStory{
	@Steps
	NavigationSteps steps;
	
	@Given("the user goes to the index page")
	public void the_user_goes_to_the_index_page() {
		steps.go_to_page();
	}
	
	@Then("the user sees their randomly generated useragent and password")
	public void the_user_sees_their_randomly_generated_useragent_and_password() {
		steps.check_page();
	}
	
	@When("the user presses Submit")
	public void the_user_presses_submit() {
		steps.click_submit();
	}
	
	@When("the user gets their password and puts it in the form")
	public void the_user_gets_their_password_and_puts_it_into_the_form() {
		steps.enter_correct_passcode();
	}
	
	@When("the user puts an incorrect password into the form")
	public void the_user_puts_an_incorrect_password_into_the_form() {
		steps.enter_incorrect_passcode();
	}
	
	@Then("the user sees Success message")
	public void the_user_sees_success_message() {
		assertEquals(steps.checkStatus(), "Success");
	}
	
	@Then("the user sees Failure message")
	public void the_user_sees_failure_message() {
		assertEquals(steps.checkStatus(), "Failure");
	}
	
	@AfterStories
	public void cleanup() {
		steps.driver_close();
	}
	
}
