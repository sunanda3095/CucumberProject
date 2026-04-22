@headless
Feature: using headless browser
  Scenario: Open application using headless browser
    Given open the headless browser
    When navigate to application
    Then get title of application
