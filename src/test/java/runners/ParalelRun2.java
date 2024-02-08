package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/ParalelRapor2.html",
                "json:target/json-reports/cucumber2.json",
                "junit:target/xml-report/cucumber2.xml"},
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@e2e",
        dryRun = false
)

public class ParalelRun2 {
}
