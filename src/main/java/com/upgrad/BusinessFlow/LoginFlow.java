package com.upgrad.BusinessFlow;

import org.openqa.selenium.WebDriver;

import com.upgrad.framework.configprop.ConfigPropertiesBO;
import com.upgrad.pages.login.Login;
import com.upgrad.pages.login.LoginOps;
import com.upgrad.utilities.ActionBot;

public class LoginFlow 
{
 
	public static void getLoginFlow(WebDriver driver)
	{
		LoginOps.clickOnSigninLink(driver,Login.signInLink);
		LoginOps.clickOnImdbButton(driver,Login.imdbLInk);
		ActionBot.waitForElement(driver,5);
		LoginOps.enterUserName(driver,Login.uname,ConfigPropertiesBO.getUserId());
		LoginOps.enterPassword(driver, Login.password, ConfigPropertiesBO.getPassword());
	    LoginOps.clickOnSignInButton(driver, Login.signInButton);
	}
	
}
