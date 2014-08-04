package com.EriBank;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestEriBank extends EriBank {
	
	public static String platformName = "Android";
	
	

//	public static String platformName = "iOS";
//	public static String platformVersion = "6.1";
//	public static String deviceName = "iPhone";
//	public static String bundleId = "com.altimetrik.concost";
//	public static String udId = "73827f2fc1166180febef8904b0ca05e49ad7125";
	
	
	EriBank eriBank = new EriBank();

	@BeforeSuite
	public TestEriBank setUp(){
//	eriBank
//		.appiumVersion(appiumVersion)
//		.platformName(platformName)
//		.identifyPlatform()
//		.platformVersion(platformVersion)
//		.deviceName(deviceName)
//		.bundleId(bundleId)
//		.udId(udId)
//		.createRemoteWebDriver("localhost", "4749")
//		.timeOut(60);

		
		eriBank
		.appiumVersion( appiumVersion)
		.platformName(platformName)
		.identifyPlatform()		
		.platformVersion(platformVersion)
		.deviceName(deviceName)
		.applicationPath(applicationPath)
		.packageName(packageName)
		.activityName(activityName)
		.createRemoteWebDriver("localhost", "4725")
		.timeOut(60);

		return this;
	}
	
	@Test
	public void testCaseOne(){
	eriBank
		.enterUserName("company")
		.enterPassword("company")
		.submitCredentials()
		.makePayment()
		.enterPhone("8446216055")
		.enterName("Muhammad Kasim")
		.enterAmount()
		.enterCountry("India")
		.searchCountry()
		.selectCountry()
		.sendPayment()
		.confirmPayment()
		.logout();
	}
	
	@AfterSuite
	public TestEriBank tearDown(){
		eriBank.tearDown();
		return this;
	}
}
