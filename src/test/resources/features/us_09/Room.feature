Feature: test api


  @RoomGet
  Scenario: Rommlar icin Get Api testi

    Given kullanici roomlar icin get request yapar
    And kullanici gelen room datayi deserialize eder
    Then kullanici room datasini validate eder



  @RoomPost
  Scenario: post request validation

    Given kullanici roomlar icin post request yapar
    Then  kullanici post request validation yapar

    @PutRequest

    Scenario: put request roomlar icin

      Given  kullanici roomlar icin put request yapar
      Then kullanici put request validation yapar


      @deleteRequest

      Scenario Outline: delete rooms

        Given kullanici Delete request eder "<id>"
        Then delete validation

        Examples: test data (ids)

          |id|
          |180673|
