package RelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

import java.time.Duration;

public class RelLocators {


    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://rahulshettyacademy.com/angularpractice/";

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
    public void RelLocatorsTest() {

        WebElement ele = driver.findElement(By.cssSelector("input[name='name']"));
        String label = driver.findElement(withTagName("label").above(ele)).getText();
        System.out.println(label);

        WebElement a=driver.findElement(By.cssSelector("form.ng-untouched.ng-pristine.ng-invalid div:nth-child(2)"));
        System.out.println(a.getText());

        driver.findElement(By.cssSelector(".form-group input[name='email']")).sendKeys("Hello");




    }


}
