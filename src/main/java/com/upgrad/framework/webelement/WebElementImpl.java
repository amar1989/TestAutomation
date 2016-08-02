package com.upgrad.framework.webelement;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;


public class WebElementImpl 
{

	private static HSSFWorkbook workbook=null;
	private static HSSFSheet sheet=null;
	private static FileInputStream elementStream=null;
	private static Map<String,By> elementMap=null;
	
	
	
	public static Map<String,By> createWebElementList(String fileName) throws IOException
	{
		elementMap=new HashMap<String,By>();
		
		
			elementStream = new FileInputStream(new File(fileName));
			workbook=new HSSFWorkbook(elementStream);
			sheet=workbook.getSheetAt(0);
			
		    Iterator<Row> rowIterator=sheet.iterator();
		
			while(rowIterator.hasNext())
			{
				Row row=rowIterator.next();
				if(row.getRowNum()==0)
				{
					   continue; 
			    }
				String webElement=row.getCell(0).getStringCellValue();
				String locator=row.getCell(1).getStringCellValue();
				String value=row.getCell(2).getStringCellValue();
				System.out.println(webElement+""+locator+""+value);
				By element=getWebElement(locator,value);
				
				elementMap.put(webElement, element);
			}
			return elementMap;
		}
	
	private static By getWebElement(String locator,String value)
	{
		By element=null;
		if(locator.equalsIgnoreCase("id"))
		{
			element=By.id(value);
		}
		else if(locator.equalsIgnoreCase("xpath"))
		{
			element=By.xpath(value);
		}
		else if(locator.equalsIgnoreCase("csspath"))
		{
			element=By.cssSelector(value);
		}
		else if(locator.equalsIgnoreCase("name"))
		{
			element=By.name(value);
		}
		else if(locator.equalsIgnoreCase("className"))
		{
			element=By.className(value);
		}
		else
		{
			System.out.println("sorry wrong Entry!!!!!");
		}
		return element;
	}
	
	public static By getElement(String element)
	{
		By byElement=null;
		Set<String> keyset=elementMap.keySet();
		for(String ele:keyset)
		{
			if(ele.equalsIgnoreCase(element))
			{
				byElement=elementMap.get(ele);
			}
		}
		return byElement;
	}
	
}
