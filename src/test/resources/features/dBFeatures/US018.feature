
Feature: US018 Database
  @US018_DB01
  Scenario Outline: US018_DB01
    Given K10 Kullanici medunna Data Base'e baglanir
    And   K10 Tum Physian bilgilerini getirir "<query>" ve "<columnName>"
    Then  K10 Physician id "399601" dogrular
    Examples: test verileri
      | query                   | columnName |
      | Select * from physician | id         |


