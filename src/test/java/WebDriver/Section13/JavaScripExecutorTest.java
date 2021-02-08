package WebDriver.Section13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class JavaScripExecutorTest {


    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://www.rahulshettyacademy.com/AutomationPractice/";


    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get(URL);

    }

    @Test
    public void jsExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

        //Send keys by Js
        js.executeScript("document.getElementById('name').value='Hello'");
        //Click Button by js
        WebElement ele = driver.findElement(By.id("alertbtn"));
        js.executeScript("arguments[0].click()", ele);
        driver.switchTo().alert().accept();

        //Navigate other link
        //js.executeScript("window.location='https://www.guru99.com/'");

        //Genearate custom alert
        js.executeScript("alert('welcome to world')");
        driver.switchTo().alert().accept();

        //Js Script for click
        //js.executeScript("document.getElementById('opentab').click()");

        //js for selecting any drop-down Value
        js.executeScript("document.getElementById('dropdown-class-example').value='option3'");


    }
}
