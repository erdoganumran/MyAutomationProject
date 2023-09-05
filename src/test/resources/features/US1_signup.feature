@signup @smoke @regression
Feature: Signup function

  Background:
    Given user is on the web page
    And user navigates to "Sign up" page

  @US1_SUP1
  Scenario: Verify that user should be able to sign up with valid credentials
    When user sign ups with a new "username" and "password"
    Then user should be able to sign up successfully

  @US1_SUP2
  Scenario: Verify that user shouldn't be able to sign up with already existing credentials
    When user enters an already exist "username" and "password"
    Then user should see "This user already exist." message

  @US1_SUP3
  Scenario Outline: "Please fill out Username and Password." message should be displayed if the username or password is empty
    When user signs up keeping "<username>" or "<password>" fields empty
    Then "Please fill out Username and Password." message should be displayed

    Examples:
      | username    | password |
      |             | test     |
      | testfortest |          |
      | testfor123  |          |

  @US1_SUP4
  Scenario: User should see the password in bullet signs by default
    When user enters a valid "password"
    Then user should see the password in bullet signs by default



