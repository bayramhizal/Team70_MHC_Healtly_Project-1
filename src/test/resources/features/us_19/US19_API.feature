
@Regression @E2E
Feature: Admin olarak;Yeni Staff (Personel) Olusturma / Guncelleme / Goruntuleme ve Silme


  Scenario: TC05 Admin tarafindan silinen Staff kayitlarini API ile dogrulama

    Given Admin herhangi bir staff bilgisini alir
    Then Admin URL'e silme istegi gonderir
    Then Admin Status Code 204 oldugunu dogrular

