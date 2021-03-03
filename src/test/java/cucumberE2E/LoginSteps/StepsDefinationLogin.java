package cucumberE2E.LoginSteps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import java.time.Duration;

public class StepsDefinationLogin {

    WebDriver driver;

    //Hooks
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @After
    public void teardown(){
        driver.quit();
    }

    @Given("^User navigates to the Air Vistara Login Page\\.$")
    public void user_navigates_to_the_Air_Vistara_Login_Page() throws Throwable {
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        Assert.assertEquals(driver.getCurrentUrl(), "https://mail.rediff.com/cgi-bin/login.cgi");

    }

    @When("^user enters user  email \"([^\"]*)\"$")
    public void user_enters_user_email(String email) throws Throwable {
        driver.findElement(By.id("login1")).sendKeys(email);
    }

    @When("^User enter  Password\"([^\"]*)\"$")
    public void user_enter_Password(String password) throws Throwable {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("^User Clicks on Login Button$")
    public void user_Clicks_on_Login_Button() throws Throwable {
        driver.findElement(By.name("proceed")).click();


    }

    @Then("^Failed Authentication Message should Display on Screen\\.$")
    public void failed_Authentication_Message_should_Display_on_Screen() throws Throwable {
        String message = "Wrong username and password combination.";
        String errormsg = driver.findElement(By.id("div_login_error")).getText();
        System.out.println(errormsg);
        Assert.assertEquals(message, errormsg);

    }



    @Then("^User should Successfully navigate to Home page\\.$")
    public void user_should_Successfully_navigate_to_Home_page() throws Throwable {
        String homepageURL= driver.getCurrentUrl();
        Assert.assertEquals(homepageURL,"https://mail.rediff.com/cgi-bin/login.cgi");

    }

}
