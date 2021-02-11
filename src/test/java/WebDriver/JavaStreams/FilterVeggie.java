package WebDriver.JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;


public class FilterVeggie {


    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";

    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @Test
    public void regularExp() {

        String searchKey = "to";
        driver.findElement(By.id("search-field")).sendKeys(searchKey);
        List<WebElement> result = driver.findElements(By.xpath("//tr/td[1]"));

        for (int i = 0; i < result.size(); i++) {

            if (result.get(i).getText().contains(searchKey)) {
                System.out.println(result.get(i).getText());
                Assert.assertTrue(true);
            } else
                Assert.assertTrue(false);

        }


    }


    @Test
    public void javaStream() {

        String searchKey = "to";
        driver.findElement(By.id("search-field")).sendKeys(searchKey);
        List<WebElement> result = driver.findElements(By.xpath("//tr/td[1]"));

        result.stream().map(a->a.getText().contains(searchKey)).forEach(a->Assert.assertTrue(a));

    }



}
