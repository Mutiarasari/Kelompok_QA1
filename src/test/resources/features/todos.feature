Feature: endpoint /todos

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

  Scenario: Get list todos with valid parameter userId
    Given Get list todo with valid userId "1"
    When Send request get list todos with parameter
    Then Status code should be 200
    And Response body resource list should contain title "delectus aut autem", complete "false"
    And Make sure size array is 20

  Scenario: Get list todos with invalid parameter userId
    Given Get list todo with valid userId "qweqwe"
    When Send request get list todos with parameter
    Then Status code should be 200

  Scenario: Post create todo with valid json file
    Given Post create todo with valid json file
    When Send request post create todo
    Then Status code should be 201
    And Response body resource should contain title "Marvel", complete "false", id 201

  Scenario: Post create todo with valid json file
    Given Post create todo with invalid json file
    When Send request post create todo
    Then Status code should be 500

  Scenario: Delete todo with valid id
    Given Delete todo with valid id "1"
    When Send request delete user
    Then Status code should be 200

  Scenario: Delete todo with invalid id
    Given Delete todo with valid id "qweqwe"
    When Send request delete user
    Then Status code should be 200

  Scenario: Put update todo with valid json file
    Given Put update todo with valid json file and id "1"
    When Send request put update todo
    Then Status code should be 200
    And Response body resource should contain title "Marvel", completed "false"

  Scenario: Put update todo with invalid json file
    Given Put update todo with invalid json file and id "1"
    When Send request put update todo
    Then Status code should be 500

  Scenario: Put update todo with invalid id
    Given Put update todo with valid json file and id "qweqwe"
    When Send request put update user
    Then Status code should be 500