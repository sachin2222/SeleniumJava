package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LocatorTest {

    WebDriver driver;
    String URL = "https://www.facebook.com/";
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = "C:\\Users\\ss26370\\IdeaProjects\\SeleniumJava\\Drivers\\chromedriver.exe";

    // @Test
    public void locator() throws InterruptedException {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.get(URL);


      /*  List<WebElement> ele = driver.findElements(By.tagName("a"));

        for (WebElement e : ele) {
           System.out.println(e.getAttribute("id"));

        }

*/

        driver.findElement(By.id("email")).sendKeys("hello");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.findElement(By.linkText("Forgotten password?")).click();
        driver.findElement(By.name("pass")).sendKeys("1223");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.findElement(By.className("_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy")).click();//Error on using compound classes

        // driver.findElement(By.xpath("//*[@id=\"u_0_f\"]")).click();
        // driver.findElement(By.xpath("//*[@id=loginbutton]")).click();


        driver.findElement(By.cssSelector("#loginbutton")).click();


    }

     @Test
    public void cssSelector() {

        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(By.cssSelector("#txtUsername")).sendKeys("Admin");
        driver.findElement(By.cssSelector("#txtPassword")).sendKeys("admin1234");
        driver.findElement(By.cssSelector("#btnLogin")).click();

        System.out.println("Text value: " + driver.findElement(By.cssSelector("#spanMessage")).getText());


    }

   // @Test
    public void cssSelectorFB() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.get(URL);

        driver.findElement(By.cssSelector("#email")).sendKeys("Admin");
        driver.findElement(By.cssSelector("#pass")).sendKeys("admin123");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.findElement(By.id("loginbutton")).click();

        //driver.findElement(By.xpath("//*[@id='loginbutton']")).click();

        driver.findElement(By.name("login")).click();// it works

        // driver.findElement(By.cssSelector("button#loginbutton")).click();

    }
}
