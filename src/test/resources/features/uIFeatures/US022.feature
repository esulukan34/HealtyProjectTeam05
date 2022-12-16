@us22

Feature: US0022 Hasta test sonuclari
  Scenario: TC01-Kullanıcı (Staff) hastanın SSN id ile arama yapabilir.
    Given K2 Kullanici "medunnaUrl" adresine gider
    When K2 Kullanici signin butonuna tiklar
    And K2 Kullanici (staff) username ve password ile giris yapar
    And K2 Acilan sayfada MyPages sekmesini tiklar
    And K2 Kullanici search patient sekmesini tiklar
    And K2 Acilan sayfada patient SSN kısmına SSN girişi yapar
    Then K2 Kullanici SSN ile yapilan  arama sonuclarini goruntuler

  Scenario: TC-02 Kullanıcı (Staff) test sonuçlarını görebilmelidir.
    Given K2 Kullanici "medunnaUrl" adresine gider
    When K2 Kullanici signin butonuna tiklar
    And K2 Kullanici (staff) username ve password ile giris yapar
    And K2 Acilan sayfada MyPages sekmesini tiklar
    And K2 Kullanici search patient sekmesini tiklar
    And K2 Acilan sayfada patient SSN kısmına SSN girişi yapar
    And K2 Acilan sayfada hastanin show appointment sekmesine tiklar
    And K2 Acilan sayfada show test sekmesine tiklar
    And K2 Acilan sayfada view results sekmesine tiklar
    Then K2 Acilan sayfada hastanin test sonuclari goruntulendigi dogrulanir

  Scenario: TC-03 Kullanıcı (Staff) "ID, Date, Result, description, Created date, ..." gibi
  sonuç bilgilerini görebilmeli ve güncelleyebilmelidir.

    Given K2 Kullanici "medunnaUrl" adresine gider
    When K2 Kullanici signin butonuna tiklar
    And K2 Kullanici (staff) username ve password ile giris yapar
    And K2 Acilan sayfada MyPages sekmesini tiklar
    And K2 Kullanici search patient sekmesini tiklar
    And K2 Acilan sayfada patient SSN kısmına SSN girişi yapar
    And K2 Acilan sayfada edit sekmesine tiklar
    And K2 Acilan sayfada hastanin  sonuc bilgilerinin goruntulendigi dogrulanir
    And K2 Acilan sayfada save butonuna tiklar
    Then K2 Acilan sayfada hastanin  sonuc bilgilerinin guncellendigi dogrulanir


