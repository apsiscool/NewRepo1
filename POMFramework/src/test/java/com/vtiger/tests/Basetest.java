package com.vtiger.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.vtiger.common.htmlreports;
import com.vtiger.config.config;

public class Basetest {
	
	public WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest logger; 
	public static String extentReport;
	
	
	
	public void createreport()
	{
		report=htmlreports.setupResult();
	}
	
	
	public void luanchApp(String browserName)
	{
		if(browserName.equals("firefox"))
		{	
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/com/vtiger/utilities/geckodriver.exe");
			driver=new FirefoxDriver();			
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/com/vtiger/utilities/chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.get(config.url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(config.timeout, TimeUnit.SECONDS);
		//return driver;
	}
	
	public boolean verifyTitle(String exp)
	{
		
		if(driver.getTitle().trim().equals(exp.trim()))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}

