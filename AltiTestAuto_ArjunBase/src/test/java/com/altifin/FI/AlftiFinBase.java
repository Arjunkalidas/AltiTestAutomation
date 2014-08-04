package com.altifin.FI;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AlftiFinBase<T extends AlftiFinBase<T>> {
	static WebElement myDynamicWebElement;
	public static final String customerID = "50000191";
	public static String agentID = "101000040";
	public static String password = "7s5h86n0";
	public static RemoteWebDriver driver;
	public static JavascriptExecutor js = driver;
	static String[]  startServer;
	static String[]  startASM;
	Runtime runtime= Runtime.getRuntime();
	Process appium=null;
	Process asm=null;
	TestShell testShell= new TestShell();
	protected abstract T getThis();
	
	
	private AlftiFinBase<T> enterAgentID(String agentID) {
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/"
						+ "android.widget.RelativeLayout[2]/android.widget.EditText[1]"))
				.sendKeys(agentID);
		return this;
	}

	
	protected AlftiFinBase<T> enterCustomerID(String customerID) {
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/"
						+ "android.widget.EditText[1]")).sendKeys(customerID);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	private AlftiFinBase<T> enterPassword(String password) {
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/"
						+ "android.widget.RelativeLayout[2]/android.widget.EditText[2]"))
				.sendKeys(password);
		return this;
	}

	public AlftiFinBase<T> loginToAltifinFI(String agentID, String password) {
		enterAgentID(agentID).enterPassword(password).clickLogin();
		return this;
	}

	public AlftiFinBase<T> selectBankingServices() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.TabHost[1]/android.widget.LinearLayout[1]/"
						+ "android.widget.LinearLayout[1]/android.widget.TabWidget[1]/android.widget.RelativeLayout[2]/"
						+ "android.widget.ImageView[1]")).click();
		return this;
	}

	public AlftiFinBase<T> clickLogin() {
		myDynamicWebElement = (new WebDriverWait(driver, 100))
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/"
								+ "android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/"
								+ "android.widget.Button[1]")));
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/"
						+ "android.widget.RelativeLayout[2]/android.widget.Button[1]"))
				.click();
		return this;
	}

	public AlftiFinBase<T> selectAccount() {
		myDynamicWebElement = (new WebDriverWait(driver, 100))
				.until(ExpectedConditions.visibilityOfElementLocated(By
						.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
								+ "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/"
								+ "android.widget.RelativeLayout[1]/android.widget.ListView[1]/"
								+ "android.widget.RelativeLayout[1]/android.widget.TextView[1]")));

		driver.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.TextView[1]"))
				.click();
		return this;
	}

	public AlftiFinBase<T> confirmAccountInformation() {
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {
			{
				put("tapCount", 1D);
				put("touchCount", 1D);
				put("duration", 0.5);
				put("x", 463D);
				put("y", 325D);
			}
		});
		return this;
	}

	public AlftiFinBase<T> printBalanceInformation() {
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/"
						+ "android.widget.Button[1]")).click();
		return this;
	}


	public AlftiFinBase<T> setUp(String application, String host, String port) {
		
		startServer =new String[]{
				"sh",
				"/tmp/StartServer.sh",
				application,
				host,
				port
		};
		
		startASM =new String[]{
				"sh",
				"/tmp/StartASM.sh",
		};
		
//		  try { 
//			  
//			appium =  TestShell.startProcess(startServer);
//			System.out.println("appium=" +appium.toString());
//			  try { 
//				  Thread.sleep(10000); }
//			  catch (InterruptedException e) {
//		  e.printStackTrace(); } 
//			
//			asm =TestShell.startProcess(startASM);
//			System.out.println("asm="+asm.toString());
//			  try { 
//				  Thread.sleep(10000); }
//			  catch (InterruptedException e) {
//		  e.printStackTrace(); } 
//			  } catch (IOException e1) {
//		  
//		 e1.printStackTrace(); }

		DesiredCapabilities capabilities = new DesiredCapabilities();
		File app = new File(application);
		capabilities.setCapability("device", "Android");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(CapabilityType.VERSION, "4.2");
		capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
		capabilities.setCapability("app", app.getAbsolutePath().toString());
		capabilities.setCapability("app-package", "com.altipay.fi.launcher");
		capabilities.setCapability("app-activity", ".AltipayFIActivity");

		try {

			driver = new RemoteWebDriver(
					new URL("http://"+host+":"+port+"/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return this;
	}
	public static Process startProcess() throws IOException {
		return TestShell.startProcess();
	}
	public AlftiFinBase<T> tearDown() {
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
	
}
