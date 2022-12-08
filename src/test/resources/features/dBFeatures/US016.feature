@US016_DB
Feature: US016_Database_Testi

  @US016_TC_008 @DB
  Scenario: TC_008_Room_DB_Testi
    Given K3 Admin oda icin "K3roomquery" ile "room_number" sutunundan kayitli bilgileri ceker
    Then  K3 Admin oda icin "K3room" bilgilerini dogrular