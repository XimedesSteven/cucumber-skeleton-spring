Feature: Test Feature

  Scenario: Retrieve User
    Given I have a user "Bob" with email "bob@mail.com"
    When I retrieve user with id "1"
    Then we receive the following user details
      | name  | Bob          |
      | email | bob@mail.com |

  Scenario: Save user
    Given I have a user "Bob" with email "bob@mail.com"
    When I save user "Joe" with email "joe@mail.com"
    And I retrieve user with id "2"
    Then we receive the following user details
      | name  | Joe          |
      | email | joe@mail.com |
