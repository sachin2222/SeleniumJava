package WebDriver.GreenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class GreenKartSearchTest {

    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://rahulshettyacademy.com/seleniumPractise/#/";
    int index = 0;

    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get(URL);

    }

    @Test(dataProvider = "SearchData")
    public void SearchTest(String[] text) throws InterruptedException {

        driver.findElement(By.cssSelector("input.search-keyword")).sendKeys(text);

        Thread.sleep(2000);
        List<WebElement> searchList = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < searchList.size(); i++) {

            String vegname = searchList.get(i).getText();
            System.out.println(vegname);


        }

        driver.findElement(By.cssSelector("input.search-keyword")).clear();

    }

    @DataProvider(name = "SearchData")
    public Object[] getData() {

        return new String[]{"po", "ba", "br", "pump"};

    }

}
