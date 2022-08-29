# US027_DB
#Kullanıcı DB ile mesajları doğrulamalıdır
@US027_DB
Feature:US027 Messages by Admin Validate with API and DB

  @US027_TC007
  Scenario Outline:TC007 Kullanici, DB ile mesajlari dogrulamalidir
    Given Kullanici Medunna veri tabanina baglanir
    Given kullanici DB e messages ile ilgili "<query>" sorgusu gonderir ve column data "<columnName>" i alir
    Then kullanici DB de messages ile ilgili kayit bilgilerini dogrular
    And Baglantiyi sonlandirir

    Examples:
      |query|columnName|
      |Select * from public.cmessage|id|