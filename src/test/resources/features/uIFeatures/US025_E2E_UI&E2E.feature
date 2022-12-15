@US25UI&API
Feature:
  Scenario: US25 hasta randevu alır
    Given   K4 Medunna sayfasina gider
    Then    K4 Account menu butonuna tiklar
    *       K4 Sign In butonuna tiklar
    *       K4 Hasta hesabıyla giris yapar
    *       K4 Hasta hesabıyla myPages butonuna tiklar
    *       K4 MyAppointments butonuna tiklar
    *       K4 Gecerli bir telefon numarasi girer
    *       K4 Randevu icin tarih secer
    *       K4 Randevu tamamlamak icin SendAppointment tusuna basar
    *       K4 randevu alindigini ve tarihin "GG/AA/YYYY" seklinde oldugunu dogrular
    And     K4 Sayfayi kapatir

  Scenario: K4 US025 randevu kontrol testi
    Given   K4 370147 id numarali hastanin tum bilgilerine get request gonderir
    Then    K4 Status code 200 oldugu kontrol edilir
    And     K4 response kayitlarini dogrular
