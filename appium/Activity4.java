package Appium;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android");

        // Google Contacts
        options.setAppPackage("com.google.android.contacts");
        options.setAppActivity("com.android.contacts.activities.PeopleActivity");

        options.noReset();

        URL serverURL = new URI("http://127.0.0.1:4723").toURL();

        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void contactsTest() {

        // Defensive: dismiss common first-run dialogs if present
        // (permission prompts, account picker, "skip" screens, etc.)
        dismissDialogIfPresent("Allow", 3);
        dismissDialogIfPresent("ALLOW", 3);
        dismissDialogIfPresent("Skip", 3);
        dismissDialogIfPresent("SKIP", 3);
        dismissDialogIfPresent("No thanks", 3);
        dismissDialogIfPresent("Got it", 3);

        // Click Create Contact
        WebElement createContactButton = waitForClickableWithDiagnostics(
                AppiumBy.accessibilityId("Create new contact"),
                "Create new contact FAB"
        );
        createContactButton.click();

        // Enter First Name
        WebElement firstNameField = waitForVisibleWithDiagnostics(
                AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View"),
                "First name field"
        );
        firstNameField.sendKeys("Aaditya");

        // Enter Last Name
        WebElement lastNameField = waitForVisibleWithDiagnostics(
                AppiumBy.xpath("//android.widget.EditText[@text=\"Last name\"]"),
                "Last name field"
        );
        lastNameField.sendKeys("Varma");

        // Enter Phone Number
        WebElement phoneField = waitForVisibleWithDiagnostics(
                AppiumBy.xpath("//android.widget.EditText[@text=\"+1\"]/android.view.View[2]"),
                "Phone number field"
        );
        phoneField.sendKeys("999148292");

        // Save Contact
        WebElement saveButton = waitForClickableWithDiagnostics(
                AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.Button"),
                "Save button"
        );
        saveButton.click();

        // Verify Contact Name
        WebElement contactNameElement = waitForVisibleWithDiagnostics(
                AppiumBy.id("com.google.android.contacts:id/large_title"),
                "Saved contact title"
        );

        String contactName = contactNameElement.getText();

        Assert.assertEquals(contactName, "Aaditya Varma");
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

    // ---------- Helper methods ----------

    /**
     * Attempts to dismiss a dialog/button with the given text if it appears
     * within the given timeout. Silently continues if not present.
     */
    private void dismissDialogIfPresent(String buttonText, int timeoutSeconds) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            shortWait.until(ExpectedConditions.elementToBeClickable(
                    AppiumBy.xpath("//*[@text='" + buttonText + "']"))).click();
            System.out.println("Dismissed dialog with button: " + buttonText);
        } catch (TimeoutException ignored) {
            // Dialog not present, safe to continue
        }
    }

    /**
     * Waits for an element to be clickable. On failure, dumps the page source
     * and a screenshot to help diagnose why the element wasn't found, then
     * rethrows the original exception.
     */
    private WebElement waitForClickableWithDiagnostics(org.openqa.selenium.By locator, String description) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            captureDiagnostics(description);
            throw e;
        }
    }

    /**
     * Waits for an element to be visible. On failure, dumps the page source
     * and a screenshot to help diagnose why the element wasn't found, then
     * rethrows the original exception.
     */
    private WebElement waitForVisibleWithDiagnostics(org.openqa.selenium.By locator, String description) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            captureDiagnostics(description);
            throw e;
        }
    }

    /**
     * Prints the current page source and saves a screenshot to help debug
     * why an expected element wasn't found on screen.
     */
    private void captureDiagnostics(String description) {
        System.out.println("=== Failure while waiting for: " + description + " ===");
        try {
            System.out.println(driver.getPageSource());
        } catch (Exception e) {
            System.out.println("Could not capture page source: " + e.getMessage());
        }
        try {
            File screenshot = driver.getScreenshotAs(OutputType.FILE);
            String fileName = "failure_" + description.replaceAll("\\s+", "_") + ".png";
            FileUtils.copyFile(screenshot, new File(fileName));
            System.out.println("Screenshot saved to: " + fileName);
        } catch (Exception e) {
            System.out.println("Could not capture screenshot: " + e.getMessage());
        }
    }
}