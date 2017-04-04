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
            requestPasswordTest("Hudi");
            requestPasswordTest("Other");
        } catch(Exception e) {
            fail(e.getMessage());
        } finally {
            driver.close();
        }
    }

    private static void requestPasswordTest(String username) {
        driver.get("http://selenium.thinkcode.se/requestPassword");

        driver.findElement(By.id("account")).sendKeys(username);
        driver.findElement(By.xpath("//form[@id='conversion']//input[@name='submit']")).click();

        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver) {
                System.out.println("Searching ...");
                return webDriver.findElement(By.id("confirmation")) != null;
            }
        });

        assertTrue(driver.findElement(By.id("confirmation")).getText().contains("A new password has been sent to "+username));
    }
}