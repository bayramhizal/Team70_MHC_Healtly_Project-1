Feature: US14 Physician (Doctor) "Edit Inpatient" (Yatılı Tedavi) işlemleri yapabilmeli
  (My Appointments / View / Edit Impatients)

  Background: ortak adim befor method gibi calisir

    Given doktor "medunnaUrl" anasayfasindan
    When doktor kullanici resmine tiklar
    Then doktor Sign in butonuna tiklar
    And doktor username ve Password bilgileri ile giris yapar
    And doktor kendi sayfasina giris yaptigini gorur
    And doktor inMyInpatients sayfasina gider
    And Doktor inPatient Edit butonunu tiklar

  Scenario: TC01 Doktor"ID, start and end dates, description, created date appointment id, status, room and patient" bilgilerini görüntülüyebilmeli

    Then doktor inMyInpatients sayfasinda "ID" basligini gorur
    Then doktor inMyInpatients sayfasinda "Start Date" Start Date basligini gorur
    Then doktor inMyInpatients sayfasinda "End Date" end Date basligini gorur
    Then doktor inMyInpatients sayfasinda "Status" status basligini gorur
    Then doktor inMyInpatients sayfasinda "Description" Description basligini gorur
    Then doktor inMyInpatients sayfasinda "Created Date" Created Date basligini gorur
    Then doktor inMyInpatients sayfasinda "Room" room basligini gorur
    Then doktor inMyInpatients sayfasinda "Appointment" Appointment basligini gorur
    Then doktor inMyInpatients sayfasinda "Patient" Patient basligini gorur

 Scenario: TC02 "Status" doktor tarafından "UNAPPROVED, DISCHARGED, STILL STAYING veya CANCELLED" olarak güncellenebilmeli

   Then doktor inMyInpatients sayfasinda Status durumunu gorur
   Then Doktor Status sekmesini CANCELLED olarak secer

 #Scenario: TC03 Doktor rezerve edilmiş odayı güncelleyebilmeli


 #  Then doktor tarafindan rezerve edilmis oda guncellenebilmeli