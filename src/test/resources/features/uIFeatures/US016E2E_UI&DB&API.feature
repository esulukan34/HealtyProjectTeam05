@US016E2E_UI_DB_API
  Feature: US016_End_To_End_Testi

    Scenario Outline: TC_001_Admin_yatan_hastalar_icin_yeni_oda_olusturabilir
      Given K3 "medunnaUrl" ana sayfasina gider
      When  K3 Admin Sign in sekmesine tiklar
      And   K3 Admin Username kutusuna gecerli bir "K3Adminname" girer
      *     K3 Admin Password kutusuna gecerli bir "K3Password" girer
      *     K3 Admin Sign in butonuna tiklar
      *     K3 Admin Items&Titles acilir menusune tiklar
      *     K3 Admin acilir menuden Room secenegine tiklar
      *     K3 Admin Create a new Room butonuna tiklar
      *     K3 Admin Room Number kutusuna unique bir "<oda numarasi>" girer
      *     K3 Admin Room Type secenegini "<room Type>" secer
      *     K3 Admin "<Status>" belirtir
      *     K3 Admin Price kutusuna "<oda ucretini>" girer
      *     K3 Admin Description kutusuna "<oda bilgileri>" girer
      *     K3 Admin Created Date kutusuna "<tarih>" girer
      *     K3 Admin Save butonuna tiklar
      Then  K3 Admin "<dogrulama>" yapar
      Examples:
        |oda numarasi|room Type|Status|oda ucretini|oda bilgileri|tarih|dogrulama|
        |8210701|TWIN|true|100|K3Twin|guncelTarih|yeniKayit|

    @DB
    Scenario: TC_008_Room_DB_Testi
      Given K3 Admin oda icin "K3roomquery" ile "room_number" sutunundan kayitli bilgileri ceker
      Then  K3 Admin E2E icin oda bilgilerini dogrular

    @API
    Scenario Outline: API_ile_oda_okuma_guncellme_ve_silme_dogrulanmali
      Given K3 Admin oda icin "<endpoint>"e gider
      When  K3 Admin oda icin "<istek>" gonderir ve yaniti alir
      Then  K3 Admin oda icin Status "<code>" alir
      And   K3 Admin oda icin yaniti "<dogrulama>" yapar
      Examples:
        |endpoint|istek|code|dogrulama|
        |E2E_id|GET|200|E2E_Read|
        |E2E_id|DELETE|204|Delete|