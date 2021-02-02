package WebDriver.Assignment;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class ScreenShot {


    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    Actions actions;

    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


    }

    @Test
    public void TakeScreenShot() throws IOException {

        WebElement logo = driver.findElement(By.cssSelector(".logoClass"));
        TakesScreenshot t1 = (TakesScreenshot) logo;
        File logosrc = t1.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(logosrc, new File(".\\Files\\logo.jpg"));

        TakesScreenshot t = (TakesScreenshot) driver;
        File webPageScr = t.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(webPageScr, new File(".\\Files\\automation.jpg"));

    }

}
