Feature: Get method request

  Scenario: Get list user with valid endpoint
    Given Get list users
    When Send request get list users with valid endpoint
    Then Status code should be 200
    And Make sure size array is 10

  Scenario: Get list user with invalid endpoint
    Given Get list users
    When Send request get list users with invalid endpoint
    Then Status code should be 404