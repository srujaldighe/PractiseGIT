package com.service.api.utils;

/*
* This is the class to create objects which is extended in each and every stepdef class
*/

public class TestBase {
	public APISetup apiSetup = new APISetup();
	public TestLogger testLogger = new TestLogger();
	public ConfigFileReader configFileReader = new ConfigFileReader();
}
