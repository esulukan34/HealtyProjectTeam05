Feature: database test

  @DBTest
  Scenario Outline: K4 db test
    Given kullanci connection kuarar
    And Kullanici tum yeni kayitli bilgileri ceker "<query>" ve "<columnName>"
    Then Kullanici kullanici bilgilerini dogrular

    Examples: test verileri
      |query                 |columnName|
      |SELECT * FROM jhi_user|ssn       |