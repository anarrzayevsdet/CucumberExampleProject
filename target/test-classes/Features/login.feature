@regression @login
Feature: This feature file tests Login Page functionality

  Background:
    Given user navigates to HRM loginpage

  @smoke @positive
  Scenario: User should be able to login to HRM successfully
    When user enter valid credentials and clicks on login button
    Then user should be able to land on HRM homepage

  @negative
  Scenario Outline: User should not be able to login to HRM with invalid credentials
    When user enter "<usernameData>" username and "<passwordData>" password
    Then user clicks on login button
    And user validates "<errorMessageData>" error message
    Examples:
      | usernameData | passwordData | errorMessageData         |
      | invalid      | valid        | Invalid credentials      |
      | valid        | invalid      | Invalid credentials      |
      | empty        | valid        | Username cannot be empty |
      | valid        | empty        | Password cannot be empty |

  Scenario: User should be able to verify main tabs on HRM Homepage
    When user enter valid credentials and clicks on login button
    Then user should be able to land on HRM homepage