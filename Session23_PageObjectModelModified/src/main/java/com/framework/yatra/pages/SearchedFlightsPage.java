package com.framework.yatra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.framework.yatra.basepage.BasePage;
//import com.framework.yatra.tests.BookingTest;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SearchedFlightsPage extends BasePage{

	//WebDriver driver;
	
	//ExtentTest test;
	
	public SearchedFlightsPage(WebDriver driver, ExtentTest test){
		super(driver,test);
		//this.test = test;
	}
	
	public BookingPage selectFlights() throws Exception{
		//steps to select the flight
		test.log(LogStatus.INFO, "Booking page");
	/*	WebElement select0 = driver.findElements(By.xpath("//*[@name='select0']")).get(0);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", select0);
		js.executeScript("arguments[0].click()", select0);
		
		WebElement select1 = driver.findElements(By.xpath("//*[@name='select1']")).get(0);
		js.executeScript("arguments[0].scrollIntoView();", select1);
		js.executeScript("arguments[0].click()", select1);
		
		Thread.sleep(3000);
		WebElement buttonBookNow = driver.findElement(By.xpath("//button[text()='Book Now']"));
		js.executeScript("arguments[0].click()", buttonBookNow);
		*/
		BookingPage bp = new BookingPage(driver,test);
		PageFactory.initElements(driver, bp);
		return bp;
	}
	

}


