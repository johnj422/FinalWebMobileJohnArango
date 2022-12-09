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
    Then I should be logged in

  Scenario: Navigate to WatchPage
    Given I am logged in
    When I navigate to WatchPage
    Then All WatchPage element validations should be completed
    And I should be back in the HomePage

  Scenario: Validate logged in Welcome text
    Given I am logged in
    When I hover the mouse to user icon
    Then It should display the user's name

  Scenario: Validate logged out Welcome text
    Given I am logged in
    When I logged out
    Then It should not display any users name

