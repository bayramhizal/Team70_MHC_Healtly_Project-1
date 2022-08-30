@Regression
Feature: ADMIN Test items(oge) Olustur, gunceller ve siler

  Background: Admin Test Item sayfasina ulasir
    Given Admin MedunnaUrl Anasayfaya gider
    When Admin kullanici iknonuna tiklar
    Then Admin sign in butonuna tiklar
    And Admin kendi Username ve Password bilgileri ile giris yapar
    And Admin Item&Titles butonuna basar
    And Admin acilan Drop Downdan Test item'i secer

  Scenario: TC01 Admin yeni test ogesi olustur sayfasina ulasir
    Given Admin acilan yeni pencerenin Test Items penceresi oldugunu gorur
    Then Admin Create a new Test Item butonuna basar
    And Admin acilan sayfanin Create or edit a Test Item oldugunu gorur
    And Admin "Name","Description", "Price", "Default Min. Value", "Default Max. Value"  ve "Created Date" metin kutucuklarinin oldugunu gorur

# Scenario: TC02 Admin yeni bir test item olusturabilir, guncelleyebilir ve silebilir
#   Given Admin Create a new Test Item butonuna basar
#   Then Admin "ZuckerUi","kurzeZeit", "200", "120", "145"  ve "25.08.2022 01:58" bilgilerini yazar
#   And Admin Save tusuna basar acilan sayfada olusturdugu test Item'in bilgilerinin dogru oldugunu gorur
# Bu senaryo icin Bug Ticket olusturuldu. Cunku Admin aktuel date disinda baska tarih ve saat giremiyor

  @E2E
  Scenario: TC02 Admin yeni bir test item olusturabilir, guncelleyebilir ve silebilir
    Given Admin Create a new Test Item butonuna basar
    Then Admin "ZuckerUi","kurzeZeit", "200", "120", "145"  ve "date yazilmayacak" bilgilerini yazar
    And Admin Save tusuna basar acilan sayfada olusturdugu test Item'in bilgilerinin dogru oldugunu gorur
    And Admin Test Item sayfasinda olusturdu Test Item'in yaninda bulunan Edit butonuna basar
    And Admin "OhneZucker","langeZeit", "100", "60", ve "72" bilgilerini girerek test item'i gunceller
    And Admin Save tusuna basar ve acilan sayfada Edit ettigi Test Item'i "OhneZucker" gorur
    And Admin en son guncelledigi Test Item'i siler ve olmadigini gorur

