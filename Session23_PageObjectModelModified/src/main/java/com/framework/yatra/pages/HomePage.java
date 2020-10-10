package com.framework.yatra.pages;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.yatra.basepage.BasePage;
import com.framework.yatra.util.ObjectRepository;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage extends BasePage{
	
	//WebDriver driver;
	
	@FindBy(xpath=ObjectRepository.departfrom)
	public WebElement departFrom;
	
	@FindBy(css=ObjectRepository.arrivalcity)
	public WebElement arrivalcity;
	
	@FindBy(xpath=ObjectRepository.arrivalcityselection)
	public WebElement arrivalcityselection;
	
	@FindBy(xpath=ObjectRepository.origindate)
	public WebElement origindate;
	
	@FindBy(xpath="//table/tbody/tr/td[@data-date='20/10/2020']")
	public WebElement departuredate;
	
	@FindBy(xpath="//table/tbody/tr/td[@data-date='25/10/2020']")
	public WebElement arrivaldate;
	
	@FindBy(xpath="//*[@id='BE_flight_paxInfoBox']/i")
	public WebElement paxinfo;
	
	//ExtentTest test;
	
	public HomePage(WebDriver driver, ExtentTest test){
		super(driver,test);
		//this.test = test;
	}
	
	public SearchedFlightsPage SearchFlights(Hashtable<String, String> data) throws InterruptedException{
		test.log(LogStatus.INFO, "Search Flights");
		driver.findElement(By.cssSelector(ObjectRepository.roundTrip)).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(ObjectRepository.originCity)).click();
		
		//WebElement depart = driver.findElement(By.xpath("//p[text()='Pune ']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", departFrom);
		test.log(LogStatus.INFO, "Click on Daparture link");
		/*departFrom.click();
		arrivalcity.click();
		arrivalcityselection.click();
		origindate.click();
		departuredate.click();
		arrivaldate.click();
		paxinfo.click();
		*/
		driver.findElement(By.xpath("//p[text()='"+data.get("DepartFrom")+" ']")).click();
		driver.findElement(By.cssSelector("input#BE_flight_arrival_city")).click();
		driver.findElement(By.xpath("//p[text()='"+data.get("ArrivalTo")+" ']")).click();
		driver.findElement(By.xpath("//*[@id='BE_flight_origin_date']")).click();
		driver.findElement(By.xpath("//table/tbody/tr/td[@data-date='"+data.get("OriginDate")+"']")).click();
		driver.findElement(By.xpath("//table/tbody/tr/td[@data-date='"+data.get("DestinationDate")+"']")).click();
		driver.findElement(By.xpath("//*[@id='BE_flight_paxInfoBox']/i")).click();
		int Adult = 4;
		String readAdult = driver.findElement(By.cssSelector("div[data-flightagegroup='adult']>span.pax-title>span.adultcount")).getText();
		System.out.println(readAdult);
		int screenAdult = Integer.parseInt(readAdult);
		while(Adult!=screenAdult){
			System.out.println("Adult");
			if(Adult<screenAdult){
				driver.findElement(By.xpath("//div[@data-flightagegroup='adult']/div[1]/div[1]/div[1]/span[1]")).click();
			}else{
				driver.findElement(By.xpath("//div[@data-flightagegroup='adult']/div[1]/div[1]/div[1]/span[2]")).click();
			}
			screenAdult++;
			
		}
		
		int Child = 2;
		String readChild = driver.findElement(By.cssSelector("div[data-flightagegroup='child']>span.pax-title>span.adultcount")).getText();
		System.out.println(readChild);
		int screenChild = Integer.parseInt(readChild);
		while(Child!=screenChild){
			System.out.println("Child");
			if(Child<screenChild){
				driver.findElement(By.xpath("//div[@data-flightagegroup='child']/div[1]/div[1]/span[1]")).click();
			}else{
				driver.findElement(By.xpath("//div[@data-flightagegroup='child']/div[1]/div[1]/span[2]")).click();
			}
			screenChild++;
			
		}
		driver.findElement(By.xpath("//span[text()='Premium Economy']")).click();
		driver.findElement(By.xpath("//span[text()='Economy']")).click();
		driver.findElement(By.xpath("//*[@id='BE_flight_flsearch_btn']")).click();
		verifyTitle("Yatra.com | "+data.get("DepartFrom")+" to "+data.get("ArrivalTo")+" flights");
		SearchedFlightsPage sfp = new SearchedFlightsPage(driver,test);
		PageFactory.initElements(driver, sfp);
		return sfp;
	}
	
	
	
	public void SearchHotels(){
		
	}
	

	
	
}
