@E2E
Feature: US_017 Admin API ile Test Items olusturabilmeli

  Scenario Outline: TC_03, 05, 06, 07  Admin API kullanarak POST, GET, PUT ve DELETE requestlerini test eder
    Given Admin Test Item icin gerekli parametreleri set eder
    Then Admin expected Datalari set eder "<name>", "<description>", <price>, "<defMinVal>", "<defMaxVal>"
    And Admin post request talep eder ve 201 Status kodunu dogrular
    And Admin expected data ile actual datanin ayni oldugunu dogrular
    Then Admin Id no ile GET yaparak olusturdugu Test Item'i gorur ve 200 Status kodunu alir
    And Admin Id no ile PUT yaparak olusturdugu Test Item'i gunceller ve 200 Status kodunu alir
    And Admin olusturdugu Test Itemi siler ve 204 kodu ile silindigini dogrular

    Examples: test data
      | name        | description      | price | defMinVal | defMaxVal |
      | ZuckerValue | letzte drei Tage | 785   | 30        | 130       |


