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
	private Sheet    sheetObject = null;
	private int      rowNum = 0;
	private int      columnNum = 0;
	private int      rowNum1 = 0;
	private int      columnNum1 = 0;
	private int      currentRowNo = 0;
	private String[] columnnName;
	private String[] columnnName1;
	private String[] rowName1;
	private boolean  status1 = true;
	private boolean  status2 = false;
	private boolean  status3 = false;

	public InitData(String packageInfo) {
		try {

			InitConfig initConfig = new InitConfig();
			String path = initConfig.getConfig("Data_dir");
			String objectSheet = initConfig.getConfig("Object_sheet_name");
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
			
			//判断是否有与包名对应的sheet以及是否存在名为basic的sheet
			String sheetName[] = book.getSheetNames();
			for(int i=0;i<sheetName.length;i++){
				if(sheetName[i].equals(packageInfo))
					{
					this.status2 = true;
					}
				else if(sheetName[i].equals(objectSheet))
				{
					this.status3 = true;
				}
			}

			//加载与包名对应的sheet
			if (status2)
			{
				sheet = book.getSheet(packageInfo);
				rowNum = sheet.getRows();
				Cell[] cell = sheet.getRow(0);
				columnNum = cell.length;
				columnnName = new String[cell.length];

				for (int i = 0; i < cell.length; i++) {
					columnnName[i] = cell[i].getContents().toString();
				}
				this.currentRowNo++;
			}
			else
			{
				System.out.println("没有找到与包名对应的sheet");
			}
			if (status3)
			{
				this.sheetObject = book.getSheet(objectSheet);
				
				Cell[] cell1 = sheetObject.getColumn(0);
				Cell[] cell2 = sheetObject.getRow(0);
				rowNum1 = cell1.length;
				columnNum1 = cell2.length;
				rowName1 = new String[cell1.length];
				columnnName1 = new String[cell2.length];
				for (int i = 0; i < cell1.length; i++) {
					rowName1[i] = cell1[i].getContents().toString();
				}	
				for (int i = 0; i < cell2.length; i++) {
					columnnName1[i] = cell2[i].getContents().toString();
				}
			}
			else
			{
				System.out.println("没有找到对象库sheet");
			}
			if(!status1&!status2&!status3)
			{
				System.out.println("没有可加载的数据");
			}
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
	
	public Map<String, String> getElement(String element){
		if ((!this.status1)&(!this.status3))
		{
			return null;
		}
		int i = 0;
		boolean status3 = false;
		for (;i<this.rowNum1;i++)
		{
			if(this.rowName1[i].equals(element))
			{
				status3 = true;	
				break;
			}
		}
		if(!status3)
		{
			System.out.println("找不到指定的对象");
			return null;
		}
		Cell[] c = sheetObject.getRow(i);
		Map<String, String> data = new HashMap<String, String>();
		for (int j = 0; j < this.columnNum1; j++) {			
			String temp = "";
			try {
				temp = c[j].getContents().toString();
			} catch (ArrayIndexOutOfBoundsException ex) {
				temp = "";
			}
			
			data.put(this.columnnName1[j], temp);
		}
		return data;	
	}
	
	public void remove() {
		if ((!this.status1)&(!this.status2)&(!this.status3))
		{
		return;
		}
		throw new UnsupportedOperationException("remove unsupported.");
	}
}