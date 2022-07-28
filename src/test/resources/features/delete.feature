Feature: Delete method request

  Scenario: Delete todo with valid id
    Given Delete todo with valid id "1"
    When Send request delete user
    Then Status code should be 200

  Scenario: Delete todo with invalid id
    Given Delete todo with valid id "qweqwe"
    When Send request delete user
    Then Status code should be 200