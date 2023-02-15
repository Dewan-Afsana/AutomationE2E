Feature: Login
  @smoke
  Scenario Outline: Check login with Valid credential
    Given user in the login page
    When user enter '<password>' and '<username>'
    And click Button
    Then user will navigate the dashboard button

    Examples:
    |password | username |
    |afsana | afsana     |