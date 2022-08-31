

Feature: Kayit olmak için email and username bilgileri girilebilmelidir.

  Background: Register sayfasina gidis

    Given kullanici ana sayfaya gider
    And kullanici ikonu altinda yer alan register butonuna tiklar

  Scenario: TC01_Herhangi bir karakter iceren ve bos birakilamayan gecerli bir "Username" olmalidir

    Given Kullanici User Name kutucuguna tiklar
    And Kullanici bos birakir ve alt satira gecer
    Then Your username is required uyari mesajinin goruntulendigini dogrular
    And kullanici harflerden olusan bir karakter veya karakterler girer
    Then Your username is required uyari mesajinin goruntulenmedigini dogrular
    And kullanici ozel karakter girer
    Then Your username is invalid uyari mesajinin goruntulendigini dogrular
    And kullanici basta ve sonda bosluk birakarak username girer
    Then Your username is invalid uyari mesajinin goruntulendigini dogrular
    And kullanici harf ve rakamlardan olusan,herhangi bir karakter sinirlamasi olmayan username girer.
    Then kullanici uyari mesajinin goruntulenmedigini dogrular.

  Scenario: TC03_Email adresi @ ve . karakterleri olmadan doldurulamamalidir

    Given Kullanici email kutucuguna bes karakterden az karakter girer
    And Your email is required to be at least characters uyari mesajinin goruntulendigini dogrular
    And kullanici @ ve . karakterlerini kullanmadan email kutucugunu doldurur
    Then This field is invalid mesajinin goruntulendigini dogrular
    And kullanici @ ve . karakterlerini en basta veya en sonda kullanarak doldurur
    Then This field is invalid mesajinin goruntulendigini dogrular
    And  kullanici @ ve . karakterlerini kullanarak istenen formatta bir email adresi girer
    Then Herhangi bir uyari mesaji alinmadigini dogrular


  Scenario: TC04_Email bos birakilamamalidir

    Given Kullanici email kutucuguna tiklar
    And   Kullanici email kutucugunu bos birakir
    Then  Your email is required uyari mesajini goruntulendigini dogrular
    Given Kullanici gecerli bir email adresi girer
    Then  Kullanici herhangi bir uyari mesaji alinmadigini dogrular