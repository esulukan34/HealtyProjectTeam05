@RUN
Feature:US010-Doktor kullanici olarak randevularini görüntüleyebilmelidir.
  Scenario:TC-01 Kullanici randevu listesi ve zaman dilimlerini görebilmelidir
    Given K2 Kullanici "medunnaUrl" adresine gider
    When K2 Kullanici signin butonuna tiklar
    Then K2 Kullanici username ve password ile giris yapar
    And K2 Acilan sayfada MyPages sekmesini tiklar
    And K2 Kullanici My appointments sekmesini tiklar
    And K2 Randevu listesi ve zaman dilimlerinin görüldüğü doğrulanir
    And K2 Sayfa kapatilir

  Scenario:TC-02 Kullanici "patient id, start date, end date, status" bilgilerinin gorebilmelidir
    Given K2 Kullanici "medunnaUrl" adresine gider
    When K2 Kullanici signin butonuna tiklar
    And K2 Kullanici username ve password ile giris yapar
    And K2 Acilan sayfada MyPages sekmesini tiklar
    And K2 Kullanici My appointments sekmesini tiklar
    Then K2 Kullanici "patient id, start date, end date, status" bilgilerinin goruldugu dogrulanir
    And K2 Sayfa kapatilir

