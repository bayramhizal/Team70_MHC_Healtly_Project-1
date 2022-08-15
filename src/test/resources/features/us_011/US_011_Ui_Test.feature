@adem
Feature:US011 "My Appointments" Physician (Doctor) tarafından düzenlenebilmeli




  Background:TC_01 "Create a new appointment or or edit" Doktor tarafindan duzenlenmeli
    Given kullanici "medunnaUrl" e gider.
    Then kullanici Sign In butonunu bulur ve tiklar
    Then kullanici doktor plarak username ve password text boxlarina dogru bilgileri girer
    And Sign in butonunu tiklar
    And Doktor MYPAGES segmentine gider ve tiklar
    And Ve MYPAGES altindaki My Appointments sekmesini tiklar
    And Doktor Edit butonunu tiklar



  Scenario:TC_02 Bir randevu güncellendiğinde; kullanıcı (doktor), hastanın "id, start and end date, Status, physician and patient" bilgilerini görmelidir.
    And Doktor patent id,start and end date,Status,physician and patient butonlarini gorur
    And Doktor hasta bilgilerinin dolu oldugunu test eder
    And Doktor patent id,start and end date,Status textboxlarinin dolu oldugunu gorur.
    And kullanici sayfayi kapatir



  Scenario:TC_03 Doktor zorunlu olarak "Anamnesis, Treatment ve Diagnosis" doldurmalidir.
    And Doktor Anmnesis,Treatment ve Diagnosis sekmelerini gorur
    And Doktor Anmnesis,Treatment ve Diagnosis alanlari doldurur ve bos olmadigi test eder.
    And bu alanlardan Diagnosis alani kasitli olarak bos birakir
    And Saved butonuna basar ve guncellemenin basarili olmadigini test eder
    And kullanici sayfayi kapatir




  Scenario:TC_04 "Status" doktor tarafından "PENDING, COMPLETED veya CANCELLED" olarak seçilebilmeli
    And Doktor Status sekmesini bulur
    And Doktor Status sekmesinden PENDING,COMPLETED,CANCELLED olarak secebilir
    And Doktor Status sekmesini CANCELLED olarak secer
    And kullanici sayfayi kapatir



  Scenario:TC_05 "prescription ve description" isteğe bağlı olmalıdır.

    And Prescription ve Description alanlari bos birakilir.
    And Doktor Save butonunu bulup click yapar
    And  Doktor Appointments is updated yazisini dogrular
    And kullanici sayfayi kapatir


