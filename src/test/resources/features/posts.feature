Feature: endpoint /posts

  @smoke
  Scenario: Get list posts with valid endpoint
    Given Get list posts
    When Send request get list posts with valid endpoint
    Then Status code should be 200
    And Make sure size array is 100

  Scenario: Get list posts with invalid endpoint
    Given Get list posts
    When Send request get list posts with invalid endpoint
    Then Status code should be 404

  @smoke
  Scenario Outline: Get single posts with valid id
    Given Get single posts with id "<id>"
    When Send Request get single posts
    Then Status code should be 200
    And Get single posts assert json validation
    Examples:
    |id   |
    |1    |
    |2    |

  @smoke
  Scenario: Get single post with invalid id
    Given Get single posts with invalid id "qweqwe"
    When Send Request get single posts
    Then Status code should be 404

  Scenario: Post create posts with valid json file
    Given Post create posts with valid json file
    When Send request post create posts
    Then Status code should be 201
    And Post create posts assert json validation

  @smoke
  Scenario: Post create posts with invalid json file
    Given Post create posts with invalid json file
    When Send request post create posts
    Then Status code should be 400

  Scenario Outline: Put update post with valid id
    Given Put update posts with valid json file and id "<id>"
    When Send request put update posts
    Then Status code should be 200
    And Post update posts assert json validation
    Examples:
      | id |
      | 2  |

  @smoke
  Scenario Outline: Put update post with invalid id
    Given Put update posts with invalid json file and id "<id>"
    When Send request put update posts
    Then Status code should be 400
    Examples:
      | id |
      | 2  |

  Scenario: Delete Posts with valid id
    Given Delete Posts with valid id "1"
    When Send request delete Posts
    Then Status code should be 200

# actual status is 200
  @smoke
  Scenario: Delete Posts with invalid id
    Given Delete Posts with invalid id "qweqwe"
    When Send request delete Posts
    Then Status code should be 404