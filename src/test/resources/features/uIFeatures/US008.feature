@US008
Feature: US008 Kullanici giris yaptiginda Password sekmesi duzenlenebilir olmalidir

  @US008_TC001
  Scenario:TC001 "New password confirmation" onaylanabilmelidir
    Given K5 kullanici "medunnaUrl" url'e gider
    When K5 kullanici login olur
    Then K5 kullanici account menuden password link tiklar
    And K5 kullanici current password girer
    And K5 kullanici new password girer
    And K5 kullanici new password confirmation girer
    And K5 kullanici "The password and its confirmation do not match!" mesajinin gorunur olmadigini dogrular
    #And K5 sayfayi kapatir


  @US008_2345
  Scenario Outline:TC002 TC003 TC004 TC005 Sifre en az 1 buyuk harf icermeli ve "Password strength:" seviyesinin degistigi gorulebilmelidir.
    Given K5 kullanici "medunnaUrl" url'e gider
    When K5 kullanici login olur
    Then K5 kullanici account menuden password link tiklar
    And K5 kullanici current password girer
    And K5 kullanici kucuk harf,buyuk harf,rakam ve ozel karakter sartlarindan herhangi ucu ile"<new password>" girer
    And K5 kullanici Password strenght seviyesinin limegreen oldugunu dogrular
    And K5 kullanici "<New password'a>" girmedigi sifre sartini ekler
    And K5 kullanici Password strength seviyesinin green oldugunu dogrular
    #And K5 sayfayi kapatir

    Examples:
      | new password | New password'a |
      | AASS12312!   | aa             |
      | aa123231!!   | AA             |
      | AAAAasda!!   | 12             |
      | AAAAssds12   | !!             |


  @US008_TC006
  Scenario: TC006 Guclu bir parola icin sifre en az 7 karakterden olusmalidir
    Given K5 kullanici "medunnaUrl" url'e gider
    When K5 kullanici login olur
    Then K5 kullanici account menuden password link tiklar
    And K5 kullanici current password girer
    And K5 kullanici kucuk harf,buyuk harf,rakam ve ozel karakter ile en az yedi karakterli new password girer
    And K5 kullanici Password strength seviyesinin green oldugunu dogrular
    #And K5 sayfayi kapatir


  @US008_TC007
  Scenario: TC007 Eski sifre kullanilmamalidir
    Given K5 kullanici "medunnaUrl" url'e gider
    When K5 kullanici login olup account menuden password linke tiklar
    Then K5 kullanici current passwordu girer ve new password ve confirm password'e eski sifreyi girer
    And K5 kullanici save butonuna tiklar
    And K5 kullanici 2 saniye bekler
    And K5 kullanici Password changed! uyarisinin gorunur olmadigini dogrular
    #And sayfayi kapatir


  @US008_negativeTC001
  Scenario: TC001 negatif "New password confirmation" onaylanabilmelidir
    Given K5 kullanici "medunnaUrl" url'e gider
    When K5 kullanici login olur
    Then K5 kullanici account menuden password link tiklar
    And K5 kullanici current password girer
    And K5 kullanici new password box'a sifre girer
    And K5 kullanici new password confirmation box'a new passworddan farkli sifre girer
    And K5 kullanici "The password and its confirmation do not match!" mesajinin gorunur oldugunu dogrular
    And K5 kullanici 2 saniye bekler
    #And K5 sayfayi kapatir


  @US008_negative1_TC006
  Scenario: TC006 negatif Guclu bir parola icin sifre en az 7 karakterden olusmalidir
    Given K5 kullanici "medunnaUrl" url'e gider
    When K5 kullanici login olur
    Then K5 kullanici account menuden password link tiklar
    And K5 kullanici current password girer
    And K5 kullanici kucuk harf,buyuk harf,rakam ve ozel karakter ile en fazla alti karakterli new password girer
    And K5 kullanici Password strength seviyesinin red oldugunu dogrular
    #And K5 sayfayi kapatir


  @US008_negative2_TC006
  Scenario Outline: TC006 negatif Guclu bir parola icin sifre en az 7 karakterden olusmalidir
    Given K5 kullanici "medunnaUrl" url'e gider
    When K5 kullanici login olur
    Then K5 kullanici account menuden password link tiklar
    And K5 kullanici current password girer
    And  K5 Kullanici "<new password>" boxa en az yedi karakter girerek strenght bar'in farkli durumlarini test eder.
    #And K5 sayfayi kapatir


    Examples:
      | new password          |
      | ÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜ. |
      | 12312332              |
      | ASDFSDFD              |
      | aafsnffg              |
      | ........              |
      | ###########           |
      | @@@@@@@               |
      | @@@@@@@@@@            |
      | ##########.           |
      | ÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜÜ  |
      | Asf!23                |
