package WebDriver.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CalenderUI {

    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://www.spicejet.com/";
    Actions actions;


    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions = new Actions(driver);
    }


    @Test
    public void CalenderUITest() {
       driver.findElement(By.id("ctl00_mainContent_view_date1")).click();

        int count = 0;
        while (count<2) {

            actions.moveToElement(driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e"))).click().build().perform();
            count++;

        }
        List<WebElement> dates = driver.findElements(By.cssSelector("td[data-handler='selectDay']"));

        for (int i = 0; i < dates.size(); i++) {

            WebElement date = dates.get(i);
            if (date.getAttribute("data-month").equals("4") && date.getText().equals("10") && date.getAttribute("data-year").equals("2021")) {
                date.click();
                break;

            }

        }


    }


}