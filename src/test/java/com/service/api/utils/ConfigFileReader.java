package com.service.api.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/*
* This Class is used to read the data from configuration.properties file
*/

public class ConfigFileReader {

	public Properties properties;
	public String propertyFilePath = "src/test/resources/Config/configuration.properties";
	public String value;

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getPropertyValue(String key) {
		value = properties.getProperty(key);
		if (value != null)
			return value;
		else
			throw new RuntimeException(key + " is not specified in the Configuration.properties file.");
	}

	public void setPropertyValue(String key, String value) {
		properties.setProperty(key, value);

	}

}
