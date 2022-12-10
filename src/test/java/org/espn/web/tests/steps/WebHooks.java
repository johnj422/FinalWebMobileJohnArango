package org.espn.web.tests.steps;

import io.cucumber.java.*;
import org.espn.web.config.WebDriverConfig;
import org.espn.web.helpers.Constants;
import org.openqa.selenium.WebDriver;
import org.tinylog.Logger;


public class WebHooks {

    private static WebDriverConfig webDriverConfig;

    @Before("@webAutomation")
    public void testSetUp(){
        webDriverConfig = new WebDriverConfig();
        Logger.info("Deleting all cookies");
        webDriverConfig.getDriver().manage().deleteAllCookies();
        webDriverConfig.getDriver().manage().window().maximize();
        Logger.info("Navigating to Homepage");
        webDriverConfig.getDriver().get(Constants.URL);
    }

    @After
    public void teardown(){
        Logger.info("Shutting down");
        webDriverConfig.getDriver().quit();
    }

    public static WebDriver getDriver(){
        return webDriverConfig.getDriver();
    }
}
