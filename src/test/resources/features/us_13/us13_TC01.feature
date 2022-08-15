@DoktorViewResult
Feature: US13 TC0001

  Background: Doktor Appontments sayfasina gelir
    Given doktor "medunnaUrl" anasayfasindan
    When doktor kullanici resmine tiklar
    Then doktor Sign in butonuna tiklar
    And doktor username ve Password bilgileri ile giris yapar
    And doktor kendi sayfasina giris yaptigini gorur
    And doktor Appointments sayfasina ilerler

  Scenario: TC0001 Doktor test result gorebilmeli
    And doktor acilan sayfanin Appointments sayfasi oldugunu gorur
    And doktor Appointments sayfasinda "ahm" isimli hastasini gorur
    And doktor test talep edecegi hastanin yaninda bulunan Edit butonunu gorur ve tiklar
    And doktor Show Test Results butonuna tiklar
    And doktor View Results butonuna tiklar
    And doktor test bilgilerini gorur





