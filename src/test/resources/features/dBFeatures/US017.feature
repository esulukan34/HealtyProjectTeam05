@DB_US017
Feature: US017 Test items(öğe) Oluştur / Güncelle / Sil DB ile dogrulama


  Scenario: Adminnevcan DB ile Test Item dogrulama/guncelleme/silme
    Given AdminNevcan MedunnaDB ile connection kurar
    And AdminNevcan MedunnaDBden test item bilgilerini alir
    And AdminNevcan DB ile test item olustugunu dogrular
