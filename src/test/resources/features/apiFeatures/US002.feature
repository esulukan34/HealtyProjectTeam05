@US_002_API
Feature: US_002_Kayıt_olmak_icin_email_and_username_bilgileri_girilebilmelidir.

  @US002_API_TC_008 @API
  Scenario Outline: TC_008_TC009_Kullanici_adi_ve_email_api_kullanilarak_dogrulanmalidir
    Given K3 Kullanici "<Username>" icin endpointe gider
    When  K3 Kullanici "<istek>" gonderir ve yaniti alir
    Then  K3 Kullanici Status "<code>" alir
    And   K3 Kullanici yaniti "<dogrulama>" yapar
    Examples:
      |Username|istek|code|dogrulama|
      |K3Username|GET|200|okuma|
      |K3Username|DELETE|204|silme|