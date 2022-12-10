package org.espn.web.tests.steps;

import io.cucumber.java.*;
import org.espn.web.config.WebDriverConfig;
import org.espn.web.helpers.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.tinylog.Logger;


public class WebHooks {

    /**
     * Hooks defined for WebSteps
     */
    private static WebDriverConfig webDriverConfig;

    /**
     * Driver configuration initiated before everything
     */
    @Before("@webAutomation")
    public void testSetUp(){
        webDriverConfig = new WebDriverConfig();
        Logger.info("Deleting all cookies");
        webDriverConfig.getDriver().manage().deleteAllCookies();
        webDriverConfig.getDriver().manage().window().maximize();
        Logger.info("Navigating to Homepage");
        webDriverConfig.getDriver().get(Constants.URL);
    }

    /**
     * Terminates the driver instance after everything runs
     */
    @After("@webAutomation")
    public void WebTeardown(){
        Logger.info("Shutting down");
        webDriverConfig.getDriver().quit();
    }

    /**
     * Driver getter method
     * @return WebDriver
     */
    public static WebDriver getDriver(){
        return webDriverConfig.getDriver();
    }
}
