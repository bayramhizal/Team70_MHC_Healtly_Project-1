
Feature: Kayit olmak için SSN, Firstname ve Lastname bilgileri girilebilmelidir.


  Background: Register sayfasina gidis

    Given kullanici ana sayfaya gider
    And kullanici ikonu altinda yer alan register butonuna tiklar


  Scenario: TC01_Gecerli bir SSN, 3. ve 5. rakamdan sonra "-"  icermeli ve 9 rakamdan olusmalidir

    Given kullanici SSN kutucuguna tiklar
    And Kullanici SSN kutucuguna sadece rakamlar girer, harf ve ozel karakter girmez
    Then Your SSN is invalid uyari mesajinin goruntulenmedigini dogrular
    And Kullanici SSN kutucuguna sadece harf ve ozel karakter girer
    Then Your SSN is invalid uyari mesajinin goruntulendigini dogrular
    And Kullanici SSN kutucuguna on rakam girer. Uc ve besinci rakamdan sonra - karakterini ekler
    Then Your SSN is invalid uyari mesajinin goruntulendigini dogrular
    And Kullanici SSN kutucuguna dokuz rakam girer. Uc ve besinci rakamdan sonra - karakterini eklemez
    Then Your SSN is invalid uyari mesajinin goruntulendigini dogrular
   # And Kullanici SSN kutucuguna dokuz rakam girer. Uc ve besinci rakamdan sonra - karakterini ekler
   # Then Kullanici herhangi bir uyari yazisi alinmadigini dogrular

  Scenario: TC02_SSN bos birakilmamalidir

    Given kullanici SSN kutucuguna tiklar
    And kullanici kutucugu bos birakir
    Then Your SSN is required uyari mesajinin goruntulendigini dogrular


  Scenario: TC03_Herhangi bir karakter iceren ve bos birakilamayan gecerli bir First Name olmalidir


    Given kullanici First Name kutucuguna tiklar ardindan bos birakir
    And Your FirstName is required uyari mesajinin goruntulendigini dogrular
    And Kullanici herhangi bir karakter veya karakterler girer
    Then Your FirstName is required uyari mesajinin alinmadigini dogrular
    And kullanici First Name kutucugunu doldurarak alt kutucuga gecer

  Scenario: TC04_Herhangi bir karakter iceren ve bos birakilamayan gecerli bir Last Name olmalidir

    Given kullanici Last Name kutucuguna tiklar ardindan bos birakir
    And Your LastName is required uyari mesajinin goruntulendigini dogrular
    And Kullanici Last Name kutucuguna herhangi bir karakter veya karakterler girer
    Then Your LastName is required uyari mesajinin alinmadigini dogrular
    And kullanici Last Name kutucugunu doldurarak alt kutucuga gecer


