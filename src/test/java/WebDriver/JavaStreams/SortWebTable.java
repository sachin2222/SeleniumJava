package WebDriver.JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SortWebTable {


    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";

    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @Test
    public void sortTable() {

        driver.findElement(By.cssSelector("th[role='columnheader']")).click();

        WebElement veggies = driver.findElement(By.cssSelector(".table.table-bordered"));
        List<WebElement> rows = veggies.findElements(By.xpath("//tr/td[1]"));
        System.out.println(rows.size());

        List<String> originalList = rows.stream().map(s -> s.getText()).collect(Collectors.toList());
        System.out.println(originalList);

        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        Assert.assertTrue(originalList.equals(sortedList));


    }

    @Test
    public void getPrice() {

        driver.findElement(By.cssSelector("th[role='columnheader']")).click();

        WebElement veggies = driver.findElement(By.cssSelector(".table.table-bordered"));
        List<WebElement> rows = veggies.findElements(By.xpath("//tr/td[1]"));
        System.out.println(rows.size());

        List<String> price = rows.stream().filter(s -> s.getText().contains("Apple")).map(s -> getVeggiePrice(s)).collect(Collectors.toList());
        price.forEach(s -> System.out.println(s));


    }

    private static String getVeggiePrice(WebElement s) {

        return s.findElement(By.xpath("following-sibling::td[1]")).getText();

    }


}
