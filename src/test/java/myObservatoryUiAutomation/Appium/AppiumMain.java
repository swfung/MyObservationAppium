package myObservatoryUiAutomation.Appium;

import java.io.File;
import java.net.URI;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumMain {
	@Test
	public void AppiumTest() throws Exception {
		final String appiumLibPath = "C:\\Users\\swfun\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib";
		final String appPath = "C:\\Users\\swfun\\eclipse-workspace\\Appium\\src\\test\\java\\resources\\myobservatory-5-16.apk";
		final String deviceName = "Galaxy A12";

		//Start the Appium server
		AppiumDriverLocalService service = new AppiumServiceBuilder()
				.withAppiumJS(new File(appiumLibPath))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		service.start();
		
		//Configurations
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setApp(appPath);
		AndroidDriver driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), options);
		DriverContext.setDriver(driver);
		
		//Handle pop-ups
		if (Utilities.isElementPresent(By.xpath(Xpath_Locator.disclaimer))) {
			System.out.println("Disclaimer present. Clicking agree...");
			Utilities.clickElement(By.xpath(Xpath_Locator.agreeBtn));
		} 
		
		if (Utilities.isElementPresent(By.xpath(Xpath_Locator.privacyPolicyStatements))) {
			System.out.println("Privacy Policy Statements present. Clicking agree...");
			Utilities.clickElement(By.xpath(Xpath_Locator.agreeBtn));
		}
		
		if (Utilities.isElementPresent(By.xpath(Xpath_Locator.permissionMessage))) {
			System.out.println("Allow MyObservatory to send you notifications? present. Clicking Don't Allow...");
			Utilities.clickElement(By.xpath(Xpath_Locator.permissionDenyButton));
		}
		
		if (Utilities.isElementPresent(By.xpath(Xpath_Locator.backgroundAlert))) {
			System.out.println("Background Access to Location Information present. Clicking Don't Allow...");
			Utilities.clickElement(By.xpath(Xpath_Locator.okBtn));
		}
		
		if (Utilities.isElementPresent(By.xpath(Xpath_Locator.locationPermissionMessage))) {
			System.out.println("Allow MyObservatory to access this device’s location? present. Clicking Don't Allow...");
			Utilities.clickElement(By.xpath(Xpath_Locator.permissionDenyButton));
		}
		
		if (Utilities.isElementPresent(By.xpath(Xpath_Locator.exitNextBtn))) {
			System.out.println("PopUp present. Clicking Next to dismiss...");
			while (Utilities.isElementPresent(By.xpath(Xpath_Locator.exitNextBtn))) {
				Utilities.clickElement(By.xpath(Xpath_Locator.exitNextBtn));
			}
		}
		
		//Check the 9th day’s weather forecast
		ValidationSteps.checkHomePage();
		ValidationSteps.checkCurrentDate();
		ValidationSteps.tapsMenuBtn();
		ValidationSteps.expandForecastCategory();
		ValidationSteps.taps9DayForecastBtn();
		ValidationSteps.check9DayForecastPage();
		
		//Close all services
		driver.quit();
		service.stop();
	}
}
