Feature:US 23 Staff Fatura Ödemesi

    Background:
    Given K1  kullanici Medunna sayfasina gider
    Then K1 Account menu butonu tiklanir
    When K1 kullacı 2 saniye bekler
    Then  K1 kullanıcı sıgn ın a tıklar
    When K1 kullacı 2 saniye bekler
    When  K1 kullanıcı geçerli bir username girer
    When K1 kullacı 2 saniye bekler
    And K1 kullanıcı geçerli bir pasword girer
    When K1 kullacı 2 saniye bekler
    And K1 Kullanıcı sıgn ın butonunu tıklar
      When K1 kullacı 2 saniye bekler
     And K1 kullanıcı myPages ı tıklar
      When K1 kullacı 4 saniye bekler
     And K1 kullanıcı Search Patient i tıklar
      When K1 kullacı 5 saniye bekler
  @k1
    Scenario: TC01 Kullanıcı (Staff) fatura oluşturabilmelidir
      When K1 kullacı 2 saniye bekler
      Then K1 kullanıcı ssnPatient ı tıklar
      When K1 kullacı 2 saniye bekler
      And K1 kulanıcı show Appointmens ı tıklar