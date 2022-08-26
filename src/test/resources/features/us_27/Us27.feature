Feature: US27 Messages by Admin Validate with API and DB

 #  Scenario: TC01 Admin, mesaj portalına gidebilir ve tüm mesajları, yazarlarını ve e-postalarını görüntüleyebilir.
 #
 #   Given kullanici Medunna adresine gider
 #   Then Kullanici sing-in sekmesine basar
 #   Then Kullanici Admin olarak giris yapar
 #   And Kullanıcı sayfanın altındakı messages butonuna tıklar
 #   And Kullanıcı mesajlar sayfasının goruntulendıgını kontrol eder
 #
  Scenario: TC02 Admin, mesajları oluşturabilir, güncelleyebilir, silebilir

    Given kullanici Medunna adresine gider
    Then Kullanici sing-in sekmesine basar
    Then Kullanici Admin olarak giris yapar
    Then Kullanıcı sayfanın altındakı messages butonuna tıklar
    And Kullanıcı mesajlar sayfasının goruntulendıgını kontrol eder
    And Kullanici Create a new message butonunu tiklar
    And Kullanici acilan pencerede yeni bir mesaj olusturur ve save butonuna tiklar
    And Kullanici olusturulan mesajin kaydedildigini kontrol eder
    And Kullanıcı olusturdugu mesajin uzerine gelerek viev tusuna basarak mesajin goruntulendigini kontrol eder
    And Kullanici olusturdugu mesajin uzerindeki edit tusuna basarak mesaji guncelleyebilmeli
    And Kullanici olusturdugu mesajin uzerindeki delete tusuna basarak mesaji guncelleyebilmeli





