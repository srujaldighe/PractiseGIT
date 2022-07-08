package com.service.api.stepdefinition;

import com.service.api.utils.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class GetUserData extends TestBase {

	@Given("^I want to setup base url$")
	public void i_want_to_setup_base_url() throws Throwable {
		apiSetup.setUpBaseURL(configFileReader.getPropertyValue("baseURL"));
		testLogger.logMessage("The Base Url Is : " + configFileReader.getPropertyValue("baseURL"));
	}

	@Given("^I want to setup the endpoint url of GET Api for single user not found$")
	public void i_want_to_setup_the_endpoint_url_of_GET_Api_for_single_user_not_found() throws Throwable {
		apiSetup.setUpEndPointURL(configFileReader.getPropertyValue("getEndpointforSingleUserNotFoundURL"));
		testLogger.logMessage(
				"The Endpoint Url is : " + configFileReader.getPropertyValue("getEndpointforSingleUserNotFoundURL"));
	}

	@Given("^I want to setup the endpoint url of GET Api$")
	public void i_want_to_setup_the_endpoint_url_of_GET_Api() throws Throwable {
		apiSetup.setUpEndPointURL(configFileReader.getPropertyValue("getEndPointURL"));
		testLogger.logMessage(
				"The Endpoint Url is : " + configFileReader.getPropertyValue("getEndPointURL"));
	}

	@Given("^I want to setup the endpoint url of GET Api for single user$")
	public void i_want_to_setup_the_endpoint_url_of_GET_Api_for_single_user() throws Throwable {
		apiSetup.setUpEndPointURL(configFileReader.getPropertyValue("getEndpointforSingleUserURL"));
		testLogger.logMessage(
				"The Endpoint Url is : " + configFileReader.getPropertyValue("getEndpointforSingleUserURL"));
	}

	@Then("^I should validate the response Body fields \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void i_should_validate_the_response_Body_fields(String expectedId, String expectedEmail,
			String expectedFirstName, String expectedLastName, String expectedAvatar) throws Throwable {
		
		testLogger.logMessage("\n");
		testLogger.logMessage("The Response body is : "+"\n"+ apiSetup.getResponseBody());
		String actualId = apiSetup.getResponseByPath("data.id");
		testLogger.assertEquals(expectedId, actualId, "The Actual id is : " + actualId);
		String actualEmail = apiSetup.getResponseByPath("data.email");
		testLogger.assertEquals(expectedEmail, actualEmail, "The Actual email is : " + actualEmail);
		String actualFirstName = apiSetup.getResponseByPath("data.first_name");
		testLogger.assertEquals(expectedFirstName, actualFirstName, "The Actual first Name is : " + actualFirstName);
		String actualLastName = apiSetup.getResponseByPath("data.last_name");
		testLogger.assertEquals(expectedLastName, actualLastName, "The actual last name is : " + actualLastName);
		String actualAvatar = apiSetup.getResponseByPath("data.avatar");
		testLogger.assertEquals(expectedAvatar, actualAvatar, "The actual avatar is : " + actualAvatar);
	}

	@When("^I hit the api using GET method$")
	public void i_hit_the_api_using_GET_method() throws Throwable {
		apiSetup.setUpGETRequest();
	}

	@Then("^I should validate the status code is (\\d+)$")
	public void i_should_validate_the_status_code_is(int expectedStatusCode) throws Throwable {
		int actualStatusCode = apiSetup.getStatusCode();
		testLogger.assertEquals(expectedStatusCode, actualStatusCode,
				"Validating the status code is : " + actualStatusCode);

	}

	@Then("^I should Validate the status line$")
	public void i_should_Validate_the_status_line() throws Throwable {
		String actualStatusLine = apiSetup.getStatusLine();
		System.out.println("Status line is : " + actualStatusLine);
	}

	@Then("^I should validate the response Body fields \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void i_should_validate_the_response_Body_fields(String expectedPage, String expectedTotal, String expectedId,
			String expectedEmail, String expectedFirstName, String expectedLastName, String expectedAvatar)
			throws Throwable {
		
		testLogger.logMessage("The Response body is :" +"\n"+ apiSetup.getResponseBody());
		String actualPage = apiSetup.getResponseByPath("page");
		testLogger.assertEquals(expectedPage.trim(), actualPage, "The Actual page value is : " + actualPage);
		String actualTotal = apiSetup.getResponseByPath("total");
		testLogger.assertEquals(expectedTotal, actualTotal, "The Actual total value is : " + actualTotal);
		String actualId = apiSetup.getResponseByPath("data[0].id");
		testLogger.assertEquals(expectedId, actualId, "The Actual id is : " + actualId);
		String actualEmail = apiSetup.getResponseByPath("data[0].email");
		testLogger.assertEquals(expectedEmail, actualEmail, "The Actual Email is : " + actualEmail);
		String actualFirstName = apiSetup.getResponseByPath("data[0].first_name");
		testLogger.assertEquals(expectedFirstName, actualFirstName, "The Actual first Name is : " + actualFirstName);
		String actualLastName = apiSetup.getResponseByPath("data[0].last_name");
		testLogger.assertEquals(expectedLastName, actualLastName, "The actual last name is : " + actualLastName);
		String actualAvatar = apiSetup.getResponseByPath("data[0].avatar");
		testLogger.assertEquals(expectedAvatar, actualAvatar, "The actual Avatar is : " + actualAvatar);
	}

}
