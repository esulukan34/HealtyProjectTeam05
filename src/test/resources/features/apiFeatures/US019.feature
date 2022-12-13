Feature: Staff(Personel) Olusturma/Guncelleme/Goruntuleme/Silme API Testleri

  Scenario Outline: TC009 Varolan Staff kullanicisinin bilgilerinin dogrulanmasi (GET Request VS Database query)
    Given K8 Admin "<id>" numarali Staff Kullanicisinin bilgilerine GET Request gonderir
    Then K8 Ayni "<id>" numarali staff kullanicisi icin Database'e query gonderir
    Then K8 Status Code'nin 200 oldugu dogrulanir
    And K8 Response'den donen bilgiler ile databaseden gelen bilgilerin dogrulugu kontrol edilir
    Examples:
      | id |
      | 366708 |
      | 366748 |

    Scenario Outline: TC011 Varolan Staff kullanicisinin bilgilerinin dogrulanmasi GET Request
      Given K8 Admin "<id>" numarali Staff Kullanicisinin bilgilerine GET Request gonderir
      Then K8 Status Code'nin 200 oldugu dogrulanir
      And K8 Response'den donen bilgilerin dogrulugu kontrol edilir
      Examples:
        | id |
        | 366708 |
        | 366748 |