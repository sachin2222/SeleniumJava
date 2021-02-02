package WebDriver.GreenKart;

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

public class GreenKartEcommerceTest {


    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://rahulshettyacademy.com/seleniumPractise/#/";

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
    public void Add_Items_To_Cart() {
        List<WebElement> product_list = driver.findElements(By.cssSelector(".product-name"));
        List<WebElement> Button_list = driver.findElements(By.cssSelector(".product-action"));


        for (int i = 0; i < product_list.size(); i++) {

            if (product_list.get(i).getText().contains("Potato - 1 Kg")) {

                //Click on "+" 2 Times
                driver.findElement(By.cssSelector(".increment")).click();
                driver.findElement(By.cssSelector(".increment")).click();
                //Click on ADD TO CART
                Button_list.get(i).click();

            }
            if (product_list.get(i).getText().contains("Cauliflower - 1 Kg")) {

                //Click on "+" 2 Times
                driver.findElement(By.cssSelector(".increment")).click();
                driver.findElement(By.cssSelector(".increment")).click();
                //Click on ADD TO CART
                Button_list.get(i).click();

            }


        }
       //Proceed to CheckOUt
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//img[@alt='Cart']")).click();
        driver.findElement(By.cssSelector(".action-block")).click();

        //Enter promocode
        driver.findElement(By.cssSelector(".promoCode")).sendKeys("sachin");
        driver.findElement(By.cssSelector(".promoBtn")).click();

        //Place Order
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/button")).click();
        //Select Country
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Select selectCountry=new Select(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/select")));
        selectCountry.selectByIndex(3);
        //Select CheckBox
        driver.findElement(By.cssSelector(".chkAgree")).click();
        //Click Proceed
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/button")).click();

    }

}
