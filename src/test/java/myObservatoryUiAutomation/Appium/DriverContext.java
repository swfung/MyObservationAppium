package myObservatoryUiAutomation.Appium;

import io.appium.java_client.android.AndroidDriver;

public class DriverContext{
	
	public static AndroidDriver driver;
	
	
	public static void setDriver(AndroidDriver inputDriver)
	{
		driver = inputDriver;
	}
	
	public static AndroidDriver getDriver()
	{
		return driver;
	}
}