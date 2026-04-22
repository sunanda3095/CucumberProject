@login
Feature: Login Functionality
  Scenario: Login with valid credentials
    Given user is on login page
    When user enters username and password
    And clicks the login button
    Then dashboard should get displayed
