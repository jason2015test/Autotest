/*
 * 对象的封装
 */

package com.selenium.common.basic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.init.InitData;

public class BasePage {
	
	protected WebDriver driver;
//	protected Map<String, String> map;
//	protected String objectName;
	
	protected InitData initData;
	
	protected BasePage(WebDriver driver) throws IOException {
		this.driver = driver;
		initData = new InitData("bet");
	}
	
	protected void sendkey(String name, String values){
		WebElement e = findElement(driver, name);
		e.sendKeys(values);
	}
	
	public WebElement findElement(WebDriver driver, String objectName)
			throws IOException {
			
			WebElement e;
			switch (initData.getElement(objectName).get("Type")) {
			case "xpath":
				e = driver.findElement(By.xpath(initData.getElement(objectName).get("Value")));
				break;
			case "id":
				e = driver.findElement(By.xpath(initData.getElement(objectName).get("Value")));
				break;
			case "name":
				e = driver.findElement(By.xpath(initData.getElement(objectName).get("Value")));
				break;
			case "cssSelector":
				e = driver.findElement(By.xpath(initData.getElement(objectName).get("Value")));
				break;
			case "className":
				e = driver.findElement(By.xpath(initData.getElement(objectName).get("Value")));
				break;
			case "tagName":
				e = driver.findElement(By.xpath(initData.getElement(objectName).get("Value")));
				break;
			case "linkText":
				e = driver.findElement(By.xpath(initData.getElement(objectName).get("Value")));
				break;
			case "partialLinkText":
				e = driver.findElement(By.xpath(initData.getElement(objectName).get("Value")));
				break;
			default:
				e = driver.findElement(By.xpath(initData.getElement(objectName).get("Value")));
			}
			return e;
		}
	

}
