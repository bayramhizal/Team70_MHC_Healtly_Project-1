@api09
Feature: US09 Staff hasta bilgilerini gorebilmeli, duzenleyebilmeli ve silebilmelidir

  Scenario: TC04 Admin, API kullanarak tum hasta bilgilerini dogrulamalidir.
    Given "Admin" URLe alma istegi gonderir
    Then "Admin" Status Code 200 oldugunu dogrular
    And Admin Hasta kayitlarini kontrol eder

  Scenario: TC05 Staff API kullanarak tum hasta bilgilerini dogrulamalidir.
    Given "Staff" URLe alma istegi gonderir
    Then "Staff" Status Code 200 oldugunu dogrular
    And Staff Hasta kayitlarini kontrol eder

  Scenario: TC07 Admin herhangi bir hasta bilgisini silebilir.
    Given "Admin" URLe silme istegi gonderir.
    Then "Admin" Status Code 200 oldugunu dogrular
    And Admin Hastanin silindigini kontol eder kontrol eder


  Scenario: TC08 Admin herhangi bir hasta bilgisini silebilir.

    Given "Staff" URLe silme istegi gonderir.
    Then "Staff" Status Code 401 oldugunu dogrular

  Scenario: TC09 Staff, hastaları SSN kimliklerine göre arayabilir.

    Given "Staff" URLe arama istegi gonderir
    Then  "Staff" Status Code 200 oldugunu dogrular
    And Staff SSN kayitlarini kontorl eder

  Scenario: TC10 Admin, hastaları SSN kimliklerine göre arayamaz.
  Given
    Then  "Admin" Status Code 200 oldugunu dogrular