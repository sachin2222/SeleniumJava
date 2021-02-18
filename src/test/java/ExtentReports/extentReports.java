package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class extentReports {

    WebDriver driver;
    String chrome_key = "webdriver.chrome.driver";
    String chromeDriverPath = ".\\Drivers\\chromedriver.exe";
    String URL = "https://rahulshettyacademy.com/seleniumPractise/#/";
    ExtentReports extentReports;


    @BeforeTest
    public void reports() {

        String path = System.getProperty("user.dir") + "\\ExtReports\\index.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("TestNG Reports");
        sparkReporter.config().setDocumentTitle("Test Results");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Tester", "Sachin");


    }


    @Test
    public void URLTest() {
        ExtentTest ext = extentReports.createTest("URLTest");
        extentReports.flush();

    }

}
