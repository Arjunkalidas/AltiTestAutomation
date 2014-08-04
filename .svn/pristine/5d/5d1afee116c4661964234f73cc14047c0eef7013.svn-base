
package com.EriBank;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class EriBankIOs {
	public static RemoteWebDriver driver;
	public static JavascriptExecutor js =driver;
	static String port_num="4723";
	static String host_name="localhost";
	
	@Test
	public void testEriBank() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("deviceName", "iPhone5S");
		capabilities.setCapability("platformName", "iOS");
	
		try {
			driver = new RemoteWebDriver(new URL("http://"+host_name+":"+port_num+"/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.name("makePaymentButton")).click();
		driver.findElement(By.name("phoneTextField")).sendKeys("8446216055");
		driver.findElement(By.name("nameTextField")).sendKeys("Steve jonathan");
		driver.executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1D); put("startX", 130D); put("startY", 207D); put("endX", 203D); put("endY", 196D); put("duration", 0.5); }});
		driver.findElement(By.name("countryTextField")).sendKeys("India");
		//driver.findElement(By.name("countryButton")).click();
		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
		driver.findElement(By.name("sendPaymentButton")).click();
		driver.findElement(By.name("Yes")).click();
		driver.findElement(By.name("logoutButton")).click();
		driver.quit();
	}
}
