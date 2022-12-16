
@US027DB
Feature: US_27 Messages by Admin Validate with API and DB
  Scenario: TC01 Kullanici DB ile mesajlari dogrulamalidir

  Given md Database'e baglan"
  When md Tablodan ileti bilgilerini getir
  Then md Sorgu (Query) sonuclarini dogrula

