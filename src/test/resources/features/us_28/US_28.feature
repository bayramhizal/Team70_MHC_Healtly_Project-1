Feature: Kullanici ulke olusturabilmeli ve bunu API ile dogrulayabilmeli

  Background: Kullanici sayfasina giris
    Given Kullanici anasayfaya gider
    When Accounta gider tiklar
    And Birinci SIgnIn e tiklar
    And Username ve password girer
    And SignIn e tiklar


  @A1
  Scenario:Kullanici yeni bir ulke olusturabilmeli

    Given Items Title tiklar
    When Country e tiklar
    And Create butonuna tiklar
    And Ulke name girer
    And Save tiklar
    Then Kayit oldugunu gosterir


  @A2
  Scenario: Kullanici, ulkeye gore ilgili eyaletler veya sehirler olusturabilmelidir

    Given Kull Ikinci Items Title gider
    When Kull State_City tiklar
    And Kull Create a new state_city
    And Kull Save butonuna tiklar
    And Kull Kayit yapildigini dogrular