/*******************************************************************************************************************
类名：InitBrowser
功能:通过指定参数调用所选浏览器，完成浏览器初始化
参数: 
返回值: 浏览器对象-driver
历史记录: [2015-06-25]Black-创建初始版本
'*******************************************************************************************************************/

package com.selenium.init;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InitBrowser {
	
	public static WebDriver Init(){
		
		InitConfig initConfig = new InitConfig();
			
    	if(initConfig.getConfig("Browser").equals("ie")){
    		
    		System.setProperty("webdriver.ie.driver", "C:/webdriver/IEDriverServer.exe");
    		
    		WebDriver driver = new InternetExplorerDriver();
    	
    		return driver;
    		
    	}
    	
    	else if(initConfig.getConfig("Browser").equals("chrome")){
    		
    		System.setProperty("webdriver.chrome.driver", "C:/webdriver/chromedriver.exe");
    		
    		WebDriver driver = new ChromeDriver();
    	
    		return driver;
    		
    	}
    	
    	else if(initConfig.getConfig("Browser").equals("firefox")){
    		  		
    		WebDriver driver = new FirefoxDriver();
    		
    		return driver;
    		
    	}
    	else{
    		
    		OutputLog.log("browser setting error in config.xml");
    		
    		return null;
    	
    	}

	}
	
}
