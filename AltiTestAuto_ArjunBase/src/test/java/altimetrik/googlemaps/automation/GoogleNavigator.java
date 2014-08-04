package altimetrik.googlemaps.automation;


public class GoogleNavigator extends GoogleMaps {
	

	public static void main(String[] args) {
		GoogleNavigator gn = new  GoogleNavigator();
//		GoogleMaps gm=new GoogleMaps(driver);
		
		gn.setUp("192.168.70.70","4725")
		.acceptTermsAndConditions()
		.skipSignIn()
		//.navigationWalkthrough()
		//.navigationSource("Bangalore")
		//.navigationDestination("Chennai")
		.tearDown();
		}

	/*@Override
	public GoogleMaps navigationWalkthrough() {
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1D); put("touchCount", 1D);
		put("duration", 0.5); put("x", 589D); put("y", 120D); }});
		return this;
	}*/

	/*@Override
	public GoogleMaps navigationDestination(String source) {
		
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[3]/android.view.View[1]/android.widget.EditText[1]")).sendKeys(source);
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ListView[1]")).click();
		
		wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1D); put("touchCount", 1D); 
		put("duration", 0.5); put("x", 199D); put("y", 271D); }});
		wd.close();
		return this;
	}

	@Override
	public GoogleMaps navigationSource(String destination) {
		wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"
				+ "/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]"
				+ "/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
				.sendKeys("Bangalore");
		driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).sendKeys(destination);
		driver.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1D); put("touchCount", 1D);
		put("duration", 0.5); put("x", 213D); put("y", 274D); }});
		return this;
	}*/
}