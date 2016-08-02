package com.upgrad.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.upgrad.utilities.ActionBot;

public class LoginOps 
{

	public static void clickOnSigninLink(WebDriver driver,By by)
	{
		ActionBot.click(driver, by);
	}
	
	public static void enterUserName(WebDriver driver,By by,String uname)
	{
		ActionBot.sendKeys(driver, by,uname);
	}
	
	public static void enterPassword(WebDriver driver,By by,String password)
	{
		ActionBot.sendKeys(driver, by, password);
	}
	
	public static void clickOnSignInButton(WebDriver driver,By by)
	{
		ActionBot.click(driver, by);
	}
	public static void clickOnImdbButton(WebDriver driver,By by)
	{
		ActionBot.click(driver, by);
	}
	
}
