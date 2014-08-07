package featdsl.core.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
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


public class TestBase {
	public static Process appium = null;
	public static RemoteWebDriver driver;
	public static JavascriptExecutor js = (JavascriptExecutor)driver;
	public static Properties CONFIG=null;
	public MyRepository suiteXls = null;
	public static FileInputStream ip = null;
	public static String [] startServer;
	public static String Dynamiclocator = null;
	public static String fileName=null;
	public static String sheetName=null;

	/************* Capabilities ************************/
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static File app;
	public static String host;
	public static String port;
	public static String platformName;
	public static String appiumVersion;
	public static String platformVersion ;
	public static String deviceName ;
	public static String activityName;
	public static String packageName ;
	public static String applicationPath ;
	public static String bundleId;
	public static String udId;

	public static void main(String[] args) {


	}

	public void initialize() throws IOException{
		CONFIG = new Properties();
		try {
			ip = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//featdsl//core//config//config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		CONFIG.load(ip);
		suiteXls = new MyRepository(System.getProperty("user.dir")+"//src//test//java//featdsl//lib//xls//Object_Repository.xls");
		startServer=new String[]{"sh",
				"StartIosServer.sh", 
				bundleId,
				udId,
				host,
				port};
		try { 
			startAppiumServer(startServer);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}

	public WebElement element(String locator) {

		WebElement element = null;

		try {

			element = driver.findElement(By.id(suiteXls.getNewLocator(fileName, sheetName, locator, "id")));

		} catch (NoSuchElementException|UnsupportedCommandException e) {

			try {

				element = driver.findElement(By.name(suiteXls.getNewLocator(fileName, sheetName, locator, "name")));

			} catch (NoSuchElementException|UnsupportedCommandException e1) {

				try{

					element = driver.findElement(By.className(suiteXls.getNewLocator(fileName, sheetName, locator, "className")));

				}

				catch(NoSuchElementException|UnsupportedCommandException  e2)

				{

					try{

						element=driver.findElement(By.cssSelector(suiteXls.getNewLocator(fileName, sheetName, locator, "cssSelector")));

					}

					catch(NoSuchElementException|UnsupportedCommandException e3){

						try{

							element = driver.findElement(By.linkText(suiteXls.getNewLocator(fileName,sheetName, locator, "linkText")));

						}

						catch(NoSuchElementException|UnsupportedCommandException e4)

						{

							try{

								element = driver.findElement(By.partialLinkText(suiteXls.getNewLocator(fileName,sheetName, locator, "partialLinkText"))); 

							}

							catch(NoSuchElementException|UnsupportedCommandException e5)

							{

								try{

									element = driver.findElement(By.tagName(suiteXls.getNewLocator(fileName,sheetName, locator, "tagName")));

								}

								catch(NoSuchElementException|UnsupportedCommandException e6)

								{

									try{

										element = driver.findElement(By.xpath(suiteXls.getNewLocator(fileName,sheetName, locator, "xpath")));

									}

									catch(NoSuchElementException|UnsupportedCommandException e7)

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

		/*startServer =new String[]{
				"sh",
				"StartServer.sh",
				application,
				host,
				port
		};*/

		capabilities= new DesiredCapabilities();
		app = new File(application);

		/********************* iOS specific ***************************/
		//						testBase.setDevice(capabilities, deviceType)
		//						.setBrowser(capabilities, browserType)
		//						.setPlatformVersion(capabilities, platFormVersion)
		//						.setPlatformName(capabilities, platformType)
		//						.setApplication(capabilities, app)
		//						.setBundIdPackage(capabilities, packageName)
		//						.setActivity(capabilities, activityName)
		//						.setUdId(capabilities, udId);

		createRemoteDriver(host, port);
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

	public TestBase applicationPath(String applicationPath) {
		capabilities.setCapability("app", applicationPath);
		return this;
	}

	public TestBase timeOuts(String timeOut) {
		driver.manage().timeouts().implicitlyWait(Long.parseLong(timeOut), TimeUnit.SECONDS);
		return this;
	}

	public TestBase createRemoteDriver(String host, String port){
		try {
			driver = new RemoteWebDriver(new URL("http://"+host+":"+port+"/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
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

	public TestBase deviceName(String deviceName) {
		capabilities.setCapability("deviceName", deviceName);
		return this;
	}

	public TestBase platformVersion(String platformVersion) {
		capabilities.setCapability("platformVersion", platformVersion);
		return this;
	}

	public TestBase platformName(String platformName) {
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

	public TestBase deviceType( String deviceType) {
		capabilities.setCapability("device", deviceType);
		return this;
	}

	public TestBase udId( String udId) {
		capabilities.setCapability("udid",udId);
		return this;
	}

	public TestBase bundleId(String bundleId) {
		capabilities.setCapability("bundleId",  bundleId);
		return this;
	}

	public void capturescreenshot(String filename){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Screenshots\\"+filename+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		System.out.println(Dynamiclocator+locatorName);
		return element(Dynamiclocator+locatorName);
	}

	public TestBase tearDown() {
		driver.quit();
		return this;
	}

}
