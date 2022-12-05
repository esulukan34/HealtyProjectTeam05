Feature: US07
  @Yasemin
  Scenario: TC01  : Bilgiler kayit girerken doldurulan kullanici bilgileri ile ayni olmalidir.
  Given K6 medunna.com adresine gider
  Then  K6 Kullanici Signin olmak icin Signin iconuna tiklar
  Then  K6 Acilan menude hasta kaydi sirasinda secilen username girilir
  Then  K6 Hasta kaydi sirasinda secilen pasword girilir.
  Then  K6 Signin butonuna tiklanir
  Then  K6 Kullanici myPage menusune tiklar
  Then  K6 appointment linkine tiklar
  Then  K6 phone kismina on haneli bir telefon girer
  Then  K6 kaydet butonuna tiklar
    #deneme











