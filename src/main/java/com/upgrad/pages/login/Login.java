package com.upgrad.pages.login;

import java.io.IOException;

import org.openqa.selenium.By;

import com.upgrad.utilities.UIElements;

public class Login {
	
	static
	{
		try 
		{
			UIElements.createWebElementMap("Resources/Login.xls");
		} 
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
	}
	
	public static final By uname=UIElements.getUIElement("email");
	public static final By password=UIElements.getUIElement("pass");
	public static final By signInButton=UIElements.getUIElement("signin_button");
	public static final By signInLink=UIElements.getUIElement("signin_link");
	public static final By imdbLInk=UIElements.getUIElement("imdb_link");

}
