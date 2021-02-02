package WebDriver.Assignment;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment1 {

    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";


    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    }

    @Test
    public void checkboxTest() {

        List<WebElement> all=driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(all.size());

        for(WebElement checkbox:all){

            checkbox.click();
            Assert.assertTrue(checkbox.isSelected());

            checkbox.click();
            Assert.assertFalse(checkbox.isSelected());


        }


    }


}
