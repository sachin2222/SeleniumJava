package RediffObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {


    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "login")
    WebElement username;

    @FindBy(name = "passwd")
    WebElement password;

    @FindBy(name = "proceed")
    WebElement signin;

    @FindBy(css = "a")
    List<WebElement> links;




    public WebElement username() {
        return username;


    }

    public WebElement password() {
        return password;


    }

    public WebElement signIn() {
        return signin;


    }
    public List<WebElement> getLinks(){
        return links;

    }

}
