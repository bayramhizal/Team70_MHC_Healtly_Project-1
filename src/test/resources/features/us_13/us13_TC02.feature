@DoktorInpatient
Feature: US13 TC0002

  Background: Doktor Appontments sayfasina gelir
    Given doktor "medunnaUrl" anasayfasindan
    When doktor kullanici resmine tiklar
    Then doktor Sign in butonuna tiklar
    And doktor username ve Password bilgileri ile giris yapar
    And doktor kendi sayfasina giris yaptigini gorur
    And doktor Appointments sayfasina ilerler

  Scenario: TC0002 Doktor Inpatient yazisini gorebilmeli
    And doktor acilan sayfanin Appointments sayfasi oldugunu gorur
    And doktor Appointments sayfasinda "ahm" isimli hastasini gorur
    And doktor test talep edecegi hastanin yaninda bulunan Edit butonunu gorur ve tiklar
    And doktor request Inpatient tusuna tiklar
    And doktor Anew In Patient is created with identifier yazisini gorur
