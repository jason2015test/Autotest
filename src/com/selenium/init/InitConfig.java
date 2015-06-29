/*******************************************************************************************************************
类名：InitConfig
功能:读取配置文件，返回数据文件、报告文件以及日志文件的路径
参数: 
返回值: 通过get调用返回具体的配置
历史记录: [2015-06-25]Black-创建初始版本
'*******************************************************************************************************************/

package com.selenium.init;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class InitConfig {

	public String getConfig(String key){
		
		String value = null; 
		Properties prop = new Properties();   
		InputStream in = Object.class.getResourceAsStream("/Config.properties");
		try {
			prop.load(in);
			value = prop.getProperty(key).trim();
		} catch (IOException e) {   
			e.printStackTrace();   
		} 	
		
		String path = null;
		int a = value.lastIndexOf("/");
		if (a != -1)
		{	
			URL base = getClass().getResource("/");
			try {
				path = new File(base.getFile(),value).getCanonicalPath();
			}catch (IOException e) {   
				e.printStackTrace();   
			}
				return path;
			}
		else
			return value;
	}

	public static void main(String[] args){
		InitConfig a = new InitConfig();
		System.out.println(a.getConfig("Report_file"));
	}
}

