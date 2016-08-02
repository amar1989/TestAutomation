package com.upgrad.services.movielist;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.upgrad.utilities.DBOperations;

public class MovieListServices 
{
	private static List<MovieBO> movieList=new ArrayList<MovieBO>();
	
	public static List<MovieBO> getMovieList(List<WebElement> movieNames,List<WebElement> releaseyears,List<WebElement> ratings,String testCaseName) throws SQLException, IOException
	{
		
		for(int i=0;i<movieNames.size();i++)
		{
			MovieBO movieListBO=new MovieBO();
			
			String movieName=movieNames.get(i).getText();
			movieListBO.setMovieName(movieName);
			String releaseYear=releaseyears.get(i).getText();
			movieListBO.setReleaseYear(releaseYear);
			String rating=ratings.get(i).getText();
			movieListBO.setRating(rating);
			
			movieList.add(movieListBO);
		}
		DBOperations.insertRecord(movieList, testCaseName);
		return movieList;
	}
}
