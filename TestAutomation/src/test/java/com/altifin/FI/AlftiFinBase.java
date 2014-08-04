package com.altifin.FI;

import java.io.IOException;
import java.util.HashMap;

import org.bouncycastle.asn1.x509.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aiframework.core.utils.TestBase;
import aiframework.core.utils.TestShell;

public  class AlftiFinBase extends TestBase  {
	static WebElement myDynamicWebElement;
	public static final String customerID = "50000191";
	public static String agentID = "101000040";
	public static String password = "7s5h86n0";
	public static RemoteWebDriver driver;
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	AlftiFinBase altiFinBase= new AlftiFinBase();
	
	private AlftiFinBase enterAgentID(String agentID) {
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/"
						+ "android.widget.RelativeLayout[2]/android.widget.EditText[1]"))
				.sendKeys(agentID);
		return this;
	}

	protected AlftiFinBase enterCustomerID(String customerID) {
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

	private AlftiFinBase enterPassword(String password) {
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/"
						+ "android.widget.RelativeLayout[2]/android.widget.EditText[2]"))
				.sendKeys(password);
		return this;
	}

	public AlftiFinBase loginToAltifinFI(String agentID, String password) {
		enterAgentID(agentID).enterPassword(password).clickLogin();
		return this;
	}

	public AlftiFinBase selectBankingServices() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			throw new RuntimeException();
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.TabHost[1]/android.widget.LinearLayout[1]/"
						+ "android.widget.LinearLayout[1]/android.widget.TabWidget[1]/android.widget.RelativeLayout[2]/"
						+ "android.widget.ImageView[1]")).click();
		return this;
	}

	public TestBase clickLogin() {
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

	public AlftiFinBase selectAccount() {
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

	public AlftiFinBase confirmAccountInformation() {
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

	public AlftiFinBase printBalanceInformation() {
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/"
						+ "android.widget.Button[1]")).click();
		return this;
	}


	public static Process startProcess() throws IOException {
		return TestShell.startProcess();
	}
	
}
