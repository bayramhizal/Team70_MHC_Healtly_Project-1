Feature: US01 Gecersiz SSN ile giris yapilamaz

  @medunna
  Scenario: TC01 SSN 4. ve 7. karakter "-" olmali ve toplam 9 rakam icermeli

  Given Medunna anasayfasina gider
  When Account simgesine tiklar
  And Register sayfasina gider
  Then SSN in 4. karakterin "-" olmasi gerektigini test eder
  #And SSN in 7. karakterin "-" olmasi gerektigini test eder
  And SSN in 9 rakamdan olusabilecegini test eder
  And SSN textbox inin bos birakilamayacagini test eder
  And Sayfayi kapatir
