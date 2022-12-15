Feature: US21
  Background: Staff Login olur, search Patienets'ten SSN girer, hastayı ekranda görür
    Given KullaniciAlti medunna.com adresine gider
    Then  KullaniciAlti user iconuna tiklar
    Then  KullaniciAlti Staff Login olur
    Then  KullaniciAlti Staff MyPages - Search Patient'te tiklar
    Then  KullaniciAlti Staff Patientin SSN girer


  @US21-UI-TC1
  Scenario: TC01 BUG : Staff Sadece Randevuları Görüntüleyebilir
    Then  KullaniciAlti Staff Patienti duzenlemek icin Edite tiklar
    Then  KullaniciAlti Staff Patientin isim ve soyisim bilgisini degiskene aktarir
    Then  KullaniciAlti Staff Patientin isim ve soyisim bilgisini degistirir
    Then  KullaniciAlti Staff Kaydet butonuna tiklar
    Then  KullaniciAlti Staff Patient View Sayfasında Edite tiklar
    Then  KullaniciAlti Staff Patientin degisiklik sonrasi isim ve soyisim bilgisini degiskene aktarir
    Then  KullaniciAlti isim ve soyisim bilgisinin degistigi dogrulanir_BUG
    Then  KullaniciAlti Hastanin gercek ismi ve soyismi tekrar girilir
    Then  KullaniciAlti Staff Kaydet butonuna tiklar
    Then  KullaniciAlti Sayfa kapatilir
#BUG için rapor alınacak


  @US21-UI-TC2
  Scenario: TC02 Staff Hastanın Randevusunun Status Bilgilerini Dogru Şekilde Düzenleyebilir
    Then  KullaniciAlti Staff Patientin Randevularini goruntuler
    Then  KullaniciAlti Staff Patientin Birinci Randevusunu Editlemek icin Edite tiklar
    Then  KullaniciAlti Staff Patientin Status bilgisini duzenler ve dogrular
    Then  KullaniciAlti Sayfa kapatilir


  @US21-UI-TC3
  Scenario: TC03 BUG : Staff Hastanın Randevusunda Anamnesis, Treatment veya Diagnosis kısımlarına data girememeli.
    Then  KullaniciAlti Staff Patientin Randevularini goruntuler
    Then  KullaniciAlti Staff Patientin Birinci Randevusunu Editlemek icin Edite tiklar
    Then  KullaniciAlti Staff Patientin Anamnesis Treatment ve Diagnosis bilgilerini degiskene aktarir
    Then  KullaniciAlti Staff Patientin Anamnesis Treatment ve Diagnosis metin kutularina FAKER metin girer, Save tiklar
    Then  KullaniciAlti Staff Patientin SSN girer
    Then  KullaniciAlti Staff Patientin Randevularini goruntuler
    Then  KullaniciAlti Staff Patientin Birinci Randevusunu Editlemek icin Edite tiklar
    Then  KullaniciAlti Staff Patientin Anamnesis Treatment ve Diagnosis bilgilerini tekrar degiskene aktarir
    Then  KullaniciAlti Staff Patientin Anamnesis Treatment ve Diagnosis bilgilerinin degistigini dogrular
    Then  KullaniciAlti Sayfa kapatilir


  @US21-UI-TC4
  Scenario: TC04 BUG : Staff Hastanın Randevu Bölümünde Hasta için gerekli doktoru seçebilmeli
    Then  KullaniciAlti Staff Patientin Randevularini goruntuler
    Then  KullaniciAlti Staff Patientin Birinci Randevusunu Editlemek icin Edite tiklar
    Then  KullaniciAlti Staff Patient icin Doktor atar ve dogrular
    Then  KullaniciAlti Sayfa kapatilir



  @US21-UI-TC5
  Scenario: TC04  : Staff Hastaların Test sonuçlarını görebilir
    Then  KullaniciAlti Staff Patientin Randevularini goruntuler
    Then  KullaniciAlti Staff Patientin Birinci Randevu Test Sonuclarini Gormek icin Show Testse tiklar
    Then  KullaniciAlti Staff Test Sayfasinin goruntulendigini dogrular
    Then  KullaniciAlti Sayfa kapatilir



