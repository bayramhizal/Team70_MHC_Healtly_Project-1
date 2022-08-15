@senturkAll
Feature:Kullanıcının herhangi bir karakter içeren "First Name" yazması gerekir ve boş bırakılamaz


  Background:  anasayfasina giris

    Given kullanici ana sayfasina girer
    And Kullanici make an appointment sekmesine tiklar

  @TC_01
  Scenario:TC_01 Kullanici randevu kismindan randevu alabildigini test eder

    Then Kullanici randevu alinan kisma tiklayarak giris yapilabilmeli

    Then KUllanici herhangi bir karakterle first name girer


  @TC_02
  Scenario: TC_02 Kullanıcı SSN numarası girmeli (kayıtlı SSN) boş bırakılamaz

    Then Kullanici_SSN_numarasi_girmeli


  @TC_03
  Scenario: TC_03 Kullanıcı, herhangi bir karakter içeren "Last Name" yazması gerekir, boş bırakılamaz

    Then Kullanici_herhangi_karakter_iceren_lastName_girmeli

  @TC_04
  Scenario: Kullanıcı, 3. ve 6. rakamdan sonra "-" olan 10 rakamlı telefon numarasını girmeli, boş bırakılamaz

    Then Kullanici_ucuncu_ve_altinci_rakamdan_sonra_-_olan_on_rakamli_tel_no_girer

  @TC_05
  Scenario: Kullanıcı randevu alıp kaydolduğunda, profillerini görebilir ve uygulamada oturum açabilir

    Then Kullanici randevu alip kaydoldugunda profilini gorebilir
    Then Kullanici uygulamada oturum acabilir


