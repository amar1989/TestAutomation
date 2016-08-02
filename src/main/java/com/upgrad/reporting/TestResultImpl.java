package com.upgrad.reporting;

import java.util.ArrayList;
import java.util.List;

public class TestResultImpl 
{
	private static List<TestResult> testResultList=new ArrayList<TestResult>();
	
	public static void createTestResultList(String testCaseName,String status)
	{
		TestResult testResult=new TestResult();
		
		testResult.setTestCasename(testCaseName);
		testResult.setStatus(status);
		
		testResultList.add(testResult);
	}
	public static List<TestResult> getTestResultList()
	{
	   return testResultList;
	}

}
