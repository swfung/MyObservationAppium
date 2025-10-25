package myObservatoryUiAutomation.Appium;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class ValidationSteps {
	protected static AndroidDriver driver = DriverContext.getDriver();
	
	private static LocalDate currentDate = LocalDate.now(ZoneId.of("Asia/Shanghai"));
	
	protected WebElement waitElementPresent(By by){
    	return  waitElementPresent(driver, by, ConstantFile.TIMEOUT60);
    }
	
	protected WebElement waitElementPresent(By by, int timeout){
    	return  waitElementPresent(driver, by, timeout);
    }
    
    protected WebElement waitElementPresent(AndroidDriver driver, By by, int timeout){
    	return new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

	public static void checkHomePage() throws IOException {
		try{
			Assert.assertTrue(Utilities.isElementPresent(By.xpath(Xpath_Locator.MyObservatory), ConstantFile.TIMEOUT10));
		} catch (AssertionError e) {
			System.out.println("HomePage can not be displayed");
			throw e;
		}
		Utilities.takeScreenshot("checkHomePage");
	}

	public static void checkCurrentDate() throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy (EEEE)");
		try {
			String currentDateXpath = "//*[contains(@text,'"+currentDate.format(formatter)+"')]";
			System.out.println("Current Date is: "+currentDate.format(formatter));
			Assert.assertTrue(Utilities.isElementPresent(By.xpath(currentDateXpath),ConstantFile.TIMEOUT10));
		} catch (AssertionError e) {
			System.out.println("Current Date Verification Error");
			throw e;
		}
		Utilities.takeScreenshot("checkCurrentDate");
	}

	public static void tapsMenuBtn() throws IOException {
		try {
			Assert.assertTrue(Utilities.isElementPresent(By.xpath(Xpath_Locator.menuBtn),ConstantFile.TIMEOUT10));
			Utilities.clickElement(By.xpath(Xpath_Locator.menuBtn));
		} catch (AssertionError e) {
			System.out.println("Menu Button is not available");
			throw e;
		}
		Utilities.takeScreenshot("tapsMenuBtn");
	}
	
	public static void expandForecastCategory() throws IOException {
		try {
			Assert.assertTrue(Utilities.isElementPresent(By.xpath(Xpath_Locator.forecastCategory),ConstantFile.TIMEOUT10));
			Utilities.clickElement(By.xpath(Xpath_Locator.forecastCategory));
		} catch (AssertionError e) {
			System.out.println("Forecast Category is not available");
			throw e;
		}
		Utilities.takeScreenshot("expandForecastCategory");
	}

	public static void taps9DayForecastBtn() throws Exception {
		try {
			Utilities.swipeToElmentByXpath(Xpath_Locator.nineDayForecastBtn);
			Utilities.clickElement(By.xpath(Xpath_Locator.nineDayForecastBtn));
		} catch (AssertionError e) {
			System.out.println("9-Day Forecast Button is not available");
			throw e;
		}
		Utilities.takeScreenshot("taps9DayForecastBtn");
	}

	public static void check9DayForecastPage() throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM");
		try {
			Assert.assertTrue(Utilities.isElementPresent(By.xpath(Xpath_Locator.nineDayForecastTab),ConstantFile.TIMEOUT10));
			for(int i=0;i<9;i++){
				LocalDate futureDate = currentDate.plusDays(i);
				String futureDateXpath = "//*[contains(@text,'"+futureDate.format(formatter)+"')]";
				System.out.println("Future Date is: "+futureDate.format(formatter));
				if(!Utilities.isElementPresent(By.xpath(futureDateXpath),ConstantFile.TIMEOUT5)) {
					Utilities.swipeToElmentByXpath(futureDateXpath);
				}
				Assert.assertTrue(Utilities.isElementPresent(By.xpath(futureDateXpath),ConstantFile.TIMEOUT5));
			}
		} catch (AssertionError e) {
			System.out.println("9-Day Forecast Page have error");
			throw e;
		}
		Utilities.takeScreenshot("check9DayForecastPage");
	}
}