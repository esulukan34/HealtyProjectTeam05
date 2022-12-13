@K1ApiTest
Feature: Emre_US001_Api

  Scenario Outline: K4 medunna api testi
    Given K4 yeni kisiler olusturmak icin tum register bilgilerini girer "<SSN>", "<firstname>", "<lastname>", "<username>", "<email>", "<password>"
    Then  K4 girdigi bilgileri POST yapar
    And   K4 olusturdugu kisi bilgilerini dogrular

    Examples: test verileri
    | SSN         | firstname | lastname | username  | email          | password   |
    | 123-45-6048 | Emree1    | Sulukan5 | esulukan1 | ess1@gmail.com | Emres.1234 |
    | 123-45-6049 | Emree2    | Sulukan6 | esulukan2 | ess2@gmail.com | Emres.1235 |
    | 123-45-6040 | Emree3    | Sulukan7 | esulukan3 | ess3@gmail.com | Emres.1236 |
    | 123-45-6041 | Emree4    | Sulukan8 | esulukan4 | ess4@gmail.com | Emres.1237 |

