@API_US017
Feature: US017 Test items(öğe) Oluştur / Güncelle / Sil API ile dogrulama

  @POST @API
  Scenario: AdminNevcan Test Item API ile POST islemi
    Given AdminNevcan sets the URL
    And AdminNevcan sets the expected data
    Then AdminNevcan sends the Post Request and gets the Response
    And AdminNevcan does Assertion

@API
  Scenario: AdminNevcan Test Item API ile GET islemi
    Given AdminNevcan sets the Get URL
    Then AdminNevcan sends the Get Request and gets the Response
    And AdminNevcan does Get Assertion

  @API
  Scenario: AdminNevcan Test Item API ile PUT islemi
    Given AdminNevcan sets the Put URL
    And AdminNevcan sets the Put expected data
    Then AdminNevcan sends the Put Request and gets the Response
    And AdminNevcan does Put Assertion


@API
  Scenario: AdminNevcan Test Item API ile DELETE islemi
    Given AdminNevcan sets the Delete URL
    Then AdminNevcan sends the Delete Request and gets the Response
    And AdminNevcan does Delete Assertion

