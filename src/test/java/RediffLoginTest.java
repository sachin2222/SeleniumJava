import RediffObjectRepositories.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RediffLoginTest {


    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = "C:\\Users\\ss26370\\IdeaProjects\\SeleniumJava\\Drivers\\chromedriver.exe";
    LoginPage loginPage;

    @BeforeSuite
    public void launchChrome() {
        System.setProperty(chrome_key, chromeDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


    //@Test
    public void loginTest() {
        loginPage = new LoginPage(driver);
        loginPage.username().sendKeys("sachin");
        loginPage.password().sendKeys("1234");
        loginPage.signIn().click();


    }

    @Test
    public void getLinks() {
        loginPage = new LoginPage(driver);
        List<WebElement> links = loginPage.getLinks();

        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());
        }


    }
}
