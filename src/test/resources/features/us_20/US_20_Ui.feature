Feature: Admin; "User management" menusunden, kullanici Active eder ve gerekli rolleri olusturur.

  Background:
    Given Admin MedunnaUrl Anasayfaya gider
    When Admin kullanici iknonuna tiklar
    Then Admin sign in butonuna tiklar
    And Admin kendi Username ve Password bilgileri ile giris yapar
    And Admin Administration butonuna basar
    And Admin acilan Drop Downdan User Management secer
    And Admin olusturulan User'in login Name "team70_us20" ile Edit butonuna basar

  Scenario: TC01 Admin, kayitli kisilerin "firstname, lastname, email... gibi bilgilerini gorebilmeli.
    Given Admin kayitli kullanicilarin "ahmet","koru", "ahr@gsmail.com" gibi bilgilerini gorur
    Then Admin olusturdugu kullaniciyi siler

  Scenario: TC02 Admin kullanicilari aktive edebilir ve rollerini ADMIN, USER PATIENT, STAFF ve PHYSICIAN olarak atayabilir.
    Given Admin kullanicinin Activated kutucugunun secili oldugunu gorur
    When Admin kullanicinin Activated kutucuguna bir kez tiklar ve kutucugun secili olmadigini gorur
    Then Admin kullanicinin Activated kutucuguna bir kez daha tiklar ve kutucugun tekrar secili oldugunu gorur
    And Admin Profiles Drop Down sekmesinden "ROLE_ADMIN" secer ve Save tusuna basar
    And Admin edit ettigi kullanicinin Aktivated ve Profilinin "ROLE_ADMIN" oldugunu gorur ve daha sonra Edit tusuna basar
    And Admin Profiles Drop Down sekmesinden "ROLE_USER" secer ve Save tusuna basar
    And Admin edit ettigi kullanicinin Aktivated ve Profilinin "ROLE_USER" oldugunu gorur ve daha sonra Edit tusuna basar
    And Admin Profiles Drop Down sekmesinden "ROLE_PATIENT" secer ve Save tusuna basar
    And Admin edit ettigi kullanicinin Aktivated ve Profilinin "ROLE_PATIENT" oldugunu gorur ve daha sonra Edit tusuna basar
    And Admin Profiles Drop Down sekmesinden "ROLE_STAFF" secer ve Save tusuna basar
    And Admin edit ettigi kullanicinin Aktivated ve Profilinin "ROLE_STAFF" oldugunu gorur ve daha sonra Edit tusuna basar
    And Admin Profiles Drop Down sekmesinden "ROLE_PHYSICIAN" secer ve Save tusuna basar
    And Admin edit ettigi kullanicinin Aktivated ve Profilinin "ROLE_PHYSICIAN" oldugunu gorur
    And Admin ROLE_PHYSICIAN olan kullaniciyi sorunsuz siler