package com.framework.yatra.basepage;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

	public WebDriver driver;
	public ExtentTest test;
	
	public BasePage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
	}
	
	//verifyTitle
	public void verifyTitle(String expected){
		System.out.println("Inside Verify Title");
		String actual = driver.getTitle();
		//String expected = "Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com";
		takeScreenshot();
		if(expected.equals(actual)){
			test.log(LogStatus.PASS, "Expected Title : " + expected + " is same as actual title " + actual);
		}else{
			test.log(LogStatus.FAIL, "Expected title is " + expected + " but actual title is " + actual);
		}

	}
	
	public void verifyText(String locator,String expected){
		//String expected = "Flights";
		//String actual = driver.findElement(By.xpath("//a[@id='booking_engine_flights']/span")).getText();
		String actual = driver.findElement(By.xpath(locator)).getText();
		System.out.println("Verify Text " + actual);
		takeScreenshot();
		if(actual.equals(expected)){
			test.log(LogStatus.PASS, "Expected Text : " + expected + " is same as actual text " + actual);
		}else{
			test.log(LogStatus.FAIL, "Expected Text is " + expected + " but actual text is " + actual);
		}
			
	}
	
	public void takeScreenshot() {
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		String filePath = "D:\\Trainings\\Selenium\\Workspace1\\Session23_PageObjectModelModified\\Screenshots\\"+screenshotFile;
		//Convert web driver object to TakeScreenshot
		TakesScreenshot	scrShot = (TakesScreenshot) driver;
		//Call getScreenshotAs method to create image file
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, test.addScreenCapture(filePath));
	
	}

	
}
