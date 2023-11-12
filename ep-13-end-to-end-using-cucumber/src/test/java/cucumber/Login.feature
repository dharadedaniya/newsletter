Feature: User Login

  Scenario: Successful login
    Given the user is on the login page
    When the user enters valid username and password
    And clicks the login button
    Then they should be redirected to the dashboard
    And see a welcome message

  Scenario: Invalid login
    Given the user is on the login page
    When the user enters invalid username and password
    And clicks the login button
    Then an error message should be displayed