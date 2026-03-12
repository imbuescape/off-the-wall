Feature: Login

  @smoke @critical
  Scenario: Successful login

    Given the user logs in with valid credentials
    Then the user should see the dashboard