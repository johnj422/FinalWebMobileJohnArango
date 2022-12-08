package org.espn.web.tests.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebTestsSteps {
    @Given("I am on the ESPN page")
    public void iAmOnTheESPNPage() {
        System.out.println("Hello");
    }

    @When("I click login")
    public void iClickLogin() {

    }

    @And("I enter username and password")
    public void iEnterUsernameAndPassword() {
    }

    @Then("I should login to my account")
    public void iShouldLoginToMyAccount() {
    }
}
