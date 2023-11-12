package com.newsletter.stepDefinitions;

import org.testng.annotations.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {	
	
	    @Given("^the user is on the login page$")
	    public void the_user_is_on_the_login_page() {
	    	System.out.println("the_user_is_on_the_login_page");
	    }	    

	    @When("^the user enters valid username and password$")
	    public void the_user_enters_valid_username_and_password() {
	    	System.out.println("the user enters valid username and password");
	    }

	    @When("^clicks the login button$")
	    public void clicks_the_login_button() {
	    	System.out.println("clicks the login button");
	    }

	    @Then("^they should be redirected to the dashboard$")
	    public void they_should_be_redirected_to_the_dashboard() {
	    	System.out.println("they should be redirected to the dashboard");
	    }

	    @Then("^see a welcome message$")
	    public void see_a_welcome_message() {
	    	System.out.println("see a welcome message");
	    }

	    @When("^the user enters invalid username and password$")
	    public void the_user_enters_invalid_username_and_password() {
	    	System.out.println("the user enters invalid username and password");
	    }

	    @Then("^an error message should be displayed$")
	    public void an_error_message_should_be_displayed() {
	    	System.out.println("an error message should be displayed");
	    }
}
