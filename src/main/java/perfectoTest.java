import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import java.net.URL;

public class perfectoTest {
    public static void main(String[] args) {
        try {
            // Define Perfecto cloud URL and credentials
            String cloudName = "demo"; // For demo.perfectomobile.com
            String username = "lentzml123@gmail.com";
            String password = "eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI4YmI4YmZmZS1kMzBjLTQ2MjctYmMxMS0zNTYyMmY1ZDkyMGYifQ.eyJpYXQiOjE3NDgzMjE5MTIsImp0aSI6IjhiM2FkYzAxLThkZjItNDA0Yy1iZTg1LThkYTk2YzhmZTIxNCIsImlzcyI6Imh0dHBzOi8vYXV0aC5wZXJmZWN0b21vYmlsZS5jb20vYXV0aC9yZWFsbXMvZGVtby1wZXJmZWN0b21vYmlsZS1jb20iLCJhdWQiOiJodHRwczovL2F1dGgucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL2RlbW8tcGVyZmVjdG9tb2JpbGUtY29tIiwic3ViIjoiZjU4YzYwZGMtM2UwZi00ODQ4LWJkOWYtNDhiMWM2NDcxNzRkIiwidHlwIjoiT2ZmbGluZSIsImF6cCI6Im9mZmxpbmUtdG9rZW4tZ2VuZXJhdG9yIiwibm9uY2UiOiI1Y2MxYTQ4My0wNjUzLTRkM2MtOGIwNi1lZWY3OTA0NTI4MzUiLCJzZXNzaW9uX3N0YXRlIjoiN2QzOWRmZTMtZWExMy00M2Y5LWI2YmQtZjg3ZTQ1ZGI3ZTQ4Iiwic2NvcGUiOiJvcGVuaWQgb2ZmbGluZV9hY2Nlc3MiLCJzaWQiOiI3ZDM5ZGZlMy1lYTEzLTQzZjktYjZiZC1mODdlNDVkYjdlNDgifQ.AGHU80iehwVP15-ADzBAoGsMpySvRwkpbjpmGPzCZMc";
            String cloudUrl = "https://" + cloudName + ".perfectomobile.com/nexperience/perfectomobile/wd/hub";

            // Base capabilities
            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("platformName", "Windows");

            // Use W3C-compliant Perfecto options
            MutableCapabilities perfectoOptions = new MutableCapabilities();
            perfectoOptions.setCapability("securityToken", password);
            perfectoOptions.setCapability("platformVersion", "11");
            perfectoOptions.setCapability("location", "US East");
            perfectoOptions.setCapability("scriptName", "Perfecto Free Trial Test");
            perfectoOptions.setCapability("user", username);

            // Attach Perfecto options
            capabilities.setCapability("perfecto:options", perfectoOptions);

            // Launch remote driver
            WebDriver driver = new RemoteWebDriver(new URL(cloudUrl), capabilities);

            // Navigate to Perfecto
/*            driver.get("https://www.perfecto.io/");

            // Find and verify the "Free Trial" button
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.titleContains("Perfecto"));
            WebElement freeTrialBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/free-trial']")));

            freeTrialBtn.click();

            if (freeTrialBtn.isDisplayed()) {
                System.out.println("'Free Trial' button is visible.");
                freeTrialBtn.click();
                System.out.println("Clicked on 'Free Trial' button.");
            } else {
                System.out.println("'Free Trial' button is NOT visible.");
            }*/

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

            // Quit the session
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
