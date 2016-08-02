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
	
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		System.out.println(ConfigPropertiesBO.getUrl());
		driver.get(ConfigPropertiesBO.getUrl());
		return driver;
	}
	
	
	public static WebDriver getChromeDriver()
	{
		WebDriver driver=null;
		
		System.setProperty("webdriver.chrome.driver", "Executable/chromedriver.exe");
		driver = new ChromeDriver();
		try
		{
		    driver.manage().window().maximize();
			driver.get(ConfigPropertiesBO.getUrl());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		  return driver;
		
	}
	
	public static void closeDriver(WebDriver driver)
	{
		if(driver!=null)
		{
			driver.close();
			driver=null;
		}
	
	}
	

}
