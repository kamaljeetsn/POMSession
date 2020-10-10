package com.temp;

public class XlsReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xls_Reader xls = new Xls_Reader("D:\\Trainings\\Selenium\\Workspace1\\Session23_PageObjectModelModified\\TestData", "bookingTest.xlsx");
		
		System.out.println(xls.getRowCount("bookingTest"));
		System.out.println(xls.getColumnCount("bookingTest"));
		System.out.println(xls.getCellData("bookingTest", "Adult", 2));

	}

}
