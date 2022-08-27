

Feature: Admin olarak;Yeni Staff (Personel) Olusturma / Guncelleme / Goruntuleme ve Silme


  Scenario: TC05 Admin tarafindan silinen Staff kayitlarini API ile dogrulama

    Given Admin herhangi bir staff bilgisini alir
    Then Admin URL'e silme istegi gonderir
    Then "Admin" Status Code 200 oldugunu dogrular
    And Admin silinen Staff bilgisini kontrol eder
