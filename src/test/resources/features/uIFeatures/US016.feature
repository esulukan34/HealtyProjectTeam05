  @US016
  Feature: US016_Oda_Olusturma_Goruntuleme_Guncelleme_Silme(Admin)

    Background: Ortak Adimlar
      Given K3 "medunnaUrl" ana sayfasina gider
      When  K3 Admin Sign in sekmesine tiklar
      And   K3 Admin Username kutusuna gecerli bir "K3Adminname" girer
      *     K3 Admin Password kutusuna gecerli bir "K3Password" girer
      *     K3 Admin Sign in butonuna tiklar
      *     K3 Admin Items&Titles acilir menusune tiklar
      *     K3 Admin acilir menuden Room secenegine tiklar

    @US016_TC_001
    Scenario Outline: TC_001_Admin_yatan_hastalar_icin_yeni_oda_olusturabilir
      And   K3 Admin Create a new Room butonuna tiklar
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
          |8210702|DELUXE|false|150|K3Deluxe|ileriTarih|yeniKayit|
          |8210703|PREMIUM_DELUXE|true|200|K3Premium|guncelTarih|yeniKayit|
          |8210704|SUIT|false|250|K3Suit|ileriTarih|yeniKayit|
          |8210705|DAYCARE|true|75|K3dayCare|guncelTarih|yeniKayit|

    @US016_TC_002_TC_003 @US016_TC_005 @US016_TC_006
    Scenario Outline:TC_002_TC003_ve_TC004Fiyat_ve_Created_Date_Negatif_Testleri
      And   K3 Admin Create a new Room butonuna tiklar
      *     K3 Admin Room Number kutusuna unique bir "<oda numarasi>" girer
      *     K3 Admin Room Type secenegini "<room Type>" secer
      *     K3 Admin "<Status>" belirtir
      *     K3 Admin Price kutusuna "<oda ucretini>" girer
      *     K3 Admin Description kutusuna "<oda bilgileri>" girer
      *     K3 Admin Created Date kutusuna "<tarih>" girer
      *     K3 Admin Save butonuna tiklar
      Then  K3 Admin yeni oda olusturulmadigini "<dogrular>"
        Examples:
          |oda numarasi|room Type|Status|oda ucretini|oda bilgileri|tarih|dogrular|
          ||TWIN|true|100|K3Twin|guncelTarih|room number|
          |8210706|TWIN|true||K3Twin|guncelTarih|price|
          |8210707|TWIN|true|100|K3Twin|gecmisTarih|tarih|
          |8210707|TWIN|true|100|K3Twin|guncelTarih|ayni oda|



    @US016_TC_005
    Scenario Outline: TC_005_Admin_mevcut_odalari_duzenleyebilir_ve_guncelleyebilir
      And   K3 Admin guncelleme yapilacak "<odaya>" gider
      *     K3 Admin Edit butonuna tiklar
      *     K3 Admin Room Number kutusuna unique bir "<oda numarasi>" girer
      *     K3 Admin Room Type secenegini "<room Type>" secer
      *     K3 Admin "<Status>" belirtir
      *     K3 Admin Price kutusuna "<oda ucretini>" girer
      *     K3 Admin Description kutusuna "<oda bilgileri>" girer
      *     K3 Admin Created Date kutusuna "<tarih>" girer
      *     K3 Admin Save butonuna tiklar
      Then  K3 Admin "<dogrulama>" yapar
        Examples:
          |odaya|oda numarasi|room Type|Status|oda ucretini|oda bilgileri|tarih|dogrulama|
          |8210707|8210708|DELUXE|false|150|K3Deluxe|guncelTarih|guncelleme|

    @US016_TC_006
    Scenario Outline: TC_006_Odalar_Admin_tarafindan_silinebilir
      And K3 Admin silinecek "<odaya>" gider ve Delete butonuna tiklar
      *   K3 Admin Pop-Up'ta cikan Delete butonuna tiklar
      *   K3 Admin "<dogrulama>" yapar
        Examples:
          |odaya|dogrulama|
          |8210707|silme|


    @US016_TC_007
    Scenario Outline: TC_007_Admin_ayni_tur_odalari_gorebilir
      And   K3 Admin Room Type basligina tiklar
      Then  K3 Admin "<Room Type 1>" oda tiplerini gorur
      And   K3 Admin Room Type basligina tiklar
      Then  K3 Admin "<Room Type 2>" oda tiplerini gorur
      And   K3 Admin Room Type basligina tiklar
      Then  K3 Admin "<Room Type 3>" oda tiplerini gorur
      Examples:
        |Room Type 1|Room Type 2|Room Type 3|
        |TWIN       |DAYCARE    |DELUXE     |