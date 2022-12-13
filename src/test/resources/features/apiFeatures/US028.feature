@US028_API
Feature: US028_API_Testleri
  @API
  Scenario Outline: TC_004_ve_TC_005_Admin_Contry_API_ile_dogrulayabilmeli_ve_guncelleyebilmeli
    Given K3 Admin ulke icin "<endpoint>"e gider
    When  K3 Admin ulke icin "<istek>" gonderir ve yaniti alir
    Then  K3 Admin ulke icin Status "<code>" alir
    And   K3 Admin ulke icin yaniti "<dogrulama>" yapar
    Examples:
      |endpoint|istek|code|dogrulama|
      |initial|POST|201|Create|
      |id|GET|200|Read|
      |countries|PUT|200|Update|
      |id|DELETE|204|Delete|