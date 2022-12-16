Feature: Varolan Staff kullanicisinin bilgilerinin dogrulanmasi
  @US019DB
  Scenario: TC010 Var olan kullanicinin bilgilerinin dogrulanmasi
    Given K8 Medunna DataBase ile baglanti kurulur
    Then K8 366708 id numaralı staff kullanicisinin Databasedeki verilerine query gonderilir
    And K8 Verilerin dogrulugu kontrol edilir
    And K8 Database ile baglati kesilir