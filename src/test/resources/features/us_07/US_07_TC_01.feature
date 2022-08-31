
Feature: Get Cucumber Projesi

  Scenario: US07_TC01_Kullanici gecerli tarih girmelidir.(guncel tarihi veya gelecekteki tarihleri secebilmelidir.)

    Given Hasta medunna ana sayfasina gider
    Then Hasta sag ust kosedeki kullanici ikonunu tiklar
    And Hasta ikonu altinda Sign in sekmesine tiklar
    Then Hasta textbox a  kullanici adini girer
    And Hasta Password textbox a sifresini girer
    And Hasta Sign in butonuna tiklar
    Then Hasta sag ust kosedeki MyPages(Paients) butonuna tiklar
    Then  Hasta Make an Appointment sekmesini tiklar
    Then Hasta Appontment Date Time Boxta guncel veya ileri tarih secer
    And Hasta kullanici guncel veya ileri tarih sectiginde uyari yazisi almaz



  Scenario: US07_TC_02 Tarih sirasi gun/ay/yil(ay/gun/yil) seklinde olmalidir

    Given Hasta medunna ana sayfasina gider
    Then Hasta sag ust kosedeki kullanici ikonunu tiklar
    And Hasta ikonu altinda Sign in sekmesine tiklar
    Then Hasta textbox a  kullanici adini girer
    And Hasta Password textbox a sifresini girer
    And Hasta Sign in butonuna tiklar
    Then Hasta sag ust kosedeki MyPages(Paients) butonuna tiklar
    Then Hasta Phone Box a telefon numarasini girer
    Then Hasta Appontment Date Time Boxta tarih sirasini gun ay ve yil olarak girebilmeli
    Then  Hasta Send an Appointment Request butonuna tiklar
    Then Hasta My Appointment sekmesini tiklar
    And  Hasta randevunun gun ay ve yil olarak olustugunu dogrular




