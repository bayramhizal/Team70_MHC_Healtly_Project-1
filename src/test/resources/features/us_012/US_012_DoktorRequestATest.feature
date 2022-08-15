@Doctor
Feature: User Story 012 Doktor test Isteyebilmeli

  Background: Doktor Appontments sayfasina gelir
    Given doktor "medunnaUrl" anasayfasindan
    When doktor kullanici resmine tiklar
    Then doktor Sign in butonuna tiklar
    And doktor username ve Password bilgileri ile giris yapar
    And doktor kendi sayfasina giris yaptigini gorur
    And doktor Appointments sayfasina ilerler

  Scenario: TC001 Doktor test isteyebilmeli
    And doktor acilan sayfanin Appointments sayfasi oldugunu gorur
    And doktor Appointments sayfasinda "ahm" isimli hastasini gorur
    And doktor test talep edecegi hastanin yaninda bulunan Edit butonunu gorur ve tiklar
    And doktor Request A Test yazan yesil kutucugu gorur ve tiklar
    And doktor acilan sayfanin Test Items sayfasi oldugunu gorur

  Scenario: TC002 Doktor Glucose, Urea, Creatinine, Sodium,Potassium, Total protein, Albumin ve Hemoglobin test seceneklerini gorur
    And doktor test talep edecegi hastanin yaninda bulunan Edit butonunu gorur ve tiklar
    And doktor Request A Test yazan yesil kutucugu gorur ve tiklar
    And doktor Test Items sayfasinda tum test isimlerinin listesini gorur
    And Doktor test secenekleri arasinda "Glucose" gorur ve secebilir
    And Doktor test secenekleri arasinda "Urea" gorur ve secebilir
    And Doktor test secenekleri arasinda "Creatinine" gorur ve secebilir
    And Doktor test secenekleri arasinda "Sodium" gorur ve secebilir
    And Doktor test secenekleri arasinda "Potassium" gorur ve secebilir
    And Doktor test secenekleri arasinda "Total protein" gorur ve secebilir
    And Doktor test secenekleri arasinda "Albumin" gorur ve secebilir
    And Doktor test secenekleri arasinda "Hemoglobin" gorur ve secebilir
    And doktor kendi isminin oldugu yeri gorur ve tiklar daha sonra da Sign out butonuna tiklar







