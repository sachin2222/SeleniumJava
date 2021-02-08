package WebDriver.Section13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable {


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
    public void fetchWebTable() {

       //List<WebElement> tabledata = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
       List<WebElement> tabledata = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

        int sum=0;

        for(int i=0;i<tabledata.size();i++){

         int value=   Integer.parseInt(tabledata.get(i).getText());
         sum=sum+value;

        }
        System.out.println(sum);

    }

}