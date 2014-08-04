package com.automation.lab;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GoogleMaps{

	public static RemoteWebDriver driver;
	//public static WebElement myDynamicElement;
	public static JavascriptExecutor js = driver; 
	public static String host_name = "localhost";
	public static String port_num = "4756";

	public static void main(String[] args) {

		GoogleMaps gm=new GoogleMaps();

		gm.setUp(host_name, port_num)
		.acceptTermsAndConditions()
		.skipSignIn()
		.tapSearchField()
		.enterLocationName("Chennai")
		.tapSearchResult()
		.clearLocation()
		.tearDown();
	}

	@Test
	public static void TestCase(){
		GoogleMaps.main(null);
	}

	public GoogleMaps setUp(String hostName, String port){
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("device", "Android");
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability(CapabilityType.VERSION, "4.2");
			capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
			capabilities.setCapability("app", "/Users/arjun/Desktop/com.google.android.apps.maps-7.0.0.apk");
			capabilities.setCapability("app-package", "com.google.android.apps.maps");
			capabilities.setCapability("app-activity", "com.google.android.maps.MapsActivity");
			driver = new RemoteWebDriver(new URL("http://"+hostName+":"+port+"/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return this;
	}

	public  GoogleMaps acceptTermsAndConditions() {
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//element("acceptTermsAndConditionsButton").click();
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.Button[1]")).click();

		return this;
	}

	public  GoogleMaps skipSignIn() {

		//element("skipSignInButton").click();
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.Button[1]")).click();
		return this;
	}

	public GoogleMaps tapSearchField() {

		//element("tapSearchField").click();
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[3]/"
				+ "android.view.View[1]/android.widget.EditText[1]")).click();

		return this;
	}

	public  GoogleMaps enterLocationName(String location) {

		//element("locationTextBox").sendKeys(location);
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[3]/"
				+ "android.view.View[1]/android.widget.EditText[1]")).sendKeys(location);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public GoogleMaps tapSearchResult(){

		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.ListView[1]/android.widget.LinearLayout[1]")).click();

		return this;
	}

	public GoogleMaps clearLocation() {

		//element("clearButton").click();
		driver.findElement(By.name("Clear")).click();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return this;
	}

	public GoogleMaps tearDown() {
		driver.quit();
		return this;
	}


}
