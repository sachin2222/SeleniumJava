package WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Practiceproject {

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
    public void rahulShettyProject() {

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
        driver.navigate().back();

        driver.findElement(By.cssSelector("[id*='checkBoxOption1']")).click();
        driver.findElement(By.cssSelector("[id*='checkBoxOption2']")).click();
        driver.findElement(By.cssSelector("[id*='checkBoxOption3']")).click();

        WebElement selectBox = driver.findElement(By.cssSelector("[id*='dropdown-class-example']"));
        Select select = new Select(selectBox);
        select.selectByVisibleText("Option2");


    }

    @Test(enabled = false)
    public void Parent_Child_XPATH() {

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//header[@class='jumbotron text-center header_style']/div/a/button")).click();


    }

    @Test(enabled = false)
    public void text_XPATH() {

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//*[text()='Practice']")).click();


    }

    @Test
    public void complexTest1() {

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       WebElement practice= driver.findElement(By.xpath("//div[@style='text-align: right;margin-top: -30px;']/button[1]"));
       practice.click();
       System.out.println(practice.getText());


    }

    @AfterSuite
    public void closeBrowser() throws InterruptedException {

        Thread.sleep(5000);
        driver.close();

    }

}
