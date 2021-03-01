package WebDriver.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

public class BasicAuthentication {

    @Test
    public void basicAuthenticationTest() {
     /*   System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");*/

        System.out.println(System.getProperty("user.dir"));


    }

    @Test
    public void downloadTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

        String downloadPath=System.getProperty("user.dir") + "\\Downloads";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);

        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/download");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.linkText("logo.png")).click();
        Thread.sleep(2000);
        File f = new File(downloadPath+"/logo.png");
        Assert.assertTrue(f.exists());
        Assert.assertTrue(f.delete());


    }
}
