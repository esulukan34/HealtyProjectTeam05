@K1ApiTest
Feature: Emre_US001_Api

  Scenario Outline: K4 medunna api testi
    Given K4 yeni kisiler olusturmak icin tum register bilgilerini girer "<SSN>", "<firstname>", "<lastname>", "<username>", "<email>", "<password>"
    Then  K4 girdigi bilgileri POST yapar
    And   K4 olusturdugu kisi bilgilerini dogrular

    Examples: test verileri
    | SSN         | firstname | lastname | username  | email         | password  |
    | 123-45-6048 | Emre10    | Sulukan5 | esulukan1 | es1@gmail.com | Emre.1234 |
    | 123-45-6049 | Emre20    | Sulukan6 | esulukan2 | es2@gmail.com | Emre.1235 |
    | 123-45-6040 | Emre3e    | Sulukan7 | esulukan3 | es3@gmail.com | Emre.1236 |
    | 123-45-6041 | Emre4e    | Sulukan8 | esulukan4 | es4@gmail.com | Emre.1237 |
