import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class noPerfectoTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.inpra.org/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Wait until the 'Donate' button is visible and clickable
            WebElement donateButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.linkText("Donate"))
            );

            System.out.println("Donate button found. Clicking it now");

            // Click the Donate button
            donateButton.click();

            // Wait until the URL changes to include 'donate'
            wait.until(ExpectedConditions.urlContains("donation-form"));

            System.out.println("Navigation to donation page successful. Current URL: " + driver.getCurrentUrl());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
