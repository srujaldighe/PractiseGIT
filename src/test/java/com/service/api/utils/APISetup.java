package com.service.api.utils;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APISetup {

	private static RequestSpecification request;
	private static Response response;
	private JsonPath jsonpath;
	private JSONObject object;
	private JSONParser parser;

	/*
	 * This method is used to set Up the Base URL of the API
	 * 
	 * @param url : The url the Base URL
	 */
	public void setUpBaseURL(String url) {
		RestAssured.baseURI = url;
		System.out.println("Base_url " + RestAssured.baseURI);
	}

	/*
	 * This method is used to set Up the Endpoint URL of the API
	 * 
	 * @param url : The url the Endpoint URL
	 */
	public void setUpEndPointURL(String endpointURL) {
		RestAssured.basePath = endpointURL;
		request = RestAssured.given();
	}

	/*
	 * This method is used to call the GET Request
	 */
	public void setUpGETRequest() {
		response = request.request(Method.GET);
	}

	/*
	 * This method is used to set Up payload for POST Request
	 * 
	 * @param filePath : The filePath is *.json path
	 */
	public void setUpPayload(String filePath) throws IOException, ParseException {
		FileReader reader = new FileReader(filePath);
		parser = new JSONParser();
		object = (JSONObject) parser.parse(reader);
		String bodyString = object.toJSONString();
		request.body(bodyString);
	}

	/*
	 * This method is used to call the POST Request
	 */
	public void setUpPOSTRequest() {
		response = request.contentType("application/json").when().post();

	}

	/*
	 * This method is used to call the PUT Request
	 */
	public void setUpPUTRequest() {
		response = request.contentType("application/json").when().put();
	}

	/*
	 * This method is used to call the DELETE Request
	 */
	public void setUpDeleteRequest() {
		response = request.request(Method.DELETE);
	}

	/*
	 * This method is used to get the Status Code after the request is hit
	 */
	public int getStatusCode() {
		return response.getStatusCode();

	}

	/*
	 * This method is used to get JSON Path
	 */
	public String getResponseByPath(String jsonPath) {
		jsonpath = new JsonPath(response.asString());
		System.out.println(response.asString());
		String actualData = jsonpath.get(jsonPath).toString();
		return actualData;
	}

	/*
	 * This method is used to get Status line of API Response
	 */
	public String getStatusLine() {
		return response.getStatusLine();
	}

	/*
	 * This method is used to get Response Body
	 */
	public String getResponseBody() {

		return response.getBody().asString();

	}

}
