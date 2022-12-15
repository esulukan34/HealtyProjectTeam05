@US05
Feature: US_05 Hastalar (patients), hastahaneden randevu (Appointment) olusturabilmelidir.

  Background: Kullanici randevu olusturma sayfasına gider

    Given md Kullanici "medunnaUrl" url adresine gider
    When md Make an appointment butonuna tiklar

  Scenario Outline: TC_01 Kullanici, herhangi bir karakter içeren "First Name" yazmali ve randevu olusturabilmelidir.

    Given md Kullanici farkli karakterleri iceren "<firstname>" girer
    When md Gecerli bir lastname girer
    And md Gecerli kayitli bir SSN girer
    And md Gecerli bir email adresi girer
    And md Gecerli bir telefon numarasi girer
    And md Gecerli bir appointment tarihi girer
    And md Send An Appointment Request'e tiklar
    Then md Randevunun basariyla olusturuldugunu test eder
    Examples:
      | firstname |
      | Ali       |
      | O'neal    |
      | Ali9      |
      | 123       |
      | @.?       |


  Scenario: TC_02 Firstname bolumu bos birakilmamalidir.

    Given md Firstname kutusunu bos birakir
    When md Gecerli bir lastname girer
    And md Gecerli kayitli bir SSN girer
    And md Gecerli bir email adresi girer
    And md Gecerli bir telefon numarasi girer
    And md Gecerli bir appointment tarihi girer
    And md Send An Appointment Request'e tiklar
    Then md Randevu isleminin gerceklesmedigini, firstname'in bos birakilalamayacagini test eder

  Scenario: TC_03 SSN numarasi bolumu bos birakilmamalidir.

    Given md Gecerli bir firstname girer
    When md Gecerli bir lastname girer
    And md SSN numarasi kustusunu bos birakir
    And md Gecerli bir email adresi girer
    And md Gecerli bir telefon numarasi girer
    And md Gecerli bir appointment tarihi girer
    And md Send An Appointment Request'e tiklar
    Then md Randevu isleminin gerceklesmedigini, ssn'in bos birakilalamayacagini test eder

  Scenario Outline: TC_04 Kullanici, herhangi bir karakter içeren "Last Name" yazmali ve randevu olusturabilmelidir.

    Given md Gecerli bir firstname girer
    When md Kullanici farkli karakterlerden olusan "<lastname>" girer
    And md Gecerli kayitli bir SSN girer
    And md Gecerli bir email adresi girer
    And md Gecerli bir telefon numarasi girer
    And md Gecerli bir appointment tarihi girer
    And md Send An Appointment Request'e tiklar
    Then md Randevunun basariyla olusturuldugunu test eder
    Examples:
      | lastname |
      | Gel      |
      | O'neal   |
      | Ali92    |
      | 1234     |
      | @.?-     |

  Scenario: TC_05 Lastname bolumu bos birakilmamalidir

    Given md Gecerli bir firstname girer
    When md Lastname kustusunu bos birakir
    And md Gecerli kayitli bir SSN girer
    And md Gecerli bir email adresi girer
    And md Gecerli bir telefon numarasi girer
    And md Gecerli bir appointment tarihi girer
    And md Send An Appointment Request'e tiklar
    Then md Randevu isleminin gerceklesmedigini, lastname'in bos birakilalamayacagini  test eder

  @US05_TC06
  Scenario Outline: TC_06 Kullanici, 3. ve 6. rakamdan sonra "-" olan 10 rakamlı telefon numarasını girmelidir.
  Bunlarin disinda gecersiz formatta degerler girilmemelidir.

    Given md Gecerli bir firstname girer
    When md Gecerli bir lastname girer
    And md Gecerli kayitli bir SSN girer
    And md Gecerli bir email adresi girer
    And md "<Gecersiz telefon numarasi>" girildiginde Phone number is invalid uyarisi verdigini test eder

    Examples:
      | Gecersiz telefon numarasi |
 #    | 123-123-1234              |
      | 123-123-123               |
      | 123-12312345              |
      | 123-1231234               |
      | 123123-1234               |
      | 1231231234                |
      | 123123-123456             |
      | 123123123                 |


  Scenario: TC_07 Telefon numarasi bolumu bos birakilmamalidir.

    Given md Gecerli bir firstname girer
    When md Gecerli bir lastname girer
    And md Gecerli kayitli bir SSN girer
    And md Gecerli bir email adresi girer
    And Telefon numarasi kutusunu bos birakir
    And md Gecerli bir appointment tarihi girer
    And md Send An Appointment Request'e tiklar
    Then md Randevu isleminin gerceklesmedigini, telefon numarasinin bos birakilamayacagini test eder


  @TC08
  Scenario: TC_08 Kullanici randevu alıp kaydolduğunda, almis oldugu randevulari goruntuleyebilmelidir.

    And md Gecerli bir firstname girer
    And md Gecerli bir lastname girer
    And md Gecerli kayitli bir SSN girer
    And md Gecerli bir email adresi girer
    And md Gecerli bir telefon numarasi girer
    And md Gecerli bir appointment tarihi girer
    And md Send An Appointment Request'e tiklar
    Then md Randevunun basariyla olusturuldugunu test eder
    And md Sayfada sign in bolumune gider
    And md Hasta olarak oturum acar
    And md MyPages(Patient) ve MyAppointments butonuna tiklar
    And md id sutunundaki id'lerin sayisini hesaplar
    And md MyPages ve Make An Appointment butonuna tiklar
    And md Gecerli bir telefon numarasi girer
    And md Bu gunden sonraki bir appointment tarihi girer
    And md Send An Appointment Request'e tiklar
    And md MyPages(Patient) ve MyAppointments butonuna tiklar
    Then md Aldigi randevunun ekranda goruntulendigini test eder

 #   And md Gecerli bir firstname girer
 #   And md Gecerli bir lastname girer
 #   And md Gecerli kayitli bir SSN girer
 #   And md Gecerli bir email adresi girer
 #   And md Gecerli bir telefon numarasi girer
 #   And md Gecerli bir appointment tarihi girer
 #   And md Send An Appointment Request'e tiklar
 #   Then md Randevunun basariyla olusturuldugunu test eder
 #   And md Sayfada sign in bolumune gider
 #   And md Hasta olarak oturum acar
 #   And md MyPages(Patient) ve MyAppointments butonuna tiklar
 #   Then md Aldigi randevunun ekranda goruntulendigini test eder
#


