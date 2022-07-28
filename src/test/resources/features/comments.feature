Feature: API for endpoint /comments

  Scenario: Get list comments with valid endpoint
    Given Get list comment
    When Send Request get list comment
    Then Status code should be 404

  Scenario: Get list comments with invalid endpoint
    Given Get list comment
    When Send Request get list comment
    Then Status code should be 404

  Scenario: Get single comments with valid id
    Given Get single comment with id "2"
    When Send Request get single comment
    Then Status code should be 200

  Scenario: Get single comment with invalid id
    Given Get single comment with invalid id "abababab"
    When Send Request get single comment
    Then Status code should be 404

  Scenario: Post create comment with valid json file
    Given Post create comment with valid json file
    When Send request post create comments
    Then Status code should be 201

  Scenario: Post create comment with invalid json file
    Given Post create comment with invalid json file
    When Send request post create comments
    Then Status code should be 500

  Scenario Outline: Put Comments user with valid id
    Given Put update Comments with valid json file and id "<id>"
    When Send request put update Comments
    Then Status code should be 200
    Examples:
      | id |
      | 2  |

  Scenario Outline: Put Posts Comments with invalid id
    Given Put update Comments with invalid json file and id "<id>"
    When Send request put update Comments
    Then Status code should be 500
    Examples:
      | id |
      | 2  |

  Scenario: Delete Comment with valid id
    Given Delete Comment with valid id "4"
    When Send request delete Comment
    Then Status code should be 200

  Scenario: Delete Comment with invalid id
    Given Delete Comment with invalid id "abababab"
    When Send request delete Comment
    Then Status code should be 200
