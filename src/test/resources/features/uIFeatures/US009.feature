@US009
Feature:Staff (Personel),hasta bilgilerini görebilmeli, düzenleyebilmeli ama silememelidir.
  Scenario: TC001 "My Pages" sekmesinden hasta bilgilerini görebilmelidir.
    Given US09 Kullanici URL'ye gider
    Then US09 Giris simgesine ve Sign In'e tiklar
    Then US09 Personel kullanicisina ait kullanici adi ve sifre girer
    Then US09 MY PAGES'e tiklar
    Then US09 Search Patient'e tiklar
    And US09 Tum hasta bilgilerinin goruldugunu dogrular
    And US09 Sayfa kapatilir

  Scenario: TC002 Kullanıcı bütün hasta bilgilerini "id, firstname, lastname, birthdate, email, phone,
            gender, blood group,  address, description, user, country and state/city" düzenleyebilmelidir.
    Given US09 Kullanici URL'ye gider
    Then US09 Giris simgesine ve Sign In'e tiklar
    Then US09 Personel kullanicisina ait kullanici adi ve sifre girer
    Then US09 MY PAGES'e tiklar
    Then US09 Search Patient'e tiklar
    Then US09 Patient SSN bolumune hastanin SSN nosu girilir
    Then US09 Edit'e tiklanir
    Then US09 Gelen bilgiler uzerinde degisiklikler yapilir ve Save buttonuna tiklanir
    And US09 Tum bilgilerinin uzerinde degisiklik yapildigi gozlemlenir
    And US09 Sayfa kapatilir

  Scenario: TC003 Kullanıcı SSN'lerine göre yeni bir başvuru sahibi arayabilmeli ve tüm kayıt bilgilerinin doldurulduğunu görebilmelidir.
    Given US09 Kullanici URL'ye gider
    Then US09 Giris simgesine ve Sign In'e tiklar
    Then US09 Personel kullanicisina ait kullanici adi ve sifre girer
    Then US09 MY PAGES'e tiklar
    Then US09 Search Patient'e tiklar
    Then US09 Patient SSN bolumune hastanin SSN nosu girilir
    Then US09 View buttonuna tiklar
    And US09 Kullanici hasta kaydinin tum bilgilerin girildigini gorur
    And US09 Sayfa kapatilir

    #4 API
    #5  DB

  Scenario: TC006 Kullanici herhangi bir hastanin First Name, Last Name, Email, Phone bilgilerini silememelidir
    Given US09 Kullanici URL'ye gider
    Then US09 Giris simgesine ve Sign In'e tiklar
    Then US09 Personel kullanicisina ait kullanici adi ve sifre girer
    Then US09 MY PAGES'e tiklar
    Then US09 Search Patient'e tiklar
    Then US09 Patient SSN bolumune hastanin SSN nosu girilir
    Then US09 Edit'e tiklanir
    And US09 Kullanici hastanin First Name, Last Name, Email, Phone bilgilerini siler
    And US09 Kullanici Save buttonuna tiklar
    And US09 Kullanici gereklidir uyarisi verildigini gorur
    And US09 Sayfa kapatilir



     #US009 dan bu acceptance chryteria cikarildi
 # Scenario: TC007 Admin tarafindan herhangi bir hastanin First Name, Last Name, Email, Phone bilgilerini silememelidir
 #   Given US09 Kullanici URL'ye gider
 #   Then US09 Giris simgesine ve Sign In'e tiklar
 #   Then US09 Admin kullanicisina ait kullanici adi ve sifre girer
 #   Then US09 Administration'a tiklar
 #   Then US09 User management'e tiklar
 #   Then US09 Edit'e tiklanir
 #   And US09 Hastanin First Name, Last Name, Email, Phone bilgilerini siler
 #   And US09 Save buttonuna tiklar
 #   And US09 Gereklidir uyarisi verildigini gorur
 #   And US09 Sayfa kapatilir
#
#
 #   #US009 dan bu acceptance chryteria cikarildi
 #   #bu testte en eski guncellemeye sahip kullanıcının belirtilen bilgilerinin guncellenmesi var.O yuzden hep calistirma
 # Scenario Outline: TC008 Admin tarafindan herhangi bir hastanin First Name, Last Name, Email, Phone bilgilerini gunceleyebilir
 #   Given US09 Kullanici URL'ye gider
 #   Then US09 Giris simgesine ve Sign In'e tiklar
 #   Then US09 Admin kullanicisina ait kullanici adi ve sifre girer
 #   Then US09 Administration'a tiklar
 #   Then US09 User management'e tiklar
 #   Then US09 Edit'e tiklanir
 #   And US09 Hastanin "<Login>","<FirstName>","<LastName>","<Email>","<SSN>" bilgilerini gunceller
 #   And US09 Save buttonuna tiklar
 #   And US09 Update yapildigina dair uyari verildigini gorur
 #   And US09 Sayfa kapatilir
 #   Examples:
 #     | Login | FirstName | LastName | Email | SSN |
 #     | Login | FirstName | LastName | Email | SSN |