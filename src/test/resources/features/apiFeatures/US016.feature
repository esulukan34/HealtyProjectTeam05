@US016_API
Feature:US_016_Oda_Olusturma_Goruntuleme_Guncelleme_Silme(Admin)

  @US016_API_TC_007 @API
  Scenario Outline: TC_007_API_ile_oda_olusturma_okuma_guncellme_ve_silme_dogrulanmali
    Given K3 Admin oda icin "<endpoint>"e gider
    When  K3 Admin oda icin "<istek>" gonderir ve yaniti alir
    Then  K3 Admin oda icin Status "<code>" alir
    And   K3 Admin oda icin yaniti "<dogrulama>" yapar
    Examples:
      |endpoint|istek|code|dogrulama|
      |rooms|POST|201|Create|
      |id|GET|200|Read|
      |rooms|PUT|200|Update|
      |id|DELETE|204|Delete|