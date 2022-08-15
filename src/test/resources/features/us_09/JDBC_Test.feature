Feature: US1003 Kullanici DBUtill ile istenen degeri test eder


  Scenario: TC03 Kullanici istenen degeri test edebilmeli

    Given kullanici DBUtils ile HMC veri tabanina baglanir
    And kullanici DBUtils ile  "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici DBUtils ile  "Price" sutunundaki verileri okur
    Then DBUtill ile 2. "Price" in 4000 oldugunu test eder