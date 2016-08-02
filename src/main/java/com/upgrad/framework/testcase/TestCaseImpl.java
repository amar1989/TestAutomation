package com.upgrad.framework.testcase;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.upgrad.framework.configprop.ConfigPropertiesBO;
public class TestCaseImpl 
{
	
	private static String testCaseFile;
	
	
	private static HSSFSheet sheet;
	private static List<TestCase> testCaseList;
	
	private static String testCaseName="";
	private static String status="";
	
	private static FileInputStream file=null;
  
	private static TestCase testCase;
	
	
	static
	{
	   getTestCaseList();
	}

	public static List<TestCase> getTestCaseList()
	{

		testCaseFile=ConfigPropertiesBO.getTestCaseFileLoc();
		
        testCaseList = new ArrayList<TestCase>();

		try {
			 file = new FileInputStream(new File(testCaseFile));

			HSSFWorkbook workbook = new HSSFWorkbook(file);

			sheet = workbook.getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {

				testCase = new TestCase();

				Row row = rowIterator.next();

				Cell testCaseNameCell = row.getCell(0);
				Cell statusCell = row.getCell(1);
				
				

				testCaseName = testCaseNameCell.getStringCellValue();
				status = statusCell.getStringCellValue();
				
				
                
                	
				testCase.setTestCaseName(testCaseName);
				testCase.setStatus(status);
               
				
                testCaseList.add(testCase);
                

			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();

		}
		return testCaseList;
	}

	public static List<String> getTestCaseNameList(String flag)
	{
		
		List<String> testCaseNameList = new ArrayList<String>();
		List<TestCase> testCaseList = getTestCaseList();
		for (TestCase testCase : testCaseList) 
		{
			if (testCase.getStatus().equals(flag)) 
			{
				testCaseNameList.add(testCase.getTestCaseName());
			}
		}
		
		return testCaseNameList;
	}
	
	public static void main(String str[])
	{
		List<String> testCaseNameList1=getTestCaseNameList("Y");
		for(String testCase:testCaseNameList1)
		{
			System.out.println(testCase);
		}
	}
	
}

