package WebDriver.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class AssigmentCheckBox {


    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://www.rahulshettyacademy.com/AutomationPractice/";
    WebDriverWait wait;
    Actions actions;


    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);

    }

    @Test
    public void assignment() {
        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkBoxOption1"));
        checkbox1.click();
        String value = driver.findElement(By.cssSelector("label[for='bmw']")).getText();
        System.out.println(value);

        Select select = new Select(driver.findElement(By.id("dropdown-class-example")));
        select.selectByVisibleText(value);

        driver.findElement(By.id("name")).sendKeys(value);
        driver.findElement(By.id("alertbtn")).click();
        String alertText = driver.switchTo().alert().getText();

        Assert.assertTrue(alertText.contains(value));


    }


}
