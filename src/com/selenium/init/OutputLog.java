/*******************************************************************************************************************
类名：InitOutputLog
功能:写入日志
参数: 
返回值: 无
历史记录: [2015-06-26]Black-创建初始版本
'*******************************************************************************************************************/
/**
* 将指定字符串写入文件。如果给定的文件路径不存在，将新建文件后写入。
* @param log       要写入文件的字符串
* @param filePath      文件路径的字符串表示形式，目录的层次分隔可以是“/”也可以是“\\”
* @param isAppend      true：追加到文件的末尾；false：以覆盖原文件的方式写入
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
