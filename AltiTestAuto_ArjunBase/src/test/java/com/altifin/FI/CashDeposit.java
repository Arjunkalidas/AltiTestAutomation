package com.altifin.FI;

import java.util.HashMap;

import org.openqa.selenium.*;

public class CashDeposit extends AlftiFinBase<CashDeposit> {

	public static CashDeposit cashDeposit = new CashDeposit() {
	};

	@Override
	protected CashDeposit getThis() {
		return this;
	}

	public static void main(String[] args) {
		cashDeposit.setUp("/Users/kasim/Downloads/AltiFinFI.apk", "localhost", "4560").loginToAltifinFI(agentID, password)
				.selectBankingServices().selectCashDeposit()
				.individualDeposit().clickContinue().selfDeposit()
				.clickContinue().cardlessCustomer().clickContinue()
				.enterCustomerID(customerID).selectAccount()
				.confirmAccountInformation().printBalanceInformation()
				.acceptAlert().tearDown();
	}

	@Override
	public CashDeposit setUp(String application, String host, String port) {
		super.setUp(application, host, port);
		return this;
	}

	@Override
	public CashDeposit selectBankingServices() {
		super.selectBankingServices();
		return this;
	}

	@Override
	public CashDeposit loginToAltifinFI(String agentID, String password) {
		super.loginToAltifinFI(agentID, password);
		return this;
	}

	@Override
	public CashDeposit enterCustomerID(String customerID) {
		super.enterCustomerID(customerID);
		return this;
	}

	@Override
	public CashDeposit selectAccount() {
		super.selectAccount();
		return this;
	}

	@Override
	public CashDeposit confirmAccountInformation() {
		super.confirmAccountInformation();
		return this;
	}

	@Override
	public CashDeposit printBalanceInformation() {
		super.printBalanceInformation();
		return this;
	}

	public CashDeposit enterAmount() {
		// enter amount - Text field
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/"
						+ "android.widget.EditText[3]")).sendKeys("100");

		return this;
	}

	public CashDeposit repDeposit() {
		// deposit type - representative
		/*
		 * driver.findElement(By.xpath(
		 * "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/" +
		 * "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/"
		 * +
		 * "android.widget.RelativeLayout[3]/android.widget.RadioButton[1]")).click
		 * ();
		 */
		// precise tap - continue
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {
			{
				put("tapCount", 1.0);
				put("touchCount", 1.0);
				put("duration", 0.5);
				put("x", 506.0);
				put("y", 512.0);
			}
		});
		return this;
	}

	public CashDeposit cardlessCustomer() {
		// tap on "Cardless" - Radio button
		/*
		 * driver.findElement(By.xpath(
		 * "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/" +
		 * "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/"
		 * + "android.widget.LinearLayout[1]/android.widget.RelativeLayout[3]/"
		 * + "android.widget.RadioButton[1]")).click();
		 */
		// continue button
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {
			{
				put("tapCount", 1.0);
				put("touchCount", 1.0);
				put("duration", 0.5);
				put("x", 501.0);
				put("y", 514.0);
			}
		});
		return this;
	}

	public CashDeposit selfDeposit() {
		// deposit type - Self
		// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
		// +
		// "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/"
		// +
		// "android.widget.RelativeLayout[2]/android.widget.RadioButton[1]")).click();

		driver.executeScript("mobile: tap", new HashMap<String, Double>() {
			{
				put("tapCount", 1.0);
				put("touchCount", 1.0);
				put("duration", 0.5);
				put("x", 501.0);
				put("y", 514.0);
			}
		});
		return this;
	}

	public CashDeposit individualDeposit() {
		// Radio button - individual
		// driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
		// +
		// "android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/"
		// +
		// "android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[3]/"
		// + "android.widget.RadioButton[1]")).click();

		// precise tap - continue
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {
			{
				put("tapCount", 1.0);
				put("touchCount", 1.0);
				put("duration", 0.5);
				put("x", 519.0);
				put("y", 506.0);
			}
		});
		return this;
	}

	public CashDeposit selectCashDeposit() {
		// cash deposit click
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
						+ "android.widget.RelativeLayout[1]/android.widget.TabHost[1]/android.widget.LinearLayout[1]/"
						+ "android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/"
						+ "android.widget.GridView[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/"
						+ "android.widget.ImageView[1]")).click();
		return this;
	}

	public CashDeposit clickContinue() {
		// tap on continue button
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {
			{
				put("tapCount", 1D);
				put("touchCount", 1D);
				put("duration", 0.5);
				put("x", 498D);
				put("y", 532D);
			}
		});
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public CashDeposit acceptAlert() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		driver.executeScript("mobile: tap", new HashMap<String, Double>() {
			{
				put("tapCount", 1D);
				put("touchCount", 1D);
				put("duration", 0.5);
				put("x", 423D);
				put("y", 526D);
			}
		});
		return this;
	}

}
