package aiframework.core.utils;

import java.io.IOException;
import java.lang.reflect.Field;

public class TestShell {

	static String[]  startServer =new String[]{
			"/bin/sh",
			"StartServer.sh",
			"/Users/arjun/Desktop/EriBank.apk", 
			"localhost", 
			"4725"
	};
	
	public void TestStartServer(){
		Process appium = null;
		try {
			appium = startProcess(startServer);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(getUnixPID(appium));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Process appium = null;
		try {
		 appium = startProcess(startServer);
		 try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(getUnixPID(appium));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
//			killUnixProcess(appium);
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Process startProcess() throws IOException {
		return startProcess(startServer);
	}

	public static Process startProcess(String[] commandArray) throws IOException {
		Process process;
		process=  Runtime.getRuntime().exec(commandArray);
		return process;
	}

	public static int getUnixPID(Process process) throws Exception
	{
	    System.out.println(process.getClass().getName());
	    if (process.getClass().getName().equals("java.lang.UNIXProcess"))
	    {
	        Class cl = process.getClass();
	        Field field = cl.getDeclaredField("pid");
	        field.setAccessible(true);
	        Object pidObject = field.get(process);
	        return (Integer) pidObject;
	    } else
	    {
	        throw new IllegalArgumentException("Needs to be a UNIXProcess");
	    }
	}

	public static int killUnixProcessByName(String processName) throws Exception
	{
	    return Runtime.getRuntime().exec("pkill -f "+processName).waitFor();
	}
	
	public static int killUnixProcess(Process process) throws Exception
	{
	    int pid = getUnixPID(process);
	    int actualPid=pid+1;
	    System.out.println(actualPid);
	    return Runtime.getRuntime().exec("kill -9 " + actualPid).waitFor();
	}

	public static int getPID() {
	  String tmp = java.lang.management.ManagementFactory.getRuntimeMXBean().getName();
	  tmp = tmp.split("@")[0];
	  return Integer.valueOf(tmp);
	}
}
