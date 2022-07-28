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

  Scenario: Get list todos with valid endpoint
    Given Get list todos with valid endpoint
    When Send request get list todos
    Then Status code should be 200
    And Response body resource list should contain title "delectus aut autem", complete "false"

  Scenario: Get single todo with valid id
    Given Get single todo with valid id "1"
    When Send request get single todo
    Then Status code should be 200
    And Response body resource single should contain title "delectus aut autem", complete "false"

  Scenario: Get single todo with valid id
    Given Get single todo with valid id "qfrvvrv"
    When Send request get single todo
    Then Status code should be 404

