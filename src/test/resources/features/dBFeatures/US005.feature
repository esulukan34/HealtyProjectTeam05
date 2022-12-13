
@DBUS05
Feature: US05 Database Testleri
  Scenario: Kullanici olusturulan appointment bilgilerini Database testi ile dogrulamalidir.
    Given md Database'e baglan
    When md Tablodan appointment bilgilerini getir
    Then md Sorgu sonuclarini dogrula
