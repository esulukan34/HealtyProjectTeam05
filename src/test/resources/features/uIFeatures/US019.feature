@US019
Feature: Admin olarak; Yeni Staff (Personel) Oluşturma / Güncelleme / Görüntüleme ve Silme
@US019PASS
  Scenario: TC001 Admin SSN kullanarak; kayıtlı kişiler arasında Staff arayabilir.
    Given K8 Kullanici URL'ye gider
    Then K8 Giris simgesine tiklar ve Sign in'e tiklar
    Then K8 Admin kullanicisina ait kullanici adi ve sifre girer
    Then K8 Items&Titles'e tiklar
    Then K8 Staff'e tiklar
    Then K8 Create a new Staff buttonuna tiklar
    Then K8 SSN bolumune var olan bir Staff SSN'i girilir
    Then K8 Search User butonun tiklanir
    And K8 User found with search SSN uyarisi gorulur
  @Bug1
    Scenario Outline: TC002 Admin SSN kullanarak; kayıtlı kişiler arasında Staff arayabilir.(Use Search)
      Given K8 Kullanici URL'ye gider
      Then K8 Giris simgesine tiklar ve Sign in'e tiklar
      Then K8 Admin kullanicisina ait kullanici adi ve sifre girer
      Then K8 Items&Titles'e tiklar
      Then K8 Staff'e tiklar
      Then K8 Create a new Staff buttonuna tiklar
      Then K8 SSN bolumune var olan bir Staff "<SSN>"'i girilir
      Then K8 Use Search kutusu isaretlenir
      Then K8 Search User butonun tiklanir
      And K8 User found with search SSN uyarisi gorulur
      And K8 Sayfayi kapatir
      Examples:
        | SSN |
        | 632-09-4333 |
        | 630-09-4333 |
        | 147-78-7879 |
        | 057-35-2009 |
        | 633-09-4333 |
#staff:632-09-4333
#admin:630-09-4333
#physician:147-78-7879
#user:057-35-2009
#patient:633-09-4333

#Staff'ta sadece staff kullanıcılarını görmesi gerekirken tüm kullanıcıların girilen SSN'E göre verilerine ulasabiliyor
@Bug2
  Scenario: TC003 Admin SSN kullanarak; kayıtlı kişiler arasında Staff arayabilir.(bilgiler asağidaki kutulara gelmesi)
    Given K8 Kullanici URL'ye gider
    Then K8 Giris simgesine tiklar ve Sign in'e tiklar
    Then K8 Admin kullanicisina ait kullanici adi ve sifre girer
    Then K8 Items&Titles'e tiklar
    Then K8 Staff'e tiklar
    Then K8 Create a new Staff buttonuna tiklar
    Then K8 SSN bolumune var olan bir Staff SSN'i "585-96-9654" girilir
    Then K8 Use Search kutusu isaretlenir
    Then K8 Search User butonun tiklanir
    And K8 User found with search SSN uyarisi gorulur
    And K8 Aranan SSN'e ait bilgiler asağidaki kutulara geldigi gozlemlenir
    And K8 Sayfayi kapatir

    #Bu Test Fail
  @Bug3
    Scenario: TC004 Admin SSN kullanarak; kayıtlı kişiler arasında Staff arayabilir.(bilgiler asağidaki kutulara gelmesi 2)
      Given K8 Kullanici URL'ye gider
      Then K8 Giris simgesine tiklar ve Sign in'e tiklar
      Then K8 Admin kullanicisina ait kullanici adi ve sifre girer
      Then K8 Items&Titles'e tiklar
      Then K8 Staff'e tiklar
      Then K8 Create a new Staff buttonuna tiklar
      Then K8 SSN bolumune var olan bir Staff SSN'i "677-11-0949" girilir
      Then K8 Use Search kutusu isaretlenir
      Then K8 Search User butonun tiklanir
      And K8 User found with search SSN uyarisi gorulur
      And K8 Aranan SSN'e ait bilgiler asağidaki kutulara geldigi gozlemlenir
      And K8 Sayfayi kapatir

    #Bu Test Fail
  @Bug4
  Scenario: TC005 Tüm bilgileri doldurulmalıdır (Create etme)
        Given K8 Kullanici URL'ye gider
        Then K8 Giris simgesine tiklar ve Sign in'e tiklar
        Then K8 Admin kullanicisina ait kullanici adi ve sifre girer
        Then K8 Items&Titles'e tiklar
        Then K8 Staff'e tiklar
        Then K8 Create a new Staff buttonuna tiklar
        Then K8 Bos olan bilgiler doldurulur
        Then K8 Save butonuna tiklar
        Then K8 Kullanici olusturulduguna dair uyariyi gorur
        And K8 Sayfayi kapatir
@create
  Scenario: TC005-2 Tüm bilgileri doldurulmalıdır (Create etme user degistirerek defalarca deneme)
    Given K8 Kullanici URL'ye gider
    Then K8 Giris simgesine tiklar ve Sign in'e tiklar
    Then K8 Admin kullanicisina ait kullanici adi ve sifre girer
    Then K8 Items&Titles'e tiklar
    Then K8 Staff'e tiklar
    Then K8 Create a new Staff buttonuna tiklar
    Then K8 Bos olan bilgiler doldurulur
    Then K8 Save butonuna tiklar
    Then K8 Kullanici olusturulmadigina dair yaziyi gorurse user i degistirir tekrar save buttonuna basar
    And K8 Sayfayi kapatir

@US019-TC006
        Scenario: TC006 Admin kayıtlı kişilerden bir kullanıcı seçebilir
          Given K8 Kullanici URL'ye gider
          Then K8 Giris simgesine tiklar ve Sign in'e tiklar
          Then K8 Admin kullanicisina ait kullanici adi ve sifre girer
          Then K8 Items&Titles'e tiklar
          Then K8 Staff'e tiklar
          Then K8 Kayitli kullanicilardan birinin view butonuna tiklar
          And K8 Hasta bilgilerini gorur ve dogrular
          And K8 Sayfayi kapatir
@US019-TC007
          Scenario: TC007 Admin kullanıcı bilgilerini düzenleyebilir
            Given K8 Kullanici URL'ye gider
            Then K8 Giris simgesine tiklar ve Sign in'e tiklar
            Then K8 Admin kullanicisina ait kullanici adi ve sifre girer
            Then K8 Items&Titles'e tiklar
            Then K8 Staff'e tiklar
            Then K8 Kayitli kullanicilardan "id" li kullanicinin edit butonuna tiklar
            Then K8 Kullanici bilgilerinde guncelleme yapar ve save botununa tiklar
            Then K8 Basarili islem oldugu uyarısını gorur
            And K8 Sayfayi kapatir
@delete
            Scenario: TC008 Admin Admin, personeli silebilmeli
              Given K8 Kullanici URL'ye gider
              Then K8 Giris simgesine tiklar ve Sign in'e tiklar
              Then K8 Admin kullanicisina ait kullanici adi ve sifre girer
              Then K8 Items&Titles'e tiklar
              Then K8 Staff'e tiklar
              Then K8 Kayitli kullanicilardan belirtilen description li kullanicinin delete butonuna tiklar
              Then K8 Gelen uyaridan Delete butonuna tiklar
              Then K8 Basarili islem oldugu uyarisini gorur
              And K8 Sayfayi kapatir