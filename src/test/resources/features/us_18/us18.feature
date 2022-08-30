@us18
Feature: admin doktor bilgileriyle islem yapar

  Background: Tekrar eden methodlar
    Given kullanici "medunnaUrl" e gider.
    Then kullanici Sign In butonunu bulur ve tiklar
    Then kullanici admin olarak giris yapar
    Then kullanici item&title sekmesinden Physicians sekmesine tiklar

  Scenario: TC_01 Admin, Doktorların bilgilerini gorebilmeli.
    Given kullanici doktorlarin gorunurlugunu kontrol eder


  Scenario: TC_02 Admin, SSN kimligine göre kayıtlı bir kisiyi secebilir/arayabilir.
    Given kullanici bir doktor secer


  Scenario: TC_03 Admin, doktorların bilgilerini Edit butonu ile düzenleyebilir.
    Given kullanici physiciansda edit tusuna basar


  Scenario: TC_04 Kisilerin "firstname, lastname birth date .." bilgileri doldurulabilmeli.
    Given kullanici physiciansda edit tusuna basar
    Then bilgileri doldurabilecegini kontrol eder


  Scenario: TC_05 Admin Doktor icin bir uzmanlık alanı secebilmeli.
    Given kullanici physiciansda edit tusuna basar
    Then Speciality kismindan uzmanlik secer


  Scenario: TC_06 Admin, doktorun profil resmini saglayabilir.
    Given kullanici physiciansda edit tusuna basar
    Then image kismindan fotograf ayarlayabilir


  Scenario: TC_07 Admin, doktorun Muayene ucretini girebilmelidir. (Exam fee)
    Given kullanici physiciansda edit tusuna basar
    Then doktor ucretini degistirebilir


  Scenario: TC_08 Admin mevcut kullanıcılar arasından doktoru seçmelidir.
    Given kullanicilar arasindan doktoru secer


  Scenario: TC_09 Admin mevcut doktorları silebilir.
    Given Physicians listesinde delete butonuna tiklar