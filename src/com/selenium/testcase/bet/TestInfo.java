/*******************************************************************************************************************
类名：TestInfo
功能:获取测试类相关信息
参数: 
返回值: 包名类名等
历史记录: [2015-06-29]Black-创建初始版本
'*******************************************************************************************************************/


package com.selenium.testcase.bet;

public class TestInfo {

	public String PackageInfo(){
	
//    	StackTraceElement stack[] = Thread.currentThread().getStackTrace(); 
//    	String classinfo = "";
//    	for (StackTraceElement ste : stack) {
//    		String methodinfo = ste.getClassName()+":"+ste.getMethodName();
//    		classinfo+=" "+methodinfo;   		
//    		}
//    	System.out.println(classinfo);
//    	
//    	int a = classinfo.lastIndexOf(":");
//    	int b = classinfo.lastIndexOf(".");
//    	String packageinfo = classinfo.substring(b+1,a);
		String packageName = this.getClass().getPackage().getName();
		int tmp = packageName.lastIndexOf(".");
		String packageInfo = packageName.substring(tmp+1,packageName.length());
		
	return packageInfo;
	}

}
