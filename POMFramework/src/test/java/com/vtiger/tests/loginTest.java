package com.vtiger.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;






import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.vtiger.pages.loginPage;

public class loginTest extends Basetest {
	
	//public loginPage lp;
	
	@BeforeSuite
	public void launchApplication()
	{
		createreport();
		luanchApp("chrome");	
		
	}
	
	
	@Test(priority=1)
	public void verifyLoginPageTitle()
	{
		logger=report.startTest("verifyLoginPageTitle");
		 loginPage lp=new loginPage(driver);
		boolean result=verifyTitle("vtiger CRM - Commercial Open Source CRM");
		if(result)
		{
			System.out.println("This is GIT Code for verifyLoginPageTitle");
			System.out.println("PASSED");
			logger.log(LogStatus.PASS, "Title matched succcessfully");
		}
		else
		{
			System.out.println("FAILED");
			logger.log(LogStatus.FAIL, "Title does not match succcessfully");
		}
		
		report.endTest(logger);
	}
	
	
	@Test(priority=2)
	public void verifyLoginPageLogo()
	{
		logger=report.startTest("verifyLoginPageLogo");
		loginPage lp=new loginPage(driver);
		boolean result=lp.verifyLogo(driver);
		if(result)
		{
			System.out.println("This is GIT Code for verifyLoginPageLogo");
			System.out.println("PASSED");
			logger.log(LogStatus.PASS, "Logo is displaying succcessfully");
		}
		else
		{
			System.out.println("FAILED");
			logger.log(LogStatus.FAIL, "Logo not found");
		}
		
		report.endTest(logger);
	}
	
	
	@Test(priority=4)
	public void validLgoin()
	{
		logger=report.startTest("validLgoin");
		loginPage lp=new loginPage(driver);
		boolean result=lp.validLogin("admin", "admin");
		if(result)
		{
			System.out.println("This is GIT Code for validLgoin");
			System.out.println("PASSED");
			logger.log(LogStatus.PASS, "Login successfully into application");
		}
		else
		{
			System.out.println("FAILED");
			logger.log(LogStatus.FAIL, "Login failed");
		}
		
		report.endTest(logger);
	}
	
	
	@Test(priority=3)
	public void InvalidLgoin()
	{
		logger=report.startTest("InvalidLgoin");
		loginPage lp=new loginPage(driver);
		boolean result=lp.InvalidLogin("admin1", "admin1",logger );
		if(result)
		{
			System.out.println("PASSED");
			logger.log(LogStatus.PASS, "Error msg validated successfully");
		}
		else
		{
			System.out.println("FAILED");
			logger.log(LogStatus.FAIL, "Incorrect error msg");
		}
		
		report.endTest(logger);
	}
	
	
	@AfterSuite
	public void closeApp()
	{
		report.flush();
		driver.quit();
	}

}
