package com.upgrad.testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
import com.upgrad.BusinessFlow.MovieListFlow;
import com.upgrad.reporting.TestResultImpl;
import com.upgrad.utilities.DriverManager;

public class MovieListTest 
{
	
	@Test
	public void TestMovieList(Method method) throws InterruptedException
	{
		String status=null;
		WebDriver driver=DriverManager.getDriver();
		Thread.sleep(5000);
		boolean flag=MovieListFlow.getMovieListFlow(driver);
		if(flag==true)
		{
			status="PASS";
		}
		else
		{
			status="FAIL";
		}
		TestResultImpl.createTestResultList(method.getName(), status);
		
	}

}
