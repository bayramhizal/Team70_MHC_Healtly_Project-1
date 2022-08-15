@senturkAll
Feature:Kullanıcının herhangi bir karakter içeren "First Name" yazması gerekir ve boş bırakılamaz


  Background:  anasayfasina giris

    Given User anasayfaya gider
    And Kullanici make an appointment sekmesine tiklar

  @TC_01
  Scenario:TC_01 Kullanici randevu kismindan randevu alabildigini test eder

    Then Kullanici sisteme signIn yapar

    Then Firstname girer


  @TC_02
  Scenario: TC_02 Kullanıcı SSN numarası girmeli (kayıtlı SSN) boş bırakılamaz

    Then SSN no girer


  @TC_03
  Scenario: TC_03 Kullanıcı, herhangi bir karakter içeren "Last Name" yazması gerekir, boş bırakılamaz

    Then Lastname girer

  @TC_04
  Scenario: Kullanıcı, 3. ve 6. rakamdan sonra "-" olan 10 rakamlı telefon numarasını girmeli, boş bırakılamaz

    Then On rakamli telefon no girer
    Then email adresini girer

  @TC_05
  Scenario: Kullanıcı randevu alıp kaydolduğunda, profillerini görebilir ve uygulamada oturum açabilir

    Then Send an appointment Request sekmesini tiklar




    @US_06
    Scenario: Kullanici profil bilgilerini guncelleyebilmeli
    When Sag ustteki profil ismini tiklar
    And Setting kismini secer
      And Kullanici profilini goruntuler
      And Main page gidilir
      And Tiklanir accounta
      And Tiklanir signIn
      And Username ve password girilir ve submite tiklanir
      And Yine Profil accounta tiklanir
      And Setting butonu secilir
      And firstname lastname ve email guncellenir save butonuna tiklanir
      And Save edildi yazisi goruntulendigi teyit edilir

