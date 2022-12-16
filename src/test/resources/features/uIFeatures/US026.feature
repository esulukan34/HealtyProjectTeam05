Feature: US26 Iletisim Mesaji (Contact messages)

  @US26_TC01
  Scenario: US26_TC01 Herhangi bir kullanici, bilgi almak icin "Contact portal" uzerinden istek gonderebilmelidir.

    Given md Kullanici "medunnaUrl" url adresine gider
    And md Contact menusune tiklar
    Then md Name kutusunun enable oldugunu test eder
    Then md Email kutusunun enable oldugunu test eder
    Then md Subject kutusunun enable oldugunu test eder
    Then md Message kutusunun enable oldugunu test eder
    Then md Mesaj gonder butonunun enable oldugunu test eder

  @US26_TC02
  Scenario: US26_TC02 Kullanici "Name, Email, Subject, Message" bolumlerine data girebilmeli ve mesajini gonderebilmelidir.

    Given md Kullanici "medunnaUrl" url adresine gider
    When md Contact menusune tiklar
    And md Gecerli bir isim ve soyisim girer
    And md Herhangi bir email adresi girer
    And md Mesajin konusunu yazar
    And md Mesajini yazar
    And md Send butonunu tiklar
    Then md Mesajin basariyla iletildigini test eder






















