Feature: Put method request

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

