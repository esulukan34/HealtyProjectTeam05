@data
Feature: US010 Randevulari Database ile dogrula
  Scenario: US010
    Given K2 Kullanici  db ye baglanir
    Then  K2 Kullanici select "*" from "appointment" sorgusu yapar
    And   K2 Kullanici randevulari dogrular