Feature: Kullanici ulke olusturabilmeli ve bunu API ile dogrulayabilmeli

  @A1
  Scenario:Kullanici yeni bir ulke olusturabilmeli

    Given Kullanici anasayfaya gider
    When Acocounta gider tiklar
    And Birinci SIgnIn e tiklar
    And Username ve password girer
    And Ikinci SignIn e tiklar
    And Items Title tiklar
    And Country e tiklar
    And Create butonuna tiklar
    And Ulke name girer
    And Save tiklar
    Then Kayit oldugunu gosterir