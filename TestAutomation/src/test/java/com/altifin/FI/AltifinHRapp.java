package com.altifin.FI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AltifinHRapp {

	public static WebDriver driver;
	public static AltifinHRapp AltifinHRapp = new AltifinHRapp();

	public static void main(String[] args) throws MalformedURLException {
				

		AltifinHRapp.setUp()
		.allPolicies()
		.compnBenefits()
		.personnelTFPolicy()
		.leavePolicy()
		.commMenu()
		.rewardnRecoMenu()
		.erpnSearchMenu()
		.quitDriver();
	}
	
	public AltifinHRapp allPolicies() {
		driver.findElement(By.name("  Policies")).click();
		sleepDuration();
		return this;
	}

	public AltifinHRapp leavePolicy() {
		// Leave policy
		sleepDuration();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[9]/UIAStaticText[1]")).click();
		// leave drop down menu
		sleepDuration();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
		driver.findElement(By.name("altimetrik button white back")).click();
		sleepDuration();
		driver.findElement(By.name("<")).click();
		return this;
	}

	public AltifinHRapp personnelTFPolicy() {
		// personnel
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]")).click();
		sleepDuration();
		// transfer policy
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[5]/UIAStaticText[1]")).click();
		sleepDuration();
		driver.findElement(By.name("Ok")).click();
		return this;
	}

	public AltifinHRapp erpnSearchMenu() {
		//  Emp ref policy - ERP
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]/UIAStaticText[1]")).click();
		sleepDuration();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[2]")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
		sleepDuration();
		// Searching a keyword from the pdf
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIASearchBar[1]")).sendKeys("policy");
		sleepDuration();
		driver.findElement(By.name("Search")).sendKeys("policy");
		// tap on a search result
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]/UIAStaticText[1]")).click();
		sleepDuration();
		driver.findElement(By.name("altimetrik button white back")).click();
		return this;
	}

	public AltifinHRapp rewardnRecoMenu() {
		sleepDuration();
		// Reward and recognition
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
		sleepDuration();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[3]")).click();
		driver.findElement(By.name("Ok")).click();
		driver.findElement(By.name("altimetrik button white back")).click();
		// Talent aquisition -> Emp ref policy
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[4]")).click();
		sleepDuration();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[1]/UIAStaticText[1]")).click();
		driver.findElement(By.name("altimetrik button white back")).click();
		return this;
	}

	public AltifinHRapp commMenu() {
		sleepDuration();
		// communication menu
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[5]/UIAStaticText[1]")).click();
		sleepDuration();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[2]/UIAStaticText[1]")).click();
		sleepDuration();
		driver.findElement(By.name("altimetrik down button down")).click();
		sleepDuration();
		driver.findElement(By.name("AllPolicies")).click();
		sleepDuration();
		return this;
	}

	public AltifinHRapp compnBenefits() {
		// compensation & benefits
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]")).click();
		sleepDuration();
		// interview plan
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableGroup[4]")).click();
		driver.findElement(By.name("Ok")).click();
		sleepDuration();
		driver.findElement(By.name("altimetrik button white back")).click();
		return this;
	}

	public AltifinHRapp setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.0");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("deviceName", "iPhone");
		capabilities.setCapability("app", "/Users/arjun/Desktop/FastPdfKitSample.app");
		driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return this;
	}
	
	public void sleepDuration() {
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public AltifinHRapp quitDriver() {
		driver.quit();
		return this;
	}
}

