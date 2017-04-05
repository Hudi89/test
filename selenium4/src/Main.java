import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

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
            firstTest();
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

    //Run->Edit Configurations->Add selenium1-4 with respective .gradle project files, and build command
    //in C:\Users\<userprofile>\.gradle\gradle.properties -> org.gradle.java.home=C:/Program Files (x86)/Java/jdk1.8.0_121
    private static void firstTest()
    {
        driver.get("http://selenium.thinkcode.se/helloWorld");
        WebElement el = driver.findElement(By.id("headline"));
        assertEquals(el.getText(), "Hello, world!");

        driver.get("http://selenium.thinkcode.se/requestPassword");
        el = driver.findElement(By.id("account"));
        el.sendKeys("test");
        //el.sendKeys(Keys.RETURN);
        driver.findElement(By.name("submit")).click();

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation")));

        assertEquals(element.getText(), "A new password has been sent to test");

        driver.get("http://selenium.thinkcode.se/selectColor");
        driver.findElements(By.name("color")).get(1).click();
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("color")));

        assertEquals(element.getText(), "blue");

        driver.get("http://selenium.thinkcode.se/selectBeverage");
        driver.findElements(By.name("beverage")).get(0).click();
        assertEquals(driver.findElements(By.name("beverage")).get(0).getAttribute("value"), "coffee");

        driver.get("http://selenium.thinkcode.se/selectCondiment");
        new Select(driver.findElement(By.id("condiments"))).selectByVisibleText("Milk");
        assertEquals(driver.findElement(By.id("condiments")).getAttribute("value"), "milk");

        driver.get("http://selenium.thinkcode.se/exchangeRate");
        el = driver.findElement(By.id("from"));
        el.sendKeys("3");
        el = driver.findElement(By.id("to"));
        el.sendKeys("4");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("exchangeRate")));
        assertEquals(element.getText(), "The exchange rate from 3 to 4 is 2.07");

        driver.get("http://selenium.thinkcode.se/alert");
        driver.findElement(By.id("alert")).click();
        assertEquals(driver.switchTo().alert().getText(), "I am an Alert");
        driver.switchTo().alert().accept();
        driver.findElement(By.id("confirmation")).click();
        driver.switchTo().alert().dismiss();
        assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");

        driver.findElement(By.id("prompt")).click();
        driver.switchTo().alert().sendKeys("hello");
        driver.switchTo().alert().accept();
        assertEquals(driver.findElement(By.id("result")).getText(), "You entered: hello");

        driver.get("http://selenium.thinkcode.se/");
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        driver.findElement(By.xpath("//a[@href='newPopupPage']")).click();
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // switch to popup window
        // perform operations on popup

        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headline")));
        assertEquals(element.getText(), "Greetings from pop-up!");

        driver.close();
        driver.switchTo().window(parentWindowHandler);  // switch back to parent window

        driver.get("http://selenium.thinkcode.se/buyCurrency");
        driver.findElement(By.id("sell")).click();
        el = driver.findElement(By.id("amount"));
        el.sendKeys("4");
        new Select(driver.findElement(By.id("fromCurrency"))).selectByVisibleText("EUR");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        assertEquals(element.getText(), "Buying 4 USD will cost you 0 EUR.");
    }

}