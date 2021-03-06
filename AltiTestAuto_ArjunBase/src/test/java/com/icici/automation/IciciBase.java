package com.icici.automation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import aiframework.core.utils.TestBase;
import aiframework.core.utils.Xls_Reader;

import com.altifin.FI.TestShell;


public class IciciBase extends TestBase {

	static String[]  startServer;
	static String[]  startASM;
	Runtime runtime= Runtime.getRuntime();
	Process appium=null;
	Process asm=null;
	public static String loginPIN;
	public static String invalidloginPIN;
	public static String validloginPIN;
	public static String mobileNumber = "8892842449";
	public static String name = "Arjun Kalidas";
	public static String city = "Bangalore";
	public static String age = "30";
	public static String pincode = "560100";
	static IciciBase icicibase = new IciciBase();
	public static String delay = "2";
	public static Xls_Reader objectRepoXLS;
	public static String application="/Users/arjun/Documents/workspace/AltiTestAuto_ArjunBase/com.csam.icici.bank.imobile.apk";
	public static String host="0.0.0.0";
	public static String port="4723";
	
	public static void main(String[] args) throws InterruptedException {
		
		icicibase.xlsLoader();
		icicibase
				.setUp(application, host, port)
				.activateAccFailScenario(loginPIN, invalidloginPIN)
				.activateAccPassScenario(loginPIN, validloginPIN)
				.helpOption()
				.locateUsOption()
				.locateCustomerCare()
				.findATM()
				.findBranch()
				.applyICICIAccount()
				.tearDown();
	}
	
	public static Process startProcess() throws IOException {
		return TestShell.startProcess();
	}

	public IciciBase setUp(String application, String host, String port) {
		
		/*startServer =new String[]{
				"sh",
				"StartServer.sh",
				application,
				host,
				port
		};
		
		startASM =new String[]{
				"sh",
				"StartASM.sh",
		};
		  
		try {
		  
		appium =  TestShell.startProcess(startServer);
		System.out.println("appium=" +appium.toString());
		  try { 
			  Thread.sleep(10000); }
		  catch (InterruptedException e) {
	  e.printStackTrace(); } 
		
		asm =TestShell.startProcess(startASM);
		System.out.println("asm="+asm.toString());
		  try { 
			  Thread.sleep(10000); }
		  catch (InterruptedException e) {
	  e.printStackTrace(); } 
		  } catch (IOException e1) {
			  e1.printStackTrace();
			   }*/
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		File app = new File(application);
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.3");
		capabilities.setCapability("deviceName", "Nexus_Tab_7");
		capabilities.setCapability("app", app.getAbsolutePath().toString());
		capabilities.setCapability("appPackage", "com.csam.icici.bank.imobile");
		capabilities.setCapability("appActivity", "ICICIActivity");
		try {
			driver = new RemoteWebDriver(new URL("http://"+host+":"+port+"/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return this;
	}

	public IciciBase activateAccFailScenario(String loginPIN, String invalidloginPIN) {
		// activate Now button - OR
		element("activateNowOption").click();
		//driver.findElement(By.xpath("//android.widget.GridView[1]/android.widget.LinearLayout[1]")).click();
		// precise tap on Next button	
		driver.executeScript("mobile: tap", new HashMap<String, Double>() 
				{{ put("tapCount", 1D); put("touchCount", 1D); put("duration", 0.5); put("x", 400D); put("y", 1167D); }});
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1D); 
				put("touchCount", 1D); put("duration", 0.5); put("x", 385D); put("y", 722D); }});
		icicibase.takeScreenshot(snapShotDirectory);
		// enter 4 digit PIN - OR
		element("enterLoginPIN").sendKeys(loginPIN);
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[1]")).sendKeys(loginPIN);
		// negative scenario, enter wrong login pin to confirm
		element("reenterLoginPIN").sendKeys(invalidloginPIN);
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[2]")).sendKeys(invalidloginPIN);
		// precise tap on Next button
		driver.executeScript("mobile: tap", new HashMap<String, Double>() 
				{{ put("tapCount", 1D); put("touchCount", 1D); put("duration", 0.5); put("x", 402D); put("y", 775D); }});
		homeButton();
		icicibase.takeScreenshot(snapShotDirectory);
		return this;
	}

	public IciciBase activateAccPassScenario(String loginPIN, String validloginPIN) {
		element("activateNowOption").click();
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.GridView[1]/android.widget.LinearLayout[1]")).click();
		// precise tap on Next button	
		driver.executeScript("mobile: tap", new HashMap<String, Double>() 
				{{ put("tapCount", 1D); put("touchCount", 1D); put("duration", 0.5); put("x", 400D); put("y", 1167D); }});
		homeButton();
		icicibase.takeScreenshot(snapShotDirectory);
		// enter 4 digit PIN - OR
		element("enterLoginPIN").sendKeys(loginPIN);
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[1]")).sendKeys(loginPIN);
		// correct value in Re-enter login pin field. - OR
		element("reenterLoginPIN").sendKeys(validloginPIN);
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[2]")).sendKeys(loginPIN);
		// precise tap on Next button
		driver.executeScript("mobile: tap", new HashMap<String, Double>() 
				{{ put("tapCount", 1D); put("touchCount", 1D); put("duration", 0.5); put("x", 402D); put("y", 767D); }});
		homeButton();
		icicibase.takeScreenshot(snapShotDirectory);
		return this;
	}

	public IciciBase helpOption() {
		// tap on help button - OR
		element("helpButton").click();
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.GridView[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).click();
		// Who can use: option
		element("WhoCanUseLink").click();	
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.ListView[1]")).click();
		return this;

	}

	public IciciBase locateUsOption() {
		// icici locate us option. - OR
		element("locateUsLink").click();
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.GridView[1]/android.widget.LinearLayout[3]")).click();

		return this;
	}

	public IciciBase locateCustomerCare() {
		element("customerCareNum").click();
		icicibase.takeScreenshot(snapShotDirectory);
		// customer care numbers for South region - OR
		element("ccareSouthRegion").click();
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
		element("tapOKorGoHome").click();	
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout[4]/android.widget.TextView[1]")).click();
		homeButton();
		return this;
	}

	public IciciBase findATM() {
		// find ATM, enter pincode - OR
		element("findATMLink").click();
		//driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")).click();
		element("enterPincode").sendKeys(pincode);
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[1]")).sendKeys(pincode);
		homeButton();
		icicibase.takeScreenshot(snapShotDirectory);
		homeButton();
		return this;
	}

	public IciciBase findBranch() {
		// click on find Branch, enter pin code, find button, tap OK - OR
		element("findBranchLink").click();
		//driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout[3]/android.widget.TextView[1]")).click();
		element("enterPincode").sendKeys(pincode);
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[1]")).sendKeys(pincode);
		homeButton();
		icicibase.takeScreenshot(snapShotDirectory);
		homeButton();
		icicibase.takeScreenshot(snapShotDirectory);
		return this;
	}

	public IciciBase applyICICIAccount() {
		// apply now button - OR
		element("applyNowOption").click();	
		//driver.findElement(By.xpath("//android.widget.GridView[1]/android.widget.LinearLayout[4]/android.widget.TextView[1]")).click();
		icicibase.takeScreenshot(snapShotDirectory);
		// tap ICICI bank account - OR
		element("applyAccountOption").click();
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.ListView[1]/android.widget.LinearLayout[1]")).click();
		// enter mobile number - OR
		element("enterMobileNumber").sendKeys(mobileNumber);
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[1]")).sendKeys(mobileNumber);
		// enter name - OR
		element("enterName").sendKeys(name);
		icicibase.takeScreenshot(snapShotDirectory);		
		//driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[2]")).sendKeys(name);
		// enter city and age - OR
		element("enterCity").sendKeys(city);
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[3]")).sendKeys(city);
		element("enterAge").sendKeys(age);
		icicibase.takeScreenshot(snapShotDirectory);
		//driver.findElement(By.xpath("//android.widget.ScrollView[1]/android.widget.EditText[4]")).sendKeys(age);
		// precise tap on Apply button
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1D); put("touchCount", 1D); put("duration", 0.5); put("x", 206D); put("y", 769D); }});
		icicibase.takeScreenshot(snapShotDirectory);
		return this;
	}

	public IciciBase pause() throws InterruptedException{
		long time = (long)Double.parseDouble(delay);
		Thread.sleep(time*1000L);
		return this;

	}

	public IciciBase homeButton() {
		// tap home button - OR
		element("HomeButton").click();
		//driver.findElement(By.xpath("//android.widget.Button[1]")).click();
		icicibase.takeScreenshot(snapShotDirectory);
		return this;
	}
	
	public IciciBase goBack(){
		
		driver.navigate().back();
		icicibase.takeScreenshot(snapShotDirectory);
		/*try {
			Runtime.getRuntime().exec("cmd /K cd " +"../libs/android-sdk-windows/platform-tools");
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
			Runtime.getRuntime().exec("cmd /C adb shell input keyevent 4");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return this;
	}

	public IciciBase tearDown() {
		driver.quit();
//		System.out.println("appium=" +appium.toString());
//		System.out.println("asm=" +asm.toString());
//		try {
//			TestShell.killUnixProcess(appium);
//			TestShell.killUnixProcess(asm);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return this;
	}
	
	public void xlsLoader(){
		
		objectRepoXLS = new Xls_Reader(System.getProperty("user.dir")+"//Object_repository.xls");
	}
	
	
}
