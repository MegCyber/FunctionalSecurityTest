
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/maggie/mscproject/test"},
        format= {"pretty","html:test-output_1",
                "json:target/cucumber-reports/CucumberTestReport.json"},
        plugin = {"json:target/cucumber.json",
                "html:target/cucumber-reports/cucumber.html"},
        monochrome = true,
        dryRun= false
)
public class TestRunner {
}
