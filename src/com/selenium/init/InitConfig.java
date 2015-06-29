/*******************************************************************************************************************
������InitConfig
����:��ȡ�����ļ������������ļ��������ļ��Լ���־�ļ���·��
����: 
����ֵ: ͨ��get���÷��ؾ��������
��ʷ��¼: [2015-06-25]Black-������ʼ�汾
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

