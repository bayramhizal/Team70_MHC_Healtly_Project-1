

Feature: Get Cucumber Projesi

  Scenario: US08_TC01 "New password confirmation" onaylanabilmeli
    Given Hasta medunna ana sayfasina gider
    Then Hasta sag ust kosedeki kullanici ikonunu tiklar
    And Hasta ikonu altinda Sign in sekmesine tiklar
    Then Hasta textbox a  kullanici adini girer
    And Hasta Password textbox a sifresini girer
    And Hasta Sign in butonuna tiklar
    And Hasta tekrar kullanici ikonuna tiklar
    And Hasta kullanici ikonun altinda Password sekmesine tiklar
    Then Hasta Current password textbox a mevcut passwordu girer
    And Hasta New password textbox a  yeni passwordu girer
    And Hasta New password confirmation textbox ina yeni passwordunu girer
    Then Hasta herhangi bir uyari yazisi almaz

  Scenario: US08_TC02 Güclü bir parola icin sifre en az 7 karakterden olusmalidir ve en az bir tane kücükharf, büyük harf , rakam ve özel karakter icermelidir.
    Given Hasta medunna ana sayfasina gider
    Then Hasta sag ust kosedeki kullanici ikonunu tiklar
    And Hasta ikonu altinda Sign in sekmesine tiklar
    Then Hasta textbox a  kullanici adini girer
    And Hasta Password textbox a sifresini girer
    And Hasta Sign in butonuna tiklar
    And Hasta tekrar kullanici ikonuna tiklar
    And Hasta kullanici ikonun altinda Password sekmesine tiklar
    Then Hasta New password confirmation textbox ina en az bir kucuk harf, buyuk harf, rakam ve ozel karakterden olusan en az 7 karakter girer
    And Hasta Password strength seviyesini yesil renkte gormelidir

  Scenario: US08_TC03 Eski sifre kullanilmamalidir
    Given Hasta medunna ana sayfasina gider
    Then Hasta sag ust kosedeki kullanici ikonunu tiklar
    And Hasta ikonu altinda Sign in sekmesine tiklar
    Then Hasta textbox a  kullanici adini girer
    And Hasta Password textbox a sifresini girer
    And Hasta Sign in butonuna tiklar
    And Hasta tekrar kullanici ikonuna tiklar
    And Hasta kullanici ikonun altinda Password sekmesine tiklar
    Then Hasta Current password textbox a mevcut passwordu girer
    Then Hasta New password confirmation textbox ina da mevcut passwordu girer
    Then Hasta password confirmation textbox ina da mevcut passwordu girer
    And Hasta Save butonuna tiklar
    Then Hasta The password and its confirmation do not match! uyarisi almali


