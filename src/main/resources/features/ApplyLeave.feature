@applyleave
Feature: Leave Module

  Background:
    Given we are in login page
    When user enter employee credentials
      | username           | password |
      | aiyrxetq@gmail.com | jm@123   |
    And clicks login
    Then logins to account homepage is displayed


  Scenario:Employee Applying for leave
    Given employee in homepage moves to leavemanagement module
    When employee clicks apply leave and fills form
    And click apply leave button
    Then leave is applied successfully
