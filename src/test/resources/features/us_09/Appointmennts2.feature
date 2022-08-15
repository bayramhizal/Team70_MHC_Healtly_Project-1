Feature: appointments test eder

  Scenario:  appointmenst data read

    Given kullanici appointments icin get request yapar
    Then kullanici appointments bilgilerini deserialize eder
    Then kullanici appointments bilgilerini validate eder