//package com.altifin.FI;
//
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class TestBalanceEnquiry extends BalanceEnquiry
//{
//	private static BalanceEnquiry balanceEnquiry = new BalanceEnquiry();
//	
//	@BeforeSuite
//	public void setUp(){
//		balanceEnquiry.setUp("/Users/kasim/Downloads/AltiFinFI.apk", "localhost", "5555", "Android", "", "4.2","", "Mac", "com.altipay.fi.launcher", ".AltipayFIActivity","");
////		balanceEnquiry.setUp("AltiFinFI.apk", "localhost", "5555");
//	}
//
//
//	@Test(dataProvider="BalanceEnquiryDataProvider")
//	public void balanceEnquiryTest(String userName, String password, String customerID){
//		balanceEnquiry.loginToAltifinFI(userName, password)
//				.selectBankingServices()
//				.checkTheBalance()	
//				.enterCustomerID(customerID)
//				.selectAccount()
//				.confirmAccountInformation()
//				.printBalanceInformation()
//				.acceptAlert();
//	}
//	
//	@AfterSuite
//	public  BalanceEnquiry tearDown()
//	{
//		System.out.println(balanceEnquiry.toString());
//		balanceEnquiry.tearDown();
//		return this;
//	}
//	@DataProvider(name="BalanceEnquiryDataProvider")
//	public  Object[][] balanceEnquiryDataProvider() {
//		Object[][] balanceArray = {{"101000040", "7s5h86n0","50000191"}};
////									{"101000040", "7s5h86n0","50000190"}};
//		return balanceArray;
//	}
//}
