import static org.junit.Assert.*;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    @Test
    public void mainTest() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 30);


        boolean result;
        try {
            assertTrue(requestPasswordTest("Hudi"));
            assertTrue(requestPasswordTest("Other"));
        } catch(Exception e) {
            fail(e.getMessage());
        } finally {
            driver.close();
        }
    }

    private static boolean requestPasswordTest(String username) {
        driver.get("http://selenium.thinkcode.se/requestPassword");
        //type search query
        driver.findElement(By.id("account")).sendKeys(username);

        // click search
        driver.findElement(By.xpath("//form[@id='conversion']//input[@name='submit']")).click();

        // Wait for search to complete
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                System.out.println("Searching ...");
                return webDriver.findElement(By.id("confirmation")) != null;
            }
        });

        // Look for QAAutomation.net in the results
        return driver.findElement(By.id("confirmation")).getText().contains("A new password has been sent to "+username);
    }
}