import static org.junit.Assert.*;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class Main {
    static WebDriver driver;
    static Wait<WebDriver> wait;

    @Test
    public void mainTest() {
        System.setProperty("webdriver.chrome.driver", "c:/Users/hupqaai/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);


        boolean result;
        try {
            googleCalculatorTest("3 + 2","5");
            googleCalculatorTest("3 * 2","6");
            googleCalculatorTest("12 + 12","24");
        } catch(Exception e) {
            fail(e.getMessage());
        } finally {
            driver.close();
        }
    }

    private static void googleCalculatorTest(String expression, String expected) {
        driver.get("http://google.com");
        WebElement searchBarElement = driver.findElement(By.id("lst-ib"));
        searchBarElement.sendKeys(expression);
        searchBarElement.sendKeys(Keys.RETURN);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cwos")));

        assertEquals(element.getText(),expected);
    }
}