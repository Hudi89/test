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

    @Test
    public void mainTest() {
        System.setProperty("webdriver.chrome.driver", "c:/Users/hupqaai/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://selenium.thinkcode.se/helloWorld");


        boolean result;
        try {
            assertTrue(driver.findElement(By.id("headline")).getText().contains("Hello, worldasd!"));
        } catch(Exception e) {
            fail(e.getMessage());
        } finally {
            driver.close();
        }

    }
}