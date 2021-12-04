Feature: This feature file tests Actions functionality

  Scenario: User should be able to hover over any tab on AP Homepage
    Given user navigates to Automation Practice Page
    Then user hover over womens tab
    And user clicks on casual dresses link
    Then user validates casual dresses page

  Scenario: User should be able to right click on Practice Page
    Given user navigates to Practice Page
    When user performs right click action on the button
    Then user should be able to handle "regular" alert on Alerts Page

  Scenario: User should be able to drag and drop items
    Given user navigates to Drag Drop Page
    Then user should be able to drag and drop capital to its country

  @actionsRun
  Scenario: User should be able to perform multiple keyboard actions
    Given user navigates to Automation Practice Page
    Then user performs multiple keyboard actions