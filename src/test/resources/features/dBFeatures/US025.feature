@US25DBTest
  Feature: US025_Database Test

    Scenario Outline: K4 medunna db testi

      Given K4 connection kurar
      Then  K4 tum kayitli bilgileri ceker "<query>" ve "<columnName>"
      And   K4 olusturulan "123-54-6060" SSN numarali randevuyu dogrular
      Examples: test verileri
        |query                 |columnName|
        |SELECT * FROM jhi_user|ssn       |
        |SELECT * FROM jhi_user|date      |