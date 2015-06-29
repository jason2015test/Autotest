package com.selenium.init;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import jxl.*;

public class InitData{
	private Workbook book = null;
	private Sheet    sheet = null;
	private int      rowNum = 0;
	private int      currentRowNo = 0;
	private int      columnNum = 0;
	private String[] columnnName;

	public InitData(String packageInfo) {
		try {
			


			InitConfig initConfig = new InitConfig();
			String path = initConfig.getConfig("Data_dir");
			String filePath = path.replaceAll("\\\\", "/");
			
			InputStream inputStream = new FileInputStream(filePath);
			
			System.out.println(filePath);

			
			book = Workbook.getWorkbook(inputStream);
			//System.out.println(classname);
			//取sheet
			sheet = book.getSheet("bet");
			rowNum = sheet.getRows();
			Cell[] cell = sheet.getRow(0);
			columnNum = cell.length;
			columnnName = new String[cell.length];
			
			System.out.println(columnNum);

			for (int i = 0; i < cell.length; i++) {
				columnnName[i] = cell[i].getContents().toString();
			}
			this.currentRowNo++;
		} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("unable to read Excel data");
			}	
	}
	
	public boolean hasNext() {

		if (this.rowNum == 0 || this.currentRowNo >= this.rowNum) {

			try {
				book.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
		} else {
		// sheet下一行内容为空判定结束
			if ((sheet.getRow(currentRowNo))[0].getContents().equals(""))
				return false;
				return true;
			}
		}

	public Map<String, String> next() {

		Cell[] c = sheet.getRow(this.currentRowNo);
		Map<String, String> data = new HashMap<String, String>();

		for (int i = 0; i < this.columnNum; i++) {
			String temp = "";
			try {
				temp = c[i].getContents().toString();
			} catch (ArrayIndexOutOfBoundsException ex) {
				temp = "";
			}
			data.put(this.columnnName[i], temp);
		}
		this.currentRowNo++;
		return data;
	}
	
	public void remove() {
		throw new UnsupportedOperationException("remove unsupported.");
	}
	
}