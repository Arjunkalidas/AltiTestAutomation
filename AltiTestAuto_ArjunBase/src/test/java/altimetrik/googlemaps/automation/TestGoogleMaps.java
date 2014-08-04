package altimetrik.googlemaps.automation;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import aiframework.core.utils.TestBase;

public class TestGoogleMaps extends GoogleMaps
{
	
	//GoogleNavigator googleNav = new GoogleNavigator();

	public static GoogleMaps googleMaps = new GoogleMaps();
	
	@BeforeSuite
	public void setUp(){
		googleMaps.setUp("localhost","4725");
	}
	
	@Test(dataProvider="LocationProvider", groups = { "Functional","Usability" })
	public void TestOne(String Location){
		googleMaps.acceptTermsAndConditions()
		.skipSignIn()
		.tapSearchField()
		.tapSearchField()
		.enterLocationName(Location)
		.tapSearchResult()
		.clearLocation();
		
	}	
	
	/*@Test(dataProvider="SourceProvider")
	public void sourceLocation(String srcLocation){
		googleNav.navigationSource(srcLocation);
	}
	
	@Test(dataProvider="DestinationProvider")
	public void destLocation(String destLocation){
		googleNav.navigationDestination(destLocation);
	}*/
		
	@DataProvider(name="LocationProvider")
	public  Object[][] LocationProvider() {
		Object[][] Locations = {{"Chennai"},{"Bangalore"},{"Kolkatta"},{"Maharashtra"},{"Delhi"}};
		return Locations;
		//return new Object[][]{{"Chennai"},{"Bangalore"},{"Kolkatta"},{"Maharashtra"},{"Delhi"}};
	}
	
	/*@DataProvider(name="SourceProvider")
	public Object[][] sourceProvider(){
		Object[][] source = {{"Chennai"}};
		return source;
	}
	 		
	@DataProvider(name="DestinationProvider")
	public Object[][] destinationProvider(){
		Object[][] destination = {{"Bangalore"}};
		return destination;
	}*/
	
	
	
		
	@AfterSuite
	public TestBase tearDown(){
		return googleMaps.tearDown();
	}
	
}
