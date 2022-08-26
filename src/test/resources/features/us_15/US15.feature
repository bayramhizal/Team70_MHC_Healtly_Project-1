
Feature: Admin tarafindan hasta olusturma ve duzenleme

  Background: Siteye gidis
    Given kullanici ana sayfaya gider

  Scenario: Yeni hastalar Yonetici tarafindan olusturulabilir

    Given kullanici sisteme "admin" olarak giris yapar
    And kullanici Item&Title sekmesinden Patient elementine tiklar
    Then kullanici Create a new Patient sekmesinin gorunur oldugunu dogrular
    Then kullanici Create a new Patient sekmesinin erisilebilir oldugunu dogrular
    When kullanici Create a new Patient sekmesine tiklar
    Then kullanici hasta olusturma sayfasina yonlendirildigini dogrular
    And kullanici altta bulunan back butonuna tiklar ve Patient sayfasina doner

  Scenario: Diger kullanicilar tarafindan yeni hasta olusturulamaz

    Given kullanici sisteme "doktor" olarak giris yapar
    Then kullanici yeni hasta kaydinin yapilamadigini dogrular
    And kullanici sisteme "personel" olarak giris yapar
    Then kullanici yeni hasta kaydinin yapilamadigini dogrular
    And kullanici sisteme "hasta" olarak giris yapar
    Then kullanici yeni hasta kaydinin yapilamadigini dogrular

  Scenario: Yonetici Ssn,Firstname,Lastname gibi tum hasta bilgilerini gorebilir

    Given kullanici sisteme "admin" olarak giris yapar
    And kullanici Item&Title sekmesinden Patient elementine tiklar
    When kullanici Patients tablosundaki sutun basliklarini alir
    Then kullanici tum basliklarin gorunur oldugunu dogrular
    And kullanici tum hasta bilgilerini dogrular

  Scenario: Hasta olusturuldugunda ogelere data girisi yapabilmeli





  Scenario: Hasta guncellendiginde ogelere data girisi yapabilmeli