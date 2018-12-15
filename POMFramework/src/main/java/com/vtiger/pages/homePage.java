package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage extends headerPage  {
	
	
	private WebDriver driver;
	
	public homePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	
	
	By lblMyUpcomingPending=By.xpath("//td[contains(text(),'My Upcoming and Pending Activities')]");
	
	
	public boolean TestUpcomingPendingDisplay()
	{
		try
		{
		boolean val=driver.findElement(lblMyUpcomingPending).isDisplayed();
		return true;
		}
		catch(Throwable t)
		{
			System.out.println(t.getMessage());
			return false;
		}
		
	}


}
