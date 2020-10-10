package com.framework.yatra.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.framework.yatra.util.ExtentManager;
import com.framework.yatra.util.YatraConstants;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class MasterTest {
	public WebDriver driver = null;
	public ExtentReports reports = ExtentManager.getReports();
	public ExtentTest test;

	//Launch Browser method - This will open the browser
	public WebDriver launchBrowser(String browserName){
		System.setProperty("webdriver.gecko.driver", "D:\\Trainings\\Selenium\\WorkspaceP\\Drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\Trainings\\Software\\Drivers\\chromedriver.exe");
		if(!YatraConstants.GridFlag){
			if(browserName.equals("Chrome")){
				ChromeOptions ops = new ChromeOptions();
				ops.addArguments("--disable-notifications");
				ops.addArguments("ignore-certificate-errors");
				ops.addArguments("--start-maximized");
				//ops.addArguments("--proxy-server=http://localhost:9090");
				driver = new ChromeDriver(ops);
			}else if(browserName.equals("Firefox")){
				FirefoxOptions fops = new FirefoxOptions();
				FirefoxProfile profile = new FirefoxProfile();
				//notifications handling
				profile.setPreference("dom.webnotifications.enabled", false);
				//ssl certificate error handling
				profile.setAcceptUntrustedCertificates(true);
				profile.setAssumeUntrustedCertificateIssuer(false);
				//proxy server handling
				//profile.setPreference("network.proxy.type", 1);
				//profile.setPreference("network.proxy.socks", "localhost");
				//profile.setPreference("network.proxy.socks_port", 9090);
				fops.setProfile(profile);
				driver = new FirefoxDriver(fops);
			}
		}else{
			DesiredCapabilities cap = new DesiredCapabilities();
			if(browserName.equals("Chrome")){
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.WINDOWS);
			}else if(browserName.equals("Firefox")){
				cap.setBrowserName("firefox");
				cap.setJavascriptEnabled(true);
				cap.setPlatform(Platform.WINDOWS);
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			//implicit wait
		    //global synchronization
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			return driver;
	}
}
