@ApiUS25
  Feature: Emre_US025_Api

    Scenario: K4 US025 randevu kontrol testi
      Given K4 370147 id numarali hastanin tum bilgilerine get request gonderir
      Then  K4 Status code 200 oldugu kontrol edilir
      And   K4 response kayitlarini dogrular

