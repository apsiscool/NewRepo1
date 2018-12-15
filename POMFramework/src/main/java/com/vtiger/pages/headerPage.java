package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class headerPage {
	
	private WebDriver driver;
	
	public headerPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	
	
	
	public void ClickonHyperlink(String text)
	{
		driver.findElement(By.linkText(text)).click();
	}
	
	

}
