package com.automation.lab;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HelloWorldChild extends HelloWorld{

	@Test
	public HelloWorld method1(){
		System.out.println("method1");
		return this;
	}
	@Test
	public HelloWorld method2(){
		System.out.println("method2");
		return this;
	}
	
	@AfterMethod
	public void takeScreenshot(){
		System.out.println("takoing scrrenshot");
	}
	
	
	
			
}
