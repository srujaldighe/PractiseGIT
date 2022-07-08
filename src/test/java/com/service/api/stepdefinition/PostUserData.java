package com.service.api.stepdefinition;

import com.service.api.utils.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PostUserData extends TestBase {

	@Given("^I want to setup the endpoint url of POST Api$")
	public void i_want_to_setup_the_endpoint_url_of_POST_Api() throws Throwable {
		apiSetup.setUpEndPointURL(configFileReader.getPropertyValue("postEndpointURL"));
		testLogger.logMessage("The endpoint URL is : " + configFileReader.getPropertyValue("postEndpointURL"));
	}

	@Given("^I want to setup the endpoint url for Bad Request$")
	public void i_want_to_setup_the_endpoint_url_for_Bad_Request() throws Throwable {
		apiSetup.setUpEndPointURL(configFileReader.getPropertyValue("postEndpointURLLogin"));
		testLogger.logMessage("The endpoint URL is : " + configFileReader.getPropertyValue("postEndpointURLLogin"));
	}

	@Then("^I should setup the POST payload to Create data$")
	public void i_should_setup_the_POST_payload_to_Create_data() throws Throwable {
		apiSetup.setUpPayload("src/test/resources/JSON_Payload/POSTCreateRequest.json");

	}

	@When("^I hit the api using POST method$")
	public void i_hit_the_api_using_POST_method() throws Throwable {
		apiSetup.setUpPOSTRequest();
	}

	@Then("^I should Validate the response body field \"([^\"]*)\",\"([^\"]*)\"$")
	public void i_should_Validate_the_response_body_field(String expectedName, String expectedJob) throws Throwable {
		testLogger.logMessage("The Response body is : " +"\n"+ apiSetup.getResponseBody());
		String actualName = apiSetup.getResponseByPath("name");
		String actualJob = apiSetup.getResponseByPath("job");
		testLogger.assertEquals(expectedName, actualName, "Validating the name : " + actualName);
		testLogger.assertEquals(expectedJob, actualJob, "Validating the job : " + actualJob);
	}

	@Given("^I should setup the POST payload for Bad Request$")
	public void i_should_setup_the_POST_payload_for_Bad_Request() throws Throwable {
		apiSetup.setUpPayload("src/test/resources/JSON_Payload/POSTBadRequestData.json");
	}

	@Then("^I should Validate the response body field \"([^\"]*)\"$")
	public void i_should_Validate_the_response_body_field(String errorMessage) throws Throwable {
		testLogger.logMessage("The response body is : " +"\n"+ apiSetup.getResponseBody());
		String actualErrorMessage = apiSetup.getResponseByPath("error");
		testLogger.assertEquals(errorMessage, actualErrorMessage,
				"The Expected error message is " + actualErrorMessage);
	}

}
