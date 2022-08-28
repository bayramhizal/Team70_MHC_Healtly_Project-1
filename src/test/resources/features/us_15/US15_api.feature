

Feature: Admin tarafindan hasta olusturma ve duzenleme

  Scenario: API ile hasta bilgilerini dogrulayin

    Given Admin hasta POST islemi icin endpointi olusturur
    When Admin hasta POST islemi icin expected data olusturur
    And Admin POST request islemi yapar ve response alir
    Then Admin status kodunun 201 oldugunu dogrular
    Then Admin POST expected data ile actual datanin ayni oldugunu dogrular
    Then Admin ID no ile GET yaparak olusturdugu hastayi gorur ve 200 Status kodunu alir
    And Admin ID no ile PUT yaparak olusturdugu hastayi gunceller ve 200 Status kodunu alir
    And Admin olusturdugu hastayi siler ve 204 kodu ile silindigini dogrular