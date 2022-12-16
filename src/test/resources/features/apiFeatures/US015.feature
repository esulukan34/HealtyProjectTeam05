@US015API
Feature: US0015 E2E API DB test

  Scenario: TC001 Yeni hastalar yalnizca yonetici tarafindan olusturulabilir
    Given FA admin "medunnaUrl" e gider
    When  FA admin login olur
    Then  FA admin Items&Titles menuden Patient tiklar
    Then  FA admin acilan pencerede Create a new Patient butonunun gorunur oldugunu dogrular ve tiklar
    And   FA admin acilan pencerede gecerli bilgileri girer ve save buttonuna tiklar
    Then  FA admin Api ve DB Test icin ID alir

  Scenario: US015 API test
    Given FA URL "api/patients/" "id"
    When  FA admin send GET Request
    Then  FA admin Status code is 200
    And   FA admin assert id, firstName, lastName

