/*******************************************************************************************************************
类名：InitData
功能:通过excel表格导入测试所需数据
参数: 
返回值: Map<String, String>
历史记录: [2015-06-30]Black-创建初始版本
'*******************************************************************************************************************/

package com.selenium.init;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	private boolean  status1 = true;
	private boolean  status2 = false;

	public InitData(String packageInfo) {
		try {

			InitConfig initConfig = new InitConfig();
			String path = initConfig.getConfig("Data_dir");
//			String filePath = path.replaceAll("\\\\", "/");
			
			InputStream inputStream = null;
			try {
				inputStream = new FileInputStream(path);
			} catch(FileNotFoundException ex){
				System.out.println(ex);
				status1 = false;
				return;
			}
					
			book = Workbook.getWorkbook(inputStream);
			
			String sheetName[] = book.getSheetNames();
			for(int i=0;i<sheetName.length;i++){
				if(sheetName[i].equals(packageInfo))
					{
					this.status2 = true;
					continue;
					}
			}
			if (!status2)
				{
				System.out.println("找不到相应的sheet,初始化数据失败");
				return;
				}
			//取sheet
			sheet = book.getSheet(packageInfo);
			rowNum = sheet.getRows();
			Cell[] cell = sheet.getRow(0);
			columnNum = cell.length;
			columnnName = new String[cell.length];

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
		if ((!this.status1)&(!this.status2))
		{
			return false;
		}
		if (this.rowNum == 0 || this.currentRowNo >= this.rowNum) {

			try {
				book.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
		} else {

			if ((sheet.getRow(currentRowNo))[0].getContents().equals(""))
				return false;
				return true;
			}
		}

	public Map<String, String> next() {
		if ((!this.status1)&(!this.status2))
		{
			return null;
			}

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
		if ((!this.status1)&(!this.status2))
		{
		return;
		}
		throw new UnsupportedOperationException("remove unsupported.");
	}
}