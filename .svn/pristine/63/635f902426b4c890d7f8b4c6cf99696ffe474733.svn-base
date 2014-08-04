package com.ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import aiframework.core.utils.TestBase;

import java.net.URL;
import java.util.HashMap;

import junit.framework.Assert;

public class EbayBase extends TestBase{

	static EbayBase ebayBase=new EbayBase();
	public static void main(String[] args) {


	ebayBase.setUp("/Users/kasim/Downloads/com.ebay.mobile.apk", "localhost", "5555", "Android", "", "4.2", "","Mac", "com.altipay.fi.launcher", ".AltipayFIActivity","");

		try 
		{
			ebayBase.acceptTermsAndConditions()
					.clickOnSignIn()
					.enterUserName("muhammadkasim@gmail.com")
					.enterPassword("Vengaayam88")
					.submitCredentials()
					.enterProductName("tablet")
					.selectProductFromList()
					.selectFirstItemFromList()
					.scrollToBuyNow()
					.tapBuyNow();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			ebayBase.tearDown();
		}
	}

	public  EbayBase clickOnSignIn() {
	//	driver.findElement(By.id("com.ebay.mobile:id/button_sign_in")).click();
		element("signInButton").click();
		return this;
	}

	public EbayBase tapBuyNow() {
//		driver.findElement(By.id("com.ebay.mobile:id/buy_it_now_button")).click();
		element("buyItNowButton").click();
		return this;
	}

	public EbayBase scrollToBuyNow() {
		driver.executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1D); put("startX", 379D); put("startY", 1155D); put("endX", 391D); put("endY", 507D); put("duration", 1D); }});
		return this;
	}

	public EbayBase selectFirstItemFromList() throws InterruptedException {
//		driver.findElement(By.id("android:id/text1")).click();
		element("firstItemFromList").click();
		Thread.sleep(4000);
		return this;
	}

	public EbayBase selectProductFromList() {
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1D); put("touchCount", 1D); put("duration", 0.5); put("x", 168D); put("y", 228D); }});
		return this;
	}
	
	public EbayBase enterProductName(String productName) throws InterruptedException {
//		driver.findElement(By.id("com.ebay.mobile:id/home_search_text")).sendKeys(productName);
		element("homeSearch").sendKeys(productName);
		Thread.sleep(4000);
		return this;
	}
	
	public EbayBase submitCredentials() {
//		driver.findElement(By.id("com.ebay.mobile:id/sign_in_button")).click();
		element("submitCredentialsButton").click();
		return this;
	}
	

	public EbayBase enterPassword(String password) {
//		driver.findElement(By.id("com.ebay.mobile:id/sign_in_password_entry")).sendKeys(password);
		element("password").sendKeys(password);;
		return this;
	}
	

	public EbayBase enterUserName(String userName) {
//		driver.findElement(By.id("com.ebay.mobile:id/sign_in_username_entry")).sendKeys(userName);
		element("userName").sendKeys(userName);
		return this;
	}
	
	public EbayBase acceptTermsAndConditions() {
//		driver.findElement(By.id("com.ebay.mobile:id/accept_btn")).click();;
		element("acceptTermsAndConditions").click();
		return this;
	}
	
	private EbayBase clickOnHome(){
//		driver.findElement(By.id("android:id/home")).click();
		element("homeButton").click();
		return this;
	}
	
	public EbayBase navigateBackToSearchProductScreen(){
		ebayBase.clickOnHome().clickOnHome().clickOnHome();
		return this;
	}
}
