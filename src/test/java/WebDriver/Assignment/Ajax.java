package WebDriver.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ajax {

    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://www.itgeared.com/demo/1506-ajax-loading.html";
    WebDriverWait wait;

    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @Test
    public void explicitWaitTest(){

        driver.findElement(By.xpath("//*[text()='Click to load get data via Ajax!']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("results"),"Process completed!"));

        System.out.println(driver.findElement(By.id("results")).getText());

    }
}
