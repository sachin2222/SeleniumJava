package WebDriver.FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FilghtStatus {

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
        driver.get("https://book.spicejet.com/Search.aspx?op=3");
        actions = new Actions(driver);

    }

    @Test
    public void Flight_Search() {


        WebElement dep = driver.findElement(By.xpath("//*[@id=\"FlifoSearchInputSearchView_originStation\"]"));
        dep.click();
        Select select_dep = new Select(dep);
        select_dep.selectByValue("IXA");


        WebElement arrival = driver.findElement(By.xpath("//*[@id=\"FlifoSearchInputSearchView_destinationStation\"]"));
        arrival.click();
        Select select_arv = new Select(arrival);
        select_arv.selectByValue("IXB");

        WebElement date = driver.findElement(By.xpath("//*[@id=\"FlifoSearchInputSearchView_DropDownListFlightDate\"]"));
        date.click();
        Select select_date = new Select(date);
        select_date.selectByIndex(2);

        driver.findElement(By.xpath("//*[@id=\"FlifoSearchInputSearchView_ButtonSubmit\"]")).click();

        String current_url=driver.getCurrentUrl();
        Assert.assertEquals(current_url,"https://book.spicejet.com/FlightStatus.aspx");




    }

}
