package WebDriver.FlightBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FlightBooking {

    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";

    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

    }

    @Test(enabled = false)
    public void staticDropDown() {

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement dropdownn = driver.findElement(By.cssSelector("select[id=ctl00_mainContent_DropDownListCurrency]"));

        Select select = new Select(dropdownn);
        select.selectByVisibleText("AED");

        System.out.println(select.getFirstSelectedOption().getText());


    }

    @Test(enabled = false)
    public void dynamicDropDown1() {

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.xpath("//input[contains(@id,'ctl00_mainContent_ddl_originStation1_CTXT')]")).click();
        WebElement gop = driver.findElement(By.xpath("//a[contains(@value,'GOP')]"));
        gop.click();

        System.out.println(gop.getText());

        WebElement JLR = driver.findElement(By.xpath("//a[contains(@value,'JLR')]"));
        gop.click();

        System.out.println(JLR.getText());

        WebElement IXM = driver.findElement(By.xpath("//a[contains(@value,'IXM')]"));
        gop.click();

        System.out.println(IXM.getText());


    }

    @Test(enabled = false)
    public void dynamicDropDown2() {

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.xpath("//div[contains(@id,'divpaxinfo')]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //3 Times click on "+"

        int i = 1;
        while (i <= 3) {
            driver.findElement(By.xpath("//span[contains(@id,'hrefIncAdt')]")).click();
            i++;

        }
        //Click on "-"
        driver.findElement(By.xpath("//span[contains(@id,'hrefDecAdt')]")).click();
        //Click on Done
        driver.findElement(By.xpath("//input[contains(@id,'btnclosepaxoption')]")).click();

    }


    @Test
    public void autoSuggestiveDropdown() {

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement country = driver.findElement(By.xpath("//input[contains(@id,'autosuggest')]"));
        country.sendKeys("ind");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> drop_list = driver.findElements(By.className("ui-menu-item"));
        for (WebElement ele : drop_list) {

            if (ele.getText().equalsIgnoreCase("India")) {

                ele.click();
                break;
            }

        }


    }

    @AfterSuite
    public void closeBrowser() {

        //driver.quit();

    }


}
