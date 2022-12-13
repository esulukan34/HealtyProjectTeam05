@US009api
Feature: API TESTLERI
  Scenario: TC004 Kullanıcı API kullanarak tüm hasta bilgilerini doğrulamalıdır
    Given Kullanici 55902 id numarali hastanin tum bilgilerine GET request gonderir
    Then Kullanici status kodunun 200 oldugu gorulur
    And Kullanici bilgilerin dogrulugunu kontrol eder