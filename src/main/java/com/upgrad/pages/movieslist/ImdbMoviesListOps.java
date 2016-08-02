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
	
	/*private  static List<String> getMovieList(WebDriver driver,By by)
	{
		List<WebElement> moviesName=driver.findElements(by);
		List<String> movieNameList=new ArrayList<String>();
		for(WebElement movie:moviesName)
		{
			String movieName=movie.getText();
			movieNameList.add(movieName);
		}
		return movieNameList;
	}
	public static List<String> getMoviesRating(WebDriver driver,By by)
	{
		List<WebElement> releaseYears=driver.findElements(by);
		List<String> releaseYearList=new ArrayList<String>();
		for(WebElement releaseYear:releaseYears)
		{
			String year=releaseYear.getText();
			releaseYearList.add(year);
		}
		return releaseYearList;
	}

	
	public static List<String> getReleaseYear(WebDriver driver,By by)
	{
		List<WebElement> releaseYears=driver.findElements(by);
		List<String> releaseYearList=new ArrayList<String>();
		for(WebElement releaseYear:releaseYears)
		{
			String year=releaseYear.getText();
			releaseYearList.add(year);
		}
		return releaseYearList;
	}
*/
}
