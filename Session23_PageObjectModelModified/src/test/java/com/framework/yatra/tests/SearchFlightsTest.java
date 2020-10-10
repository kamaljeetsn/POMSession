package com.framework.yatra.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.framework.yatra.base.MasterTest;
import com.framework.yatra.util.Xls_Reader;
import com.relevantcodes.extentreports.LogStatus;

public class SearchFlightsTest extends MasterTest{
	String testName = "SearchFlightsTest";
	//Xls_Reader xls = new Xls_Reader("D:\\Trainings\\Selenium\\Workspace1\\Session23_PageObjectModelModified\\TestData", ""+testName+".xlsx");
	Xls_Reader xlsExec = new Xls_Reader("D:\\Trainings\\Selenium\\Workspace1\\Session23_PageObjectModelModified\\TestData", "TestCaseExecutor.xlsx");

	@Test
	public void testSearchFlights(){
		test = reports.startTest(testName);
		launchBrowser("Chrome");
		driver.get("https://www.google.com/");
		test.log(LogStatus.INFO, "Google page is opened");
		
	}
	
	@AfterMethod
	public void quit(){
		if(reports!=null){
			reports.endTest(test);
			reports.flush();
		}
		if(driver!=null){
			driver.quit();
		}
	}

}
