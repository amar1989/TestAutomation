package com.upgrad.pages.movieslist;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.upgrad.utilities.ActionBot;

public class ImdbMoviesListOps extends ImdbMoviesList 
{
	
	public static void clickOnLink(WebDriver driver,By by)
	{
		ActionBot.click(driver,by);
	}
	
	public static List<WebElement> getMoviesList(WebDriver driver,By by)
	{
		List<WebElement> moviesName=ActionBot.getListOfElement(driver, by);
		return moviesName;
	}
	
	public static List<WebElement> getRatingsList(WebDriver driver,By by)
	{
		List<WebElement> ratings=ActionBot.getListOfElement(driver, by);
		return ratings;
	}
	public static List<WebElement> getReleaseYearList(WebDriver driver,By by)
	{
		List<WebElement> releaseYears=ActionBot.getListOfElement(driver, by);
		return releaseYears;
	}
	
}
