package com.eriBank;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.common.io.Files;

	public class EriBankDev extends CustomListener{
		
		public static RemoteWebDriver driver;
		static String port_num="4725";
		static String host_name="localhost";
		public static String currentUserName = "";
		//********** For the snapshot folder ************//
		/*public static SimpleDateFormat formatter = new SimpleDateFormat("_yyyy_MMM_dd HH_mm_ss");
		public static String dateN = formatter.format(new Date().getTime());
		public static String snapShotDirectory = Files.simplifyPath(System.getProperty
				("user.dir")+"//Snapshot") + dateN;
		public static EriBankDev eb=new EriBankDev();*/
		
		@Test
		public void testEriBank() {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("appium-version", "1.0");
			capabilities.setCapability("platformVersion", "4.4");
			capabilities.setCapability("platformName", "Android");
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
			eb.takeScreenshot(snapShotDirectory);
			driver.findElement(By.xpath("//android.widget.EditText[2]")).sendKeys("company");
			eb.takeScreenshot(snapShotDirectory);
			driver.findElement(By.xpath("//android.widget.Button[1]")).click();// login
			driver.findElement(By.xpath("//android.widget.Button[1]")).click();// make payment
			driver.findElement(By.xpath("//android.widget.EditText[1]")).sendKeys("8446216055");
			eb.takeScreenshot(snapShotDirectory);
			driver.findElement(By.xpath("//android.widget.EditText[2]")).sendKeys("Muhammad Kasim");
			eb.takeScreenshot(snapShotDirectory);
			driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]")).sendKeys("10");
			// "Select" button
			driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.Button[1]")).click();
			// Select country "India"
			driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.TextView[1]")).click();
			// "Send Payment" button
			driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.Button[1]")).click();
			// precise tap on "Yes" button of pop up window
			driver.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1D); put("touchCount", 1D); put("duration", 0.5); put("x", 232D); put("y", 732D); }});
			// Log out button
			driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout[1]/android.widget.Button[2]")).click();
						
			driver.quit();
		}	
		public EriBankDev takeScreenshot(String snapShotDirectory) {
			String path = null;
			try {
				File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				String fileName = source.getName();
				fileName = "screenshot"+System.currentTimeMillis();
				File f = new File(snapShotDirectory);
				try{
					f.mkdir();
				}catch (SecurityException se){}
				path = f.getAbsolutePath() + "/" + fileName +".jpg";
				FileUtils.copyFile(source, new File(path));
				
				Reporter.log("<a href='"+ path+"'> <img src='"+ path + " height='100' width='100'/> </a>");
			}
			catch(IOException e) {
				path = "Failed to capture screenshot: " + e.getMessage();
			}
			Reporter.setCurrentTestResult(null);
			return (EriBankDev)this;
		}
}
