

Feature: US19 Admin olarak;Yeni Staff (Personel) Oluşturma / Güncelleme / Görüntüleme ve Silme

  Background:Tekrar eden methodlar

    Given kullanici Medunna adresine gider
    Then Kullanici sing-in sekmesine basar
    And Kullanici Admin olarak giris yapar
    And Kullanici Item and Titles den "Staff" secimi yapar


@arif1
  Scenario: TC01 Admin SSN kullanarak; kayıtlı kişiler arasında Staff arayabilir ve tumbilgileri dogrular.


    And Kullanici Create a new Staff butonuna basar
    And Kullanici Acilan sayfada SSN kutusuna gecerli staff "SSN" bilgisini girer
    And Kullanici "Use Search" secimi yapar ve "Search User" butonuna basar
    And Kullanici "User found with search SSN" mesajini gorur
    And Kullanici girmis oldugu SSN bilgisine gore "Staff" bilgilerini dogrular



  Scenario: TC02 Admin kayitli kisilerden bir kullanici secebilir


    And Kullanici acilan sayfada herhangi bir kullaniciyi goruntuler
    And Kullanici acilan sayfanin "Staff" sayfasi oldugunu gorur


  Scenario: TC03 Admin kayıtlı kisilerden bir kullanıcı bilgilerini duzenleyebilir.


    And Kullanici acilan sayfada herhangi bir kullanici icin "edit" butonuna basar
    And Kullanici Staff bilgilerini gunceller ve "Save" tusuna basar
    And Acilan pencerede "A Staff is updated with identifier" uyarisini gorur


  Scenario: TC04 Admin kullanıcı bilgilerini silebilir.

    And Kullanici acilan sayfada herhangi bir kullanici icin "delete" butonuna basar
    And Acilan pencerede "A Staff is deleted with identifier" uyarisini gorur
