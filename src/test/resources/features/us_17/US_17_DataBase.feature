@E2E
Feature: US017 ADMIN Test items(öğe) Oluştur, gunceller ve siler

Background: TAdmin Data Base testi icin API kullanarak Test Item olusturur ve Database'de dogrular
  Given Admin Test Item icin gerekli parametreleri set eder
  Then Admin expected Datalari set eder "Zucker", "fur DataBase", 550, "210", "340"
  And Admin post request talep eder ve 201 Status kodunu dogrular
  And Admin expected data ile actual datanin ayni oldugunu dogrular

  Scenario: TC_04 Admin API ile olusturdugu Test Item'i Data Base'de dogrular
    Given Admin Medunna veri tabanina baglanir
    Then Admin "c_test_item" tablosundaki verileri alir
    And Admin Test Item tablosundaki olusturdugu testi dogrular
    And Admin olusturdugu Test Itemi siler ve 204 kodu ile silindigini dogrular


