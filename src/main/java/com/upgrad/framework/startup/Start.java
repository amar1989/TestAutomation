package com.upgrad.framework.startup;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;


import com.upgrad.framework.testcase.TestCaseImpl;
import com.upgrad.reporting.TestCaseReporting;


public class Start {
	
	public static void main(String str[]) throws IOException, SQLException
	{
		
		List<XmlSuite> listXmlSuite=new ArrayList<XmlSuite>();
		List<XmlClass> listXmlClass=new ArrayList<XmlClass>();
		List<String> includeTestCaseName=TestCaseImpl.getTestCaseNameList("Y");
		
		List<String> excludeTestcaseName=TestCaseImpl.getTestCaseNameList("N");
		
		XmlSuite xmlSuite=new XmlSuite();
		XmlClass xmlClass;
		XmlTest test=new XmlTest(xmlSuite);
		//XmlTest xmlTest=new XmlTest(xmlSuite);
		List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
		classLoadersList.add(ClasspathHelper.contextClassLoader());
		classLoadersList.add(ClasspathHelper.staticClassLoader());

		Reflections reflections = new Reflections(new ConfigurationBuilder()
		    .setScanners(new SubTypesScanner(false), new ResourcesScanner())
		    .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
		    .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("com.upgrad.testcases"))));
		
		Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);
		List<XmlInclude> includeList=new ArrayList<XmlInclude>();
		for(String names:includeTestCaseName)
		{
			includeList.add(new XmlInclude(names));
		}
		
		for(Class classList:classes)
		{
			xmlClass=new XmlClass(classList.getName());
			xmlClass.setIncludedMethods(includeList);
			xmlClass.setExcludedMethods(excludeTestcaseName);
			listXmlClass.add(xmlClass);
		}
		test.setXmlClasses(listXmlClass);
		listXmlSuite.add(xmlSuite);
		TestNG testng=new TestNG();
		testng.setXmlSuites(listXmlSuite);
		testng.run();
		TestCaseReporting.writeReport();

	}

}
