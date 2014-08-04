/*package altimetrik.googlemaps.automation;

public class RoughTest {
	
	Screenshot code::

		driver.get("http://bangalore.quikr.com/");
		        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		        FileUtils.copyFile(scrFile, new File("E:\\quickr.jpg"));


		Reporting code::


		public static void loadTemplate_for_report(String Dir) {

		    try {
		        FileOutputStream fileout = new FileOutputStream(Dir + "\\"
		            + file_counter + "_" + use_case + ".html", false);
		        PrintStream scriptMainStream = new PrintStream(fileout);
		        scriptMainStream
		            .println("<img src = \""
		                + Constants.parent_dir
		                + Constants.parent_dir_images
		                + "/FunQA.png\"><div align = \"left\"><TABLE BORDER align = \"center\"><TR><TH><img src = \""
		                + Constants.parent_dir
		                + Constants.parent_dir_images
		                + "/time.png\"><div align = \"center\">Start Time<TH><img src = \""
		                + Constants.parent_dir
		                + Constants.parent_dir_images
		                + "/scenario.png\"><div align = \"center\">Use case<TH><img src = \""
		                + Constants.parent_dir
		                + Constants.parent_dir_images
		                + "/steps.png\"><div align = \"center\">Test Steps<TH><img src = \""
		                + Constants.parent_dir
		                + Constants.parent_dir_images
		                + "/steps.png\"><div align = \"center\">TestData_Messages<TH><img src = \""
		                + Constants.parent_dir
		                + Constants.parent_dir_images
		                + "/statusnew.png\"><div align = \"center\">Test case status<TH><img src = \""
		                + Constants.parent_dir
		                + Constants.parent_dir_images
		                + "/screenshot.png\"><div align = \"center\">Snapshot<TH><img src = \""
		                + Constants.parent_dir
		                + Constants.parent_dir_images
		                + "/time.png\"><div align = \"center\">End Time<TR>");
		        scriptMainStream.close();

		    } catch (FileNotFoundException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }

		    }

		    public static void addReportStartDate(String Dir) {

		    addtoreport("<TR><TD>" + new Date().toString(), Dir);
		    }

		    public static void addReportEndDate(String Dir) {

		    addtoreport("<TD>" + new Date().toString() + "</TR>", Dir);
		    }

		    public static void addUsecase(String Dir) {

		    addtoreport("<TD>" + use_case, Dir);
		    }

		    public static void addSnapshot(String Dir) {

		    Random rand = new Random();
		    int fname = rand.nextInt(1000000);

		    File scrFile = ((ChromeDriver) driver)
		        .getScreenshotAs(OutputType.FILE);
		    try {
		        FileUtils.copyFile(scrFile, new File(Dir + "\\Images\\Execution\\"
		            + fname + ".png"));
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }

		    addtoreport("<TD><A href = \"Images/Execution/" + fname + ".png"
		        + "\">" + "<div align = \"center\">" + "<img src = \""
		        + Constants.parent_dir + Constants.parent_dir_images
		        + "/screenshot1.png\">" + "</A>", Dir);

		    }

		    public static void ADDSNAPSHOT(String Dir) throws IOException, AWTException {
		    Random rand = new Random();
		    int fname = rand.nextInt(2000000);
		    Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
		        .getScreenSize());
		    BufferedImage capture = new Robot().createScreenCapture(screenRect);
		    ImageIO.write(capture, "png", new File(Dir + "\\Images\\Execution\\"
		        + fname + ".png"));
		    addtoreport("<TD><A href = \"Images/Execution/" + fname + ".png"
		        + "\">" + "<div align = \"center\">" + "<img src = \""
		        + Constants.parent_dir + Constants.parent_dir_images
		        + "/screenshot1.png\">" + "</A>", Dir);

		    }

		    public static void addStatus(String Dir, Boolean value) {
		    if (value) {
		        addtoreport("<TD><div align = \"center\"><img src=\""
		            + Constants.parent_dir + Constants.parent_dir_images
		            + "/pass.jpg\">", Dir);

		    } else {
		        addtoreport("<TD><div align = \"center\"><img src=\""
		            + Constants.parent_dir + Constants.parent_dir_images
		            + "/error.png\">", Dir);
		    }

		    }

		    public static void addTestData(String Dir, String Tdata) {
		    addtoreport("<TD>" + Tdata, Dir);
		    }

}
*/


/*public class {scriptName} {
	public static void main(String[] args) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(CapabilityType.VERSION, "4.2");
		capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
		capabilities.setCapability("app", "/Android-Tools/adt-bundle-mac-x86_64-20140321/sdk/build-tools/android-4.4.2/com.google.android.apps.maps-7.0.0.apk");
		capabilities.setCapability("app-package", "com.google.android.apps.maps");
		capabilities.setCapability("app-activity", "com.google.android.maps.MapsActivity");
		wd = new RemoteWebDriver(new URL("http://192.168.70.70:4725/wd/hub"), capabilities);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
(JavascriptExecutor)wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1); put("touchCount", 1);
put("duration", 0.5); put("x", 589); put("y", 120); }});
		wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]"
				+ "/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]"
				+ "/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]"))
				.sendKeys("Bangalore");
(JavascriptExecutor)wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1); put("touchCount", 1);
put("duration", 0.5); put("x", 213); put("y", 274); }});
		wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.TextView[2]"))
				.sendKeys("Chennai");
(JavascriptExecutor)wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1); put("touchCount", 1); put("duration", 0.5); put("x", 199); put("y", 271); }});
		wd.close();
	}
}*/

/*import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class {scriptName} {
	public static void main(String[] args) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(CapabilityType.VERSION, "4.2");
		capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
		capabilities.setCapability("app", "/Android-Tools/adt-bundle-mac-x86_64-20140321/sdk/build-tools/android-4.4.2/com.google.android.apps.maps-7.0.0.apk");
		capabilities.setCapability("app-package", "com.google.android.apps.maps");
		capabilities.setCapability("app-activity", "com.google.android.maps.MapsActivity");
		wd = new RemoteWebDriver(new URL("http://192.168.70.70:4725/wd/hub"), capabilities);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.findElement(By.name("Directions")).click();
		wd.findElement(By.name("Driving mode")).click();
		wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).sendKeys("Bangalore");
		wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]")).click();
		wd.close();
	}
}
*/


/*import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class {scriptName} {
	public static void main(String[] args) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(CapabilityType.VERSION, "4.2");
		capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
		capabilities.setCapability("app", "/Android-Tools/adt-bundle-mac-x86_64-20140321/sdk/build-tools/android-4.4.2/com.google.android.apps.maps-7.0.0.apk");
		capabilities.setCapability("app-package", "com.google.android.apps.maps");
		capabilities.setCapability("app-activity", "com.google.android.maps.MapsActivity");
		wd = new RemoteWebDriver(new URL("http://192.168.70.70:4725/wd/hub"), capabilities);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[3]/android.view.View[1]/"
				+ "android.widget.EditText[1]")).sendKeys("Bangalore");
		wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.TextView[1]")).sendKeys("Bangalore");
		wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]")).click();
		wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.TextView[2]")).sendKeys("Chennai");
		wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.TextView[2]")).sendKeys("Chennai");
		wd.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/"
				+ "android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]")).click();
		wd.close();
	}
}
*/
