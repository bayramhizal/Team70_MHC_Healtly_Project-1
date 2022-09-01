@US22_TC01
Feature: US22_TC01
  @Regression
  Scenario: US22_TC01 Kullanici (Staff) hastanin SSN id ile arama yapabilir.

    Given kullanici "medunnaUrl" e gider.
    Then kullanici Sign In butonunu bulur ve tiklar
    And Kullanici  Valid username ve Password girerek Staff olarak sisteme girer
    And Kullanici MYPAGES butonu altinda ki Search Patient sekmmesine tiklar
    And Kullanici Patient SSN text box ina guncellemek istedigi hastanin ssn numarasini girer

  @Smoke
  Scenario: US22_TC02 Kullanici (Staff) test sonuclarını gorebilmelidir.

    Given kullanici "medunnaUrl" e gider.
    Then kullanici Sign In butonunu bulur ve tiklar
    And Kullanici  Valid username ve Password girerek Staff olarak sisteme girer
    And Kullanici MYPAGES butonu altinda ki Search Patient sekmmesine tiklar
    And Kullanici Patient SSN text box ina guncellemek istedigi hastanin ssn numarasini girer
    And Kullanici cikan ekranda Show Appointments butonunu tiklar
    And Kullanici show tests butonuna tiklar
    Then kullanici gelen sayfada view results butonuna tiklar

  @Smoke @Regression
  Scenario: US22_TC03 Kullanici (Staff) "ID, Date, Result, description, Created date, ..." gibi sonuc bilgileini gorebilmeli ve
  guncelleyebilmelidir.

    Given kullanici "medunnaUrl" e gider.
    Then kullanici Sign In butonunu bulur ve tiklar
    And Kullanici  Valid username ve Password girerek Staff olarak sisteme girer
    And Kullanici MYPAGES butonu altinda ki Search Patient sekmmesine tiklar
    And Kullanici Patient SSN text box ina guncellemek istedigi hastanin ssn numarasini girer
    And kullanici patientin edit butonuna tiklar
    And kullanici edit sayfasinda oldugunu ve bilgileri guncelleyebilecegini kontrol eder