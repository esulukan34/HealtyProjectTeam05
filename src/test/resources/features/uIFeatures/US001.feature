@gp
Feature: Medunna Health Group
    @gp1
  Scenario: TC01 kullanici medunna.com da
    Given   K4 Medunna sayfasina gider
    Then    K4 Account menu butonu tiklanir
    And     K4 Register butonuna tiklar
    And     K4 Gecerli bir SSN girilir
    And     K4 Gecerli bir firstname girilir
    And     K4 Gecerli bir lastname girilir

    @gp2
  Scenario: TC02 negatif testi
    Given   K4 Medunna sayfasina gider
    Then    K4 Account menu butonu tiklanir
    And     K4 Register butonuna tiklar
    And     K4 Gecersiz bir SSN girilir

  Scenario: TC03 negatif testi
    Given   K4 Medunna sayfasina gider
    Then    K4 Account menu butonu tiklanir
    And     K4 Register butonuna tiklar
    And     K4 Register2 butonuna tiklar
    And     K4 SSN,firstname ve lastname bos birakilir
    And     K4 Sayfayi kapatir





