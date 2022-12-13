Feature: US_27 Messages by Admin Validate with API and DB

  Scenario: TC05 Kullanici, API kullanarak iletileri olusturabilmeli ve dogrulamalidir.

    Given md Kullanici post islemi icin endpoint olusturur
    When md Kullanici post islemi icin expectedData olusturur
    And md Kullanici token alip POST REQUEST yapar ve response alir
    Then md Kullanici post islemi icin dogrulamalari yapar

  Scenario: TC06 Kullanici API ile iletileri okuyabilmeli ve dogrulamalidir.

    Given md Kullanici get islemi icin endpoint olusturur
    When md Kullanici get islemi icin expectedData olusturur
    And md Kullanici token alip GET REQUEST yapar ve response alir
    Then md Kullanici get islemi icin dogrulamalari yapar
