package com.upgrad.services.movielist;

public class MovieBO {
	
	private String movieName=null;
	private String releaseYear=null;
	private String rating=null;
	
	public String getMovieName()
	{
		return movieName;
	}
	public void setMovieName(String movieName) 
	{
		this.movieName = movieName;
	}
	public String getReleaseYear()
	{
		return releaseYear;
	}
	public void setReleaseYear(String releaseYear) 
	{
		this.releaseYear = releaseYear;
	}
	public String getRating() 
	{
		return rating;
	}
	public void setRating(String rating) 
	{
		this.rating = rating;
	}
	

}
