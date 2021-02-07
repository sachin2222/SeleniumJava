package WebDriver.GreenKart;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ScreenShotGreenKart {

    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://www.aakash.ac.in/";
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

     @Test
    public void getScreenShotAll() throws IOException {

        List<WebElement> Images = driver.findElements(By.cssSelector(".product-image"));
        for (int i = 0; i < Images.size(); i++) {

            File src = Images.get(i).getScreenshotAs(OutputType.FILE);
            String[] VegName = driver.findElements(By.cssSelector(".product-name")).get(i).getText().split("-");
            String veg = VegName[0].trim();

            String formatedPath = String.format(".\\ScreenShots\\%s.png", veg);
            File dest = new File(formatedPath);
            FileHandler.copy(src, dest);

        }

    }

    //@Test
    public void akash() throws IOException {

        List<WebElement> Images = driver.findElements(By.tagName("img"));
        for (int i = 0; i < Images.size(); i++) {

            File src = Images.get(i).getScreenshotAs(OutputType.FILE);
            String name = Images.get(i).getAttribute("alt");

            String formatedPath = String.format(".\\Akash\\%s.png", name);
            File dest = new File(formatedPath);
            FileHandler.copy(src, dest);

        }

    }

}