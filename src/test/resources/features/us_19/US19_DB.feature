

Feature: Admin tarafindan silinen Staff kayitlarini DB  ile dogrulama

  Scenario: DB ile dogrulama

Given Kullanici Medunna veri tabanina baglanir
Then Kullanici Staff tablosundaki verilerini alir
And Staff tablosunda silinen "staff" bilgisini kontrol eder