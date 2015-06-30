package com.testmain;

import com.selenium.init.*;
import com.selenium.testcase.bet.TestInfo;

public class TestMain {
	
	public static void main(String[] args) {
		
		TestInfo testInfo = new TestInfo();
		System.out.println(testInfo.PackageInfo());
		InitData initData = new InitData(testInfo.PackageInfo());	

		test_001 a = new test_001(initData.next());
		System.out.println(a.test());
    }
	
}

