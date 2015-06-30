package com.testmain;

import com.selenium.init.*;
import com.selenium.testcase.bet.TestInfo;

public class TestMain {
	
	public static void main(String[] args) {
		
		TestInfo testInfo = new TestInfo();
		InitData initData = new InitData(testInfo.PackageInfo());
		
		while(initData.hasNext()){
		test_001 a = new test_001(initData.next());
		System.out.println(a.test());
		}
	}	
}

