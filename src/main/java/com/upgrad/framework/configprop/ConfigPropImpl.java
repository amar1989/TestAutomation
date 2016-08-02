package com.upgrad.framework.configprop;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ConfigPropImpl {
	private static Properties prop=null;
	private static FileInputStream is=null;
	private static ConfigPropertiesBO config=null;
	
	
    
	public static void loadProperties() throws IOException
	{
		prop=new Properties();
		is=new FileInputStream("config.properties");
		prop.load(is);
		config=new ConfigPropertiesBO();
		
		config.setPassword(prop.getProperty("password"));
		config.setUserId(prop.getProperty("username"));
		config.setUrl(prop.getProperty("url"));
		config.setTestCaseFileLoc(prop.getProperty("testCaseFileloc"));
		config.setBrowserName(prop.getProperty("browser"));
		
	}
}
