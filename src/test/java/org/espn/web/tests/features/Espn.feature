@webAutomation
Feature: ESPN web page Navigation Test
  In order to validate web page's functionalities
  As a ESPN user
  I want to be able to login and navigate to ESP subPages

  Background:
    Given I am in the ESPN website

  Scenario: Validate that modal is present and contains its elements
    Given I am in the login modal
    Then The modal and its elements should be displayed

  Scenario: Validate SignUp elements
    Given I am in the login modal
    When I click the signUp button
    Then All signUp elements should be displayed

  Scenario: SignUp for a new ESPN account
    Given I am in the login modal
    When I click the signUp button
    And I complete the SignUp form