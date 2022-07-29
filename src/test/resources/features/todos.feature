Feature: endpoint /todos

  Scenario: Get list todos with valid endpoint
    Given Get list todos with valid endpoint
    When Send request get list todos
    Then Status code should be 200
    And Response body resource list should contain title "delectus aut autem", complete "false"
    And Make sure size array is 200

  @smoke
  Scenario Outline: Get single todo with valid id
    Given Get single todo with valid id "<id>"
    When Send request get single todo
    Then Status code should be 200
    And Response body single should contain title "<title>", complete "<complete>"
    And Get single todo assert json validation
    Examples:
    |id   |title                              |complete   |
    |1    |delectus aut autem                 |false      |
    |2    |quis ut nam facilis et officia qui |false      |

  Scenario: Get single todo with invalid id
    Given Get single todo with invalid id "qfrvvrv"
    When Send request get single todo
    Then Status code should be 404

  @smoke
  Scenario Outline: Get list todos with valid parameter userId
    Given Get list todo with valid userId "<id>"
    When Send request get list todos with parameter
    Then Status code should be 200
    And Response body resource list should contain title "<title>", complete "<complete>"
    And Make sure size array is 20
    Examples:
    |id     |title                                                |complete   |
    |1      |delectus aut autem                                   |false      |
    |2      |suscipit repellat esse quibusdam voluptatem incidunt |false      |

# actual status code is 200
  Scenario: Get list todos with invalid parameter userId
    Given Get list todo with valid userId "qweqwe"
    When Send request get list todos with parameter
    Then Status code should be 404

  @smoke
  Scenario: Post create todo with valid json file
    Given Post create todo with valid json file
    When Send request post create todo
    Then Status code should be 201
    And Response body should contain title "Marvel", complete "false", id 201
    And Post create todo assert json validation

  Scenario: Post create todo with valid json file
    Given Post create todo with invalid json file
    When Send request post create todo
    Then Status code should be 400

  @smoke
  Scenario: Delete todo with valid id
    Given Delete todo with valid id "1"
    When Send request delete user
    Then Status code should be 200

# actual status code is 200
  Scenario: Delete todo with invalid id
    Given Delete todo with valid id "qweqwe"
    When Send request delete user
    Then Status code should be 404

  @smoke
  Scenario: Put update todo with valid json file
    Given Put update todo with valid json file and id "1"
    When Send request put update todo
    Then Status code should be 200
    And Response body resource should contain title "Marvel", completed "false"
    And Put update todo assert json validation

  Scenario: Put update todo with invalid json file
    Given Put update todo with invalid json file and id "1"
    When Send request put update todo
    Then Status code should be 400

  @smoke
  Scenario: Put update todo with invalid id
    Given Put update todo with valid json file and id "qweqwe"
    When Send request put update user
    Then Status code should be 404