@Smoke_Test
Feature: US_04 Giris sayfasi yalnizca gecerli kimlik bilgileriyle erisilebilir olmalidir.

  Background:Tekrar eden methodlar
    Given kullanici "medunnaUrl" e gider.
    And Kullanici User iconuna tiklar
    And Kullanici Sign In butonuna tiklar

  Scenario: TC_01 Giris yapmak icin basari mesajini dogrulayan, gecerli bir kullanici adi ve sifre olmalidir.
    Given Kullanici Username box a kullanici adi girer
    And Kullanici Password box a password girer
    And Kullanici Sign In butonuna gider ve tiklar
    And Kullanici WELCOME TO MEDUNNA mesajini gorur


  Scenario: TC_02 Kullanicinin mevcut kimlik bilgilerini her zaman kullanabilecegi bir beni hatirla secenegi olmalidir
    Given Remember me sekmesi gorunur olmalidir
    And Remember me secilebilir olmalidir


  Scenario: TC_03 Eger sifre unutulursa diye "Did you forget your password?" secenegi olmali
    Given Did you forget your password" gorunur olmalidir
    Then Remember me tiklanabilir olmalidir
    And Reset your password sayfasi gorunur olmalidir


  Scenario: TC_04 "You don't have an account yet? Register a new account" secenegi olmali
    Given You don't have an account yet? Register a new account gorunur olmalidir
    Then Register a new account tiklanabilir olmalidir
    Then Registration sayfasi gorunur olmalidir

  Scenario: TC_05 "Cancel" secenegi olmali
    Given Cancel gorunur olmalidir
    And Cancel erisilebilir olmalidir
    And MEDUNNA  page donuldugu dogrulanir olmalidir.