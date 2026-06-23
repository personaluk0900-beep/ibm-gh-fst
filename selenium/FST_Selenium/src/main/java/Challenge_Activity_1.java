import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Challenge_Activity_1 {
    public static void main(String args[]) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.google.com");

        System.out.println("Page title is: " + driver.getTitle());

        WebElement searchButton = driver.findElement(By.name("btnK"));

        System.out.println("ID: " + searchButton.getAttribute("id"));
        System.out.println("Class: " + searchButton.getAttribute("class"));
        System.out.println("Name: " + searchButton.getAttribute("name"));
        System.out.println("Type: " + searchButton.getAttribute("type"));
        System.out.println("Jsname: " + searchButton.getAttribute("jsname"));

        driver.quit();
    }
}