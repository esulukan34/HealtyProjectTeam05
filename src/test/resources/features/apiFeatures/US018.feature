@US018_Api
  Feature: US018_Api
    Scenario: Doktorlari Api ile Dogrulama

      Given K10 399601 Id numarali doktorun tum bilgileri icin get request gonderir
       Then K10 Status code 200 oldugu dogrulanir
       And  K10 response ile dogrulanir