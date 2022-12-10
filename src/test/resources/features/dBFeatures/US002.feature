@US002_DB
Feature: Database test

  @US002_DB_TC_009 @DB
  Scenario: Kullanici DB test
    Given  K3 Kullanici "K3userquery" ile "email" sutunundan kayitli bilgileri ceker
    Then   K3 Kullanici "K3Email" bilgilerini dogrular