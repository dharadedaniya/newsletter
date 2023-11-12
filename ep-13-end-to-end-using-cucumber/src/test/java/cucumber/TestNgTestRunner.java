package cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/java/cucumber",glue="com.newsletter.stepDefinitions",
monochrome = true,plugin = {"html:target/cucumber.html"})
public class TestNgTestRunner extends AbstractTestNGCucumberTests {

}
