@wip @Regression
Feature:US_016 Oda Olusturma / Goruntuleme / Guncelleme /Silme (Admin)

  Background:US_016 Tekrar eden methodlar
    Given kullanici "medunnaUrl" e gider.
    Then kullanici Sign In butonunu bulur ve tiklar
    And Kullanici Admin olarak sisteme giris yapar
    And Kullanici Item&Title sekmesine gider Room elementini tiklar
    And Create a new Room sekmesine tiklar

  @Smoke @E2E
  Scenario:US_016 TC_01 Admin, yatan hastalar için yeni oda oluşturabilir.
    Given Create or edit a Room yazisinin gorunur oldugunu test eder

  @Smoke
  Scenario: US_016 TC_02 Oda oluşturulurken "Room Number" mutlaka olmalı,"Room Type"; TWIN, DELUXE, PREMIUM_DELUXE, SUIT ve DAYCARE olmalı
    Given  Kullanici Room Number sekmesinin zorunlu alan oldugunu test eder(This field is required.)
    Then Kullanici Room Number sekmesine rakam ve harfler olusan deger girer (This field should be a number.)
    And  Kullanici Room Types secerek butun opsiyonlari gorur

  @Smoke
  Scenario: US_016 TC_03 Oda için "Status" ayarlanabilir olmalı.
    Given Kullanici Status sekmesini bulur
    And Kullanici Status sekmesinin secilebilir oldugunu test eder

  @Smoke
  Scenario: US_016 TC_04 Fiyat eklenebilir olmalı ve boş bırakılamamalı.
    Given Price text boxu bulunur once deger girilmeden zorunlu alan oldugu test edilir
    Then Kullanici Price text boxina rakam ve harflerden olusan deger girer
    And Kullanici (This field should be at least .) yazisini dogrular

  Scenario:US_016 TC_05 "Description" isteğe bağlı olarak doldurulmalı.
    Given Kullanici Description kutucugunu bulur
    Then Kullanici Description zorunlu alan olmadigini test eder


  Scenario: US_016 TC_06 "Created Date" Gün/Ay/Yıl şeklinde olmalı ve geçmiş tarih seçilememeli.
    Given Kullanici Created Date elementini bulur
    Then Kullanici tarih sablonunu Gun-Ay-Yil seklinde oldugunu kontrol eder
    And Kullanici gecmis bir tarihi ayarlar ve saved butonuna basar
    And Kullanici gecmis bir tarihle  oda olusturalamayacagini gorur

  Scenario: US_016 TC_07 Admin aynı tür odaları görebilir.
    Given Kullanici RoomType basligini bulur ve tiklar
    Then Kullanici oda turlerinin alt alta siralandigini gorur

  @Smoke
  Scenario: US_016 TC_08 Admin mevcut odaları düzenleyebilir ve güncelleyebilir.
    Given Kullanici Room Type elementini bulur ve tiklar
    Then Kullanici oda turlerinin secilebilir oldugunu gorur ve opsiyonu degistirebilir

    @Smoke @E2E
    Scenario: US_016 TC_09 Odalar Admin tarafından silinebilir.
      Given Admin silmek istedigi hastayi bulur ve siler