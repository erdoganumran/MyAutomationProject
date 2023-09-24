@purchase @smoke @regression

Feature: Purchase function

  Background:
    Given user is on the web page
    And user navigates to "Log in" page
    And user logs in with valid credentials

  @PRC1_01
  Scenario: User should be able to purchase products
    When user navigates to "Laptops" page
    And user navigates to "Sony vaio i5" page
    And user adds the product to the cart
    And user goes to home page
    When user navigates to "Laptops" page
    And user navigates to "Dell i7 8gb" page
    And user adds the product to the cart
    And user navigates to "Cart" page
    And user delete "Dell i7 8gb" from the cart
    And user clicks "Place Order" button
    And user fills out Place Order page
    And user clicks "Purchase" button
    Then purchase amount equals expected amount

