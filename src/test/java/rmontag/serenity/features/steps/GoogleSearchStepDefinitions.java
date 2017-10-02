package rmontag.serenity.features.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import rmontag.serenity.features.steps.serenity.GoogleSearchSteps;

/**
 * @author rmontag
 * Use @Steps to add a layer of abstraction between the "what" and the "how" of our acceptance tests.
 * Step definitions describe "what" the acceptance test is doing, in clear business domain language (Cucumber).
 * So we say "I search for 'Serenity BDD'", not "user enters 'Serenity BDD' into google search field and clicks on the search button".
 */
public class GoogleSearchStepDefinitions {

	@Steps
	GoogleSearchSteps googleSearchSteps;
	
	@Given("^I want to search in Google$")
	public void i_want_to_search_in_Google() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // throw new PendingException();
		googleSearchSteps.openGoogleSearchPage();
	}

//	@When("^I search for 'Serenity BDD'$")
//	public void i_search_for_Serenity_BDD() throws Throwable {
//	@When("^I search for 'Cucumber'$")
//	public void i_search_for_Cucumber() throws Throwable {
	@When("I search for '(.*)'")
	public void iSearchFor(String searchRequest) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	    // throw new PendingException();
		googleSearchSteps.searchFor(searchRequest);
	}

//	@Then("^I should see link to 'Serenity BDD - Automated Acceptance Testing with Style'$")
//	public void i_should_see_link_to_Serenity_BDD_Automated_Acceptance_Testing_with_Style() throws Throwable {
//	@Then("^I should see link to 'Cucumber'$")
//	public void i_should_see_link_to_Cucumber() throws Throwable {
	@Then("I should see link to '(.*)'")
	public void iShouldSeeLinkTo(String searchResult) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	    // throw new PendingException();
		googleSearchSteps.verifyResult(searchResult);
	}

}
