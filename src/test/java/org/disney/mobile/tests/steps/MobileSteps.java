package org.disney.mobile.tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.disney.mobile.screenObjects.DashBoardScreen;
import org.disney.mobile.screenObjects.MapScreen;
import org.disney.mobile.screenObjects.TutorialScreen;
import org.testng.asserts.SoftAssert;
import org.tinylog.Logger;

public class MobileSteps {

    SoftAssert softAssert = new SoftAssert();
    private TutorialScreen tutorialScreen;
    private DashBoardScreen dashboardScreen;
    private MapScreen mapScreen;

    @Given("I am in the Dashboard Screen")
    public void iAmInTheDashboardScreen() {
        tutorialScreen = new TutorialScreen(MobileHooks.getDriver());
        tutorialScreen.startPermissionsProcess();
        dashboardScreen = tutorialScreen.shareLocationPermissions();
    }

    @Given("I am in the Map Screen")
    public void iAmInTheMapScreen() {
        softAssert.assertTrue(dashboardScreen.mapButtonIsDisplayed(), "Map button should be displayed");
        mapScreen = dashboardScreen.goToMapScreen();
        softAssert.assertAll();
    }

    @Then("Map screen elements must be displayed")
    public void mapScreenElementsMustBeDisplayed() {
        Logger.info("Navigating to Category List");
        Logger.info("Validating if Category button is displayed");
        softAssert.assertTrue(mapScreen.categoryIsDisplayed(), "Category button should be displayed");
        mapScreen.tapCategoryButton();
        Logger.info("Validating if different categories are listed");
        softAssert.assertTrue(mapScreen.checkCategoryContainerSize() > 0, "Category List must have elements");
        softAssert.assertTrue(mapScreen.isHotelsIncluded(), "Hotels category should be displayed");
        softAssert.assertAll();
    }
}
