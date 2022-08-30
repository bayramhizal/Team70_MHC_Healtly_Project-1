

Feature: Admin tarafindan hasta olusturma ve duzenleme


  @grid
  Scenario: Yeni hastalar Yonetici tarafindan olusturulabilir

    Given grid kullanici "http://192.168.0.51:4444" chrome ile medunna sayfasina gider
    Given kullanici sisteme "adminn" olarak giris yapar
    And kullanici Item&Title sekmesinden Patient elementine tiklar
    Then kullanici Create a new Patient sekmesinin gorunur oldugunu dogrular
    Then kullanici Create a new Patient sekmesinin erisilebilir oldugunu dogrular
    When kullanici Create a new Patient sekmesine tiklar
    Then kullanici hasta olusturma sayfasina yonlendirildigini dogrular
    And kullanici altta bulunan back butonuna tiklar ve Patient sayfasina doner


  Scenario Outline: Diger kullanicilar tarafindan yeni hasta olusturulamaz - NegatifTest

    Given grid kullanici "http://192.168.0.51:4444" firefox ile medunna sayfasina gider
    Given kullanici sisteme "<kullaniciGiris>" olarak giris yapar
    Then kullanici yeni hasta kaydinin yapilamadigini dogrular


    Examples:
      | kullaniciGiris |
      | doktorr |
      | personell |
      | hastaa |


  @grid
  Scenario: Yeni hastalar Yonetici tarafindan olusturulabilir

    Given grid kullanici "http://192.168.0.51:4444" firefox ile medunna sayfasina gider
    Given kullanici sisteme "adminn" olarak giris yapar
    And kullanici Item&Title sekmesinden Patient elementine tiklar
    Then kullanici Create a new Patient sekmesinin gorunur oldugunu dogrular
    Then kullanici Create a new Patient sekmesinin erisilebilir oldugunu dogrular
    When kullanici Create a new Patient sekmesine tiklar
    Then kullanici hasta olusturma sayfasina yonlendirildigini dogrular
    And kullanici altta bulunan back butonuna tiklar ve Patient sayfasina doner