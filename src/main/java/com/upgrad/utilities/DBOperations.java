package com.upgrad.utilities;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.upgrad.services.movielist.MovieListBO; 

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
  
            /*if (conn != null) 
            {
                System.out.println("Connected to the database");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                System.out.println("Driver version: " + dm.getDriverVersion());
                System.out.println("Product name: " + dm.getDatabaseProductName());
                System.out.println("Product version: " + dm.getDatabaseProductVersion());
                //conn.close();
            }*/
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
    
    public static void createTable() throws SQLException
    {
    	Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String createTableSQL = "CREATE TABLE IF NOT EXISTS MOVIELIST1(MOVIENAME VARCHAR(20) NOT NULL, RELEASE_YEAR VARCHAR(4) NOT NULL, RATING VARCHAR(4) NOT NULL)";
		
		
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

public static void insertRecord(List<MovieListBO> movieList) throws SQLException
{
	boolean flag=true;
	Connection dbConnection = null;
	PreparedStatement preparedStatement = null;

	String insertTableSQL = "INSERT INTO MOVIELIST1"
			+ "(MOVIENAME, RELEASE_YEAR, RATING) VALUES"
			+ "(?,?,?)";

	try 
	{
		dbConnection = getConnection();
		if(dbConnection!=null)
		{
		    createTable();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
	        
			for(MovieListBO movieBO:movieList)
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
			flag=false;
		}
	}
	catch (SQLException e) 
	{
        flag=false;
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
	 
	    
	/*public static void main(String str[]) throws SQLException
	{
		List<MovieListBO> movieList=getMovieList();
		for(MovieListBO movie:movieList)
		{
			System.out.println(movie.getMovieName()+"\t"+movie.getReleaseYear()+"\t"+movie.getRating());
		}
	}*/
	
	public static List<MovieListBO> getMovieList() throws SQLException
	{
		
		List<MovieListBO> moviesBOList=new ArrayList<MovieListBO>();
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM MOVIELIST1";

		try 
		{
			dbConnection = getConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			//preparedStatement.setInt(1, 11);
			
			ResultSet rs = preparedStatement.executeQuery();
			

			while (rs.next())
			{
                MovieListBO movie=new MovieListBO();
                
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

