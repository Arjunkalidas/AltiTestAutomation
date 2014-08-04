//package com.ebay;
//
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class TestEbay extends EbayBase{
//	EbayBase ebayBase=new EbayBase();
//	
//	
//	@BeforeSuite
//	public TestEbay setup(){
//		super.setUp("/Users/kasim/Downloads/com.ebay.mobile.apk", "localhost", "5555", "Android", "", "4.2", "","Mac", "com.altipay.fi.launcher", ".AltipayFIActivity","");
//		return this;
//	}
//	
//	@Test
//	public void loginTest(){
//		ebayBase.acceptTermsAndConditions()
//		.clickOnSignIn()
//		.enterUserName("muhammadkasim@gmail.com")
//		.enterPassword("Vengaayam88")
//		.submitCredentials();
//	}
//	
//	@Test(dependsOnMethods="loginTest", dataProvider="ProductDataProvider")
//	public void productSearchTest(){
//		productSearchTest("tablet");
//	}
//
//	@Test(dependsOnMethods="loginTest", dataProvider="ProductDataProvider")
//	public void productSearchTest(String productName){
//		try {
//			ebayBase.enterProductName(productName)
//			.selectProductFromList()
//			.selectFirstItemFromList()
//			.scrollToBuyNow()
//			.tapBuyNow()
//			.navigateBackToSearchProductScreen();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}
//
//	
//	@DataProvider(name="ProductDataProvider")
//	public  Object[][] productDataProvider() {
//		Object[][] productArray = {{"Tablet"}, {"Iphone"},{"LED TV"}};
//		return productArray;
//	}
//	
//	@AfterSuite
//	public TestEbay tearDown()
//	{
//		ebayBase.tearDown();
//		return this;
//	}
//	
//}
