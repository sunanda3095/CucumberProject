Feature: AddEmployee

  Background: Admin Login
    Given admin in login page
    When admin enter username and password
      | username           | password     |
      | sunanda1@gmail.com | Sunanda@1806 |
    And clicks login button
    Then urBuddi home page displayed

  Scenario: AddEmployee using datatables
    Given Admin moving to employee module
    When admin enter fields values
      | fields        | values             |
      | firstname     | Test               |
      | lastname      | Winner             |
      | empId         | random             |
      | email         | random             |
      | role          | Employee           |
      | personalemail | chand123@gmail.com |
      | passwordEmp   | jm@123             |
      | dob           | 23-09-2011         |
      | doj           | 05-03-2026         |
      | experience    | 1                  |
      | qualification | B.Tech             |
      | dept          | CSE                |
      | gender        | Male               |
      | mobileNo      | 9090909090         |
      | bloodGroup    | O+                 |
      | designation   | Intern             |
      | salary        | 35000              |
      | location      | Hyderabad          |
      | reportingTo   | sunanda1@gmail.com |
    And click add employee button
    Then Successfully employee added message dispalyed


