package org.espn.web.tests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.espn.web.pageObjects.HomePage;
import org.espn.web.pageObjects.WatchPage;
import org.espn.web.tests.hooks.WebHooks;
import org.testng.asserts.SoftAssert;
import org.tinylog.Logger;
import org.espn.web.helpers.Constants;

public class WebSteps {

    private HomePage homePage;
    private WatchPage watchPage;
    SoftAssert softAssert = new SoftAssert();

    @Given("I am in the ESPN website")
    public void iAmInTheESPNWebsite() {
        homePage = new HomePage(WebHooks.getDriver());
    }

    @Given("I am in the login modal")
    public void iAmInTheLoginModal() {
        homePage.userLogin();
        Logger.info("Opening Login modal");
        homePage.changingIframe(homePage.getUserFrame());
    }


    @Then("The modal and its elements should be displayed")
    public void validateDisplayedElements() {
        Logger.info("Validating if ESPN Logo is displayed");
        softAssert.assertTrue(homePage.isEspnLogoDisplayed(),"Espn Logo must be displayed");
        Logger.info("Validating if Submit Button is displayed");
        softAssert.assertTrue(homePage.validateIfBtnSubmitDisplayed(),"Submit Button must be displayed");
        Logger.info("Validating if SignUp Button is displayed");
        softAssert.assertTrue(homePage.isBtnSignUpDisplayed(),"SignUp Button must be displayed");
        softAssert.assertAll();
    }

    @When("I click the signUp button")
    public void iClickTheSignUpButton() {
        Logger.info("Clicking SignUp Button");
        homePage.clickSignUpButton();
    }

    @Then("All signUp elements should be displayed")
    public void allSignUpElementsShouldBeDisplayed() {
        Logger.info("Validating if Sign Up tittle is displayed");
        softAssert.assertTrue(homePage.validateIfTitleIsDisplayed(), "SignUp title must be displayed");
        Logger.info("Validating if First Name input is displayed");
        softAssert.assertTrue(homePage.validateIfFirstNameInputIsDisplayed(), "First Name input must be displayed");
        Logger.info("Validating if Last Name input is displayed");
        softAssert.assertTrue(homePage.validateIfLastNameInputIsDisplayed(), "Last Name input must be displayed");
        Logger.info("Validating if Email input is displayed");
        softAssert.assertTrue(homePage.validateIfEmailSignUpInputIsDisplayed(), "Email input must be displayed");
        Logger.info("Validating if Password input is displayed");
        softAssert.assertTrue(homePage.validateIfPasswordSignUpInputIsDisplayed(), "Password input must be displayed");
        Logger.info("Validating if Sign Up button is displayed");
        softAssert.assertTrue(homePage.validateIfBtnSubmitDisplayed(), "SignUp button must be displayed");
        Logger.info("Validating if Close button is displayed");
        softAssert.assertTrue(homePage.validateIfCloseButtonIsDisplayed(), "Close button must be displayed");
        softAssert.assertAll();
    }

    @And("I complete the SignUp form")
    public void iCompleteTheSignUpForm() {
        Logger.info("Signing Up");
        homePage.singUp(Constants.FIRST_NAME, Constants.LAST_NAME, Constants.SIGN_UP_EMAIL, Constants.PASSWORD);
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        Logger.info("Validating if user was successfully created");
        homePage.performMouseHover(homePage.getUserIcon());
        softAssert.assertTrue(homePage.validateUserName().contains(Constants.FIRST_NAME), "User name should contains " +
                Constants.FIRST_NAME);
        softAssert.assertAll();
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        Logger.info("Login to account");
        homePage.loginToAccount(Constants.LOGIN_EMAIL, Constants.PASSWORD);
    }

    @When("I navigate to WatchPage")
    public void iNavigateToWatchPage() {
        Logger.info("Navigating to WatchPage");
        watchPage = homePage.navigateToWatch();
    }

    @Then("All WatchPage element validations should be completed")
    public void validateWatchPageElements() {
        Logger.info("Validating that there is at least one carrousel");
        softAssert.assertTrue(watchPage.getCarrouselContainerSize() > 0, "Should have at least one carrousel");
        Logger.info("Validating that every card in the carrousel has title and description");
        softAssert.assertEquals(watchPage.getNoTitleCards(), 0, "Every card must have title and description");
        Logger.info("Clicking second carrousel's card");
        watchPage.clickSecondCard();
        Logger.info("Checking that close button is displayed");
        softAssert.assertTrue(watchPage.validateCloseButton(), "Close button must be displayed");
        Logger.info("Closing details");
        watchPage.clickCloseButton();
        softAssert.assertAll();
    }

    @And("I should be back in the HomePage")
    public void iShouldBeBackInTheHomePage() {
        Logger.info("Navigating back to HomePage");
        watchPage.navigateToHomePage();
    }

    @When("I hover the mouse to user icon")
    public void iHoverTheMouseToUserIcon() {
        Logger.info("Hovering mouse to user panel");
        homePage.performMouseHover(homePage.getUserIcon());

    }

    @Then("It should display the user's name")
    public void itShouldDisplayTheUserSName() {
        Logger.info("Validating displayed name");
        softAssert.assertEquals(homePage.validateUserName(), "Welcome"+Constants.FIRST_NAME+"!", "User's name must " +
                "be displayed");
        softAssert.assertAll();
    }

    @When("I logged out")
    public void iAmLoggedOut() {
        Logger.info("Login out");
        homePage.performMouseHover(homePage.getUserIcon());
        homePage.clickLogOutButton();
    }

    @Then("It should not display any users name")
    public void itShouldNotDisplayAnyUserSName() {
        homePage.pageRefresh();
        Logger.info("Hovering mouse to user's panel");
        homePage.performMouseHover(homePage.getUserIcon());
        Logger.info("Validating displayed name");
        softAssert.assertEquals(homePage.validateUserName(), "Welcome!", "No User's name should be displayed");
        softAssert.assertAll();
    }
}
