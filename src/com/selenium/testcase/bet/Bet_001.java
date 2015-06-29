package com.selenium.testcase.bet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.init.OutputLog;

public class Bet_001 {
	
	public static void enterCqssc(WebDriver driver){
		
		WebElement cqssc = driver.findElement(By.className("title_active"));
		
		cqssc.click();
		
		driver.switchTo().frame("main");
		WebElement div = driver.findElement(By.className("lottery_frame"));
		WebElement current_issue = div.findElement(By.id("current_issue"));
				
		OutputLog.log("当前销售：" + current_issue.getText() + "期");
		
	}
//	public String toString() {
//		return this.getClass().getName() + "{browserName:" + browser + ", url:" + url + ", userName:" + userName + ",passWord:" + password + "}";
//	}
	
}
