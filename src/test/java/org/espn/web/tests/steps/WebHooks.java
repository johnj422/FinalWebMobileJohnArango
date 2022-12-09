package org.espn.web.tests.steps;

import io.cucumber.java.*;
import org.espn.web.config.Driver;
import org.espn.web.helpers.Constants;
import org.openqa.selenium.WebDriver;
import org.tinylog.Logger;


public class WebHooks {

    private static Driver driver;

    @Before("@webAutomation")
    public void testSetUp(){
        driver = new Driver();
        Logger.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
        driver.getDriver().manage().window().maximize();
        Logger.info("Navigating to Homepage");
        driver.getDriver().get(Constants.URL);
    }

    @After
    public void teardown(){
        Logger.info("Shutting down");
        driver.getDriver().quit();
    }

    public static WebDriver getDriver(){
        return driver.getDriver();
    }
}
