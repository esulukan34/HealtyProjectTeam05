@us17
Feature: US017 Test items(öğe) Oluştur / Güncelle / Sil

  @tc001
  Scenario: TC01 Admin yeni test ogeleri olusturabilmelidir
    Given AdminNevcan Medunna anasayfasinda
    And   AdminNevcan sign in butonuna tiklar
    Then AdminNevcan gecerli bir username girer
    And AdminNevcan gecerli bir password girer
    Then AdminNevcan sign_in butonuna tiklar
    And AdminNevcan acilan sayfada ItemsTitles butonuna tiklar
    Then AdminNevcan Test Item butonuna tiklar
    And AdminNevcan CreateANewTestItem butonuna tiklayabilir
    Then AdminNevcan Name,Description,Price,DefaultMinValue,DefaultMaxValue,CreatedDate degerlerini girer
    And AdminNevcan save butonuna tiklar
    Then AdminNevcan yeni test ogesini olusturdugunu dogrular
    And AdminNevcan sayfayi kapatir

  @tc002
  Scenario: TC02 Admin test ogelerinde "Name, Description, Price, Default Min Value, Default Max Value, Created Date" seceneklerini olusturabilmeli ve guncelleyebilmelidir
    Given AdminNevcan Medunna anasayfasinda
    And   AdminNevcan sign in butonuna tiklar
    Then AdminNevcan gecerli bir username girer
    And AdminNevcan gecerli bir password girer
    Then AdminNevcan sign_in butonuna tiklar
    And AdminNevcan acilan sayfada ItemsTitles butonuna tiklar
    Then AdminNevcan Test Item butonuna tiklar
    And AdminNevcan pageNinetyFive tiklar
    Then AdminNevcan test ogesinin edit butonuna tiklar
    And AdminNevcan Name,Description,Price,DefaultMinValue,DefaultMaxValue,CreatedDate tekrar deger girer
    Then AdminNevcan save butonuna tiklar
    And AdminNevcan test ogesini guncelledigini dogrular
    And AdminNevcan sayfayi kapatir

  @tc003
  Scenario: TC03 Admin test ogelerini goruntuleyebilmelidir
    Given AdminNevcan Medunna anasayfasinda
    And   AdminNevcan sign in butonuna tiklar
    Then AdminNevcan gecerli bir username girer
    And AdminNevcan gecerli bir password girer
    Then AdminNevcan sign_in butonuna tiklar
    And AdminNevcan acilan sayfada ItemsTitles butonuna tiklar
    Then AdminNevcan Test Item butonuna tiklar
    And AdminNevcan pageNinetyFive tiklar
    Then AdminNevcan test ogesinin view butonuna tiklar
    And AdminNevcan test ogesinin goruntulendigini dogrular
    And AdminNevcan sayfayi kapatir

  @tc004
  Scenario: TC04 Admin test ogelerini silebilmelidir
    Given AdminNevcan Medunna anasayfasinda
    And   AdminNevcan sign in butonuna tiklar
    Then AdminNevcan gecerli bir username girer
    And AdminNevcan gecerli bir password girer
    Then AdminNevcan sign_in butonuna tiklar
    And AdminNevcan acilan sayfada ItemsTitles butonuna tiklar
    Then AdminNevcan Test Item butonuna tiklar
    And AdminNevcan pageNinetyFive tiklar
    Then AdminNevcan test ogesinin delete butonuna tiklar
    And AdminNevcan popup_delete butonuna tiklar
    Then AdminNevcan test ogesinin silindigini dogrular
    And AdminNevcan sayfayi kapatir
