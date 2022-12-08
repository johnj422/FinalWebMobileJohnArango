package org.espn.web.tests.hooks;

import io.cucumber.java.Before;
import org.espn.web.config.Driver;
import org.espn.web.helpers.Constants;
import org.espn.web.pageObjects.HomePage;
import org.openqa.selenium.WebDriver;

public class WebHooks {

    protected static Driver driver;
    protected HomePage homePage;

    @Before
    public void testSetUp(){
        driver = new Driver();
        driver.getDriver().manage().deleteAllCookies();
        driver.getDriver().manage().window().maximize();
        driver.getDriver().get(Constants.URL);
        homePage = new HomePage(driver.getDriver());
    }

    public static WebDriver getDriver(){
        return driver.getDriver();
    }
}
