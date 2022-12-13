@US014
Feature: US014 Physician (Doctor) "Edit Inpatient" (Yatılı Tedavi) işlemleri yapabilmeli (My In Patients / View / Edit Impatients)

  Background: ilk adimlar
    Given K5 kullanici "medunnaUrl" url'e gider
    When  K5 doktor olarak login olur
    Then  K5 2 saniye bekler
    Then  K5 doktor Mypages menusunden MyInpatient'e tiklar

  @US014_TC001
  Scenario: TC001 Doktor ID, start and, dates, description, created date, appointment id, status, room,patient bilgilerini goruntuleyebilmelidir.
    And K5 Doctor ID, start and end dates, description, created date appointment id, status, room and patient bilgilerini gorunur oldugunu dogrular

  @US014_TC002_TC003
  Scenario: TC002/TC 003 "Status" doktor tarafindan "UNAPPROVED, DISCHARGED, STILL STAYING , CANCELLED" olarak guncellenebilmelidir./ Doktor rezerve edilmiş odayı güncelleyebilmelidir.
    Then K5 doctor bilgilerini guncellemek istedigi hastaya edit yapar
    And  K5 2 saniye bekler
    Then K5 doctor status bilgisi secer ve dogrular
    And  K5 2 saniye bekler
    Then K5 doctor rezerve edilmis hasta odasini gunceller
    And  K5 2 saniye bekler
    And  K5 doctor save butonuna tiklar ve uyariyi dogrular
