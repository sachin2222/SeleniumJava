package WebDriver.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MultipleWindowsTest {


    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://the-internet.herokuapp.com/windows";
    WebDriverWait wait;


    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    @Test
    public void windowsTest() {

        driver.findElement(By.cssSelector("a[target='_blank']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);
        System.out.println(driver.findElement(By.cssSelector(".example")).getText());

        driver.switchTo().window(parentId);
        System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());


    }

}
