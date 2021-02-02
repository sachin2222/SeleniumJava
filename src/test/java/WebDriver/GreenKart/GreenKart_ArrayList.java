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

public class GreenKart_ArrayList {


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
    public void add_Vegetables() {

        String vegetables[] = {"Water Melon", "Nuts Mixture","Beetroot"};
        List<WebElement> product_list = driver.findElements(By.cssSelector(".product-name"));
        int count = 1;

        for (int i = 0; i < product_list.size(); i++) {

            String[] veg_name = product_list.get(i).getText().split("-");
            List vegetable_list = Arrays.asList(vegetables);

            if (vegetable_list.contains(veg_name[0].trim())) {

                //Click on "+" 4 times
                while (count < 5) {
                    driver.findElements(By.cssSelector(".increment")).get(i).click();
                    count++;
                }

                //Click on ADD TO CART
                driver.findElements(By.cssSelector(".product-action")).get(i).click();

            }


        }


    }

}
