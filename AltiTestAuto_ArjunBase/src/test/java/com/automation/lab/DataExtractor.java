package com.automation.lab;

import aiframework.core.utils.Xls_Reader;

public class DataExtractor{

	public static Xls_Reader objectRepoXLS;
	
	public static void main(String[] args) {

		DataExtractor.xlsLoader();
				
	}
	public static void xlsLoader(){

		objectRepoXLS = new Xls_Reader("//Users//arjun//Documents//workspace//AltiTestAutomation//Object_repository.xls");
		
		for(int i=2; i<=objectRepoXLS.getRowCount("Locators"); i++){
		String x = objectRepoXLS.getCellData("Locators", "xpath", i);
		System.out.println(x);
		}
	}

}
