@US05Api
Feature: US05 API TESTLERI

  Scenario: Kullanici API testi yaparak appointments bilgilerini dogrulamalidir.

 # Given Kullanici, appointment bilgilerini almak icin get request yapar
   #
  Given md Kullanici, 308698 id nolu appointment bilgilerini almak icin get request yapar
  Then md Satatus Code'nin 200 oldugunu dogrular
  And  md Randevu alinirken girilen bilgilerin asertion islemlerini yapar







