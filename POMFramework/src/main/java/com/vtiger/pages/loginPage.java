package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class loginPage  {
	private WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
			
	@FindBy(name="user_name")
    WebElement txtUserName;
	//By txtUserName=By.name("user_name");
	
	
	@FindBy(how=How.NAME, using="user_password")
    WebElement txtPassword;
	//By txtPassword=By.name("user_password");
	
	By btnLogin=By.name("Login");
	By lnkLogout=By.linkText("Logout");
	By ErrorMsg=By.xpath("//td[contains(text(),'You must specify a valid username')]");
	By ImgLogo=By.xpath("//img[@src='include/images/vtiger-crm.gif']");
	
	//WebElement txtUserName=driver.findElement(By.name("user_name"));
	//WebElement txtPassword=driver.findElement(By.name("user_password"));
	//WebElement btnLogin=driver.findElement(By.name("Login"));
	//WebElement lnkLogout=driver.findElement(By.linkText("Logout"));
	//WebElement ErrorMsg=driver.findElement(By.xpath("//td[contains(text(),'You must specify a valid username')]"));
	//WebElement ImgLogo=driver.findElement(By.xpath("//img[@src='include/images/vtiger-crm.gif']"));
	
	
	
	public boolean validLogin(String userid,String pwd)
	{
	  try
	  {
		  txtUserName.clear();
		  txtUserName.sendKeys(userid);
		  txtPassword.clear();
		  txtPassword.sendKeys(pwd);
		driver.findElement(btnLogin).click();
		if(driver.findElement(lnkLogout).isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	  }
	  catch(Throwable t)
	  {
		  System.out.println(t.getMessage());
		  return false;
	  }
	}
	
	
	public boolean InvalidLogin(String userid,String pwd,ExtentTest logger)
	{
		try
		  {
			txtUserName.clear();
			logger.log(LogStatus.INFO, "Clear text values");
			txtUserName.sendKeys(userid);
			logger.log(LogStatus.INFO, "Enter "+userid+ " within userid field");
			txtPassword.clear();
			txtPassword.sendKeys(pwd);
			logger.log(LogStatus.INFO, "Enter "+pwd+ " within password field");
			driver.findElement(btnLogin).click();	
			logger.log(LogStatus.INFO, "Clicked on login button");
			if(driver.findElement(ErrorMsg).isDisplayed())
			{
				return true;
			}
			else
			{
				return false;
			}
		  }
		  catch(Throwable t)
		  {
			  System.out.println(t.getMessage());
			  return false;
		  }
	}
	
	public boolean verifyLogo(WebDriver driver)
	{
	 try
	 {
		 if(driver.findElement(ImgLogo).isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	  }
	  catch(Throwable t)
	  {
		  System.out.println(t.getMessage());
		  return false;
	  }
	}


}
