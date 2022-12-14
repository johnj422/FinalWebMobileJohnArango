package org.disney.mobile.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runs the tests defined in MobileSteps
 */
@CucumberOptions(
        features = "src/test/java/org/disney/mobile/tests/features",
        glue = "org/disney/mobile/tests/steps"

)
public class RunMobileTests extends AbstractTestNGCucumberTests {


}
