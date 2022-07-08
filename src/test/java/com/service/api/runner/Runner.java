

package com.service.api.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/com/service/api/feature",glue={"com.service.api.stepdefinition"},
tags= {"@PostAPIResponse,@DELETEAPI,@GetAPIResponse,@UpdateAPIResponse"},monochrome=true,
plugin = {"pretty","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/APITestReport.html"})

public class Runner {
	
	@AfterClass
	public static void setReportInfo()
	{
		Reporter.setSystemInfo("Author", "Srujal Dighe");
		Reporter.setSystemInfo("Platform", "Windows");
		Reporter.setSystemInfo("RestAssured Version", "4.4.0");
	}
	
}
