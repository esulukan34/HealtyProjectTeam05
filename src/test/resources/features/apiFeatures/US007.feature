@US07-API-TC1
Feature: US07
  Scenario Outline: API kullanarak randevular görüntülenebilmelidir.
    Given K6 Kullanicisi "<ID>" nolu Randevuya Get Request yapar
    Then K6 "<ID>" id nolu ve kullanici isimli randevu objesi olusturur
    Then K6 Bilgileri Dogrular

    Examples: Randevu ID'leri
      |ID|
      |342064|
      |343024|
      |319994|


