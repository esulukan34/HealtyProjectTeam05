Feature: US07
  Background: Hasta doğru bilgileri ile sisteme giriş yapar.
    Given K6 medunna.com adresine gider
    Then  K6 Kullanici Signin olmak icin Signin iconuna tiklar
    Then  K6 Acilan menude hasta kaydi sirasinda secilen username girilir
    Then  K6 Hasta kaydi sirasinda secilen pasword girilir.
    Then  K6 Signin butonuna tiklanir
    Then  K6 Kullanici olarak sayfaya girdigini dogrular


  @US07-UI-TC1
  Scenario: TC01  Hasta doğru bilgiler ile randevu oluşturabilir.
    Then  K6 Kullanici myPage menusune tiklar
    Then  K6 make appointment linkine tiklar
    Then  K6 phone kismina on haneli bir telefon girer
    Then  K6 guncel tarihten ileri bir tarihi girer
    Then  K6 kaydet butonuna tiklar
    Then  K6 sayfayi kapatir


  @US07-UI-TC2
  Scenario: TC02  Hasta randevu oluşturabildiğini doğrular
    Then  K6 Kullanici myPage menusune tiklar
    Then  K6 my appointment linkine tiklar
    Then  sayfadaki ilk appointment adetini hesaplar
    Then  K6 Kullanici myPage menusune tiklar
    Then  K6 make appointment linkine tiklar
    Then  K6 phone kismina on haneli bir telefon girer
    Then  K6 guncel tarihten ileri bir tarihi girer
    Then  K6 kaydet butonuna tiklar
    Then  K6 Kullanici myPage menusune tiklar
    Then  K6 my appointment linkine tiklar
    Then  K6 Web driver 3 sn bekler
    Then  K6 sayfadaki ikinci appointment adetini hesaplar
    Then  K6 appointment adetinin artigini dogrular
    Then  K6 sayfayi kapatir


  @US07-UI-TC3
  Scenario: TC03  Hasta gecmiş bir tarih ile randevu oluşturamaz.
    Then  K6 Kullanici myPage menusune tiklar
    Then  K6 make appointment linkine tiklar
    Then  K6 phone kismina on haneli bir telefon girer
    Then  K6 guncel tarihten onceki bir tarihi girer
    Then  K6 Appointment date can not be past date! hata mesajini dogrular
    Then  K6 sayfayi kapatir


  @US07-UI-TC4
  Scenario: TC04  Hasta hatali telefon numarasi ile randevu oluşturamaz.
    Then  K6 Kullanici myPage menusune tiklar
    Then  K6 make appointment linkine tiklar
    Then  K6 guncel tarihten ileri bir tarihi girer
    Then  K6 phone kismina hatali bir telefon girer
    Then  K6 kaydet butonuna tiklar
    Then  K6 Web driver 2 sn bekler
    Then  K6 Phone number is invalid hata mesajini dogrular
    Then  K6 sayfayi kapatir








