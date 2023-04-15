
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com/maggie/mscproject/test"},
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json",
                            "html:target/cucumber-reports/cucumber"},
        monochrome = true,
        dryRun= false
)
public class TestRunner {
}
