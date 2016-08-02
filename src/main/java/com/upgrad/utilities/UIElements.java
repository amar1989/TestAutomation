package com.upgrad.utilities;

import java.io.IOException;

import java.util.HashMap;

import java.util.Map;

import org.openqa.selenium.By;

import com.upgrad.framework.webelement.WebElementImpl;

public class UIElements {

	private static Map<String, By> elementMap = new HashMap<String, By>();

	public static By getUIElement(String webElement) {
		By by = null;
		by = elementMap.get(webElement);
		return by;
	}

	public static void createWebElementMap(String fileName) throws IOException {
		elementMap = WebElementImpl.createWebElementList(fileName);
	}

}
