package aiframework.core.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import com.google.common.io.Files;

public class TestBase {
	public static RemoteWebDriver driver;
	public static WebElement myDynamicElement;
	public static JavascriptExecutor js = driver;
	public static String location;
	public static String[] startServer;
	public static String[] startASM;
	public static Runtime runtime = Runtime.getRuntime();
	public static Process asm = null;
	public static Process appium = null;
	public static TestShell testShell = new TestShell();
	public static String fileName = "Object_Repository.xls";
	public static String sheetName = "EriBank";
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static File app;
	public static String Dynamiclocator = "i_";
	public static String platformName;
	public static String appiumVersion;
	public static String platformVersion ;
	public static String deviceName ;
	public static String activityName;
	public static String packageName ;
	public static String applicationPath ;
	public static String bundleId;
	public static String udId;
	//********** For the snapshot folder ************//
		public static SimpleDateFormat formatter = new SimpleDateFormat("_yyyy_MMM_dd HH_mm_ss");
		public static String dateN = formatter.format(new Date().getTime());
		public static String snapShotDirectory = Files.simplifyPath(System.getProperty
				("user.dir")+"//Snapshot") + dateN;
		//public static int photoIndex = 0;

	public static WebElement element(String locator) {

		WebElement element = null;

		try {

			element = driver.findElement(By.id(MyRepository.getNewLocator(locator, "id")));

		} catch (NoSuchElementException |UnsupportedCommandException e) {

			try {

				element = driver.findElement(By.name(MyRepository.getNewLocator(locator, "name")));


			} catch (NoSuchElementException |UnsupportedCommandException e1) {

				try{

					element = driver.findElement(By.className(MyRepository.getNewLocator(locator, "className")));

				}

				catch(NoSuchElementException |UnsupportedCommandException e2)

				{

					try{

						element=driver.findElement(By.cssSelector(MyRepository.getNewLocator(locator, "cssSelector")));

					}

					catch(NoSuchElementException |UnsupportedCommandException e3){

						try{

							element = driver.findElement(By.linkText(MyRepository.getNewLocator(locator,"linkText")));

						}

						catch(NoSuchElementException |UnsupportedCommandException e4)

						{

							try{

								element = driver.findElement(By.partialLinkText(MyRepository.getNewLocator(locator,"partialLinkText"))); 

							}

							catch(NoSuchElementException |UnsupportedCommandException e5)

							{

								try{

									element = driver.findElement(By.tagName(MyRepository.getNewLocator(locator,"tagName")));

								}

								catch(NoSuchElementException |UnsupportedCommandException e6)

								{

									try{

										element = driver.findElement(By.xpath(MyRepository.getNewLocator(locator,"xpath")));

									}

									catch(NoSuchElementException |UnsupportedCommandException e7)

									{

										e7.printStackTrace();

									}

								}

							}

						}

					}

				}

			}

		}

		return element;

	}

	public TestBase takeScreenshot(String snapShotDirectory) {
		String path = null;
		try {
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

			String fileName = source.getName();
			/*int indexOfExt = fileName.indexOf(".");
			String file1 = fileName.substring(0,indexOfExt);
			fileName =	file1+"_"+photoIndex+".png";*/

			fileName = "screenshot"+System.currentTimeMillis()/*+"_"+photoIndex+".png"*/;
			File f = new File(snapShotDirectory);
			try{

				f.mkdir();

			}catch (SecurityException se){

			}

			path = f.getAbsolutePath() + "/" + fileName +".jpg";
			//System.out.println(path);

			FileUtils.copyFile(source, new File(path));
			Reporter.log("<a href='"+ path+"'> <img src='"+ path + " height='100' width='100'/> </a>");
			//photoIndex++;
		}
		catch(IOException e) {

			path = "Failed to capture screenshot: " + e.getMessage();

		}
		Reporter.setCurrentTestResult(null);
		return this;
	}

	public TestBase setUp(String application, 
			String host, 
			String port, 
			String deviceType, 
			String browserType, 
			String platFormVersion, 
			String deviceName, 
			String platformName, 
			String packageName, 
			String activityName, 
			String udId) {

		TestBase testBase=new TestBase();
		startServer =new String[]{
				"sh",
				"StartServer.sh",
				application,
				host,
				port
		};

		/*startASM =new String[]{
							"sh",
							"StartASM.sh",
			};
			/*				  try { 
							startAppiumServer(); 
							startASM();
				  					} 
			  					catch (IOException e1) 
			  						{
			  						e1.printStackTrace(); 
			  							}*/
		capabilities= new DesiredCapabilities();
		app = new File(application);
		/********************* iOS specific ***************************/
		//				testBase.setDevice(capabilities, deviceType)
		//				.setBrowser(capabilities, browserType)
		//				.setPlatformVersion(capabilities, platFormVersion)
		//				.setPlatformName(capabilities, platformType)
		//				.setApplication(capabilities, app)
		//				.setBundIdPackage(capabilities, packageName)
		//				.setActivity(capabilities, activityName)
		//				.setUdId(capabilities, udId);

		createRemoteWebDriver(host, port);
		return this;
	}
	
	public TestBase startASM() throws IOException {
		asm =TestShell.startProcess(startASM);
		System.out.println("asm="+asm.toString());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	public TestBase startAppiumServer(String[] startServer) throws IOException {
		appium =  TestShell.startProcess(startServer);
		System.out.println("appium=" +appium.toString());
		try { 
			Thread.sleep(10000); }
		catch (InterruptedException e)
		{
			e.printStackTrace(); 
		}
		return this;
	}

	public TestBase createRemoteWebDriver(String host, String port) {
		try {
			driver = new RemoteWebDriver(new URL("http://"+host+":"+port+"/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return this;
	}

	public TestBase stopASM() {
		try {
			System.out.println("asm=" +asm.toString());
			TestShell.killUnixProcess(asm);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public TestBase stopAppiumServer() {
		try {
			System.out.println("appium=" + appium.toString());
			TestShell.killUnixProcessByName("appium");
		} 
		catch (Exception e1) {
			e1.printStackTrace();
		}
		return this;
	}

	public TestBase activityName(String activityName) {
		capabilities.setCapability("appActivity", activityName);
		return this;
	}
	public TestBase packageName(String packageName) {
		capabilities.setCapability("appPackage", packageName);
		return this;
	}
	public TestBase applicationPath(String applicationPath) {
		capabilities.setCapability("app", applicationPath);
		return this;
	}
	public TestBase deviceName(String deviceName) {
		capabilities.setCapability("deviceName", deviceName);
		return this;
	}
	public TestBase platformVersion(String platformVersion) {
		capabilities.setCapability("platformVersion", platformVersion);
		return this;
	}
	public TestBase platformName(String platformName) {
		System.out.println(platformName);
		capabilities.setCapability("platformName", platformName);
		return this;
	}
	public TestBase appiumVersion(String appiumVersion) {
		capabilities.setCapability("appium-version", appiumVersion);
		return this;
	}

	public TestBase browserName(String browserName) {
		capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
		return this;
	}

	public TestBase timeOut(int timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
		return this;
	}

	public TestBase  setActivity( String activityName) {
		capabilities.setCapability("app-activity", activityName);
		return this;
	}

	public TestBase applicationPath( File app) {
		capabilities.setCapability("app", app.getAbsolutePath().toString());
		return this;
	}

	public TestBase deviceType( String deviceType) {
		capabilities.setCapability("device", deviceType);
		return this;
	}

	public TestBase udId( String udId) {
		capabilities.setCapability("udid",udId);
		return this;
	}
	public TestBase bundIdPackage( String bundleIdpackageName) {
		capabilities.setCapability("bundleId", bundleIdpackageName);
		return this;
	}
	public TestBase bundleId(String bundleId) {
		capabilities.setCapability("bundleId",  bundleId);
		return this;
	}
	public TestBase identifyPlatform() {
		System.out.println("platformName= "+platformName);
		if(platformName.equals("Android"))
		{
			Dynamiclocator="a_";
		}else if(platformName.equals("iOS")){
			Dynamiclocator="i_";
		}
		return this;
	}
	public WebElement universalElement(String locatorName) {
		//identifyPlatform();
		System.out.println(Dynamiclocator+locatorName);
		return element(Dynamiclocator+locatorName);
	}
	
	public TestBase tearDown() {
		driver.quit();
		return this;
	}
};