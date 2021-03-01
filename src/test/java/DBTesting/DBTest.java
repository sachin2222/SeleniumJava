package DBTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.*;

public class DBTest {

    WebDriver driver;
    ResultSet resultSet;
    ResultSet count;

    // @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ss26370\\IdeaProjects\\SeleniumJava\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    //@Test(dataProvider = "getUserData")
    public void dbTest(String username, String password) throws SQLException {

      /*  for (int p=0;p<username.length;p++) {

            System.out.println(username[p]);
            System.out.println(password[p]);
        }
*/
        System.out.println(username);
        System.out.println(password);

     /*   for (int i = 0; i < username.length; i++) {

            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.findElement(By.id("txtUsername")).sendKeys(username[i]);
            driver.findElement(By.id("txtPassword")).sendKeys(password[i]);
            driver.findElement(By.id("btnLogin")).click();
        }*/


    }

   /*// @DataProvider
    public Object[] getUserData() throws SQLException {
        String host = "localhost";
        String port = "3306";
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/mypersonal", "root", "root");
        Statement statement = connection.createStatement();
        count = statement.executeQuery("select count(*) Total_Rows from user_info");
        count.next();

        int rowsCount = count.getInt("Total_Rows");

        resultSet = statement.executeQuery("select * from user_info");
        String[] username = new String[rowsCount];
        String[] password = new String[rowsCount];
        int i = 0;
        if (username.length == 0) {
            while (resultSet.next()) {
                username[i] = resultSet.getString("username");
                password[i] = resultSet.getString("password");
                return new String[]{username[i], password[i]};
                i++;
            }
        }
        else
        {
            return new String[]{"anc"};
        }

    }*/

    @Test
    public void test() throws SQLException {
        String host = "localhost";
        String port = "3306";
        Connection connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/mypersonal", "root", "root");
        Statement statement = connection.createStatement();
        count = statement.executeQuery("select count(*) Total_Rows from user_info");
        count.next();

        int rowsCount = count.getInt("Total_Rows");

        resultSet = statement.executeQuery("select * from user_info");
        String[] username = new String[rowsCount];
        String[] password = new String[rowsCount];
        int i = 0;
        while (resultSet.next()) {
            username[i] = resultSet.getString("username");
            password[i] = resultSet.getString("password");
            i++;
        }

       /* for (int p=0;p<username.length;p++){
            System.out.println(username[p]);
            System.out.println(password[p]);
        }*/


    }

}
