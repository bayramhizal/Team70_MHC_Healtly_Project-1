Feature: US_021 Staff hastalar için randevuları görür

  Background:US_021 Tekrar eden methodlar
    Given kullanici "medunnaUrl" e gider.
    Then kullanici Sign In butonunu bulur ve tiklar
    And Kullanici  Valid username ve Password girerek Staff olarak sisteme girer
    And Kullanici MYPAGES butonu altinda ki Search Patient sekmmesine tiklar
    And Kullanici Patient SSN text box ina guncellemek istedigi hastanin ssn numarasini girer
    And Kullanici cikan ekranda Show Appointments butonunu tiklar
    And Kullanici tekrar Edit butonuna tiklar


  Scenario:TC_01 Staff sadece randevuları güncelleyebilir.
    Given Kullanici Start date guncelleyebilir
    Then kullanici End date guncelleyebilir