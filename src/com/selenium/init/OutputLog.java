/*******************************************************************************************************************
������InitOutputLog
����:д����־
����: 
����ֵ: ��
��ʷ��¼: [2015-06-26]Black-������ʼ�汾
'*******************************************************************************************************************/
/**
* ��ָ���ַ���д���ļ�������������ļ�·�������ڣ����½��ļ���д�롣
* @param log       Ҫд���ļ����ַ���
* @param filePath      �ļ�·�����ַ�����ʾ��ʽ��Ŀ¼�Ĳ�ηָ������ǡ�/��Ҳ�����ǡ�\\��
* @param isAppend      true��׷�ӵ��ļ���ĩβ��false���Ը���ԭ�ļ��ķ�ʽд��
*/ 

package com.selenium.init;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OutputLog {
      
	    public static boolean writeIntoFile(String log, String filePath, boolean isAppend){
	    	 	
	        boolean isSuccess = true;
	        String filePathTurn = filePath.replaceAll("\\\\", "/");
	        int index = filePathTurn.lastIndexOf("/");
	        String dir = filePath.substring(0, index);
	        File fileDir = new File(dir);
	        fileDir.mkdirs();
	        File file = null;
	        try {
	            file = new File(filePath);
	            file.createNewFile();
	        } catch (IOException e) {
	            isSuccess = false;
	            e.printStackTrace();
	        }
	        FileWriter fileWriter = null;
	        try {
	            fileWriter = new FileWriter(file, isAppend);           
	            fileWriter.write(log);
	            fileWriter.flush();
	        } catch (IOException e) {
	            isSuccess = false;
	            e.printStackTrace();
	        } finally{
	            try {
	                fileWriter.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	         
	        return isSuccess;
	    }
	       
	    public static void log(String log){
	    	
	    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateinfo = "[" + df.format(new Date()) + "]";
	    	
	    	StackTraceElement stack[] = Thread.currentThread().getStackTrace(); 
	    	String classinfo = "";
	    	for (StackTraceElement ste : stack) {
	    		String methodinfo = ste.getClassName()+":"+ste.getMethodName();
	    		classinfo+=" "+methodinfo;   		
	    		}
	    	
	    	String loginfo = dateinfo + " " + classinfo + "  " + log + "\r\n";

	    	InitConfig initConfig = new InitConfig();	    	
	    	String path = initConfig.getConfig("Log_dir");
	    	OutputLog.writeIntoFile(loginfo, path, true);
	    }

}
