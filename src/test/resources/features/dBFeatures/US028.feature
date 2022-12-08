@US028_DB
Feature: US028_Database_Testi

  @DB
  Scenario: TC_006_Country_DB_Testi
    Given K3 Admin country icin "K3countryquery" ile "name" sutunundan kayitli bilgileri ceker
    Then  K3 Admin country icin "K3Ulke" bilgilerini dogrular