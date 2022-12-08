package org.espn.web.tests.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.espn.web.pageObjects.HomePage;
import org.espn.web.tests.hooks.WebHooks;
import org.testng.asserts.SoftAssert;
import org.tinylog.Logger;

public class WebSteps {

    private HomePage homePage;
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
}
