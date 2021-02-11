package RelativeLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class MultipleWindows {


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
    public void multplewindows() {
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> s = driver.getWindowHandles();
        Iterator<String> it = s.iterator();
        String p_id = it.next();
        String c_id = it.next();

        driver.switchTo().window(c_id);
        driver.get("https://rahulshettyacademy.com/");

        String text = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        System.out.println(text);


    }
}
