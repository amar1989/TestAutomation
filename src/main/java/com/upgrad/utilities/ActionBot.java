package com.upgrad.utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionBot {
	
	public static void click(WebDriver driver,By by)
	{
		WebElement element=driver.findElement(by);
		if(element.isEnabled())
		{
		  element.click();
		}
		else
		{
			System.out.println("Element is not enabled so can't be clicked");
		}
	}
	
	public static void sendKeys(WebDriver driver,By by,String data)
	{
		System.out.println("data is::"+data);
		WebElement element=driver.findElement(by);
		if(element.isDisplayed())
		{
			element.click();
			element.clear();
			element.sendKeys(data);
		}
		else
		{
			System.out.println("Element is not displayed so data can not be sent");
		}
	
	}
	public static String getText(WebDriver driver,By by)
	{
	   String text=null;
	   WebElement element=driver.findElement(by);
	   if(element.isDisplayed())
	   {
		   text=element.getText();
	   }
	   else
	   {
		   System.out.println("Element is not visible..");
	   }
	   return text;
	}
	public static List<WebElement> getListOfElement(WebDriver driver,By by)
	{
		List<WebElement> elementList=driver.findElements(by);
		return elementList;
	}
	
	public static void waitForElement(WebDriver driver,int second)
	{
		driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
	}
	
	public static void waitForElementToExist(WebDriver driver,By by)
	{
		WebElement element=driver.findElement(by);
		for(int i=0;i<20;i++)
		{
			if(element.isDisplayed())
			{
				driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				break;
			}
			else
			{
				continue;
			}
		}
	}
	 
}
