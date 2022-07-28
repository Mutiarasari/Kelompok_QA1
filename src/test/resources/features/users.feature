Feature: API for endpoint /users

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

  Scenario: Post create user with valid json file
    Given Post create user with valid json file
    When Send request post create user
    Then Status code should be 201
    And Response body resource should contain name "Dhandy", email "dhan@gmail.com", phone "12312312"

  Scenario: Post create user with invalid json file
    Given Post create user with invalid json file
    When Send request post create user
    Then Status code should be 500

  Scenario: Post create posts with valid json file
    Given Post create posts with valid json file
    When Send request post create posts
    Then Status code should be 201

  Scenario: Post create posts with invalid json file
    Given Post create posts with invalid json file
    When Send request post create posts
    Then Status code should be 500

  Scenario Outline: Put user user with valid json file
    Given Put update user with valid json file and id "<id>"
    When Send request put update user
    Then Status code should be 200
    And Response body resource should contain name "Manuel Neuer", email "neuer@gmail.com", phone "123123", id <id>
    Examples:
      |id   |
      |1    |

  Scenario Outline: Put user user with invalid json file
    Given Put update user with invalid json file and id "<id>"
    When Send request put update user
    Then Status code should be 500
    Examples:
      |id   |
      |1    |

  Scenario Outline: Put user user with invalid id
    Given Put update user with valid json file and id "<id>"
    When Send request put update user
    Then Status code should be 500
    Examples:
      |id         |
      |qweqwe     |