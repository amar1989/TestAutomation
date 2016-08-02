package com.upgrad.framework.configprop;

public class ConfigPropertiesBO {
	
	private static String proUrl=null;
	private static String userId=null;
	private static String password=null;
	private static String testCaseFileLoc=null;
	private static String testDataFileLoc=null;
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
	public  static void setUrl(String url) {
		proUrl = url;
	}
	public static String getUserId() 
	{
		return userId;
	}
	public static String getTestCaseFileLoc()
	{
		return testCaseFileLoc;
	}
	public static void setTestCaseFileLoc(String testCaseFileLocation) 
	{
		testCaseFileLoc = testCaseFileLocation;
	}
	public static String getTestDataFileLoc() 
	{
		return testDataFileLoc;
	}
	public static void setTestDataFileLoc(String testDataFileLocation) {
		testDataFileLoc = testDataFileLocation;
	}
	public static void setUserId(String loginId) {
		userId = loginId;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String pass) {
		password = pass;
	}
	
	
	

}
