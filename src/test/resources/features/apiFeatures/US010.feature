@K6API
Feature: US010 Randevulari API ile dogrula
  Scenario: US010 Randevulari API ile dogrula
    Given K2 Kullanici  313570 numarali randevu bilgileri icin get request gonderir
    Then  K2 Kullanici status kodunun 200 oldugunu gorur
    And   K2 Kullanici randevu bilgilerini dogrular