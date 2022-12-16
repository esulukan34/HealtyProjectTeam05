Feature: My Appointments (Randevular) (Patient)
  Background:
    Given K1  kullanici Medunna sayfasina gider
     Then K1 Account menu butonu tiklanir
     When K1 kullacı 2 saniye bekler
     Then  K1 kullanıcı sıgn ın a tıklar
     When K1 kullacı 2 saniye bekler
     When  K1 kullanıcı(patient) geçerli bir username girer
     When K1 kullacı 2 saniye bekler
     And K1 kullanıcı (patient)geçerli bir pasword girer
     When K1 kullacı 2 saniye bekler
     And K1 Kullanıcı sıgn ın butonunu tıklar
  Scenario:Hasta hesabına girdiğinde test sonuçlarını görebilmelidir
     And K1 kullanıcı myPages(patient) ı tıklar
     When K1 kullacı 4 saniye bekler
     And K1 kulanıcı  MyAppointmens ı tıklar

