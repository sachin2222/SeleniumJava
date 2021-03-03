package Grid;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTestCases {


    @Test
    public void ChromeTest() throws MalformedURLException {

        DesiredCapabilities dc=new DesiredCapabilities();
        dc.setBrowserName("chrome");
        dc.setPlatform(Platform.WINDOWS);

        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.108:5566/wd/hub"),dc);
        driver.manage().window().maximize();
        driver.get("https://google.com");

        driver.findElement(By.name("q")).sendKeys("Chrome Browser Testing");


    }
}
