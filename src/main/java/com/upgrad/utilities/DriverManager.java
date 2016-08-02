package com.upgrad.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.upgrad.framework.configprop.ConfigPropertiesBO;

public class DriverManager 
{

	public static WebDriver getDriver()
	{
		String browserName=ConfigPropertiesBO.getBrowserName();
		WebDriver driver=null;
		if(browserName.equalsIgnoreCase("firefox"))
		{
			
			driver=getFirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=getChromeDriver();
		}
		return driver;
	}
	private static WebDriver getFirefoxDriver()
	{
		System.out.println("hello------123");
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println(ConfigPropertiesBO.getUrl());
		driver.get(ConfigPropertiesBO.getUrl());
		return driver;
	}
	
	private static WebDriver getChromeDriver()
	{
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	
	

}
