@US015
Feature:US015 Admin tarafindan hasta olusturma ve duzenleme

  @US015_TC001
  Scenario: TC001 Yeni hastalar yalnizca yonetici tarafindan olusturulabilir
    Given FA admin "medunnaUrl" e gider
    When  FA admin login olur
    Then  FA admin Items&Titles menuden Patient tiklar
    Then  FA admin acilan pencerede Create a new Patient butonunun gorunur oldugunu dogrular ve tiklar
    And   FA admin acilan pencerede gecerli bilgileri girer ve save buttonuna tiklar
    #And   FA admin kayit isleminin gerceklestigini dogrular

  @US015_TC002
  Scenario: TC002 Yönetici "SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group, Address,
  Description, Created Date, User, Country and state / City" gibi hasta bilgilerini görebilir.
    Given FA admin "medunnaUrl" e gider
    When  FA admin login olur
    Then  FA admin Items&Titles menuden Patient tiklar
    And   FA Admin acilan pencerede SSN,First Name,Last Name,Birth Date,Phone, Gender,Blood Group,Address,Description,Created Date,User,Country and stateCity title'larinin gorunur oldugunu dogrular

  @US015_TC003
  Scenario: TC003 Hasta oluşturulduğunda veya güncellendiğinde yukarıdaki öğelere data girişi yapılabilmeli.
    Given FA admin "medunnaUrl" e gider
    When  FA admin login olur
    Then  FA hasta 3 saniye bekler
    Then  FA admin Items&Titles menuden Patient tiklar
    Then  FA admin acilan pencerede Create a new Patient butonunun gorunur oldugunu dogrular ve tiklar
    And   FA admin acilan pencerede gecerli bilgileri girer ve save buttonuna tiklar
    Then  FA hasta 3 saniye bekler
    And   FA admin id tiklar olusturulan hastaya edit yapar
    Then  FA admin hastanin email,phone,adres,description bilgisini gunceller ve save butonuna tiklar
    #And   FA "A Patient is updated with identifier" mesajinin gorundugunu dogrular


  @US015_TC004
  Scenario:TC004 Hastaya doktoru sadece Admin atayabilir.
    Given FA admin "medunnaUrl" e gider
    When  FA admin login olur
    Then  FA hasta 3 saniye bekler
    Then  FA admin Items&Titles menuden Appointment tiklar
    And   FA admin Create a new Appointment butonuna tiklar
    Then  FA admin gecerli randevu tarihlerini secer
    Then  FA admin status,physician ve patient bilgisi secer ve save butonuna tiklar
    #And   FA "A new Appointment is created with identifier" mesajinin gorundugunu dogrular

  @US015_TC005
  Scenario: TC005 "Country", "US state" olmali ve bos bırakilmamali
    Given FA admin "medunnaUrl" e gider
    When  FA admin login olur
    Then  FA admin Items&Titles menuden Patient tiklar
    Then  FA admin acilan pencerede Create a new Patient butonunun gorunur oldugunu dogrular ve tiklar
    And   FA admin acilan pencerede Country ve State disindaki hasta bilgilerini girer ve save butonuna tiklar
    #And   FA admin "A new Appointment is created with identifier" mesajinin gorunur olmadıgini dogrular

  @US015_TC006
  Scenario:TC006 Admin herhangi bir hastayi silebilir
    Given FA admin "medunnaUrl" e gider
    When  FA admin login olur
    Then  FA hasta 3 saniye bekler
    Then  FA admin Items&Titles menuden Patient tiklar
    Then  FA admin acilan pencerede Create a new Patient butonunun gorunur oldugunu dogrular ve tiklar
    And   FA admin acilan pencerede gecerli bilgileri girer ve save buttonuna tiklar
    Then  FA hasta 3 saniye bekler
    And   FA admin id tiklar olusturulan hastaya delete yapar ve popUpta delete button'a tiklar
    #And   FA "A Patient is deleted with identifier" mesajinin gorundugunu dogrular

  @US015_TC004Negatif
  Scenario:TC004 Hastaya doktoru sadece Admin atayabilir.
    Given FA admin "medunnaUrl" e gider
    When  FA admin login olur
    Then  FA hasta 3 saniye bekler
    Then  FA admin Items&Titles menuden Appointment tiklar
    And   FA admin Create a new Appointment butonuna tiklar
    Then  FA admin gecersiz randevu tarihlerini secer ve save butonuna tiklar
    #And   FA admin "Appointment start date time can not be greater than end date time" mesajinin gorundugunu dogrular