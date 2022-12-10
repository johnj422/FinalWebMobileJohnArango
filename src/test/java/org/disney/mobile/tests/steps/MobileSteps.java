package org.disney.mobile.tests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.disney.mobile.screenObjects.DashBoardScreen;
import org.disney.mobile.screenObjects.MapScreen;
import org.disney.mobile.screenObjects.MenuScreen;
import org.disney.mobile.screenObjects.TutorialScreen;
import org.testng.asserts.SoftAssert;
import org.tinylog.Logger;

public class MobileSteps {

    SoftAssert softAssert = new SoftAssert();
    private TutorialScreen tutorialScreen;
    private DashBoardScreen dashboardScreen;
    private MapScreen mapScreen;
    private MenuScreen menuScreen;

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
        softAssert.assertAll();
    }

    @When("I tap the category button")
    public void iTapTheCategoryButton() {
        mapScreen.tapCategoryButton();
    }

    @Then("Category's elements should be validated")
    public void categorySElementsShouldBeValidated() {
        Logger.info("Validating if different categories are listed");
        softAssert.assertTrue(mapScreen.checkCategoryContainerSize() > 0, "Category List must have elements");
        softAssert.assertTrue(mapScreen.isHotelsIncluded(), "Hotels category should be displayed");
        softAssert.assertAll();
    }

    @Given("I am in the Menu Screen")
    public void iAmInTheMenuScreen() {
        menuScreen = dashboardScreen.goToMenuScreen();
    }

    @And("MenuScreen elements are validated")
    public void menuScreenElementsAreValidated() {
        Logger.info("Swiping down");
        menuScreen.swipeDown();
        Logger.info("Validating all menuScreen elements");
        softAssert.assertTrue(menuScreen.isMyProfileVisible(), "My Profile option should be available");
        softAssert.assertTrue(menuScreen.isPropertyRulesVisible(), "Property Rules option should be available");
        softAssert.assertTrue(menuScreen.isLinkToAccountVisible(), "Link to Account option should be available");
        softAssert.assertTrue(menuScreen.isHelpVisible(), "Help option should be available");
        softAssert.assertTrue(menuScreen.isPrivacyAndLegaVisible(), "Privacy & Legal option should be available");
        softAssert.assertAll();
    }

    @When("I tap the Privacy & Legal option")
    public void iTapThePrivacyLegalOption() {
        Logger.info("Taping Privacy & Legal");
        menuScreen.tapPrivacyAndLegal();
    }

    @Then("Privacy and Legal option elements should be validated")
    public void privacyAndLegalOptionElementsShouldBeValidated() {
        Logger.info("Validating if different privacy and legal options are listed");
        softAssert.assertTrue(menuScreen.isPrivacyPolicyVisible(), "Privacy Policy option should be available");
        softAssert.assertTrue(menuScreen.isTermsOfUseVisible(), "Terms of use should be available");
        softAssert.assertTrue(menuScreen.isSupplementalTermsVisible(), "Supplemental Terms and Conditions should be available");
        softAssert.assertTrue(menuScreen.isLegalNoticesVisible(), "Legal Notices should be available");
        softAssert.assertTrue(menuScreen.isPropertyRules2Visible(), "Property Rules should be available");
        softAssert.assertTrue(menuScreen.isElectronicCommVisible(), "Electronic Communication Disclosure should be available");
        softAssert.assertAll();
    }

    @When("I tap on the Add plans option")
    public void iTapOnTheAddPlansOption() {
        Logger.info("Tapping on the Add plans option");
        dashboardScreen.goToAddPlans();
    }

    @Then("Dining Availability should be displayed")
    public void diningAvailabilityShouldBeDisplayed() {
        Logger.info("Validating Dining Availability");
        softAssert.assertTrue(dashboardScreen.isReserveOptionVisible(), "Check Dining Availability option should be displayed");
        softAssert.assertAll();
    }
}
