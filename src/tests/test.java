package tests;

import org.openqa.selenium.*;

import com.selenium.common.basic.DriverFactory;
import com.selenium.init.*;

public class test {

	public static void main(String[] args){
		WebDriver wd = DriverFactory.getDriver();


		InitData initData = new InitData("bet");
		System.out.println(initData.next().get("Url"));
//		String url = initData.next().get("Url");
		String url = "http://www.baidu.com";
		System.out.println(url);
		wd.get(url);		
//		wd.get(initData.next().get("Url"));
//		String e = initData.getElement("ËÑË÷ÊäÈë¿ò").get("Value");
//		WebElement we = wd.findElement(By.id(e));
//		we.click();
//		we.sendKeys("selenium");
//		WebElement we1 = wd.findElement(By.id("su"));
//		we1.click();
	}	
}
