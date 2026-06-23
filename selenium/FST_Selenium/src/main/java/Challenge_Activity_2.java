import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Challenge_Activity_2 {
    public static void main(String[] args) throws Exception {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.amazon.in");

        Thread.sleep(5000);

        driver.findElement(By.name("field-keywords"))
              .sendKeys("iPhone 17 Pro");

        driver.findElement(By.id("nav-search-submit-button"))
              .click();

        Thread.sleep(5000);

        List<WebElement> products = driver.findElements(
            By.xpath("//div[@data-component-type='s-search-result']")
        );

        if (products.size() >= 4) {

            WebElement fourthProduct = products.get(3);

            String productName = fourthProduct.findElement(
                By.xpath(".//h2/span")
            ).getText();

            String price = fourthProduct.findElement(
                By.xpath(".//span[@class='a-price-whole']")
            ).getText();

            System.out.println("4th Product: " + productName);
            System.out.println("Price: ₹" + price);

        } else {
            System.out.println("Less than 4 products found.");
        }

        driver.quit();
    }
}