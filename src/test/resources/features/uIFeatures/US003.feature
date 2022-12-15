@US_003
Feature: US03 New Password Guclu sifre girilmesi ve Strenght degisimi dogrulamasi

  @US_003_TC01
  Scenario: TC01 test senaryosu

    Given "MedunnaUrl" sayfasina gider
    Then  Sign Dropdown butonuna basar
    And   Register butonuna basar ve sayfasina  gider
    Then  New Password kismina tiklar
    And   Guclu sifre icin en az bir kucuk harf icermeli
    Then  Ve Password Strength degisimi dogrulanir.
    And   Sayfayi kapatir.


  @US_003_TC02
  Scenario: TC02 test senaryosu

    Given "MedunnaUrl" sayfasina gider
    Then  Sign Dropdown butonuna basar
    And   Register butonuna basar ve sayfasina  gider
    Then  New Password kismina tiklar
    And   Guclu sifre icin en az bir Buyuk harf icermeli
    Then  Ve Buyuk harf icin Password Strength degisimi dogrulanir.
    And   Sayfayi kapatir.

  @US_003_TC03
  Scenario: TC03 test senaryosu

    Given "MedunnaUrl" sayfasina gider
    Then  Sign Dropdown butonuna basar
    And   Register butonuna basar ve sayfasina  gider
    Then  New Password kismina tiklar
    And   Guclu sifre icin en az bir rakam icermeli
    Then  Ve Rakam icin Password Strength degisimi dogrulanir.
    And   Sayfayi kapatir.

  @US_003_TC04
  Scenario: TC04 test senaryosu

    Given "MedunnaUrl" sayfasina gider
    Then  Sign Dropdown butonuna basar
    And   Register butonuna basar ve sayfasina  gider
    Then  New Password kismina tiklar
    And   Guclu sifre icin en az bir ozel karakter icermeli
    Then  Ve Ozel karakter icin Password Strength degisimi dogrulanir.
    And   Sayfayi kapatir.

  @US_003_TC05
  Scenario: TC05 test senaryosu

    Given "MedunnaUrl" sayfasina gider
    Then  Sign Dropdown butonuna basar
    And   Register butonuna basar ve sayfasina  gider
    Then  New Password kismina tiklar
    And   Guclu sifre icin en az yedi karakter icermeli
    Then  Ve En az karakter olmasi icin Password Strength degisimi dogrulanir.
    And   Sayfayi kapatir.
