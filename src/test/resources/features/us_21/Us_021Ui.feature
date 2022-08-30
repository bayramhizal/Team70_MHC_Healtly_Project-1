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
    And Start yil ve End yil "2022"den buyuk olmamali

  Scenario: TC_02 Staff hasta durumunu (status) "UNAPPROVED, PENDING veya CANCELLED" yapabilmeli ancak "COMPLETED" yapamamalı.
    Given Kullanici Status secenegini bulup butun opsiyonlari secebilmeli
    Then  Kullanici Saved butonuna basip,secilen statunun basariyla degistirildigini gormelidir
    Then Kullanici COMPLETED opsiyonu secememeli

  Scenario: TC_03 Staff "Anamnesis (Hastalık Geçmişi), Treatment ( Tedavi) veya Diagnosis(Teşhis)" kısımlarına
    Given Kullanici Anamnesis alanina "Veri" girisi yapip yapamadigi test edebilmeli
    Then  Kullanici Treatment alannina "Veri" girisi yapip yapamadigi test edebilmeli
    Then Kullanici Diagnosis alanina "Veri" girisi yapip yapamadigi test edebilmeli

  Scenario: TC_04 Hasta için gerekli doktoru seçebilmeli ve randevuyu oluşturmalı.
    Given Kullanici gerekli doktoru secer
    Then Saved butonuna tiklar
    And kullanici guncellemenin basarili oldugunu gorur


