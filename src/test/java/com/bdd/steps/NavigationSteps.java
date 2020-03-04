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
}
