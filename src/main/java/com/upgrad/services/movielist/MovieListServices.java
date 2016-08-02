package com.upgrad.services.movielist;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.upgrad.utilities.DBOperations;

public class MovieListServices 
{
	private static List<MovieListBO> movieList=new ArrayList<MovieListBO>();
	
	public static List<MovieListBO> getMovieList(List<WebElement> movieNames,List<WebElement> releaseyears,List<WebElement> ratings) throws SQLException
	{
		
		for(int i=0;i<movieNames.size();i++)
		{
			MovieListBO movieListBO=new MovieListBO();
			
			String movieName=movieNames.get(i).getText();
			movieListBO.setMovieName(movieName);
			String releaseYear=releaseyears.get(i).getText();
			movieListBO.setReleaseYear(releaseYear);
			String rating=ratings.get(i).getText();
			movieListBO.setRating(rating);
			
			movieList.add(movieListBO);
		}
		DBOperations.insertRecord(movieList);
		return movieList;
	}
}
