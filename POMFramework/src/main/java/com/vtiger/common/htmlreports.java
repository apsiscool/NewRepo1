package com.vtiger.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class htmlreports {
	
	
	
	public synchronized static ExtentReports setupResult()
	{	
		DateFormat format=new SimpleDateFormat("yyyyMMddhhmmss");
		Date date=new Date();
		String datestr=format.format(date);
		String extentReport=System.getProperty("user.dir")+"\\src\\test\\java\\com\\vtiger\\reports\\vTigerCRM_"+datestr+".html";
		System.out.println(extentReport);
		ExtentReports report=new ExtentReports(extentReport);
		return report;
	}
	
	

}
