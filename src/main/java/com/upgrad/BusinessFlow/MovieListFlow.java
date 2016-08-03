package com.upgrad.BusinessFlow;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.upgrad.pages.movieslist.ImdbMoviesList;
import com.upgrad.pages.movieslist.ImdbMoviesListOps;
import com.upgrad.services.movielist.MovieBO;
import com.upgrad.services.movielist.MovieListServices;


public class MovieListFlow {
	
	
	@SuppressWarnings("finally")
	public static boolean getMovieListFlow(WebDriver driver,String testCaseName)
	{
		boolean flag=true;
		try
		{
			
			ImdbMoviesListOps.clickOnLink(driver,ImdbMoviesList.moviesLink);
			
			List<WebElement> moviesList=ImdbMoviesListOps.getMoviesList(driver, ImdbMoviesList.moviesName);
			
			
			List<WebElement> releaseYearList=ImdbMoviesListOps.getReleaseYearList(driver, ImdbMoviesList.releaseYear);
			List<WebElement> moviesRatingList=ImdbMoviesListOps.getRatingsList(driver,ImdbMoviesList.mviesRating );
			
			List<MovieBO> movieList=MovieListServices.getMovieList(moviesList, releaseYearList, moviesRatingList,testCaseName);
		   
			if(movieList==null)
		    {
		    	flag=false;
		    }
		}
		catch(Exception e)
		{
		  flag=false;
		  e.printStackTrace();	
		}
		finally
		{
			return flag;
		}
	}
	

}
