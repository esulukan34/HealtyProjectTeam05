@gp
Feature: Giriş sayfası yalnızca geçerli kimlik bilgileriyle erişilebilir olmalıdır.

  Scenario: TC 01 kullanıcı giriş yapmak için başarı mesajını doğrulayan
  geçerli bir kullanıcı adı ve şifre olmalıdır
    Given A  kullanici Medunna sayfasina gider
    Then A Account menu butonu tiklanir
    When A kullacı 2 saniye bekler
    Then  A kullanıcı sıgn ın a tıklar
    When A kullacı 2 saniye bekler
    When  A kullanıcı geçerli bir username girer
    When A kullacı 2 saniye bekler
    And A kullanıcı geçerli bir pasword girer
    When A kullacı 2 saniye bekler
    And A Kullanıcı sıgn ın butonunu tıklar
    And A kullanıcı sayfa başlığnı görnürlüğünü doğrular
    And A sayfayı kapatır

  Scenario Outline: : TC01A kullanici gecersiz bilgilerle giris yapılamadığını kontrol eder
    Given A kullanici Medunna sayfasina gider
    When A Account menu butonu tiklanir
    Then A kullanıcı sıgn ın a tıklar
    When A kullacı 2 saniye bekler
    And A kullanıcı"<geçersizUsername>" username girer
    When A kullacı 2 saniye bekler
    And A kullanıcı "<geçersizPassword>" password girer
    When A kullacı 2 saniye bekler
    Then A Kullanıcı sıgn ın butonunu tıklar
    Then A sayfaya giris yapilamadigini kontrol eder
    Examples:
      | geçersizUsername | geçersizPassword |
      | Ahmet            |          1111    |

  Scenario: TC02 kullanıcı kimlik bilgilerini herzaman kullanabileceği Remember me seçeneği olmalıdır
    Given A kullanici Medunna sayfasina gider
    When A kullacı 2 saniye bekler
    When A Account menu butonu tiklanir
    When A kullacı 2 saniye bekler
    Then A kullanıcı sıgn ın a tıklar
    When A kullacı 2 saniye bekler
    When A kullanıcı geçerli bir username girer
    When A kullacı 2 saniye bekler
    Then A kullanıcı geçerli bir pasword girer
    And A kullanıcı Remmember me butonunun görünürlüğünü test eder
    And A sayfayı kapatır




  Scenario:TC03 Eğer şifre unutulursa diye "Did you forget your password?" seçeneği olmalıdır
    Given A kullanici Medunna sayfasina gider
    When A kullacı 2 saniye bekler
    When  A Account menu butonu tiklanir
    Then A kullanıcı sıgn ın a tıklar
    When  A kullacı 2 saniye bekler
    When A kullanıcı geçerli bir username girer
    When  A kullacı 2 saniye bekler
    Then A kullanıcı geçerli bir pasword girer
    And  A kullanıcı Did you forget your password? butonunun görünürlüğünü test eder


  Scenario:TC04 "You don't have an account yet? Register a new account" seçeneği olmalıdır.
    Given A kullanici Medunna sayfasina gider
    When A kullacı 2 saniye bekler
    When  A Account menu butonu tiklanir
    Then A kullanıcı sıgn ın a tıklar
    When  A kullacı 2 saniye bekler
    When A kullanıcı geçerli bir username girer
    When  A kullacı 2 saniye bekler
    Then A kullanıcı geçerli bir pasword girer
    And A kullanıcı You don't have an account yet? Register a new account butonunun görünürlüğünü test eder


  Scenario:TC05 kullanıcı "Cancel" sçeneğini tıklar
    Given A kullanici Medunna sayfasina gider
    When A kullacı 2 saniye bekler
    When  A Account menu butonu tiklanir
    Then A kullanıcı sıgn ın a tıklar
    When  A kullacı 2 saniye bekler
    When A kullanıcı geçerli bir username girer
    When  A kullacı 2 saniye bekler
    Then A kullanıcı geçerli bir pasword girer
    And A "Cancel" seçeneği olmalıdır.
