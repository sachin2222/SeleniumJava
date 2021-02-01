package WebDriver.FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class SpiceJetTest {

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

    @Test(priority = 0)
    public void Depart_Arrival_Drop_Down_Test() {

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions.moveToElement(driver.findElement(By.cssSelector("a[value='HYD']"))).click().build().perform();


        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions.moveToElement(driver.findElement(By.cssSelector("a[value='GOI']"))).click().build().perform();
    }

    @Test(priority = 1)
    public void datePicker() {

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_view_date1\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[2]/td[4]/a")).click();// 10 feb

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_view_date2\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[3]/td[2]/a")).click();// 15 feb


    }

   @Test(priority = 2)
    public void setPassangers() {

        driver.findElement(By.xpath("//*[@id=\"divpaxinfo\"]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement adult=driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
        Select selectAdult=new Select(adult);
        selectAdult.selectByVisibleText("4");

        WebElement child=driver.findElement(By.id("ctl00_mainContent_ddl_Child"));
        Select selectChild=new Select(child);
        selectChild.selectByVisibleText("2");


    }

    @Test(priority = 3)
    public void SearchTest(){

        driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_btn_FindFlights\"]")).click();

    }

    // @AfterTest
    public void closeBrowser() throws InterruptedException {

        Thread.sleep(2000);
        driver.close();

    }


}
