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
