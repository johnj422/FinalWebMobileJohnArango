package org.disney.mobile.tests.steps;

import io.cucumber.java.en.Given;
import org.disney.mobile.screenObjects.DashBoardScreen;
import org.disney.mobile.screenObjects.TutorialScreen;
import org.tinylog.Logger;

public class MobileSteps {

    private TutorialScreen tutorialScreen;
    private DashBoardScreen dashboardScreen;

    @Given("I am in the Dashboard Screen")
    public void iAmInTheDashboardScreen() {
        tutorialScreen = new TutorialScreen(MobileHooks.getDriver());
        tutorialScreen.startPermissionsProcess();
        dashboardScreen = tutorialScreen.shareLocationPermissions();
    }

    @Given("I am in the Map Screen")
    public void iAmInTheMapScreen() {
        Logger.info("I am in the Map Screen");
    }
}
