import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_7 {
	public static void main(String args[]) {
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/dynamic-controls");
	    WebElement textbox = driver.findElement(By.id("textInput"));
		
		System.out.println("Input field is enabled: " + textbox.isEnabled());
        // Click the toggle button to enable it
        driver.findElement(By.id("textInputButton")).click();
        // Check if the text field is enabled
        System.out.println("Input field is enabled: " + textbox.isEnabled());
        
        // Type something in to it
        textbox.sendKeys("Example text");
        System.out.println(textbox.getDomProperty("value"));
        
        driver.quit();
	}

}
