
  Feature:US_016 Oda Olusturma / Goruntuleme / Guncelleme /Silme (Admin)

    Background:US_016 Tekrar eden methodlar
    Given Kullanici medunnaUrl'e gider
    Then Kullanici Sign In butonunu bulur ve tiklar
    And Kullanici Admin olarak sisteme giris yapar
    And Kullanici Item&Title sekmesine gider Room elementini tiklar
    And Create a new Room sekmesine tiklar

      Scenario:US_016 TC_01 Admin, yatan hastalar için yeni oda oluşturabilir.
        Given Create or edit a Room yazisinin gorunur oldugunu test eder