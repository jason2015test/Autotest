package tests;

//import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import com.selenium.common.basic.BasePage;
import com.selenium.common.basic.DriverFactory;
import com.selenium.init.*;

public class test {

	
	@Test
	public void testcase() throws Exception{
//	public static void main(String[] args) throws Exception{
		WebDriver wd = DriverFactory.getDriver();
		InitData initData = new InitData("bet");
		Map<String, String> map = new HashMap<String, String>();
		map = initData.next();
		BasePage bp = new BasePage(wd);

		wd.get(map.get("Url"));
		
		bp.click("��¼��ť");
		
		Thread.sleep(10);
//		wd.implicitly_wait(10);
		bp.sendkey("�û��������",map.get("UserName"));
		Thread.sleep(5);
		bp.sendkey("���������", map.get("PassWord"));
		bp.click("��¼");
		
	}
}
