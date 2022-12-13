Feature: Staff(Personel) Olusturma/Guncelleme/Goruntuleme/Silme API Testleri
@US019-APIvs-DB @API
  Scenario Outline: TC009 Varolan Staff kullanicisinin bilgilerinin dogrulanmasi (GET Request VS Database query)
    Given K8 Admin "<id>" numarali Staff Kullanicisinin bilgilerine GET Request gonderir
    Then K8 Ayni "<id>" numarali staff kullanicisi icin Database'e query gonderir
    Then K8 Status Code'nin 200 oldugu dogrulanir
    And K8 Response'den donen bilgiler ile databaseden gelen bilgilerin dogrulugu kontrol edilir
    Examples:
      | id |
      | 366708 |
      | 366748 |
@US019-API-GetReq @API
    Scenario Outline: TC011 Varolan Staff kullanicisinin bilgilerinin dogrulanmasi GET Request
      Given K8 Admin "<id>" numarali Staff Kullanicisinin bilgilerine GET Request gonderir
      Then K8 Status Code'nin 200 oldugu dogrulanir
      And K8 Response'den donen bilgilerin dogrulugu kontrol edilir
      Examples:
        | id |
        | 366708 |
        | 366748 |
  @US019-API-DeleteReq @API
  Scenario Outline: TC012 API ile doğrulayın(Admin, personeli silebilmeli)
    Given K8 Admin "<id>" numarali Staff Kullanicisinin bilgilerine DELETE Request gonderir
    Then K8 Status Code'nin 204 oldugu dogrulanir
    Examples:
      | id |
      | 400523 |