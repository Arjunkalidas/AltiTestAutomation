package com.automation.lab;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	public class SampleTest{

	SampleTest object = new SampleTest();

	@Test
	public void sampleTest(){
		//object.method1().method2();

	}
	
	@AfterMethod
	public void takeScreenshot(){
		System.out.println("Taking screenshot...");
	}
}
