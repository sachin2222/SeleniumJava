package Grid;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FireFoxTestCases {

    @Test
    public void firefoxTest() throws MalformedURLException {

        DesiredCapabilities dc=new DesiredCapabilities();
        dc.setBrowserName("firefox");
        dc.setPlatform(Platform.WINDOWS);
        dc.setAcceptInsecureCerts(true);

        WebDriver driver=new RemoteWebDriver(new URL("http://192.168.0.108:5567/wd/hub"),dc);
        driver.get("https://google.com");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("Firefox Browser Testing");

    }
}
