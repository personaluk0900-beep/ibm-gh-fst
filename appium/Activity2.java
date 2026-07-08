package Appium;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {

    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Set the Appium server URL
        URL serverURL = new URI("http://localhost:4723").toURL();

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);

        // Explicit wait, reused across the test
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open the page in Chrome
        driver.get("https://training-support.net");
    }

    // Test method
    @Test
    public void chromeTest() {
        // Wait for the homepage heading to be visible, then read it
        WebElement homeHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")
        ));
        System.out.println("Heading: " + homeHeading.getText());

        // Wait for the About Us link to be clickable, then click it
        WebElement aboutUsLink = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.accessibilityId("About Us")
        ));
        aboutUsLink.click();

        // Wait for the old heading element to become stale (page has transitioned)
        wait.until(ExpectedConditions.stalenessOf(homeHeading));

        // Now wait for the new page's heading to appear, then read it
        WebElement aboutHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//android.widget.TextView[@text='About Us']")
        ));
        System.out.println("About Page Heading: " + aboutHeading.getText());
    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}