@US028_E2E_UI_DB_API
  Feature: US028_End_To_End_Testi

    Scenario: TC_001_Admin_yeni_bir_ulke_olusturabilir
      Given K3 "medunnaUrl" ana sayfasina gider
      When  K3 Admin Sign in sekmesine tiklar
      And   K3 Admin Username kutusuna gecerli bir "K3Adminname" girer
      *     K3 Admin Password kutusuna gecerli bir "K3Password" girer
      *     K3 Admin Sign in butonuna tiklar
      *     K3 Admin Items&Titles acilir menusune tiklar
      *     K3 Admin acilir menuden Country secenegine tiklar
      *     K3 Admin +Create a new Country butonuna tiklar
      *     K3 Admin Country Name kutusuna yeni "K3Ulke" adini girer
      *     K3 Admin Save butonuna tiklar
      Then  K3 Admin yeni ulke olusturuldugunu dogrular


    @DB
    Scenario: TC_006_Country_DB_Testi
      Given K3 Admin country icin "K3countryquery" ile "name" sutunundan kayitli bilgileri ceker
      Then  K3 Admin E2E country icin bilgileri dogrular

    @API
    Scenario Outline: Admin_Contry_API_ile_dogrulayabilmeli_ve_silebilmeli
      Given K3 Admin ulke icin "<endpoint>"e gider
      When  K3 Admin ulke icin "<istek>" gonderir ve yaniti alir
      Then  K3 Admin ulke icin Status "<code>" alir
      And   K3 Admin ulke icin yaniti "<dogrulama>" yapar
      Examples:
        |endpoint|istek|code|dogrulama|
        |E2E_id|GET|200|E2E_Read|
        |E2E_id|DELETE|204|Delete|

