package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LocatorTest {

    WebDriver driver;
    String URL="https://www.facebook.com/";
    String chrome_key="webdriver.chrome.driver";
    String chromeDriverPath="C:\\Users\\ss26370\\IdeaProjects\\SeleniumJava\\Drivers\\chromedriver.exe";

    @Test
    public void locator(){
        System.setProperty(chrome_key,chromeDriverPath);
        ChromeOptions options=new ChromeOptions();
        options.addArguments("start-maximized");

        driver=new ChromeDriver(options);
        driver.get(URL);

        driver.findElement(By.id("email")).sendKeys("sachin.vashishth007@gmail.com");

    }

}
