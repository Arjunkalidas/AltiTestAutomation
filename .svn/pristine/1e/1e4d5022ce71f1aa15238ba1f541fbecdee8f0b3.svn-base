package com.EriBank;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestEriBankIOs extends EriBank {
	
	private static final String host = "localhost";
	private static final String port = "4723";
	
	EriBank eriBank = new EriBank();

	@BeforeSuite
	public TestEriBankIOs setUp(){
		
		platformName = "iOS";
		//bundleId = "com.altimetrik.concost";
		//udId = "f477f90c7d5475a81dfe7acb3a56f6e0cef70b0c";

		String startServer[]={"sh", "StartIosServer.sh", bundleId,udId,host,port};

		try {
			eriBank.startAppiumServer(startServer);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		eriBank
			.appiumVersion(appiumVersion)
			.platformName(platformName)
			.identifyPlatform()
			.platformVersion(platformVersion)
			.deviceName(deviceName)
//			.bundleId(bundleId)
//			.udId(udId)
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
	public TestEriBankIOs tearDown(){
		eriBank.tearDown();
		return this;
	}
}
