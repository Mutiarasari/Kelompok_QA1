Feature: endpoint /comments

  @smoke
  Scenario: Get list comments with valid endpoint
    Given Get list comment
    When Send Request get list comment
    Then Status code should be 200
    And Make sure size array is 500

  @smoke
  Scenario Outline: Get single comments with valid id
    Given Get single comment with id "<id>"
    When Send Request get single comment
    Then Status code should be 200
    And Get single comment assert json validation
    Examples:
    |id   |
    |1    |
    |2    |

  Scenario: Get single comment with invalid id
    Given Get single comment with invalid id "qweqwe"
    When Send Request get single comment
    Then Status code should be 404

  @smoke
  Scenario: Post create comment with valid json file
    Given Post create comment with valid json file
    When Send request post create comments
    Then Status code should be 201
    And Post create comment assert json validation

  Scenario: Post create comment with invalid json file
    Given Post create comment with invalid json file
    When Send request post create comments
    Then Status code should be 400

  Scenario Outline: Put Comments user with valid id
    Given Put update Comments with valid json file and id "<id>"
    When Send request put update Comments
    Then Status code should be 200
    And Put update comment assert json validation
    Examples:
      | id |
      | 1  |
      | 2  |

  @smoke
  Scenario Outline: Put Posts Comments with invalid id
    Given Put update Comments with invalid json file and id "<id>"
    When Send request put update Comments
    Then Status code should be 400
    Examples:
      | id |
      | 1  |

  @smoke
  Scenario Outline: Delete Comment with valid id
    Given Delete Comment with valid id "<id>"
    When Send request delete Comment
    Then Status code should be 200
    Examples:
    |id   |
    |1    |
    |2    |

# actual status code is 200
  Scenario: Delete Comment with invalid id
    Given Delete Comment with invalid id "abababab"
    When Send request delete Comment
    Then Status code should be 404

