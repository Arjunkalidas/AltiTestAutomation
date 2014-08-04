//package com.altifin.FI;
//
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class TestCashDeposit extends CashDeposit {
//
//	private static CashDeposit cashDeposit= new CashDeposit();
//
//	@BeforeSuite
//	public CashDeposit setUp(){
//		cashDeposit.setUp("/Users/kasim/Downloads/AltiFinFI.apk", "localhost", "4756");
//		return this;
//	}
//
//
//	@Test(dataProvider="CashDepositDataProvider")
//	public void balanceEnquiryTest(String userName, String password, String customerID){
//		cashDeposit
//		.loginToAltifinFI(agentID, password)
//		.selectBankingServices()
//		.selectCashDeposit()
//		.individualDeposit()
//		.clickContinue()
//		.selfDeposit()
//		.clickContinue()
//		.cardlessCustomer()
//		.clickContinue()
//		.enterCustomerID(customerID)
//		.selectAccount()
//		.confirmAccountInformation()
//		.printBalanceInformation()
//		.acceptAlert();
//	}
//
//	@AfterSuite
//	public  CashDeposit tearDown()
//	{
//		return (CashDeposit) cashDeposit.tearDown();
//	}
//	@DataProvider(name="CashDepositDataProvider")
//	public  Object[][] cashDepositDataProvider() {
//		Object[][] AmountArray = {{"101000040", "7s5h86n0","50000187"}};
////		,{"101000040", "7s5h86n0","50000188"}};
//		return AmountArray;
//	}
//}
