@RUN2
Feature:US011-"My Appointments" Physician (Doctor) tarafindan duzenlenebilmeli

  Scenario: TC-01 Kullanici "Create or edit an appointment" işlemlerini yapabilmeli hastanın asagidaki
  bilgilerini gorebilmelidir

    Given K2 Kullanici "medunnaUrl" adresine gider
    When K2 Kullanici signin butonuna tiklar
    And K2 Kullanici username ve password ile giris yapar
    And K2 Acilan sayfada MyPages sekmesini tiklar
    And K2 Kullanici My appointments sekmesini tiklar
    And K2 Acilan sayfada Edit butonunu tiklar
    Then K2 Acilan sayfada kullanici hastanın Anamnesis, Treatment ve Diagnosis bilgilerini görebilmeli
    Then K2 Acilan sayfada kullanici hastanın prescription ve description ve status bilgilerini görebilmeli
    And K2 Sayfa kapatilir

  Scenario: TC-02 Kullanici "Anamnesis, Treatment ve Diagnosis" alanlarini doldurabilmeli.
    Given K2 Kullanici "medunnaUrl" adresine gider
    When K2 Kullanici signin butonuna tiklar
    And K2 Kullanici username ve password ile giris yapar
    And K2 Acilan sayfada MyPages sekmesini tiklar
    And K2 Kullanici My appointments sekmesini tiklar
    And K2 Acilan sayfada Edit butonunu tiklar
    Then K2 Kullanici Anamnesis, Treatment ve Diagnosis alanlarini doldurabilmeli
    And K2 Sayfa kapatilir

  Scenario: TC-03 Kullanici "Anamnesis, Treatment ve Diagnosis" alanlarini doldurmak zorundadir.
    Given K2 Kullanici "medunnaUrl" adresine gider
    When K2 Kullanici signin butonuna tiklar
    And K2 Kullanici username ve password ile giris yapar
    And K2 Acilan sayfada MyPages sekmesini tiklar
    And K2 Kullanici My appointments sekmesini tiklar
    And K2 Acilan sayfada Edit butonunu tiklar
    And K2 Anamnesis, Treatment ve Diagnosis alanlari doldurulmadiginda "This field is required" uyarisi almali
    And K2 Sayfa kapatilir


  Scenario: TC-04 Kullanicinin prescription ve description alanlarini doldurmasi istege baglı olmalidir.
    Given K2 Kullanici "medunnaUrl" adresine gider
    When K2 Kullanici signin butonuna tiklar
    And K2 Kullanici username ve password ile giris yapar
    And K2 Acilan sayfada MyPages sekmesini tiklar
    And K2 Kullanici My appointments sekmesini tiklar
    And K2 Acilan sayfada Edit butonunu tiklar
    Then K2 Kullanici prescription ve description alanlarini doldurabilmeli
    And K2 Sayfa kapatilir

  Scenario: TC-05 Kullanicinin prescription ve description alanlarini doldurmasi isteğe bağlı olmalıdır.
    Given K2 Kullanici "medunnaUrl" adresine gider
    When K2 Kullanici signin butonuna tiklar
    And K2 Kullanici username ve password ile giris yapar
    And K2 Acilan sayfada MyPages sekmesini tiklar
    And K2 Kullanici My appointments sekmesini tiklar
    And K2 Acilan sayfada Edit butonunu tiklar
    And K2 Kullanici prescription ve description alanlarini doldurmadıgında herhangi bir uyarı almamalı
    And K2 Sayfa kapatilir


  Scenario: TC-06 Kullanici  tarafindan Status bolumu PENDING, COMPLETED veya CANCELLED olarak secilebilmelidir.
    Given K2 Kullanici "medunnaUrl" adresine gider
    When K2 Kullanici signin butonuna tiklar
    And K2 Kullanici username ve password ile giris yapar
    And K2 Acilan sayfada MyPages sekmesini tiklar
    And K2 Kullanici My appointments sekmesini tiklar
    And K2 Acilan sayfada Edit butonunu tiklar
    Then K2 Kullanici Status kismini pending olarak secer
    Then K2 Kullanici Status kismini completed olarak secer
    Then K2 Kullanici Status kismini cancelled olarak secer
    And K2 Sayfa kapatilir



