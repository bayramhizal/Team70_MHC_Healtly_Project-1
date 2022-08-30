@Regression
Feature: US26 İletişim Mesajı (Contact messages)

  Scenario: TC01 Herhangi bir kullanıcı bilgi almak için "Contact portal" üzerinden istek gönderebilmeli

    Given kullanici Medunna adresine gider
    Then contact portalina tiklar
    And Contact sayfasinin acildigini goruntuler



  Scenario: TC02 Kullanıcı "Name, Email, Subject, Message" bölümlerine data girebilmeli ve mesajını gönderebilmeli

    Given kullanici Medunna adresine gider
    Then contact portalina tiklar
    And Contact sayfasinin acildigini goruntuler
    And Name, Email, Subject, Message bölümlerini doldurur
    And send tusuna basar