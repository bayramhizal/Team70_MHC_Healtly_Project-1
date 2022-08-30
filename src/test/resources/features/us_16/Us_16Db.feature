@Regression @E2E
Feature:US_016 TC11 Database Testi

  @db16
  Scenario:Kullanici database ile oda bilgilerini dogrulayabilir


    Given kullanici room database ile baglanti kurar
    When kullanici room query tanimlar
    Then kullanici oda bilgilerini gorebilmeli