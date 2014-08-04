package altimetrik.googlemaps.automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import aiframework.core.utils.TestBase;

public class GoogleMaps extends TestBase{

	public static GoogleMaps gm=new GoogleMaps();
	
	
	public static void main(String[] args) {
		
		gm.setUp("localhost","4725")
		.acceptTermsAndConditions()
		.skipSignIn()
		.tapSearchField()
		.enterLocationName(location)
		.tapSearchResult()
		.clearLocation()
		.tearDown();
	}
	
	/*@AfterMethod
	public void takeSnapshot(){
		gm.takeScreenshot();
	}*/
	
	@Test
	public static void TestCase(){
		GoogleMaps.main(null);
	}

	public GoogleMaps setUp(String hostName, String port){
		try {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("device", "Android");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability(CapabilityType.VERSION, "4.2");
			capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
			capabilities.setCapability("deviceName", "Droid17");
			capabilities.setCapability("app", "/Users/arjun/Desktop/com.google.android.apps.maps-7.0.0.apk");
			capabilities.setCapability("app-package", "com.google.android.apps.maps");
			capabilities.setCapability("app-activity", "com.google.android.maps.MapsActivity");
			driver = new RemoteWebDriver(new URL("http://"+hostName+":"+port+"/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			gm.takeScreenshot(snapShotDirectory);
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
				gm.takeScreenshot(snapShotDirectory);
		return this;
	}
	
	public  GoogleMaps skipSignIn() {

		//element("skipSignInButton").click();
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.Button[1]")).click();
				gm.takeScreenshot(snapShotDirectory);
		return this;
		
	}
	
	public GoogleMaps tapSearchField() {
		
		//element("tapSearchField").click();
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[3]/"
				+ "android.view.View[1]/android.widget.EditText[1]")).click();
				gm.takeScreenshot(snapShotDirectory);
		return this;
	}
	
	public  GoogleMaps enterLocationName(String location) {
		
		//element("locationTextBox").sendKeys(location);
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[3]/"
				+ "android.view.View[1]/android.widget.EditText[1]")).sendKeys(location);
				gm.takeScreenshot(snapShotDirectory);
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
				gm.takeScreenshot(snapShotDirectory);
		return this;
	}
	
	public GoogleMaps clearLocation() {
		
		//element("clearButton").click();
		driver.findElement(By.name("Clear")).click();
		gm.takeScreenshot(snapShotDirectory);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return this;
	}
	
	public TestBase tearDown() {
		driver.quit();
		return this;
	}

	/*public GoogleMaps navigationWalkthrough() {
		driver.executeScript("mobile: tap", 
				new HashMap<String, Double>()
				{{ put("tapCount", 1D); 
				put("touchCount", 1D);
				put("duration", 0.5); 
				put("x", 589D); 
				put("y", 120D); }});
		return this;
	}*/

	/*public GoogleMaps navigationDestination(String Location) {
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
	}*/

	
}
