package com.service.api.stepdefinition;

import com.service.api.utils.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class PutUserData extends TestBase {

	@Given("^I want to setup the endpoint url of PUT Api$")
	public void i_want_to_setup_the_endpoint_url_of_PUT_Api() throws Throwable {
		apiSetup.setUpEndPointURL(configFileReader.getPropertyValue("getEndpointforSingleUserURL"));
		testLogger
				.logMessage("The endpoint url is : " + configFileReader.getPropertyValue("getEndpointforSingleUserURL"));
	}

	@Given("^I should setup the PUT payload to Create data$")
	public void i_should_setup_the_PUT_payload_to_Create_data() throws Throwable {
		apiSetup.setUpPayload("src/test/resources/JSON_Payload/PUTRequest.json");
	}

	@When("^I hit the api using PUT method$")
	public void i_hit_the_api_using_PUT_method() throws Throwable {
		apiSetup.setUpPUTRequest();

	}

}
