Feature: medunna projekt

  Scenario: US10_TC01 Kullanici randevu listesini ve zaman dilimlerini My Appointments sekmesinden gorebilmelidir
    Given Hasta medunna ana sayfasina gider
    Then Hasta sag ust kosedeki kullanici ikonunu tiklar
    And Hasta ikonu altinda Sign in sekmesine tiklar
    Then Hasta textbox a  kullanici adini girer
    And Hasta Password textbox a sifresini girer
    And Hasta Sign in butonuna tiklar
    Then Hasta sag ust kosedeki MyPages(Paients) butonuna tiklar
    Then Hasta My Appointment sekmesini tiklar
    Then Hasta randevularinin goruntulendigini dogrular


  Scenario: US10_TC02 Kullanici patient id, start date en date, status bilgilerini gorebilmelidir
    Given Hasta medunna ana sayfasina gider
    Then Hasta sag ust kosedeki kullanici ikonunu tiklar
    And Hasta ikonu altinda Sign in sekmesine tiklar
    Then Hasta textbox a  kullanici adini girer
    And Hasta Password textbox a sifresini girer
    And Hasta Sign in butonuna tiklar
    Then Hasta sag ust kosedeki MyPages(Paients) butonuna tiklar
    Then Hasta My Appointment sekmesini tiklar
    Then Hasta patient id, start date en date, status bilgilerini gorebilmelidir
