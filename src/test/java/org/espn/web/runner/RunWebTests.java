package org.espn.web.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/org/espn/web/tests/features",
        glue = {"org.espn.web.tests.steps"}

)
public class RunWebTests extends AbstractTestNGCucumberTests {

}
