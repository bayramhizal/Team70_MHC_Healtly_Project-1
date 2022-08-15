@senturkAll
Feature: Hasta kullanici bilgilerini olusturup randevu alabilmeli,profil bilgilerini guncelleyebilmelidir
#US_05
  @TestCase1
  Scenario: Kullanici bilgilerini girerek randevu alabilmeli
    When Kullanici make an appointment butonuna tiklamali
    And Kullanici firstname girmelidir
    And Kullanici lastname girmelidir
    And Kullanici ssn numarasini girmelidir
    And Kullanici email bilgilerini girmelidir
    And Kullanici on haneli telefon no girmeli
    And Kullanici send an appointment butonuna tiklamali
    Then Kullanici kaydedildi mesajini gorebilmelidir


  @TestCase2
  Scenario: Kullanici bilgilerini bos biraktiginda hata mesaji almalidir
    When Kullanici make an appointment butonuna tiklamali
    And Kullanici send an appointment butonuna tiklamalidir
    Then kullanici hata mesajlarini almalidir

  #US_06

  @TestCase3
  Scenario: Kullanici profil bilgilere guncelleyebilmelidir
    When Kullanici Sign-in butonuna tiklamali
    And Kullanici username girmelidir
    And Kullanici password girmelidir
    And Kullanici Signin butonuna tiklamalidir
    And Kullanici profil ismine tiklamalidir
    And Kullanici settings butonuna tiklamalidir
    And kullanici adini,soyadini,emailini guncellemelidir
    And Kullannici save butonuna tiklamalidir
    Then Kullanici kaydedildi yazisini gorebilmelidir
