@Regression
Feature: DB ile sorgulama

  Scenario: Ulke id si ile sorgulamanin yapilmasi

    Given Kullanici database connect olur
    And Kullanici id nolari alir
    Then Kullanici id nolari dogrular

