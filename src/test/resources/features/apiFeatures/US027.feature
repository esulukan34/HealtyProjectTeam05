Feature: US_27 Messages by Admin Validate with API and DB
@US27_TC01
  Scenario: TC01 Kullanici, API kullanarak iletileri olusturabilmeli ve dogrulamalidir.

    Given md Kullanici token alip ileti olusturmak icin POST REQUEST yapar ve response alir
    Then md Respons'larin dogrulamasini yapar


  Scenario: TC02 Kullanici API ile iletileri okuyabilmeli ve dogrulamalidir.
    Given md Kullanici token alip ileti getirmek icin GET REQUEST yapar ve response alir"
    Then md Respons'larin dogrulamasini yapar(getRequest)

