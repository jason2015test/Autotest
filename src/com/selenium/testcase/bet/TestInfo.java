/*******************************************************************************************************************
������TestInfo
����:��ȡ�����������Ϣ
����: 
����ֵ: ����������
��ʷ��¼: [2015-06-29]Black-������ʼ�汾
'*******************************************************************************************************************/


package com.selenium.testcase.bet;

public class TestInfo {

	public String PackageInfo(){
	
		String packageName = this.getClass().getPackage().getName();
		int tmp = packageName.lastIndexOf(".");
		String packageInfo = packageName.substring(tmp+1,packageName.length());
		
	return packageInfo;
	}

}
