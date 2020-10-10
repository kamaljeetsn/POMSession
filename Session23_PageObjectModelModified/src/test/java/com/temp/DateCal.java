package com.temp;

import java.util.Date;

public class DateCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Date d = new Date();
		//String filename = d.toString().replace(":", "_").replace(" ", "_") + ".html";
		System.out.println(d);
		String filename = d.toString().replace(":", "_").replace(" ", "_")+".html";
		System.out.println(filename);
		
	}
	
	
}
