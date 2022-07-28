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

  Scenario: Get single user with valid id
    Given Get single user with id "1"
    When Send request get single user
    Then Status code should be 200
    And Response body resource should contain name "Leanne Graham" and email "Sincere@april.biz"

  Scenario: Get single user with invalid id
    Given Get single user with id "asdasd"
    When Send request get single user
    Then Status code should be 404

  Scenario: Get list posts with valid endpoint
    Given Get list posts
    When Send request get list posts with valid endpoint
    Then Status code should be 200

  Scenario: Get list posts with invalid endpoint
    Given Get list posts
    When Send request get list posts with invalid endpoint
    Then Status code should be 404

  Scenario: Get single posts with valid id
    Given Get single posts with id "2"
    When Send Request get single posts
    Then Status code should be 200

  Scenario: Get single post with invalid id
    Given Get single posts with invalid id "aba"
    When Send Request get single posts
    Then Status code should be 404

  Scenario: Get list comments with valid endpoint
    Given Get list comment
    When Send Request get list comment
    Then Status code should be 200

  Scenario: Get list comments with invalid endpoint
    Given Get list comment
    When Send Request get list comment
    Then Status code should be 404