package WebDriver.GreenKart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ExplicitWaitTest {

    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://rahulshettyacademy.com/seleniumPractise/#/";
    WebDriverWait wait;

    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @Test
    public void waitTest() {

        List<WebElement> veggies = driver.findElements(By.cssSelector(".product-name"));
        for (int i = 0; i < veggies.size(); i++) {

            if (veggies.get(i).getText().contains("Brocolli")) {

                driver.findElements(By.cssSelector(".product-action")).get(i).click();

            }

        }
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        //Explicitly wait
        wait.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/seleniumPractise/#/cart"));
        driver.findElement(By.cssSelector(".promoCode")).sendKeys("sachin");
        driver.findElement(By.cssSelector(".promoBtn")).click();

        WebElement info = driver.findElement(By.cssSelector(".promoInfo"));
        System.out.println(info.getText());


    }

}
