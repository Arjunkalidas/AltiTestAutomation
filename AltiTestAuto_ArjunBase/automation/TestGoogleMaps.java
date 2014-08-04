package altimetrik.googlemaps.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestGoogleMaps extends GoogleMaps
{
	

	GoogleMaps googleMaps = new GoogleMaps();
	
	@BeforeSuite
	public void setUp(){
		googleMaps.setUp("192.168.70.70","4725")
		.acceptTermsAndConditions()
		.skipSignIn();
	}

	@Test(dataProvider="LocationProvider")
	public void locationSearch(String Location){
		googleMaps.enterLocationName(Location)
		.tapLocationName()
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
		
	
	@AfterSuite
	public GoogleMaps tearDown(){
		return googleMaps.tearDown();
	}
	
}
