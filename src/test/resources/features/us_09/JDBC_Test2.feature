Feature: US1004 Kullanici istenen tablodaki istenen field'i listeleyebilir

  Scenario: TC04 Kullanici field listesi yazdirabilmeli

    Given kullanici DBUtils ile HMC veri tabanina baglanir
    And kullanici DBUtils ile  "tHOTEL" tablosundaki "Email" verilerini alir
    And kullanici DBUtils ile  "Email" sutunundaki verileri okur
    And DBUtil ile tum "Email" degerlerini sira numarasi ile yazdirir
