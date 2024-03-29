package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/features", glue = { "stepdefinitions", "hooks" }, plugin = { "pretty",
		"html:target/SystemTestReports/index.html", "json:target/SystemTestReports/json/report.json",
		"junit:target/SystemTestReports/junit/report.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, dryRun = false, monochrome = true, tags = "@Excel")
public class DSAlgoTestRunnerTest {

}
