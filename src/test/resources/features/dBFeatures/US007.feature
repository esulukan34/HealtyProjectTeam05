@US07-DB-TC1
Feature: US07
  Scenario Outline: DB kullanarak randevular görüntülenebilmelidir.
    Given K6 Kullanicisi Database baglanir
    Then K6 DB ile "<ID>" id nolu randevuyu sorgular
    Then K6 DB Bilgileri Dogrular

    Examples: Randevu ID'leri
      |ID|
      |342064|
      |343024|
      |356033|