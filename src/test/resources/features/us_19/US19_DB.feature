
@Regression @E2E
Feature: Admin tarafindan silinen Staff kayitlarini DB  ile dogrulama

  Scenario Outline: DB ile dogrulama

  Given Kullanici Medunna veri tabanina baglanir
  Then Kullanici "staff" tablosundaki verilerini alir
  And  staff tablosunda silinen "<id>" bilgisini kontrol eder
  And Baglantiyi sonlandir


    Examples:

      |id    |
      |214867|








