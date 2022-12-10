@mobileAutomation
Feature: Disney App Navigation Test
  In order to validate App's functionalities
  As a Disney user
  I want to be able to navigate to different App's screens

  Background:
    Given I am in the Dashboard Screen

  Scenario: Validate Map screen display
    Given I am in the Map Screen
    Then Map screen elements must be displayed

  Scenario: Validate Category list's elements
    Given I am in the Map Screen
    When I tap the category button
    Then Category's elements should be validated

  Scenario: Validate Privacy & Legal Menu option
    Given I am in the Menu Screen
    And MenuScreen elements are validated
    When I tap the Privacy & Legal option
    Then Privacy and Legal option elements should be validated

  Scenario: Validate Add Plans screen
    When I tap on the Add plans option
    Then Dining Availability should be displayed