package altimetrik.googlemaps.automation;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import aiframework.core.utils.TestBase;

public class TestGoogleNavigator extends GoogleMaps{
	

	GoogleNavigator googleNav = new GoogleNavigator();
	
		
	/*@Test(dataProvider="SourceDestinationProvider")
	public void sourceLocation(String sourceLocation){
		googleNav.navigationSource(sourceLocation);
	}
	
	@Test(dataProvider="SourceDestinationProvider")
	public void destLocation(String destLocation){
		googleNav.navigationDestination(destLocation);
	}*/	
		
	@DataProvider(name="SourceDestinationProvider")
	public Object[][] LocationProvider() {
		Object[][] Locations = {{"Bangalore"},{"Chennai"}};
		return Locations;
	}
	
	@Override
	@AfterSuite
	public TestBase tearDown(){
		return googleNav.tearDown();
	}
	
	
}
