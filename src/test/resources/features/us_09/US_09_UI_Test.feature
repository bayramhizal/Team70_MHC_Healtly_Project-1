Feature: US09 Staff hasta bilgilerini gorebilmeli, duzenleyebilmeli ve silebilmelidir

  Scenario: TC01 Kullanici "My Pages" sekmesinden hasta bilgilerini gorebilmelidir.

    Given kullanici Staff olarak giris yapar
    Then kullanici MyPage sekmesine basar
    And kullanici MyPage sekmesinde SearchPatients sekmesine tiklar
    And kullanici sayfanin acilmasini bekler
    And kullanici acilan pencerenin Patient sayfasi oldugunu kontrol eder



  Scenario: TC02 Kullanici butun hasta bilgilerini duzenleyebilmelidir

    Given kullanici Staff olarak giris yapar
    Then kullanici MyPage sekmesine basar
    And kullanici MyPage sekmesinde SearchPatients sekmesine tiklar
    And kullanici sayfanin acilmasini bekler
    And kullanici rastgele bir hasta secimi yaparak edit butonuna basar
    And kulanici hasta bilgilerini duzenler
    Then kullanici Create or edit a Patient sayfasinda Save butonuna basar
    And kullanici acilan sayfanin Patient sayfasi oldugunu kontrol eder

  Scenario: TC03 Kullanici, SSN'lerine göre yeni bir başvuru sahibi arayabilmeli ve tüm kayit bilgilerinin dolduruldugunu gorebilmelidir.

    Given kullanici Staff olarak giris yapar
    Then kullanici MyPage sekmesine basar
    And kullanici MyPage sekmesinde SearchPatients sekmesine tiklar
    And Staff gecerli bir "415-15-2256" bilgisini Patient SSN: alanına girer
    Then SSN i girilen hastanin kayit bilgileri dogrulanir