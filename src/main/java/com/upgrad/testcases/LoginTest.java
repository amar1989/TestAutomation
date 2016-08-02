package com.upgrad.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.upgrad.BusinessFlow.LoginFlow;
import com.upgrad.utilities.DriverManager;

public class LoginTest 
{
	@Test
	public void loginTOImdb() throws InterruptedException
	{
		WebDriver driver=DriverManager.getDriver();
		Thread.sleep(5000);
		LoginFlow.getLoginFlow(driver);
	}

}
