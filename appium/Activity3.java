package Appium;

import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception{
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setApp("C:/Users/UdayKiran/Downloads/Calculator.apk");

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
	}
	
	@Test
	public void add() {
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result = driver.findElement(
                AppiumBy.id("com.google.android.calculator:id/result_final"))
                .getText();
        Assert.assertEquals(result, "14");
        
	}
	
	@Test
	public void minus() {
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result = driver.findElement(
                AppiumBy.id("com.google.android.calculator:id/result_final"))
                .getText();
        Assert.assertEquals(result, "5");
	}
	
	@Test
	public void multiply() {
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
		driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result = driver.findElement(
                AppiumBy.id("com.google.android.calculator:id/result_final"))
                .getText();
        Assert.assertEquals(result, "500");
	}
	
	@Test
	public void divide() {
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_0")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
        String result = driver.findElement(
                AppiumBy.id("com.google.android.calculator:id/result_final"))
                .getText();
        Assert.assertEquals(result, "25");
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
}







