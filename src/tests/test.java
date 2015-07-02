package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.*;

import com.selenium.init.*;

public class test {

	public static void main(String[] args){
		WebDriver wd = InitBrowser.Init();

		InitData initData = new InitData("bet");
		wd.get(initData.next().get("Url"));
		String e = initData.getElement("ËÑË÷ÊäÈë¿ò").get("Value");
		WebElement we = wd.findElement(By.id(e));
		we.click();
//		String k = initData.next().get("KeyWord");
		we.sendKeys("selenium");
//		String b = initData.getElement("ËÑË÷°´Å¥").get("Value");
		WebElement we1 = wd.findElement(By.id("su"));
		we1.click();
	}	
}
