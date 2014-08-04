package com.EriBank;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestEriBankAndroid extends EriBank {
	
	private static final String host = "localhost";
	private static final String port = "4725";
	public String [] startServer={"sh",
									"StartServer.sh",
									applicationPath, 
									host, 
									port};
	
	EriBank eriBank = new EriBank();

	@BeforeSuite
	public TestEriBankAndroid setUp(){
		try {
			eriBank.startAppiumServer(startServer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		platformName = "Android";
		platformVersion = "4.3";
		deviceName = "Droid17";	
		activityName = ".LoginActivity";
		packageName = "com.experitest.ExperiBank";
		applicationPath = "/Users/arjun/Desktop/EriBank.apk";
			
		eriBank
		.appiumVersion( appiumVersion)
		.platformName(platformName)
		.identifyPlatform()		
		.platformVersion(platformVersion)
		.deviceName(deviceName)
		.applicationPath(applicationPath)
		.packageName(packageName)
		.activityName(activityName)
		.createRemoteWebDriver(host, port)
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
	public TestEriBankAndroid tearDown(){
		eriBank.tearDown();
		eriBank.stopAppiumServer();
		return this;
	}
}
