package com.framework.yatra.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.framework.yatra.basepage.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPage extends BasePage{

	//WebDriver driver;
	//ExtentTest test;
	
	public LaunchPage(WebDriver driver, ExtentTest test){
		//this.driver;
		super(driver,test);
		//this.test = test;
	}
	
	
	public HomePage openURL(){
		test.log(LogStatus.INFO, "Inside function for opening url");
		driver.get("https://www.yatra.com/");
		verifyTitle("Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com");
		verifyText("//a[@id='booking_engine_flights']/span","Flights");
		HomePage homepage = new HomePage(driver,test);
		PageFactory.initElements(driver, homepage);
		return homepage;
	}
	

}
