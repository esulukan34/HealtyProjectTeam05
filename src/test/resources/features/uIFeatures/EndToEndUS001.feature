@E2ETest
Feature: E2E Test

  Scenario Outline: K4 medunna api testi
    Given K4 yeni kisiler olusturmak icin tum register bilgilerini girer "<SSN>", "<firstname>", "<lastname>", "<username>", "<email>", "<password>"
    Then  K4 girdigi bilgileri POST yapar
    And   K4 olusturdugu kisi bilgilerini dogrular

    Examples: test verileri
      | SSN         | firstname | lastname | username  | email         | password  |
      | 123-45-6038 | Emre1     | Sulukan1 | esulukan5 | es5@gmail.com | Emre.1234 |
      | 123-45-6039 | Emre2     | Sulukan2 | esulukan6 | es6@gmail.com | Emre.1235 |
      | 123-45-6040 | Emre3     | Sulukan3 | esulukan7 | es7@gmail.com | Emre.1236 |
      | 123-45-6041 | Emre4     | Sulukan4 | esulukan8 | es8@gmail.com | Emre.1237 |

  Scenario Outline: kullanici db test
    Given kullanci connection kuarar
    And Kullanici tum yeni kayitli bilgileri ceker "<query>" ve "<columnName>"
    Then Kullanici kullanici bilgilerini dogrular
    Examples: test verileri
      |query                 |columnName|
      |SELECT * FROM jhi_user|ssn       |
