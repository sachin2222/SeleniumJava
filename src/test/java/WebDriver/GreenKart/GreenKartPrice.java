package WebDriver.GreenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class GreenKartPrice {

    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://rahulshettyacademy.com/seleniumPractise/#/";

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
    public void getVeggiePrice() {

        String[] vegetables = {"Brocolli", "Beetroot", "Raspberry"};
        List<WebElement> veggieNames = driver.findElements(By.cssSelector(".product-name"));

        for (int i = 0; i < veggieNames.size(); i++) {

            String[] name = veggieNames.get(i).getText().split("-");

            List vegetableList = Arrays.asList(vegetables);

            if (vegetableList.contains(name[0].trim())) {

                System.out.println(driver.findElements(By.cssSelector(".product-price")).get(i).getText());

            }
        }

    }
}

