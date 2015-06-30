
/*******************************************************************************************************************
������InitBrowser
����:ǰ̨��ص�ҵ������������¼
����: 
����ֵ: ���������-driver
��ʷ��¼: [2015-06-25]Black-������ʼ�汾
'*******************************************************************************************************************/

package com.selenium.common.business;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.init.*;

public class FrontEnd {
	
	public static void Enter(WebDriver driver){
		
		InitBrowser.Init();
		
		driver.get("www.baidu.com");
			
		driver.manage().window().maximize();
		
		OutputLog.log("����ϵͳ��ҳ:" + driver.getTitle());
		
	}

	public static void logIn(WebDriver driver){

		
		WebElement username = driver.findElement(By.id("username"));		
		username.click();
//		username.sendKeys(initData.getUsername());
				
		WebElement password = driver.findElement(By.id("password"));
		password.click();
//		password.sendKeys(initData.getPassword());
		
		WebElement code = driver.findElement(By.id("code"));
		code.click();
		code.sendKeys("1111");
				
		WebElement submit = driver.findElement(By.id("loginSubmit"));		
		submit.click();
		
//		WebElement div = driver.findElement(By.className("top_loginhover"));		
//		WebElement a = div.findElement(By.className("balance"));
//		
//		OutputLog.testLog("�û����Ϊ��" + (a.getText()));
				
	}
	
}
