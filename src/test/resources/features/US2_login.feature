@login @smoke @regression
Feature: Login function

  Background:
    Given user is on the web page
    And user navigates to "Log in" page

  @US2_LOG1
  Scenario: Verify that user should be able to login with valid credentials
    When user logs in with valid credentials
    Then user should be able to login successfully

  @US2_LOG2
  Scenario: Verify that user shouldn't be able to sign up with already existing credentials
    When user logs in with valid username and invalid password
    Then user should see "Wrong password." message

  @US2_LOG3
  Scenario: Verify that user shouldn't be able to sign up with already existing credentials
    When user logs in with invalid username and valid password
    Then user should see "User does not exist." message

  @US2_LOG4
  Scenario Outline: user can login with valid credentials
    When user logs in with valid credentials "<username>" "<password>"
    Then user should be able to login successfully

    Examples:
      | username    | password |
      | testfortest | test     |
      | testfor123  | test     |

  @US2_LOG5
  Scenario: Verify that user shouldn't be able to login without clicking login button
    When user logs in with valid credentials without clicking login button
    Then user shouldn't be able to log in

  @US2_LOG6
  Scenario Outline: "Please fill out Username and Password." message should be displayed if the username or password is empty
    When user logs in keeping "<username>" "<password>" fields empty
    Then user should see "Please fill out Username and Password." message
    Examples:
      | username    | password |
      |             | test     |
      | testfortest |          |
      | testfor123  |          |

  @US2_LOG7
  Scenario: User should see the password in bullet signs by default
    When user enters a valid password in login page
    Then user should see the password in bullet signs by default in login page




