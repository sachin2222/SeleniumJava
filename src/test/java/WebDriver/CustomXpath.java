package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CustomXpath {

    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = "C:\\Users\\ss26370\\IdeaProjects\\SeleniumJava\\Drivers\\chromedriver.exe";

    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

    }

    @Test(enabled = false)
    public void custom_XPATH() throws InterruptedException {

        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("hello");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("hello");
        //driver.findElement(By.xpath("//button[@name='login']")).click();
        driver.findElement(By.xpath("//*[@value='1']")).click();

    }

    @Test(enabled = false)
    public void custom_CSS() {

        //Alternative ways to define the custom CSS .
        driver.get("https://www.facebook.com/");
        // driver.findElement(By.cssSelector("#email")).sendKeys("#email");
        //  driver.findElement(By.cssSelector("input#email")).sendKeys("input#email");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("input[name='email']");// Standard way of defining custome CSS.


    }

    @Test(enabled = false)
    public void regular_Expression_Dynamic_XPATH() {

        driver.get("https://www.facebook.com/");
        //standard Expression for Handling the Dynamic Xpath Values
        driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys("DynamicXpath");
        driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys("DynamicXpath");
        driver.findElement(By.xpath("//input[contains(@id,'u_0')]")).click();

    }

    @Test(enabled =false)
    public void regular_Expression_Dynamic_CSS() {

        driver.get("https://www.facebook.com/");
        //standard Expression for Handling the Dynamic CSS Values
        driver.findElement(By.cssSelector("[id*='email']")).sendKeys("HELLO");
        driver.findElement(By.cssSelector("[id*='pass']")).sendKeys("HELLO");
        driver.findElement(By.cssSelector("[id*='u_0']")).click();

    }


    @Test(enabled = false)
    public void regular_exp_Test()
    {

        driver.get("https://www.rediff.com/");
        driver.findElement(By.cssSelector("a[title*='Sign in']")).click();


        driver.findElement(By.cssSelector("input[id*='login1']")).sendKeys("hello");
        driver.findElement(By.cssSelector("input[name*='passwd']")).sendKeys("hello");

        driver.findElement(By.cssSelector("input[name*='proceed']")).click();


    }

    @Test
    public void regular_exp_Test_for_xpath()
    {

        driver.get("https://www.rediff.com/");

        driver.findElement(By.xpath("//a[contains(@title,'Sign in')]")).click();

        driver.findElement(By.xpath("//input[contains(@id,'login')]")).sendKeys("Hello");
        driver.findElement(By.xpath("//input[contains(@id,'password')]")).sendKeys("Hello");
        driver.findElement(By.xpath("//input[contains(@name,'proceed')]")).click();



    }



    @AfterTest
    public void closeBrowser() throws InterruptedException {

        Thread.sleep(5000);
        driver.close();

    }

}