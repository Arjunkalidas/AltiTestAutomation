package altimetrik.googlemaps.automation;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import aiframework.core.utils.TestBase;

public class GoogleMaps extends TestBase{
	
	public static void main(String[] args) {
		GoogleMaps gm=new GoogleMaps();
		gm.setUp("192.168.70.70","4725")
			.acceptTermsAndConditions()
			.skipSignIn()
			.enterLocationName("Chennai")
			.tapLocationName()
			.clearLocation()
//			.navigationWalkthrough()
//			.navigationSource("Bangalore")
//			.navigationDestination("Chennai")
			.tearDown();
	}
	
	
	public GoogleMaps tearDown() {
		driver.quit();
		return this;
	}

	public GoogleMaps tapLocationName() {
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1.0); put("touchCount", 1.0); put("duration", 0.5); put("x", 192.0); put("y", 356.0); }});
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	public GoogleMaps clearLocation() {
//		driver.findElement(By.name("Clear")).click();
		element("clearButton").click();
		return this;
	}
	
	public  GoogleMaps enterLocationName(String location) {
//		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[3]/android.view.View[1]/android.widget.EditText[1]")).sendKeys(location);

		element("locationTextBox").sendKeys(location);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public  GoogleMaps skipSignIn() {
		
		element("skipSignInButton").click();
//		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.Button[1]")).click();
		return this;
	}
	
	public  GoogleMaps acceptTermsAndConditions() {
//		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
//				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
//				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
//				+ "android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.Button[1]")).click();
		
		element("acceptTermsAndConditionsButton").click();
		return this;
	}
	
	public GoogleMaps navigationWalkthrough() {
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1D); put("touchCount", 1D);
		put("duration", 0.5); put("x", 589D); put("y", 120D); }});
		return this;
	}

	public GoogleMaps navigationDestination(String Location) {
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.TextView[2]")).sendKeys("Chennai");
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.TextView[2]")).sendKeys("Chennai");
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]")).click();
		return this;
	}

	public GoogleMaps navigationSource(String Location) {
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[3]/android.view.View[1]/"
				+ "android.widget.EditText[1]")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.TextView[1]")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]")).click();
		return this;
	}
	
	public GoogleMaps setUp(String hostName, String port){
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("device", "Android");
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability(CapabilityType.VERSION, "4.2");
			capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
			capabilities.setCapability("app", "/Android-Tools/adt-bundle-mac-x86_64-20140321/sdk/build-tools/android-4.4.2/com.google.android.apps.maps-7.0.0.apk");
			capabilities.setCapability("app-package", "com.google.android.apps.maps");
			capabilities.setCapability("app-activity", "com.google.android.maps.MapsActivity");
			driver = new RemoteWebDriver(new URL("http://"+hostName+":"+port+"/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return this;
	}
}
