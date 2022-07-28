Feature: API for endpoint /posts

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





  Scenario Outline: Put Posts user with valid id
    Given Put update posts with valid json file and id "<id>"
    When Send request put update posts
    Then Status code should be 200
    Examples:
      | id |
      | 2  |

  Scenario Outline: Put Posts user with invalid id
    Given Put update posts with invalid json file and id "<id>"
    When Send request put update posts
    Then Status code should be 500
    Examples:
      | id |
      | 2  |

  Scenario: Delete Posts with valid id
    Given Delete Posts with valid id "1"
    When Send request delete Posts
    Then Status code should be 200

  Scenario: Delete Posts with invalid id
    Given Delete Posts with invalid id "abababa"
    When Send request delete Posts
    Then Status code should be 200