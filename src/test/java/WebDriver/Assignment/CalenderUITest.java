package WebDriver.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CalenderUITest {

    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    Actions actions;

    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.spicejet.com/");
        actions = new Actions(driver);

    }


    @Test
    public void selectCurrentdate() {
        //Select Roundtrip
        driver.findElement(By.xpath("//*[@value='RoundTrip']")).click();
        //Click on Calender
        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        //Select current Date for Departure
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active.ui-state-hover")).click();

        //Check the return Calender Enabled
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {

            Assert.assertTrue(true);

        } else {
            Assert.assertTrue(false);
        }

        //Click on Return Calender
        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_view_date2\"]")).click();
       //Select current Date
       driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[1]/td[2]/a")).click();

    }

}
