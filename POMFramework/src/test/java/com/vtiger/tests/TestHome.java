package com.vtiger.tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.vtiger.pages.homePage;

public class TestHome extends Basetest {
	
	
	//@Test(dependsonmethod='validLgoin')
	public void validatehomepage()
	{
		logger=report.startTest("validatehomepage");
		
		homePage hp=new homePage(driver);
		boolean val=hp.TestUpcomingPendingDisplay();
		if(val)
		{
			System.out.println("PASSED");
			logger.log(LogStatus.PASS, "Upcoming Pending Activity dashboard is displaying succcessfully");
		}
		else
		{
			System.out.println("FAILED");
			logger.log(LogStatus.FAIL, "Upcoming Pending Activity dashboard not found");
		}
		report.endTest(logger);
	}

}
