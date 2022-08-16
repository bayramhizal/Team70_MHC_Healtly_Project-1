Feature: DB ile Sorgulama


  @dbsm
  Scenario: DB ile SSN kimlikleri dogrulanir

    Given kullanici database baglanir
    And kullanici SSN kimliklerini alir
    Then kullanici SSN kimliklerini dogrular



  Scenario: Email DB ile dogrulanir

    Given kullanici database baglanir
    And kullanici Email verilerini alir
    Then kullanici Email verilerini dogrular