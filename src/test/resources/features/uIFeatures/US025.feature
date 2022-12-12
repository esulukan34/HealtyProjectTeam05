@US25
Feature: US25 hasta hesabı olusturup randevu alma


  #Scenario: US25 hasta register olusturma testi
  #  Given   K4 Medunna sayfasina gider
  #  Then    K4 Account menu butonuna tiklar
  #  *       K4 Register butonuna tiklar
  #  *       K4 Gecerli bir SSN girer
  #  *       K4 Gecerli bir firstname girer
  #  *       K4 Gecerli bir lastname girer
  #  *       K4 Gecerli bir username girer
  #  *       K4 Gecerli bir email girer
  #  *       K4 Gecerli bir password girer
  #  *       K4 Register butonuna tiklar


  @USUI25
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

  @US25NEG1
  Scenario: US25 Negatif test hatali telefon numarasi
    Given   K4 Medunna sayfasina gider
    Then    K4 Account menu butonuna tiklar
    *       K4 Sign In butonuna tiklar
    *       K4 Hasta hesabıyla giris yapar
    *       K4 Hasta hesabıyla myPages butonuna tiklar
    *       K4 MyAppointments butonuna tiklar
    *       K4 Gecersiz bir telefon numarasi girer
    *       K4 Randevu icin tarih secer
    *       K4 Randevu tamamlamak icin SendAppointment tusuna basar
    And     K4 randevu alinamadigini dogrular

  @US25NEG2
  Scenario: US25 Negatif test gecmis tarih
    Given   K4 Medunna sayfasina gider
    Then    K4 Account menu butonuna tiklar
    *       K4 Sign In butonuna tiklar
    *       K4 Hasta hesabıyla giris yapar
    *       K4 Hasta hesabıyla myPages butonuna tiklar
    *       K4 MyAppointments butonuna tiklar
    *       K4 Gecerli bir telefon numarasi girer
    *       K4 Randevu icin gecmis bir tarih secer
    *       K4 Randevu tamamlamak icin SendAppointment tusuna basar
    And     K4 randevu alinamadigini dogrular



