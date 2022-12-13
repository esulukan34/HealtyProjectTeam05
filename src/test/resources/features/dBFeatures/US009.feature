Feature: US009 Staff (Personel), hasta bilgilerini gorebilmeli, duzenleyebilmeli ve silebilememelidir.

  Scenario: TC05 Kullanıcı, DB kullanarak tüm hasta bilgilerini doğrulamalıdır.
    Given Kullanici medunna database e baglanir
    Then Kullanici database'den bir hastanin tum bilgilerini alir ve kontrol eder