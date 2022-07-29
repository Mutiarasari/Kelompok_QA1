Feature: endpoint /users

  @dhandy
  Scenario: Get list user with valid endpoint
    Given Get list users
    When Send request get list users with valid endpoint
    Then Status code should be 200
    And Make sure size array is 10

  @dhandy
  Scenario: Get list user with invalid endpoint
    Given Get list users
    When Send request get list users with invalid endpoint
    Then Status code should be 404

  @dhandy
  Scenario Outline: Get single user with valid id
    Given Get single user with id "<id>"
    When Send request get single user
    Then Status code should be 200
    And Response body resource should contain name "<name>" and email "<email>"
    And Get single user assert json validation
    Examples:
    |id   |name           |email              |
    |1    |Leanne Graham  |Sincere@april.biz  |
    |2    |Ervin Howell   |Shanna@melissa.tv  |

  @dhandy
  Scenario: Get single user with invalid id
    Given Get single user with id "asdasd"
    When Send request get single user
    Then Status code should be 404

  @dhandy
  Scenario: Post create user with valid json file
    Given Post create user with valid json file
    When Send request post create user
    Then Status code should be 201
    And Response body resource should contain name "Dhandy", email "dhan@gmail.com", phone "12312312"
    And Post create user assert json validation

  @dhandy
  Scenario: Post create user with invalid json file
    Given Post create user with invalid json file
    When Send request post create user
    Then Status code should be 400

  @dhandy
  Scenario Outline: Put update user with valid json file
    Given Put update user with valid json file and id "<id>"
    When Send request put update user
    Then Status code should be 200
    And Response body resource should contain name "<name>", email "<email>", phone "<phone>", id <id>
    And Put update user assert json validation
    Examples:
      |id   |name         |email            |phone    |
      |1    |Manuel Neuer |neuer@gmail.com  |123123   |

  @dhandy
  Scenario Outline: Put update user with invalid json file
    Given Put update user with invalid json file and id "<id>"
    When Send request put update user
    Then Status code should be 400
    Examples:
      |id   |
      |1    |

  @dhandy
  Scenario Outline: Put update user with invalid id
    Given Put update user with valid json file and id "<id>"
    When Send request put update user
    Then Status code should be 404
    Examples:
      |id         |
      |qweqwe     |

  @dhandy
  Scenario Outline: Delete user with valid id
    Given Delete user with valid id "<id>"
    When Send request delete user
    Then Status code should be 200
    Examples:
      |id     |
      |1      |
      |2      |

# status should be 404, but the actual response status code is 200
  @dhandy
  Scenario Outline: Delete user with invalid id
    Given Delete user with invalid id "<id>"
    When Send request delete user
    Then Status code should be 404
    Examples:
      |id     |
      |1      |
      |2      |
