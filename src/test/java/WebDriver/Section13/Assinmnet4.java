package WebDriver.Section13;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Assinmnet4 {

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @Test
    public void dynamicDropDown() {

        Actions actions = new Actions(driver);

        driver.findElement(By.id("autocomplete")).sendKeys("Ind");

        List<WebElement> countries = driver.findElements(By.cssSelector(".ui-menu-item"));
        System.out.println(countries.size());

        for (int i = 0; i < countries.size(); i++) {

            if (countries.get(i).getText().equals("India")) {

                countries.get(i).click();
                break;

            }


        }
        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

        driver.findElement(By.id("name")).sendKeys("sachin");
        System.out.println(driver.findElement(By.id("name")).getAttribute("value"));


    }

    //@Test
    public void dropDown() {

        driver.findElement(By.id("autocomplete")).sendKeys("Ind");
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);


    }


}
