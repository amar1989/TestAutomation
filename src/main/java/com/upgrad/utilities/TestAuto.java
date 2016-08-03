package com.upgrad.utilities;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestAuto {

	@Test
	public void imdbAuto() throws InterruptedException
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.imdb.com/");
		Thread.sleep(2000);
		WebElement element1=driver.findElement(By.xpath("//span[@class=\"widget_header\"]/span[@class=\"oneline\"]/a/h3[contains(text(),\"IMDb's Top Rated Indian Movies\")]"));
		element1.click();
		Thread.sleep(2000);
		List<WebElement> elements=driver.findElements(By.xpath("//div[2]/div[3]/div/div[1]/div/span/div/div/div[2]/table/tbody/tr/td[2]/a"));
		for(WebElement ele:elements)
		{
			System.out.println(ele.getText());
		}
	}
}
