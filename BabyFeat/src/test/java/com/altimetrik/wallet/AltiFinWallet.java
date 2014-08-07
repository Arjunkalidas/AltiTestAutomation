package com.altimetrik.wallet;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;

import featdsl.core.utils.TestBase;

public class AltiFinWallet extends TestBase{

	public static AltiFinWallet AFW = new AltiFinWallet();

	public static void main(String[] args) {

		try {
			AFW.initialize();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// in case of launching directly into iPhone, app path need not be specified.
		platformName = "iOS";
		AFW
		.appiumVersion(CONFIG.getProperty("appiumVersion"))
		.platformName(CONFIG.getProperty("platformName"))
		.identifyPlatform()
		.platformVersion(CONFIG.getProperty("platformVersion"))
		.deviceName(CONFIG.getProperty("deviceName"))
		.bundleId(CONFIG.getProperty("bundleId"))
		.udId(CONFIG.getProperty("udId"))
		.createRemoteDriver(CONFIG.getProperty("host"), CONFIG.getProperty("port"))
		.timeOuts(CONFIG.getProperty("default_implicitWait"));
		
		AFW
		.enterUsername()
		.enterPassword()
		.clickLogin()
		.acceptAlert()
		.addPayee()
		.acceptAlert()
		.enterPayeeDetails()
		.submitForm()
		.confirmByPin()
		.fundTransfer()
		.submitForm()
		.confirmTransfer()
		.confirmByPin()
		.accountStmt()
		.goToMainMenu()
		.logOut();

	}

	public AltiFinWallet logOut() {
		driver.findElement(By.name("Logout")).click();
		return this;
	}

	public AltiFinWallet goToMainMenu() {
		driver.findElement(By.name("Menu")).click();
		return this;
	}

	public AltiFinWallet accountStmt() {
		driver.findElement(By.name("Account Stmt.")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
		return this;
	}

	public AltiFinWallet confirmTransfer() {
		driver.findElement(By.name("Confirm")).click();
		return this;
	}

	public AltiFinWallet choosePayee() {
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).click();
		js.executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1D); put("startX", 155D); put("startY", 435D); put("endX", 155D); put("endY", 334D); put("duration", 0.5); }});
		return this;
	}

	public AltiFinWallet fundTransfer() {
		driver.findElement(By.name("Transfer")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).click();
		js.executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1D); put("startX", 155D); put("startY", 435D); put("endX", 155D); put("endY", 334D); put("duration", 0.5); }});
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[2]")).sendKeys("Pending Amt");
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[3]")).sendKeys("5000");
		driver.findElement(By.name("Remark")).click(); // to dismiss the keypad
		return this;
	}

	public AltiFinWallet confirmByPin() {
		driver.findElement(By.name("1")).click();
		driver.findElement(By.name("2")).click();
		driver.findElement(By.name("3")).click();
		driver.findElement(By.name("4")).click();
		return this;
	}

	public AltiFinWallet submitForm() {
		driver.findElement(By.name("Submit")).click();
		return this;
	}

	public AltiFinWallet enterPayeeDetails() {
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys("Arjun Kalidas");
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[2]")).sendKeys("Arjun");
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[3]")).sendKeys("03712040005667");
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[4]")).sendKeys("03712040005667");
		driver.findElement(By.name("Payee Name")).click(); // to dismiss the keypad
		driver.findElement(By.name("Register")).click();
		return this;
	}

	public AltiFinWallet addPayee() {
		driver.findElement(By.name("Add Payee")).click();
		return this;
	}

	public AltiFinWallet acceptAlert() {
		driver.findElement(By.name("OK")).click();
		return this;
	}

	public AltiFinWallet clickLogin() {
		driver.findElement(By.name("Login")).click();
		return this;
	}

	public AltiFinWallet enterPassword() {
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]")).sendKeys("1234");
		return this;
	}

	public AltiFinWallet enterUsername() {
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys("altimetrik");
		return this;
	}
}



