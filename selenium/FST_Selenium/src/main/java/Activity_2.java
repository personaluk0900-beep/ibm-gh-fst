import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity_2 {
    public static void main(String args[]) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/webelements/login-form/");

        System.out.println("Page title is: " + driver.getTitle());
        
        driver.findElement(By.id("username")).sendKeys("admin");
        
        driver.findElement(By.id("password")).sendKeys("password");
        
        driver.findElement(By.xpath("//button[text()='Submit']")).click();  
        
        String message = driver.findElement(By.tagName("h1")).getText();
        System.out.println(message);
        
        String message2=driver.findElement(By.tagName("h2")).getText();
        System.out.println(message2);
        
        driver.quit();
    }
}