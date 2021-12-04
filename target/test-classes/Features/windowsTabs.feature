Feature: This feature file tests Window and Tab Page functionality

  @runWindowTab
  Scenario: User should be able to handle new window on Window and Tab Page
    Given user navigates to Window and Tab Page
    When user clicks on new window button
    Then user should be able to verify new window title
