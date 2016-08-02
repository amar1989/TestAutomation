package com.upgrad.framework.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.upgrad.framework.testcase.TestCase;
import com.upgrad.framework.testcase.TestCaseImpl;

public class TestDataImpl 
{
		private static List<TestData> testDataList=null;
		private static String filePath="TestData";
		private static FileInputStream inputStream=null;
		

		public static List<TestData> getTestDataList(String testCaseName) throws IOException 
		{
			testDataList = new ArrayList<>();
			
			List<TestCase> testCaseList = TestCaseImpl.getTestCaseList();
			String testDataFile = null;
			String key="";
			String value="";
			
			for (TestCase testCase : testCaseList)
			{
				if (testCase.getTestCaseName().equals(testCaseName)) 
				{
					testDataFile = testCase.getTestDataFile();
					System.out.println(testDataFile);
					break;
				}
			}
			
			
			String fileName = filePath + "/" + testDataFile;
            
				
			testDataList = new ArrayList<TestData>();

			try {
				   inputStream = new FileInputStream(new File(fileName));

					HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

					HSSFSheet sheet = workbook.getSheetAt(0);

					Iterator<Row> rowIterator = sheet.iterator();
					
					while (rowIterator.hasNext()) 
					{

						TestData testData = new TestData();

						Row row = rowIterator.next();

						Cell keyCell = row.getCell(0);
						Cell valueCell = row.getCell(1);
						
					    key = keyCell.getStringCellValue();
						value = valueCell.getStringCellValue();
						
					    testData.setKey(key);
					    testData.setValue(value);
		              
						testDataList.add(testData);
		                

					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();

				}
				return testDataList;
			}
		
		public static String getValue(String key,String testCaseName) throws IOException
		{
			String value="";
			System.out.println(testCaseName);
			List<TestData> testDataList1=getTestDataList(testCaseName);
			for(TestData testData:testDataList1)
			{
				if(testData.getKey().equalsIgnoreCase("key"))
				{
					value=testData.getValue();
					break;
				}
			}
			return value;
		}
}
