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
    Then Status code should be 400
    Examples:
      | id |
      | 2  |

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
    Then Status code should be 400
    Examples:
      | id |
      | 2  |


