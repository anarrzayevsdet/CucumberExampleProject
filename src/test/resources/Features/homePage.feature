@regression @homepage
Feature: This feature file tests Homepage functionality

  Background:
    Given user navigates to HRM loginpage

  Scenario: User should be able to verify main tabs on HRM Homepage
    When user enter valid credentials and clicks on login button
    Then user should be able to land on HRM homepage
    And user should be able to validate all main tabs on Homepage
      |tabName        |
      |Admin          |
      |PIM            |
      |Leave          |
      |Time           |
      |Recruitment    |
      |My Info        |
      |Performance    |
      |Dashboard      |
      |Directory      |
      |Maintenance    |

  @employeeList
  Scenario: User should be able to verify employee list table on HRM
    When user enter valid credentials and clicks on login button
    Then user should be able to land on HRM homepage
    Then user clicks on "PIM" main tab on HRM homepage
    Then user clicks on "Employee List" sub tab on HRM homepage
    And user verifies employee list table