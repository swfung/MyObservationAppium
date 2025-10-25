package myObservatoryUiAutomation.Appium;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

public class Utilities {
	protected static AndroidDriver driver = DriverContext.getDriver();
	
	public static boolean isElementPresent(By by) {
			return isElementPresent(by, ConstantFile.TIMEOUT5);
			}
	public static boolean isElementPresent(By by, int timeout) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(by));
			return true;
		} catch (Exception e) {
			return false;
		}

	}
	public static void takeScreenshot(String fileName) throws IOException {
		fileName = "screenshots/" + fileName + ".png";
		String directory = "output/";
		File sourceFile = ((TakesScreenshot) DriverContext.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
	}
	
	public static WebElement swipeToElmentByXpath(String xpath) {
		WebElement webElement = null;
		for(int i = 1; i<= 10; i++) {
			try {
				webElement = driver.findElement(By.xpath(xpath));
			}catch (Exception e) {
				
			}
			
			if(webElement != null) {
				return webElement;
			}
			swipeDown();
		}
		throw new RuntimeException("Cannot find element for xpath: " + xpath);
	}
	
	public static void swipeDown() {
		Dimension phoneSize = driver.manage().window().getSize();

        int height = phoneSize.getHeight() * 6 / 10;
        int width = phoneSize.getWidth();
        int left = driver.manage().window().getPosition().getX();
        int top = driver.manage().window().getPosition().getY() / 10;

        driver.executeScript("mobile: scrollGesture",
                ImmutableMap.of(
                        "left", left,
                        "top", top,
                        "width", width,
                        "height", height,
                        "direction", "down",
                        "percent", 1.0,
                        "speed", 100));
	}
	
	public static void clickElement(By by) {
		driver.findElement(by).click();
	}
}
