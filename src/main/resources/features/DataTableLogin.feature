@data
Feature: Login

  Scenario: Login with data table values
    Given user present in login page
    When user enter username and password data from data table
      | username           | password |
      | aiyrxetq@gmail.com | jm@123   |
      | jllpasmi@gmail.com | jm@123   |
      | wa0o8ul6@gmail.com | jm@123   |
    And click loginbtn
    Then urbuddi home page should get displayed



