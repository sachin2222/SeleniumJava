package WebDriver.Links;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LinksTest {


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
    public void linksTest() {

        WebElement firstrow = driver.findElement(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td[1]"));
        List<WebElement> f_links = firstrow.findElements(By.cssSelector("a"));
        System.out.println(f_links.size());
        for (WebElement f : f_links) {

            //actions.keyDown(Keys.CONTROL).click(f).build().perform();
            f.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));


        }
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        while (it.hasNext()) {

            String id = it.next();
            driver.switchTo().window(id);
            System.out.println(driver.getTitle());

        }


    }


}
