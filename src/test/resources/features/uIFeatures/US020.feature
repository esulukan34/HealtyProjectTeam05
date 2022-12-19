Feature: US20
  Background: Fake bir kullanici olusturulur ve ID'ye göre tersten sıralanırlar
    Given KullaniciAlti medunna.com adresine gider
    Then  KullaniciAlti user iconuna tiklar
    Then  KullaniciAlti Register linkine tiklar
    Then  KullaniciAlti Fake bir kullanici olusturur
    Then  KullaniciAlti Fake kullanici Edit url'e gidilir
    Then  KullaniciAlti Admin sifresi girilir


  @US20-UI-TC1
  Scenario: TC01 KullaniciAlti Fake bir kullanici olusturur, bilgilerini görür ve doğrular
    Then  KullaniciAlti Admin Fake kullanici bilgilerini dogrular
    Then  KullaniciAlti Admin Fake hesabi save eder
    Then  KullaniciAlti Admin kullanicilari tersten siralar
    Then  KullaniciAlti Admin Fake hesabi siler
    Then  KullaniciAlti Sayfa kapatilir


  @US20-UI-TC2
  Scenario: TC02 KullaniciAlti Fake bir kullanici olusturur Aktif eder, Görev atar ve Aktif olduğunu doğrular
    Then  KullaniciAlti Admin Fake kullaniciyi Active yapar
    Then  KullaniciAlti Admin Fake kullaniciya bir rol atar
    Then  KullaniciAlti Admin logout olur
    Then  KullaniciAlti Fake kullanici login olur
    Then  KullaniciAlti Fake kullanicinin login oldugu dogrulanir
    Then  KullaniciAlti Fake kullanici logout olur
    Then  KullaniciAlti Admin login olur
    Then  KullaniciAlti Admin user management linkine tiklar
    Then  KullaniciAlti Admin kullanicilari tersten siralar
    Then  KullaniciAlti Admin Fake hesabi siler
    Then  KullaniciAlti Sayfa kapatilir


  @US20-UI-TC3
  Scenario: TC02 KullaniciAlti Fake bir kullanici olusturur siler ve sildiğini doğrular
    Then  KullaniciAlti Admin Fake kullaniciyi Active yapar
    Then  KullaniciAlti Admin Fake kullaniciya bir rol atar
    Then  KullaniciAlti Admin logout olur
    Then  KullaniciAlti Fake kullanici login olur
    Then  KullaniciAlti Fake kullanicinin login oldugu dogrulanir
    Then  KullaniciAlti Fake kullanici logout olur
    Then  KullaniciAlti Admin login olur
    Then  KullaniciAlti Admin user management linkine tiklar
    Then  KullaniciAlti Admin kullanicilari tersten siralar
    Then  KullaniciAlti Admin Fake hesabi siler
    Then  KullaniciAlti Admin logout olur
    Then  KullaniciAlti Fake kullanici login olur
    Then  KullaniciAlti Fake hesap silindigi icin login olamadigi dogrulanir
    Then  KullaniciAlti Sayfa kapatilir














