Feature: This feature file tests iFrame Page functionality

  @runiFrame
  Scenario: User should be able to enter a keyword into the textbox on iFrame Page
    Given user navigates to iFrame Page
    When user enters a keyword into the textbox on iFrame Page
    Then user should be able to verify entered text