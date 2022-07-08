package com.service.api.stepdefinition;

import com.service.api.utils.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class DeleteUserData extends TestBase {

	@Given("^I want to setup the endpoint url for DELETE Api$")
	public void i_want_to_setup_the_endpoint_url_for_DELETE_Api() throws Throwable {
		apiSetup.setUpEndPointURL(configFileReader.getPropertyValue("getEndpointforSingleUserURL"));
		testLogger.logMessage("The endpoint is : " + configFileReader.getPropertyValue("getEndpointforSingleUserURL"));
	}

	@When("^I hit the api using DELETE method$")
	public void i_hit_the_api_using_DELETE_method() throws Throwable {
		apiSetup.setUpDeleteRequest();
	}

}
