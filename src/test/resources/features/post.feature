Feature: Post method request

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

  Scenario: Post create comment with valid json file
    Given Post create comment with valid json file
    When Send request post create comments
    Then Status code should be 201

  Scenario: Post create comment with invalid json file
    Given Post create comment with invalid json file
    When Send request post create comments
    Then Status code should be 500