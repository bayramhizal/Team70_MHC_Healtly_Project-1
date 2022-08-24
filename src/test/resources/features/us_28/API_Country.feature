Feature: Country okuma,olusturma,guncelleme ve silme islemleri
  Scenario: Country okuma

  Given Kullanici country icin get request yapar


  Scenario Outline:Country olusturma
    * kullanici api end point "https://www.medunna.com/api/countries" den "<idJson>" ve "<nameJson>" kullanarak ulke olusturur

    Examples: country olusturma
      |idJson|nameJson|
      |123212|PapuaYeniGine|

  Scenario Outline:Coutry Guncelleme
    * kullanici api end point "https://www.medunna.com/api/countries/" den "<id>" ve "<name>" kullanarak guncelleme yapar

    Examples: country guncelleme
      |id|name|
      |216030|Lithuania|

  Scenario Outline:Country Silme
    * kullanici endpoint "<endPoint>" ve id ile "<id>" ulke siler

    Examples: country silme
      |endPoint|id|
      |https://www.medunna.com/api/countries/|210638|