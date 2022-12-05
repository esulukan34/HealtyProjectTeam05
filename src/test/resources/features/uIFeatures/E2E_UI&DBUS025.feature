@E2E_UI&DBUS25
Feature: US25 UI ve DB testleri

  Scenario: US25 hasta randevu alır
    Given   K4 Medunna sayfasina gider
    Then    K4 Account menu butonuna tiklar
    And     K4 Sign In butonuna tiklar
    *       K4 Hasta hesabıyla giris yapar
    *       K4 Hasta hesabıyla myPages butonuna tiklar
    *       K4 MyAppointments butonuna tiklar
    *       K4 Gecerli bir telefon numarasi girer
    *       K4 Randevu icin tarih secer
    *       K4 Randevu tamamlamak icin SendAppointment tusuna basar
    And     K4 randevu alindigini onaylar

  Scenario Outline: K4 medunna db testi

    Given K4 connection kurar
    Then  K4 tum kayitli bilgileri ceker "<query>" ve "<columnName>"
    And   K4 olusturulan "123-54-6060" SSN numarali randevuyu dogrular
    Examples: test verileri
      |query                 |columnName|
      |SELECT * FROM jhi_user|ssn       |