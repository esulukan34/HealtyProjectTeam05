Feature: US_27 Messages by Admin Validate with API and DB

  Background:Kullanici sigin islemlerini yaparak mesaj portalina gider

    Given md Kullanici "medunnaUrl" url adresine gider
    And md Anasayfada kullanici girisi simgesine tiklar
    And md Sign in'e tiklar
    And md Gecerli admin username girer
    And md Gecerli admin password girer
    And md Girisi onaylamak icin Sign in butonuna tiklar
    And md items_Titles menusune tiklar
    And md Messages'e tiklar

  Scenario: TC01 Admin, mesaj portalina gidebilmeli ve tum mesajlari, yazarlarini ve e-postalarini goruntuleyebilmelidir

    Then md Messages sayfasinda mesajlarin gorundugunu test eder
    Then md Messages sayfasinda isimlerin gorundugunu test eder
    Then md Messages sayfasinda epostalarin gorundugunu test eder

  Scenario: TC02 Admin, mesajlari olusturabilmelidir

    And md Create new messages butonuna tiklar
    And md Name kutusuna bir isim soyisim girer
    And md Email kutusuna bir email girer
    And md Subject kutusuna bir konu girer
    And md Messages kutusuna mesajini yazar
    And md Save butonuna tiklar
    Then md Mesajin olusturuldugunu test eder

  Scenario: TC03 Admin, mesajlari guncelleyebilmelidir.

    And md Create new messages butonuna tiklar
    And md Name kutusuna bir isim soyisim girer
    And md Email kutusuna bir email girer
    And md Subject kutusuna bir konu girer
    And md Messages kutusuna mesajini yazar
    And md Save butonuna tiklar
    Then md Mesajin olusturuldugunu test eder
    And md Admin kendi olusturdugu mesajda edit butonunu tiklar
    And md Mesaj kutusunda guncelleme yapar
    And md Save butonuna tiklar
    Then md Mesajin update isleminin basariyla yapildigini test eder

  Scenario: TC04 Admin, mesajlari silebilmelidir.

    And md Create new messages butonuna tiklar
    And md Name kutusuna bir isim soyisim girer
    And md Email kutusuna bir email girer
    And md Subject kutusuna bir konu girer
    And md Messages kutusuna mesajini yazar
    And md Save butonuna tiklar
    Then md Mesajin olusturuldugunu test eder
    And md Admin kendi olusturdugu mesajda delete butonunu tiklar
    And md Silme islemini onaylamak icin gelen Delete butonuna tiklar
    And md Mesajin silindigini test eder





