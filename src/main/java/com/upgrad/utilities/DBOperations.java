package com.upgrad.utilities;

import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upgrad.framework.testdata.TestDataImpl;
import com.upgrad.services.movielist.MovieBO; 

public class DBOperations
{
	 
    public static Connection getConnection()
    {
    	Connection conn=null;
        try
        {
        	
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:product.db";
            conn = DriverManager.getConnection(dbURL);
            System.out.println("hello--1");
        } 
        catch (ClassNotFoundException ex) 
        {
            ex.printStackTrace();
        } 
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return conn;
    }
    
    public static void createTable(String tableName) throws SQLException
    {
    	Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String createTableSQL = "CREATE TABLE IF NOT EXISTS "+tableName+"(MOVIENAME VARCHAR(20) NOT NULL, RELEASE_YEAR VARCHAR(4) NOT NULL, RATING VARCHAR(4) NOT NULL)";
		
		
		try 
		{
			dbConnection = getConnection();
			
			preparedStatement = dbConnection.prepareStatement(createTableSQL);

			preparedStatement.executeUpdate();
			
			

		} 
		catch (SQLException e) 
		{

		 e.printStackTrace();

		} 
		finally 
		{

			if (preparedStatement != null)
			{
				preparedStatement.close();
			}

			if (dbConnection != null)
			{
				dbConnection.close();
			}

		}

	}

public static void insertRecord(List<MovieBO> movieList,String testCaseName) throws SQLException, IOException
{
	
	
	
	Connection dbConnection = null;
	PreparedStatement preparedStatement = null;
	String tableName=TestDataImpl.getValue("TableName", testCaseName);
  
	String insertTableSQL = "INSERT INTO "+tableName+""
			+ "(MOVIENAME, RELEASE_YEAR, RATING) VALUES"
			+ "(?,?,?)";
	
	

	try 
	{
		dbConnection = getConnection();
		if(dbConnection!=null)
		{
			
		    createTable(tableName);
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
	        
			for(MovieBO movieBO:movieList)
			{
			   
				preparedStatement.setString(1, movieBO.getMovieName());
				preparedStatement.setString(2, movieBO.getReleaseYear());
				preparedStatement.setString(3, movieBO.getRating());
				
				preparedStatement.executeUpdate();
			
			}
			System.out.println("Insertion of record completed");
		}
		else
		{
			System.out.println("Connection has not been created.");
			
		}
	}
	catch (SQLException e) 
	{
       
		e.printStackTrace();

	} 
	finally 
	{

		if (preparedStatement != null) 
		{
			preparedStatement.close();
		}

		if (dbConnection != null) 
		{
			dbConnection.close();
		}

	}

}
	/*public static void main(String str[])
	{
		Connection con=getConnection();
		System.out.println("connection :::"+con);
	}*/

	public static List<MovieBO> getMovieList(String testCaseName) throws SQLException, IOException
	{
		System.out.println("Fetching records from DB....");
		String tableName=TestDataImpl.getValue("TableName", testCaseName);
		List<MovieBO> moviesBOList=new ArrayList<MovieBO>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM "+tableName;
       
		try 
		{
			dbConnection = getConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			
			ResultSet rs = preparedStatement.executeQuery();
			

			while (rs.next())
			{
                MovieBO movie=new MovieBO();
                
				String movieName = rs.getString("MOVIENAME");
				
				movie.setMovieName(movieName);
				String releaseYear = rs.getString("RELEASE_YEAR");
			
				movie.setReleaseYear(releaseYear);
				String rating=rs.getString("RATING");
				movie.setRating(rating);
                
				moviesBOList.add(movie);
				
			}
           
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();

		} 
		finally 
		{

			if (preparedStatement != null)
			{
				preparedStatement.close();
			}

			if (dbConnection != null)
			{
				dbConnection.close();
			}

		}
        return moviesBOList;
	}
}

