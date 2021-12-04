Feature: This feature file tests Alert Page functionality

  @runAlert
  Scenario: User should be able to verify regular alert on Alert Page
    Given user navigates to Alerts Page
    When user clicks on "regular" alert button on Alerts Page
    Then user should be able to handle "regular" alert on Alerts Page