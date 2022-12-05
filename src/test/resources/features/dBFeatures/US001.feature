Feature: US001_Database Test
  @K1DBTest
  Scenario Outline: K1 medunna db test

    Given K4 connection kurar
    Then  K4 tum yeni kayitli bilgileri ceker "<query>" ve "<columnName>"
    And   K4 kullanici bilgilerini dogrular
    Examples: test verileri
      |query                 |columnName|
      |SELECT * FROM jhi_user|ssn       |