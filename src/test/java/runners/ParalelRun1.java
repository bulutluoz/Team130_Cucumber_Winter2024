package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/ParalelRapor1.html",
                "json:target/json-reports/cucumber1.json",
                "junit:target/xml-report/cucumber1.xml"},
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@smoke",
        dryRun = false
)


public class ParalelRun1 {

}
