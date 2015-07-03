package com.selenium.common.basic;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.selenium.init.InitConfig;

public class DriverFactory {

	private static InitConfig ic;
	private static String browser;
	
	public static WebDriver getDriver(){
		ic = new InitConfig();
		browser = ic.getConfig("Browser");
		
		switch(browser){
		
		case "HtmlUnitDriver":
			HtmlUnitDriver htud = new HtmlUnitDriver();
			return htud;
			
		case "Chrome":
			WindowsUtils.tryToKillByName("chrome.exe");

			String chromedriver = null;
			if (ic != null) {
				chromedriver = ic.getConfig("Chromedriver");
			}
			System.setProperty("webdriver.chrome.driver", chromedriver);
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches",Arrays.asList("--start-maximized"));
			options.addArguments("--test-type", "--start-maximized");
			WebDriver driverChrome = new ChromeDriver(options);
			return driverChrome;
			
		case "Firefox":
			WindowsUtils.tryToKillByName("firefox.exe");

			String fireBug = null;
			if (ic != null) {
				fireBug = ic.getConfig("FireBug");
			}
			File file = new File(fireBug);
			FirefoxProfile profile = new FirefoxProfile();
			try {
				profile.addExtension(file);
				profile.setPreference("extensions.firebug.currentVersion", "2.0.4");
				profile.setPreference("extensions.firebug.allPagesActivation","off");
			} catch (IOException e3) {
				e3.printStackTrace();
			}
			WebDriver driverFirefox = new FirefoxDriver(profile);
			return driverFirefox;
			
		case "IE":
			WindowsUtils.tryToKillByName("iexplore.exe");

			String IEDriverServer = null;
			if (ic != null) {
				IEDriverServer = ic.getConfig("IEDriverServer");
			}
			System.setProperty("webdriver.ie.driver", IEDriverServer);
			WebDriver driverIE = new InternetExplorerDriver();
			return driverIE;
			
		default:
			System.out.println("≈‰÷√≤ª’˝»∑");
			return null;
		}
		
	}

}
