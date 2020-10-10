package com.framework.yatra.tests;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.framework.yatra.base.MasterTest;
import com.framework.yatra.pages.BookingPage;
import com.framework.yatra.pages.HomePage;
import com.framework.yatra.pages.LaunchPage;
import com.framework.yatra.pages.LoginPage;
import com.framework.yatra.pages.SearchedFlightsPage;
import com.framework.yatra.util.DataUtil;
import com.framework.yatra.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.framework.yatra.util.Xls_Reader;

public class BookingTest extends MasterTest{
	//ExtentReports reports;
//share the driver from test to pages - done
//common functions handling
//returning multiple values from the same function
	String testName = "bookingTest";
	Xls_Reader xls = new Xls_Reader("D:\\Trainings\\Selenium\\Workspace1\\Session23_PageObjectModelModified\\TestData", ""+testName+".xlsx");
	Xls_Reader xlsExec = new Xls_Reader("D:\\Trainings\\Selenium\\Workspace1\\Session23_PageObjectModelModified\\TestData", "TestCaseExecutor.xlsx");
	
@Test(dataProvider="getData")
public void bookingTest(Hashtable<String, String> data){
	try{
		System.out.println("Departure " + data.get("DepartFrom"));
		test = reports.startTest("bookingTest");
		if(!DataUtil.isExecutable(xlsExec, testName)){
			test.log(LogStatus.SKIP, "Skipping booking test");
			throw new SkipException("skipping booking test");
		}
		test.log(LogStatus.INFO, "Launching the chrome browser");
		launchBrowser("Chrome");
		//driver = new ChromeDriver();
		LaunchPage launchPage = new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		//LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
		test.log(LogStatus.INFO, "Opening the url www.yatra.com");
		HomePage homepage = launchPage.openURL();
		//verify that the url is successfully opened
		test.log(LogStatus.INFO, "Flights are getting searched");
		SearchedFlightsPage sfp = homepage.SearchFlights(data);
		BookingPage bp = sfp.selectFlights();
		
	}catch(Exception ex){
		ex.printStackTrace();
	}
	//hp.SearchFlights(driver);
	//driver.get("https://www.yatra.com/");
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

	
	@DataProvider
	public Object[][] getData(){
		
	/*	int rows = xls.getRowCount(testName);
		int cols = xls.getColumnCount(testName);
		System.out.println("No. of rows : " + rows);
		System.out.println("No. of columns : " + cols);
		Object[][] data = new Object[rows-1][1];
		Hashtable<String, String> table = null;
		int dataRow=0;
		for(int irow=2;irow<=rows;irow++){
			table = new Hashtable<String, String>();
			for(int icol=0;icol<cols;icol++){
				String key = xls.getCellData(testName, icol, 1);
				//System.out.println(key);
				String value = xls.getCellData(testName, icol, irow);
				//System.out.println(value);
				table.put(key, value);
			}
			data[dataRow][0]=table;
			dataRow++;
		}
		//System.out.println(table.get("DepartFrom"));
		return data;
		*/
		
		return DataUtil.getData(xls, testName);
	}
	
	
	
	

}
