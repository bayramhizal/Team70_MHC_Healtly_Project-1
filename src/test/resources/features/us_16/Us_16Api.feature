Feature:test api


  @RoomGet
  Scenario:Rooms api with GET request / Room api testi
    Given kullanici roomlar icin get request yapar
    And kullanici gelen room datayi deserialize eder
    Then kullanici room datasini validate eder


  @RoomPost
  Scenario:Rooms api with POST request
    Given kullanici roomlar icin post request yapar
    Then kullanici post request validation yapar


  @RoomPut
  Scenario:Rooms api with PUT request
    Given kullanici roomlar icin put request yapar
    Then kullanici put request validation yapar

  @RoomDelete
  Scenario Outline:delete rooms
    Given kullanici delete request yapar "<id>"
    Then delete validation

    Examples:test data
      |id|
      |237159|