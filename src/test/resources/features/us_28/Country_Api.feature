Feature: Countries testAPI

  @CountryGet
  Scenario: Countries api with GET request
    Given Kulanici countries icin get request yapar
    And Kullanici gelen countries datayi deserialize eder
    Then Kullanici countries datasini validate eder

    @CountryPost
    Scenario: post request validation
      Given KUllanici countries icin post request yapar
      Then Kullanici post request validation yapar