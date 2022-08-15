@adem2
Feature: US_04 Giriş sayfası yalnızca geçerli kimlik bilgileriyle erişilebilir olmalıdır.

  Background:Tekrar eden methodlar
    Given kullanici "medunnaUrl" e gider.
    And Kullanıcı User iconuna tıklar
    And Kullanıcı Sign In butonuna tıklar

  Scenario: TC_01 Giriş yapmak için başarı mesajını doğrulayan, geçerli bir kullanıcı adı ve şifre olmalıdır.
    Given Kullanıcı Username box a kullanıcı adı girer
    And Kullanıcı Password box a password girer
    And Kullanici Sign In butonuna gider ve tiklar
    And Kullanıcı WELCOME TO MEDUNNA mesajını gorur


  Scenario: TC_02 Kullanıcının mevcut kimlik bilgilerini her zaman kullanabileceği bir beni hatırla seçeneği olmalıdır
    Given Remember me sekmesi gorunur olmalidir
    And Remember me secilebilir olmalidir


  Scenario: TC_03 Eğer şifre unutulursa diye "Did you forget your password?" seçeneği olmalı
    Given Did you forget your password" gorunur olmalıdır
    Then Remember me tıklanabilir olmalidir
    And Reset your password sayfasi gorunur olmalıdır


  Scenario: TC_04 "You don't have an account yet? Register a new account" seçeneği olmalı
    Given You don't have an account yet? Register a new account gorunur olmalıdır
    Then Register a new account tıklanabilir olmalidir
    Then Registration sayfası gorunur olmalıdır

  Scenario: TC_05 "Cancel" seçeneği olmalı
    Given Cancel gorunur olmalıdır
    And Cancel erisilebilir olmalidir
    And MEDUNNA  page donuldugu dogrulanir olmalidir.