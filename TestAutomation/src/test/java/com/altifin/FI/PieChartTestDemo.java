package com.altifin.FI;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//public class PieChartTestDemo extends BalanceEnquiry {
	public class PieChartTestDemo {
	
	@BeforeSuite
	public void setup()
	{
		System.out.println("setting up");
	}
	
	@Test
	public void helloWorld(){
	System.out.println("Hello");	
	}
	
	
	@Test
	public void sum(){
		Assert.assertEquals(2, 2);
	}

	
	
	@Test
	public void sub(){
		Assert.assertEquals(2, 2);
	}

	
	@Test
	public void div(){
		Assert.assertEquals(2, 2);
	}

	@AfterSuite
	public void tear(){
		System.out.println("tearing down");
	}
	
}
