package com.service.api.utils;

import junit.framework.Assert;

public class TestLogger {

	/*
	 * This method is used to do String parameters Assertion in framework
	 * 
	 * @param expected : It is the expected result in API Response
	 * 
	 * @param actual : It is the actual result in API Response
	 * 
	 * @param message : It is the String message we can put in the html report
	 */
	public void assertEquals(String expected, String actual, String message) {
		Assert.assertEquals(expected, actual);
		com.cucumber.listener.Reporter.addStepLog(message);
	}

	/*
	 * This method is used to do Integer parameters Assertion in framework
	 * 
	 * @param expected : It is the expected result in API Response
	 * 
	 * @param actual : It is the actual result in API Response
	 * 
	 * @param message : It is the String message we can put in the html report
	 */
	public void assertEquals(int expected, int actual, String message) {
		Assert.assertEquals(expected, actual);
		com.cucumber.listener.Reporter.addStepLog(message);
	}

	/*
	 * This method is used to do String parameters Assertion in framework
	 * 
	 * @param message : It is message to log in the html report
	 */
	public void logMessage(String message) {
		com.cucumber.listener.Reporter.addStepLog(message);
	}

}
