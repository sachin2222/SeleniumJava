@FunctionalTest
Feature: Login User Functionality of Air Vistara

  @Login@InvalidUsers
  Scenario Outline: Validate Invalid Login Failure Access.
    Given User navigates to the Air Vistara Login Page.
    When user enters user  email "<Email>"
    And User enter  Password"<Password>"
    And User Clicks on Login Button
    Then Failed Authentication Message should Display on Screen.

    Examples:
      | Email               | Password  |
      | testuser1@gmail.com | test@1234 |
      | testuser2@gmail.com | test@1234 |


  @Login@ValidUsers
  Scenario Outline: Validate valid Login Successfull Access
    Given User navigates to the Air Vistara Login Page.
    When user enters user  email "<Email>"
    And User enter  Password"<Password>"
    And User Clicks on Login Button
    Then User should Successfully navigate to Home page.

    Examples:
      | Email      | Password   |
      | validuser1 | valid@1234 |
      | validuser2 | validuser2 |



