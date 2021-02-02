package WebDriver.Assignment;

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
import java.util.List;

public class ClearTrip {


    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    Actions actions;

    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get("https://www.cleartrip.com/");
        actions = new Actions(driver);

    }

    @Test(priority = 1)
    public void selectDepartureCity() {
        driver.findElement(By.id("FromTag")).sendKeys("new");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Select Departure City
        List<WebElement> list = driver.findElements(By.xpath("//*[@role='presentation']"));

        for (WebElement ele : list) {
            if (ele.getText().contains("Delhi")) {
                ele.click();
            }

        }


    }

    @Test(priority = 2)
    public void selectArrivalCity() {

        //Select Arrival City
        driver.findElement(By.id("ToTag")).sendKeys("kol");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement kolkata = driver.findElement(By.xpath("//*[@id=\"ui-id-2\"]/li[2]/a"));
        kolkata.click();
    }

    @Test(priority = 3)
    public void select_date() {

        //Click on Calender
        driver.findElement(By.id("DepartDate")).click();
        //Select Current Date
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();


    }

    @Test(priority = 4)
    public void Choose_Adult() {
        //Select 4 Adults
        WebElement adults = driver.findElement(By.id("Adults"));
        Select selectA = new Select(adults);
        selectA.selectByValue("4");


    }

    @Test(priority = 5)
    public void Choose_Children() {
        //Select 2 Children
        WebElement childrens = driver.findElement(By.id("Childrens"));
        Select selectC = new Select(childrens);
        selectC.selectByValue("2");


    }

    @Test(priority = 6)
    public void clickLink() {

        //Click on Link
        driver.findElement(By.id("MoreOptionsLink")).click();
    }

    @Test(priority = 7)
    public void Enter_Preferred_Airline() {

        //Enter preferred airline name
        driver.findElement(By.id("AirlineAutocomplete")).sendKeys("Indigo");

    }

    @Test(priority = 8)
    public void clickOnSearch() {
        //Click on Search
        driver.findElement(By.id("SearchBtn")).click();

    }

    @Test(priority = 9)
    public void fetchDetails() {

        List<WebElement> AmountList = driver.findElements(By.cssSelector(".m-0.fs-5.fw-700.c-neutral-900.h-7"));
        List<WebElement> DepTime = driver.findElements(By.cssSelector(".ms-grid-column-1.ms-grid-row-1"));

        System.out.println("SIZE: " + AmountList.size());
        System.out.println("SIZE: " + DepTime.size());

        for(int i=0;i<AmountList.size();i++){

          String amount=AmountList.get(i).getText();
          String deptime=DepTime.get(i).getText();

          System.out.println(amount + ": " + deptime);

        }

    }




}
