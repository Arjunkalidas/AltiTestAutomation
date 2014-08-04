package com.eriBank;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test(priority=1)
	public void login(){
		
		// Two scenarios
			// 1. error - stop & evaluate
			// 2. error - continue till the end
		
		System.out.println("start");
		try{
		Assert.assertEquals("A", "x");
		}catch(Throwable t){
			// assertions fall under throwable class.
			System.out.println("error");
			// code - to report error
			ErrorUtil.addVerificationFailure(t);
			// wherever error needs to be reported, call the ErroUtil class and pass the exception object.
			// here the "t" holds the error.
			// ErrorUtil is similar to a bag.
		}
		
		try{
			Assert.assertEquals("A", "B");
			}catch(Throwable t){
				// assertions fall under throwable class.
				System.out.println("error");
				// code - to report error
				ErrorUtil.addVerificationFailure(t);
			}
		System.out.println("end");
	}

	@Test(priority=2)
	public void adminLogin(){
		
	}
}


// Notes:::*****************************************************
	//when this test passes the listener would be called automatically.
		// The listener will work only if you use TestNG.xml
		// You can have the testListeners and testcases in different packages also.
		
		// This will work only with TestNG
		// these listener classes are called only after once the test is executed.
		// so why aren't we going for @Before or @After methods?
			// Because you won't know the status of the test. You will have to write some special code to get the status 
			// of the run.
			// Assume that suppose, I have 50 or more test cases, it is not a viable solution to add @AfterMethod annotation
			// after the test cases in every class.

	// While assertions, once if a condition or test fails, it is not going further.
