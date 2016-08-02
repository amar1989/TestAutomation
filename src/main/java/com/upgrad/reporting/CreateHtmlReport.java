package com.upgrad.reporting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

import com.upgrad.services.movielist.MovieBO;
import com.upgrad.utilities.DBOperations;

public class CreateHtmlReport {
	
private static StringBuilder htmlWriter1;
	
	private static String fileName="/Movies.html";
	public  static int counter=0;
	
	static
	{
		
		
		htmlWriter1=new StringBuilder();
		htmlWriter1.append("<html>");
		htmlWriter1.append("<body>");
		
		htmlWriter1.append("<table align=center border=2 CELLPADDING=6>");
		htmlWriter1.append("<tr><td colspan=\"8\"><h2 align=\"center\">Top 250 Movies Report</td></tr>");
		htmlWriter1.append("<tr><td width=\"40%\">Movie Name</td><td>Release Year</td><td>Ratings</td></tr>");
		
	}
	
	public static void writeTestCase(String movieName,String releaseYear,String ratings) throws IOException
	{
		
	    String script="<tr><td>"+movieName+"</td><td>"+releaseYear+"</td><td>"+ratings+"</td></tr>";
		htmlWriter1.append(script);
		
	}
	
	public static String getHtmlReportFile() throws SQLException, IOException
	{
	   List<MovieBO> movieList=DBOperations.getMovieList();
	   
	   for(MovieBO movie:movieList)
	   {
		   String movieName=movie.getMovieName();
		   String releaseYear=movie.getReleaseYear();
		   String rating=movie.getRating();
		   
		   writeTestCase(movieName,releaseYear,rating);
		   
	   }
	   writeFooter();
	   return fileName;
	}
	
	public static void writeFooter() throws IOException
	{
		try
		{
			htmlWriter1.append("</table>");
			htmlWriter1.append("</body>");
			htmlWriter1.append("</html>");
			
			WriteToFile(htmlWriter1.toString(),fileName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void WriteToFile(String fileContent, String fileName) throws IOException
	{
	    try
	    {
			File file = new File(fileName);
			if (file.exists()) 
			{
				try 
				{
					
					file.createNewFile();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			}
			
			OutputStream outputStream = new FileOutputStream(file,false);
			Writer writer = new OutputStreamWriter(outputStream);
			writer.write(fileContent);
			writer.close();
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
  }

}
