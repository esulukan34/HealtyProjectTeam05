Feature: US06
  Scenario: TC01  : Bilgiler kayit girerken doldurulan kullanici bilgileri ile ayni olmalidir.
  Given K6 medunna.com adresine gider
  Then  K6 Kullanici Signin olmak icin Signin iconuna tiklar
  Then  K6 Acilan menude hasta kaydi sirasinda secilen username girilir
  Then  K6 Hasta kaydi sirasinda secilen pasword girilir.
  Then  K6 Signin butonuna tiklanir
  Then  K6 Kullanici olarak sayfaya girdigini dogrular
  Then  K6 Kullanici adina tiklar, acilan menuden Settings tiklar
  Then  K6 Firstname kutusundaki ismin, kayit sirasinda secilen isim ile ayni oldugu dogrulanir
  Then  K6 Lastname kutusundaki soyismin, kayit sirasinda secilen soyisim ile ayni oldugu dogrulanir
  Then  K6 Email kutusundaki mailin, kayit sirasinda secilen mail ile ayni oldugu dogrulanir
  And   K6 sayfayi kapatir


  Scenario: TC02 :  "Firstname"güncelleme seçeneği olmalıdır
    Given K6 medunna.com adresine gider
    Then  K6 Kullanici Signin olmak icin Signin iconuna tiklar
    Then  K6 Acilan menude hasta kaydi sirasinda secilen username girilir
    Then  K6 Hasta kaydi sirasinda secilen pasword girilir.
    Then  K6 Signin butonuna tiklanir
    Then  K6 Kullanici olarak sayfaya girdigini dogrular
    Then  K6 Kullanici adina tiklar, acilan menuden Settings tiklar
    Then  K6 Firstname kutusundaki ismi siler ve yerine herhangi bir isim girer
    Then  K6 Kayit butonuna tiklar
    Then  K6 Firstname kutusundaki ismin rastgele girilen isim oldugunu dogrular
    Then  K6 Test sonrasi islemlerin dogru olmasi icin Firstname kismina yeniden Zehra girer
    And   K6 Kayit butonuna tiklar
    And   K6 sayfayi kapatir


  Scenario: TC03 :  "Lastname"güncelleme seçeneği olmalıdır
    Given K6 medunna.com adresine gider
    Then  K6 Kullanici Signin olmak icin Signin iconuna tiklar
    Then  K6 Acilan menude hasta kaydi sirasinda secilen username girilir
    Then  K6 Hasta kaydi sirasinda secilen pasword girilir.
    Then  K6 Signin butonuna tiklanir
    Then  K6 Kullanici olarak sayfaya girdigini dogrular
    Then  K6 Kullanici adina tiklar, acilan menuden Settings tiklar
    Then  K6 Lastname kutusundaki soyismi siler ve yerine herhangi bir soyisim girer
    Then  K6 Kayit butonuna tiklar
    Then  K6 Sayfayi yeniler
    Then  K6 Lastname kutusundaki soyismin rastgele girilen soyisim oldugunu dogrular
    Then  K6 Test sonrasi islemlerin dogru olmasi icin Lastname kismina yeniden Sen girer
    And   K6 Kayit butonuna tiklar
    And   K6 sayfayi kapatir


  Scenario: TC04 :  "email"güncelleme seçeneği olmalıdır
    Given K6 medunna.com adresine gider
    Then  K6 Kullanici Signin olmak icin Signin iconuna tiklar
    Then  K6 Acilan menude hasta kaydi sirasinda secilen username girilir
    Then  K6 Hasta kaydi sirasinda secilen pasword girilir.
    Then  K6 Signin butonuna tiklanir
    Then  K6 Kullanici olarak sayfaya girdigini dogrular
    Then  K6 Kullanici adina tiklar, acilan menuden Settings tiklar
    Then  K6 email kutusundaki bilgiyi siler ve yerine rastgele bir email girer
    Then  K6 Kayit butonuna tiklar
    Then  K6 Sayfayi yeniler
    Then  K6 email kutusundaki mailin rastgele girilen mail oldugunu dogrular
    Then  K6 Test sonrasi islemlerin dogru olmasi icin mail kismina yeniden orjinal maili girer
    And   K6 Kayit butonuna tiklar
    And   K6 sayfayi kapatir

  Scenario: TC05 : İsim, soyisim ve e-mail alanı boş bırakılmamalı
    Given K6 medunna.com adresine gider
    Then  K6 Kullanici Signin olmak icin Signin iconuna tiklar
    Then  K6 Acilan menude hasta kaydi sirasinda secilen username girilir
    Then  K6 Hasta kaydi sirasinda secilen pasword girilir.
    Then  K6 Signin butonuna tiklanir
    Then  K6 Kullanici olarak sayfaya girdigini dogrular
    Then  K6 Kullanici adina tiklar, acilan menuden Settings tiklar
    Then  K6 isim kutusundaki bilgiyi siler ve hata mesajini dogrular
    Then  K6 Test sonrasi islemlerin dogru olmasi icin Firstname kismina yeniden Zehra girer
    Then  K6 soyisim kutusundaki bilgiyi siler ve hata mesajini dogrular
    Then  K6 Test sonrasi islemlerin dogru olmasi icin Lastname kismina yeniden Sen girer
    Then  K6 email kutusundaki bilgiyi siler ve hata mesajini dogrular
    Then  K6 Test sonrasi islemlerin dogru olmasi icin mail kismina yeniden orjinal maili girer
    Then  K6 Kayit butonuna tiklar
    And   K6 sayfayi kapatir





