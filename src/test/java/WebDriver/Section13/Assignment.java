package WebDriver.Section13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class Assignment {


    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://www.rahulshettyacademy.com/AutomationPractice/";


    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get(URL);

    }

    @Test
    public void FetchTableData() {

        List<WebElement> Rows = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr"));
        int rows = Rows.size();
        System.out.println("No. of Rows: " + rows);


        List<WebElement> headers = driver.findElements(By.xpath("//table[@class='table-display']/tbody/tr[1]/th"));
        System.out.println("No. of cols: " + headers.size());

        //Print Rows-3 Data
        WebElement secondRowsData = driver.findElement(By.xpath("//table[@class='table-display']/tbody/tr[3]"));
        System.out.println(secondRowsData.getText());

    }

}
