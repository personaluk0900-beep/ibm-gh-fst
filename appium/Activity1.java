package Appium;

import java.net.URI;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {

    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android");

        // Launch installed Google Calculator
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");

        options.noReset();

        URL url = new URI("http://127.0.0.1:4723").toURL();

        driver = new AndroidDriver(url, options);
    }

    @Test
    public void multiplyTest() {

        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5")).click();

        driver.findElement(AppiumBy.accessibilityId("multiply")).click();

        driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_8")).click();

        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        String result = driver.findElement(
                AppiumBy.id("com.google.android.calculator:id/result_final"))
                .getText();

        Assert.assertEquals(result, "40");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}