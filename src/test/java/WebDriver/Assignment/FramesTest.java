package WebDriver.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesTest {

    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://the-internet.herokuapp.com/nested_frames";
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
    public void nestedFramesTest() {

        WebElement frame_top = driver.findElement(By.cssSelector("frame[name='frame-top']"));
        driver.switchTo().frame(frame_top);
        WebElement frame_middle = driver.findElement(By.xpath("/html/frameset/frame[2]"));
        driver.switchTo().frame(frame_middle);
        System.out.println(driver.findElement(By.id("content")).getText());

    }


}
