Feature: Test Feature

  Scenario: Test Scenario
    Given I save user "Bob" with email "bob@mail.com"
    When I retrieve user with id "0"
    Then we receive the following user details
      | name  | Bob          |
      | email | bob@mail.com |

