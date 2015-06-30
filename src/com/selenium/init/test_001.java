package com.selenium.init;

import java.util.HashMap;
import java.util.Map;

public class test_001 {
	
	Map<String, String> dataMap = new HashMap<String, String>();

	public test_001(Map<String, String> testData) {
		
		this.dataMap = testData;
	}
	
	public String test(){
		return dataMap.get("ºÅÂë");
	}
}
