
Feature: US09 US09 Staff hasta bilgilerini gorebilmeli, duzenleyebilmeli ve silebilmelidir

  Scenario: Kullanicinin DB'den gelen tum hasta bilgilerini dogrulamalidir
    Given Kullanici Medunna veri tabanina baglanir
    Then Kullanici "patient" tablosundaki verileri alir
    And Kullanici "patient" tablosundaki hastalari dogrular

