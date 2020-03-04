package com.bdd.stories;


import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
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
}
