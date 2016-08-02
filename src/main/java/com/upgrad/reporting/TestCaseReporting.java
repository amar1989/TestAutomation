package com.upgrad.reporting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;



public class TestCaseReporting {
	
    private static StringBuilder htmlWriter;
	
	private static String fileName="Report/TestReport.html";
	
	public  static int counter=0;
	
	
	static
	{
		
	    htmlWriter=new StringBuilder();
		htmlWriter.append("<html>");
		htmlWriter.append("<body>");
		
		htmlWriter.append("<table align=center border=2 CELLPADDING=6>");
		htmlWriter.append("<tr><td colspan=\"8\"><h2 align=\"center\">Test Report</td></tr>");
		htmlWriter.append("<tr><td width=\"40%\">Test Case Name</td><td>Status</td><td>Test Report</td></tr>");
	}
	public static void writeTestCase(String testCaseName,String status,String reportFile23) throws IOException
	{
		
	    String script="<tr><td>"+testCaseName+"</td><td>"+status+"</td><td><a href="+reportFile23+">Response</a></td></tr>";
		htmlWriter.append(script);
		
	}
	
	public static void writeReport() throws IOException, SQLException 
	{
		System.out.println("Writing Report....");
		List<TestResult> testResultList=TestResultImpl.getTestResultList();
		
		for(TestResult testResult:testResultList)
		{
			String testCaseName=testResult.getTestCasename();
			String status=testResult.getStatus();
			String fileName=CreateHtmlReport.getHtmlReportFile();
			System.out.println("fileName :::"+fileName);
			writeTestCase(testCaseName,status,fileName);
		}
		 writeFooter();	
	}
	public static void writeFooter() throws IOException
	{
		try
		{
			htmlWriter.append("</table>");
			htmlWriter.append("</body>");
			htmlWriter.append("</html>");
			
			WriteToFile(htmlWriter.toString(),fileName);
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
			if (file.exists()) {
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
