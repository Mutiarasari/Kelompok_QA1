Feature: Delete method request

  Scenario: Delete todo with valid id
    Given Delete todo with valid id "1"
    When Send request delete user
    Then Status code should be 200

  Scenario: Delete todo with invalid id
    Given Delete todo with valid id "qweqwe"
    When Send request delete user
    Then Status code should be 200

  Scenario: Delete Posts with valid id
    Given Delete Posts with valid id "1"
    When Send request delete Posts
    Then Status code should be 200

  Scenario: Delete Posts with invalid id
    Given Delete Posts with invalid id "abababa"
    When Send request delete Posts
    Then Status code should be 200

  Scenario: Delete Comment with valid id
    Given Delete Comment with valid id "4"
    When Send request delete Comment
    Then Status code should be 200

  Scenario: Delete Comment with invalid id
    Given Delete Comment with invalid id "abababab"
    When Send request delete Comment
    Then Status code should be 200