package org.espn.web.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runs the tests defined in WebSteps
 */
@CucumberOptions(
        features = "src/test/java/org/espn/web/tests/features",
        glue = "org/espn/web/tests/steps",
        plugin = { "pretty" },
        tags = "@webAutomation"
)
public class RunWebTests extends AbstractTestNGCucumberTests {


}
