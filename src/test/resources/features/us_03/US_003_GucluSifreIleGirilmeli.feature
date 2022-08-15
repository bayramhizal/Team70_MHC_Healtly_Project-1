
@Smoketest
Feature: User Story 003 Registration sayfasında güçlü şifre girilmeli ve "Password strength" seviyeleri görülebilmelidir.

  Scenario: TC01 Girilen farkli password karakter turlerine gore; "Password Strength" seviyesindeki degisimler gorulmelidir
    Given kullanici ana sayfaya gider
    When kullanici registration icin resme tiklar
    Then kullanici register butonuna tiklar
    And Kullanici new Password kutusuna Tiklar
    And Kullanici en az yedi karakter uzunlugunda sadece kucuk harf iceren "asdfghj" sifre girer
    And Kullanıcı  Password strength seviyesinin degismedigini gorur
    And Kullanıcı New Password kutusundaki eski sifreyi siler
   Then Kullanici onceki girdigi sifreyi icerisinde bir buyuk harf olacak sekilde degistirir "Asdfghj" ve yeniden girer
    And Kullanıcı Password strength seviyesinin iki turuncu cizgiye yukseldigini görür.
    And Kullanıcı New Password kutusundaki eski sifreyi siler
    Then Kullanici bu defa onceki  girdigi sifreyi, icerisinde bir buyuk harf ve rakam olacak sekilde degistirir "A1sdfgh" ve yeniden girer
    And Kullanıcı Password strength seviyesinin dort yesil cizgiye yukseldigini görür.
    And Kullanıcı New Password kutusundaki eski sifreyi siler
    Then Kullanici onceki  girdigi sifreyi, icerisinde bir buyuk harf , rakam ve ozel karakter olacak sekilde degistirir "A1*sdfg" ve yeniden girer
    And Kullanıcı Guclu sifre yani Password strength seviyesinin max. bes cizgi ve yesil oldugunu gorur









