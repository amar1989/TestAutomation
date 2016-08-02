package com.upgrad.framework.configprop;

public class ConfigPropertiesBO {
	
	private static String proUrl=null;
	
	private static String testCaseFile=null;
	
	private static String browserName=null;
	
	static
	{
		try
		{
			ConfigPropImpl.loadProperties();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public  static void setUrl(String url) {
		proUrl = url;
	}
	public static String getUrl() 
	{
		return proUrl;
	}
	public static String getBrowserName()
	{
		return browserName;
	}
	public static void setBrowserName(String browserName) 
	{
		ConfigPropertiesBO.browserName = browserName;
	}
	public static String getTestCaseFileLoc()
	{
		return testCaseFile;
	}
	public static void setTestCaseFileLoc(String testCaseFileLocation) 
	{
		testCaseFile = testCaseFileLocation;
	}
	
	
	
	

}
