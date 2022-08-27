
Feature: Admin tarafindan hasta olusturma ve duzenleme

  Background: Siteye gidis
    Given kullanici ana sayfaya gider

  Scenario: Yeni hastalar Yonetici tarafindan olusturulabilir

    Given kullanici sisteme "adminn" olarak giris yapar
    And kullanici Item&Title sekmesinden Patient elementine tiklar
    Then kullanici Create a new Patient sekmesinin gorunur oldugunu dogrular
    Then kullanici Create a new Patient sekmesinin erisilebilir oldugunu dogrular
    When kullanici Create a new Patient sekmesine tiklar
    Then kullanici hasta olusturma sayfasina yonlendirildigini dogrular
    And kullanici altta bulunan back butonuna tiklar ve Patient sayfasina doner

  Scenario Outline: Diger kullanicilar tarafindan yeni hasta olusturulamaz - NegatifTest

    Given kullanici sisteme "<kullaniciGiris>" olarak giris yapar
    Then kullanici yeni hasta kaydinin yapilamadigini dogrular


    Examples:
      | kullaniciGiris |
       | doktorr |
       | personell |
       | hastaa |


  Scenario: Yonetici Ssn,Firstname,Lastname gibi tum hasta bilgilerini gorebilir

    Given kullanici sisteme "adminn" olarak giris yapar
    And kullanici Item&Title sekmesinden Patient elementine tiklar
    When kullanici "ID" basliginin oldugunu dogrular
    When kullanici "SSN" basliginin oldugunu dogrular
    When kullanici "First Name" basliginin oldugunu dogrular
    When kullanici "Last Name" basliginin oldugunu dogrular
    When kullanici "Birth Date" basliginin oldugunu dogrular
    When kullanici "Phone" basliginin oldugunu dogrular
    When kullanici "Email" basliginin oldugunu dogrular
    When kullanici "Gender" basliginin oldugunu dogrular
    When kullanici "Blood Group" basliginin oldugunu dogrular
    When kullanici "Address" basliginin oldugunu dogrular
    When kullanici "Description" basliginin oldugunu dogrular
    When kullanici "Created Date" basliginin oldugunu dogrular
    When kullanici "User" basliginin oldugunu dogrular
    When kullanici "Country" basliginin oldugunu dogrular
    When kullanici "State/City" basliginin oldugunu dogrular
    Then kullanici tum basliklarin gorunur ve erisilebilir oldugunu dogrular



  Scenario: Hasta olusturuldugunda ogelere data girisi yapabilmeli
    
    Given kullanici sisteme "adminn" olarak giris yapar
    And kullanici Item&Title sekmesinden Patient elementine tiklar
    When kullanici Create a new Patient sekmesine tiklar
    And kullanici hasta first name kutucugunu doldurur
    And kullanici hasta last name kutucugunu doldurur
    And kullanici hasta birth date kutucugunu doldurur
    And kullanici hasta email kutucugunu doldurur
    And kullanici hasta phone kutucugunu doldurur
    And kullanici hasta gender dropdown menusunden cinsiyet secer
    And kullanici hasta blood group dropdown menusunden kan grubu secer
    And kullanici hasta address kutucugunu doldurur
    And kullanici hasta description kutucugunu doldurur
    And kullanici hasta user dropdown menusunden kullanici secer
    And kullanici hasta country dropdown menusunden ulke secer
    And kullanici hasta state dropdown menusunden sehir secer
    Then kullanici edit a Patient sayfasinda Save butonuna basar
    Then kullanici A Patient is created yazisinin goruldugunu dogrular

  Scenario: Hasta guncellendiginde ogelere data girisi yapabilmeli

    Given kullanici sisteme "adminn" olarak giris yapar
    And kullanici Item&Title sekmesinden Patient elementine tiklar
    When kullanici Patients tablosundaki hastanin Edit butonuna tiklar
    And kullanici hasta first name kutucugunu doldurur
    And kullanici hasta last name kutucugunu doldurur
    And kullanici hasta birth date kutucugunu doldurur
    And kullanici hasta email kutucugunu doldurur
    And kullanici hasta phone kutucugunu doldurur
    And kullanici hasta gender dropdown menusunden cinsiyet secer
    And kullanici hasta blood group dropdown menusunden kan grubu secer
    And kullanici hasta address kutucugunu doldurur
    And kullanici hasta description kutucugunu doldurur
    And kullanici hasta user dropdown menusunden kullanici secer
    And kullanici hasta country dropdown menusunden ulke secer
    And kullanici hasta state dropdown menusunden sehir secer
    Then kullanici edit a Patient sayfasinda Save butonuna basar
    Then kullanici A Patient is updated yazisinin goruldugunu dogrular


    Scenario: Hastaya doktoru sadece Admin atayabilir

      Given kullanici sisteme "adminn" olarak giris yapar
      And kullanici Item&Title sekmesinden Patient elementine tiklar
      When kullanici Patients tablosundaki hastanin Edit butonuna tiklar
      Then kullanici doktor atama sekmesini bulur ve Adminin doktor atamasi yapabildigini test eder


    Scenario:  "State", "US state" olmali ve bos birakilmamali




    Scenario: "State", "US state" olmali ve bos birakilmamali - NegatifTest





     Scenario: Yonetici herhangi bir hastayi silebilir


















