@US002_UI
  Feature: US_002_Kayıt_olmak_icin_email_and_username_bilgileri_girilebilmelidir.

    Background: Ortak Adimlar
      Given K3 "medunnaUrl" ana sayfasina gider
      When  K3 Kullanici Register sekmesine tiklar
      And   K3 Kullanici SSN kutusuna "K3SSN" girer
      *     K3 Kullanici First Name kutusuna bir "K3Firstname" girer
      *     K3 Kullanici Last Name kutusuna  bir "K3Lastname" girer

    @US002_UI_TC_001 @US002_Negatif_Test
      Scenario Outline:TC_001_Email adresi_(@)_ve_(.)_karakterleri_olmadan_doldurulmamalidir
        And   K3 Kullanici Username kutusuna gecerli bir "K3Username" girer
        *     K3 Kullanici Email kutusuna gecersiz "<email>" girer
        *     K3 Kullanici New password kutusuna gecerli bir "K3Password" girer
        *     K3 Kullanici New password confirmation kutusuna ayni "K3Password" girer
        *     K3 Kullanici Register butonuna tiklar
        Then  K3 Kullanici kayit olmadigini dogrular
      Examples:
      |email|
      |tahirerdemgmailcom|
      |tahirerdemgmail.com|
      |tahirerdem@gmailcom|
      ||

    @US002_UI_TC_005 @US002_Negatif_Test
    Scenario: TC_005_Username_kismi_bos_birakilmamalidir
      And   K3 Kullanici Username kutusunu bos birakir
      *     K3 Kullanici Email kutusuna gecerli bir "K3Email" girer
      *     K3 Kullanici New password kutusuna gecerli bir "K3Password" girer
      *     K3 Kullanici New password confirmation kutusuna ayni "K3Password" girer
      *     K3 Kullanici Register butonuna tiklar
      Then  K3 Kullanici kayit olmadigini dogrular

    @US002_UI_TC_006
    Scenario:TC_006_Herhangi_bir_karakter_iceren_ve_bos_bırakılamayan_gecerli_bir_Username_olmalidir
      And   K3 Kullanici Username kutusuna gecerli bir "K3Username" girer
      *     K3 Kullanici Email kutusuna gecerli bir "K3Email" girer
      *     K3 Kullanici New password kutusuna gecerli bir "K3Password" girer
      *     K3 Kullanici New password confirmation kutusuna ayni "K3Password" girer
      *     K3 Kullanici Register butonuna tiklar
      Then  K3 Kullanici gecerli bir username ile kayit oldugunu dogrular

    @US002_UI_TC_007 @US002_Negatif_Test
    Scenario: TC_007_Username_unique_olmalidir_Negatif_Test
      And   K3 Kullanici Username kutusuna unique olmayan bir "K3Username" girer
      *     K3 Kullanici Email kutusuna gecerli bir "K3Email" girer
      *     K3 Kullanici New password kutusuna gecerli bir "K3Password" girer
      *     K3 Kullanici New password confirmation kutusuna ayni "K3Password" girer
      *     K3 Kullanici Register butonuna tiklar
      Then  K3 Kullanici unique olmayan username ile kayit olmadigini dogrular


