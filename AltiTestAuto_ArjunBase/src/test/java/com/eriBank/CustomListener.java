package com.eriBank;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.internal.Utils;

import com.google.common.io.Files;

public class CustomListener extends TestListenerAdapter implements IInvokedMethodListener{
	
	// here we are going to override some functions.
		// TestListenerAdapter class has these methods, but we are overriding them here. 
		// So now when we call it, it calls the
		// the method in the CustomListener class.
	
	// The custom listener will be called every time a test case is passed or failed.
	
	public static RemoteWebDriver driver;
	public static String currentUserName = "";
	public static SimpleDateFormat formatter = new SimpleDateFormat("_yyyy_MMM_dd HH_mm_ss");
	public static String dateN = formatter.format(new Date().getTime());
	public static String snapShotDirectory = Files.simplifyPath(System.getProperty
			("user.home")+"//VDL//currentUserName"+dateN+"//Snapshots");
	public static String images = Files.simplifyPath(System.getProperty("user.dir")+"//Images//testng-mini-logo.png");
	public static EriBankDev eb=new EriBankDev();
			
	
	public void onTestFailure(ITestResult tr){
		System.out.println("Failed -- "+tr.getName());
		eb.takeScreenshot(snapShotDirectory);
	}

	/*public void onTestSkipped(ITestResult tr) {
		System.out.println("Skipped -- "+tr.getName());
		eb.takeScreenshot(snapShotDirectory);
	}*/
	
	public void onTestSuccess(ITestResult tr){
		System.out.println("Success -- "+tr.getName());
		// here if you want to report to an excel or create a log file with log4j jar.
		eb.takeScreenshot(snapShotDirectory);
	}
	
	// this will be called only after the test cases are invoked.
	public void afterInvocation(IInvokedMethod method, ITestResult result) {
		Reporter.setCurrentTestResult(result);

		if (method.isTestMethod()) {
			List<Throwable> verificationFailures = ErrorUtil.getVerificationFailures();
			//if there are verification failures...
			if (verificationFailures.size() != 0) {
				//set the test to failed
				result.setStatus(ITestResult.FAILURE);
				
				//if there is an assertion failure add it to verificationFailures
				if (result.getThrowable() != null) {
					verificationFailures.add(result.getThrowable());
				}
 
				int size = verificationFailures.size();
				//if there's only one failure just set that
				if (size == 1) {
					result.setThrowable(verificationFailures.get(0));
				} else {
					//create a failure message with all failures and stack traces (except last failure)
					StringBuffer failureMessage = new StringBuffer("Multiple failures (").append(size).append("):nn");
					for (int i = 0; i < size-1; i++) {
						failureMessage.append("Failure ").append(i+1).append(" of ").append(size).append(":n");
						Throwable t = verificationFailures.get(i);
						String fullStackTrace = Utils.stackTrace(t, false)[1];
						failureMessage.append(fullStackTrace).append("nn");
					}
 
					//final failure
					Throwable last = verificationFailures.get(size-1);
					failureMessage.append("Failure ").append(size).append(" of ").append(size).append(":n");
					failureMessage.append(last.toString());
 
					//set merged throwable
					Throwable merged = new Throwable(failureMessage.toString());
					merged.setStackTrace(last.getStackTrace());
 
					result.setThrowable(merged);
					
				}
			}
		
		}
		
	}
 
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {}
	
	public EriBankDev takeScreenshot(String snapShotDirectory) {
		String path = null;
		String iconPath = null;
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

			path = f.getAbsolutePath() + "/" + fileName+".jpg";
			//System.out.println(path);
			
			FileUtils.copyFile(source, new File(path));
			Reporter.log("<a href='"+ path +"'> <img src='"+ images + "' height='100' width='100'/> </a>");
			//photoIndex++;
		}
		catch(IOException e) {

			path = "Failed to capture screenshot: " + e.getMessage();

		}
		Reporter.setCurrentTestResult(null);
		return (EriBankDev)this;
		//FileUtils.copyFile(scrFile, new File(file.getAbsolutePath()+ "/selenium-reports/html/" + result.getName() + ".jpg"));
        //Reporter.log("<a href='"+ file.getAbsolutePath()+"/selenium-reports/html/" + result.getName() + ".jpg'> <img src='"+ file.getAbsolutePath()+"/selenium-reports/html/"+ result.getName() + ".jpg' height='100' width='100'/> </a>");
		
	}
}
