@E2E
Feature: Kayit olmak için email and username bilgileri girilebilmelidir.


  Scenario: US02_TC02 Kullanici adi API kullanilarak dogrulanmalidir
            US02_TC05 Email API ve DB ile dogrulanmalidir

    Given kullanici enpoint olusturur ve request yapar
    And kullanici post islemi icin expected data olusturur
    Given kullanici post request islemi yapar
    Then kullanici post yapilan kullanici adini dogrular
    Then kullanici post yapilan email adresini dogrular