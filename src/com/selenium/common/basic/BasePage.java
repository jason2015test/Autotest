/*******************************************************************************************************************
类名：BasePage
功能: 封装对象以及操作对象的方法
参数: 
返回值: 通过调用相应的方法返回具体的对象或者完成相应对象的操作
历史记录: [2015-07-05]Black-创建初始版本
'*******************************************************************************************************************/

package com.selenium.common.basic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.init.InitData;

public class BasePage {
	
	private WebDriver driver;
	private InitData initData;
	
	public BasePage(WebDriver driver) throws IOException {
		this.driver = driver;
		initData = new InitData("bet");
	}
	
	public void sendkey (String name, String values){
		findElement(this.driver,name).sendKeys(values);
	}
	
	public void click(String name) throws Exception {
		findElement(this.driver,name).click();
	}
	
	public WebElement getElement(String name) throws IOException {
		return findElement(this.driver, name);
	}
	
	public WebElement findElement(WebDriver driver, String objectName) {
			
		WebElement e = null;
		try{
			switch (initData.getElement(objectName).get("Type")) {
			case "xpath":
				e = driver.findElement(By.xpath(initData.getElement(objectName).get("Value")));
				break;
			case "id":
				e = driver.findElement(By.id(initData.getElement(objectName).get("Value")));
				break;
			case "name":
				e = driver.findElement(By.name(initData.getElement(objectName).get("Value")));
				break;
			case "cssSelector":
				e = driver.findElement(By.cssSelector(initData.getElement(objectName).get("Value")));
				break;
			case "className":
				e = driver.findElement(By.className(initData.getElement(objectName).get("Value")));
				break;
			case "tagName":
				e = driver.findElement(By.tagName(initData.getElement(objectName).get("Value")));
				break;
			case "linkText":
				e = driver.findElement(By.linkText(initData.getElement(objectName).get("Value")));
				break;
			case "partialLinkText":
				e = driver.findElement(By.partialLinkText(initData.getElement(objectName).get("Value")));
				break;
			default:
				e = driver.findElement(By.xpath(initData.getElement(objectName).get("Value")));
			}
		}catch (NoSuchElementException x){
			System.out.println(x);
		}
			return e;
		}
	

}
