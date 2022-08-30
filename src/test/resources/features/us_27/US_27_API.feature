
@Regression @E2E
Feature: US27 Messages by Admin Validate with API and DB

  Scenario: TC05 Kullanici, API kullanarak ileti olusturmayi dogrulamalidir

    Given "Admin" message icin URLe post istegi gonderir
    Then Admin Status Code 201 oldugunu dogrular
    And Admin olusturulan message bilgisini kontrol eder

  Scenario: TC06 Kullanici, API kullanarak ileti okumayi dogrulamalidir

    Given "Admin" message icin URLe alma istegi gonderir
    Then Admin Status Code 200 oldugunu dogrular
    And Admin message bilgisini kontrol eder