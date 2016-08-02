package com.upgrad.pages.movieslist;

import java.io.IOException;

import org.openqa.selenium.By;

import com.upgrad.utilities.UIElements;

public class ImdbMoviesList 
{
	
	static 
	{
		try 
		{
			UIElements.createWebElementMap("Resources/imdb.xls");
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	public static final By moviesLink=UIElements.getUIElement("movies_link");
	public static final By moviesName=UIElements.getUIElement("movies_name");
	public static final By mviesRating=UIElements.getUIElement("mvies_rating");
	public static final By releaseYear=UIElements.getUIElement("release_year");

}
