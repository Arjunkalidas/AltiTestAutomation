package com.eriBank;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class EriBankAndroid {
	public static RemoteWebDriver driver;
	static String port_num="4756";
	static String host_name="192.168.1.131";

	public static void main(String[] args) {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("deviceName", "Droid17");
		capabilities.setCapability("app", "/Users/arjun/Desktop/EriBank.apk");
		capabilities.setCapability("appPackage", "com.experitest.ExperiBank");
		capabilities.setCapability("appActivity", ".LoginActivity");
		try {
			driver = new RemoteWebDriver(new URL("http://"+host_name+":"+port_num+"/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//android.widget.EditText[1]")).sendKeys("company");
		driver.findElement(By.xpath("//android.widget.EditText[2]")).sendKeys("company");
		driver.findElement(By.xpath("//android.widget.Button[1]")).click();
		driver.findElement(By.xpath("//android.widget.Button[1]")).click();
		driver.findElement(By.xpath("//android.widget.EditText[1]")).sendKeys("8446216055");
		driver.findElement(By.xpath("//android.widget.EditText[2]")).sendKeys("Arjun Kalidas");
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1D); put("touchCount", 1D); put("duration", 0.5); put("x", 401D); put("y", 520D); }});
		driver.findElement(By.xpath("//android.widget.EditText[3]")).sendKeys("India");
		driver.findElement(By.xpath("//android.widget.Button[1]")).click();
		driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.TextView[1]")).click();
		driver.findElement(By.xpath("//android.widget.Button[2]")).click();
		driver.findElement(By.xpath("//android.widget.Button[1]")).click();
		driver.findElement(By.xpath("//android.widget.Button[2]")).click();
		driver.quit();
	}

}
