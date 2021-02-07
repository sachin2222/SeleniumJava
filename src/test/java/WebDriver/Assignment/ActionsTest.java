package WebDriver.Assignment;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class ActionsTest {

    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://rahulshettyacademy.com/AutomationPractice/";
    WebDriverWait wait;


    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get(URL);
        wait=new WebDriverWait(driver,Duration.ofSeconds(15));


    }


    // @Test
    public void handleChildTab() {

        driver.findElement(By.id("opentab")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);
        driver.findElement(By.cssSelector("a.theme-btn.register-btn")).click();
        driver.switchTo().window(parentId);
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();


    }

     @Test
    public void handleChildWindows() {

        driver.findElement(By.id("openwindow")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();
        String parentId = it.next();
        String childId = it.next();

        driver.switchTo().window(childId);
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='homepage']/div[4]/div[2]/div/div/div/span/div/div[7]/div/div/div[2]")));
        driver.findElement(By.xpath("//*[@id='homepage']/div[4]/div[2]/div/div/div/span/div/div[7]/div/div/div[2]")).click();

        driver.findElement(By.cssSelector(".fa.fa-lock.fa-lg")).click();


    }


}
