
@E2E
Feature: Kayit olmak için SSN, Firstname ve Lastname bilgileri girilebilmelidir.



  Scenario: US01_TC05 Swagger kullanarak tum kayit bilgilerini alin ve dogrulayin

    Given kullanici get islemi icin Medunna URLi olusturur
#    And kullanici request gonderir ve response datasi olusturur
#    Then kullanici responsedan gelen status codun 200 ve content tipin Json oldugunu dogrular
#    Then kullanici gelen data icindeki registrant bilgilerini dogrular




  Scenario: US01_TC06 API kullanarak kayitli kisiler olusturun ve dogrulayin

    Given kullanici post islemi icin Medunna Urli olusturur
    And kullanici kayitli kisi olusturmak icin body ile expected data olusturur
    When kullanici post request yapar
    And kullanici response alir
    Then kullanici post edilen kisinin kayit oldugunu dogrular