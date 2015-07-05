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
		
		bp.click("登录按钮");
//		wd.implicitly_wait(10);
		bp.sendkey("用户名输入框",map.get("UserName"));
		bp.sendkey("密码输入框", map.get("PassWord"));
		bp.click("登录");
	}
}
