package cucumberE2E;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/cucumberE2E/Login.feature",
        glue = "cucumberE2E/LoginSteps",
        dryRun = false,
        tags = {"@Login"},
        plugin={"pretty", "html:target/cucumber-html-report",
                "json:target/cucumber-report.json"}

)
public class Runner {


}
