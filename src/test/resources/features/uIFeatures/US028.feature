
@US028
Feature: Admin olarak Country oluşturma / Okuma ve Silme

  Background: Ortak Adimlar
    Given K3 "medunnaUrl" ana sayfasina gider
    When  K3 Admin Sign in sekmesine tiklar
    And   K3 Admin Username kutusuna gecerli bir "K3Adminname" girer
    *     K3 Admin Password kutusuna gecerli bir "K3Password" girer
    *     K3 Admin Sign in butonuna tiklar
    *     K3 Admin Items&Titles acilir menusune tiklar


  @US028_TC_001 @US028_TC_002 @US028_TC_003
  Scenario: TC_001_Admin_yeni_bir_ulke_olusturabilir
    And   K3 Admin acilir menuden Country secenegine tiklar
    *     K3 Admin +Create a new Country butonuna tiklar
    *     K3 Admin Country Name kutusuna yeni "K3Ulke" adini girer
    *     K3 Admin Save butonuna tiklar
    Then  K3 Admin yeni ulke olusturuldugunu dogrular

  @US028_TC_002
  Scenario: TC_002_Admin_ulkeye_gore_ilgili_eyaletler_veya_sehirler_olusturabilmeli
    And   K3 Admin acilir menuden State-City secenegine tiklar
    *     K3 Admin +Create a new State-City butonuna tiklar
    *     K3 Admin Name kutusuna "K3State" adini girer
    *     K3 Admin State-City menusunden "K3Ulke" secer
    *     K3 Admin Save butonuna tiklar
    Then  K3 Admin ulkeye ait eyalet-sehir olusturdugunu dogrular

  @US028_TC_003
  Scenario: TC_003_Admin_ulkeleri_silebilmelidir
    And   K3 Admin acilir menuden Country secenegine tiklar
    And   K3 Admin silinecek "K3Ulke" gider ve delete butonuna tiklar
    And   K3 Admin country icin Pop-Up'ta cikan Delete butonuna tiklar
    Then  K3 Admin ulkeyi sildiginin dogrular
