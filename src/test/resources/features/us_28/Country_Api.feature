Feature: Countries testAPI


  Scenario:Country Okuma
    * kullanici medunna apiden "https://www.medunna.com/api/countries" ulke bilgilerini okur


  Scenario Outline:Country olusturma
    * kullanici api end point "https://www.medunna.com/api/countries" den "<idJson>" ve "<nameJson>" kullanarak ulke olusturur

    Examples: country olusturma
      |idJson|nameJson|
      |name|ANGARA|

  Scenario Outline:Coutry Guncelleme
    * kullanici api end point "https://www.medunna.com/api/countries/" den "<id>" ve "<name>" kullanarak guncelleme yapar

    Examples: country guncelleme
      |id|name|
      |80061|ANKARA|

  Scenario Outline:Country Silme
    * kullanici endpoint "<endPoint>" ve id ile "<id>" ulke siler

    Examples: country silme
      |endPoint|id|
      |https://www.medunna.com/api/countries/|80061|