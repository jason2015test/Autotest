package com.selenium.init;

import java.util.HashMap;
import java.util.Map;

public class test_001 {
	
	Map<String, String> dataMap = new HashMap<String, String>();

	public test_001(Map<String, String> testData) {
		
		this.dataMap = testData;
		System.out.println("haha");

	}
	
	public String test(){
		System.out.println("hehe");
		return dataMap.get("Íæ·¨ÀàĞÍ");
	}
}
