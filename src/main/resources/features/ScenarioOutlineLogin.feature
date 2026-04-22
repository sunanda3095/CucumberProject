@multipleuser
Feature: Login with valid credentials

  Scenario Outline:Login with multiple users
    Given user is on login page
    When user enters "<username>" and "<password>"
    And clicks on login button
    Then home page should get displayed
    Examples:
      | username           | password |
      | aiyrxetq@gmail.com | jm@123   |
      | jllpasmi@gmail.com | jm@123   |
      | wa0o8ul6@gmail.com | jm@123   |