package com.framework.yatra.util;

import java.util.Hashtable;

public class DataUtil {
	
	public static Object[][] getData(Xls_Reader xls,String testName){
		int rows = xls.getRowCount(testName);
		int cols = xls.getColumnCount(testName);
		System.out.println("No. of rows : " + rows);
		System.out.println("No. of columns : " + cols);
		Object[][] data = new Object[rows-1][1];
		Hashtable<String, String> table = null;
		int dataRow=0;
		for(int irow=2;irow<=rows;irow++){
			table = new Hashtable<String, String>();
			for(int icol=0;icol<cols;icol++){
				String key = xls.getCellData(testName, icol, 1);
				//System.out.println(key);
				String value = xls.getCellData(testName, icol, irow);
				//System.out.println(value);
				table.put(key, value);
			}
			data[dataRow][0]=table;
			dataRow++;
		}
		//System.out.println(table.get("DepartFrom"));
		return data;
	
	}

	
	public static boolean isExecutable(Xls_Reader xls,String testName){
		String sheetName="TestExecution";
		int rows = xls.getRowCount(sheetName);
		int cols = xls.getColumnCount(sheetName);
		for(int irow=2;irow<=rows;irow++){
			for(int icol=0;icol<cols;icol++){
				String celltestname = xls.getCellData(sheetName, "TestCaseName", irow);
				if(celltestname.equalsIgnoreCase(testName)){
					String cellrunmode = xls.getCellData(sheetName, "RunMode", irow);
					if(cellrunmode.equalsIgnoreCase("Y")){
						return true;
					}else{
						return false;
					}
				}
			}
		}
		return false;
		
	}
}
