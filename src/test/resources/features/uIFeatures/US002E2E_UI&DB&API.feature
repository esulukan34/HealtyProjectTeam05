 @US002_E2E_UI_DB_API_Test
  Feature: US002_End_To_End_Test

    Scenario:Herhangi_bir_karakter_iceren_ve_bos_bırakılamayan_gecerli_bir_Username_olmalidir
      Given K3 "medunnaUrl" ana sayfasina gider
      When  K3 Kullanici Register sekmesine tiklar
      And   K3 Kullanici SSN kutusuna "K3SSN" girer
      *     K3 Kullanici First Name kutusuna bir "K3Firstname" girer
      *     K3 Kullanici Last Name kutusuna  bir "K3Lastname" girer
      *     K3 Kullanici Username kutusuna gecerli bir "K3Username" girer
      *     K3 Kullanici Email kutusuna gecerli bir "K3Email" girer
      *     K3 Kullanici New password kutusuna gecerli bir "K3Password" girer
      *     K3 Kullanici New password confirmation kutusuna ayni "K3Password" girer
      *     K3 Kullanici Register butonuna tiklar
      Then  K3 Kullanici gecerli bir username ile kayit oldugunu dogrular

    @DB
    Scenario: Kullanici_DB_test
      Given  K3 Kullanici "K3userquery" ile "email" sutunundan kayitli bilgileri ceker
      Then   K3 Kullanici email bilgilerini E2E icin dogrular

    @API
    Scenario Outline: Kullanici_adi_ve_email_api_kullanilarak_dogrulanmalidir
      Given K3 Kullanici "<Username>" icin endpointe gider
      When  K3 Kullanici "<istek>" gonderir ve yaniti alir
      Then  K3 Kullanici Status "<code>" alir
      And   K3 Kullanici yaniti "<dogrulama>" yapar
      Examples:
        |Username|istek|code|dogrulama|
        |K3Username|GET|200|okuma|
        |K3Username|DELETE|204|silme|


