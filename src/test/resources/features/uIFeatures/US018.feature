@@US018
Feature: US_018

  @US018_TC_001
  Scenario: US018_TC_001
  Given K10 MedunnaUrl adresine gider
    *   K10 Sign in butonunu tiklar
    *   K10 Gecerli bir username girer
    *   K10 Gecerli bir password girer
    *   K10 Sign butonunu tiklar
    *   K10 Item&titles ten physician butonuna basar.
    *   K10 Physician sayfasini goruntuledigini dogrular

   @US018_TC_002
  Scenario: TC_002
     Given K10 MedunnaUrl adresine gider
       *   K10 Sign in butonunu tiklar
       *   K10 Gecerli bir username girer
       *   K10 Gecerli bir password girer
       *   K10 Sign butonunu tiklar
       *   K10 Item&titles ten physician butonuna basar.
       *   K10 create a new physician butonuna basilir.
       *   K10 SSN girerek seach yapabilir

  @US018_TC_003
  Scenario Outline
  : TC_003
    Given K10 MedunnaUrl adresine gider
       *  K10 Sign in butonunu tiklar
       *  K10 Gecerli bir username girer
       *  K10 Gecerli bir password girer
       *  K10 Sign butonunu tiklar
       *  K10 Item&titles ten physician butonuna basar.
       *  K10 create a new physician butonuna basilir.
       *  K10 SSN girerek seach yapabilir
       *  K10 Secili Physicianin "<name>" "<surname>" "<birthday"> "<PhoneNumber>" bilgilerini doldurabilir.
       Examples:
         | name    | surname  |  birthday   | phoneNumber |
         | Kemal   | Sunal    |             |             |




  @US018_TC_004
  Scenario: TC_004
    Given K10 MedunnaUrl adresine gider
       *  K10 Sign in butonunu tiklar
       *  K10 Gecerli bir username girer
       *  K10 Gecerli bir password girer
       *  K10 Sign butonunu tiklar
       *  K10 Item&titles ten physician butonuna basar.
       *  K10 create a new physician butonuna basilir.
       *  K10 Physicianin uzmanligini secebilmelidir
       *  K10 Physicianin  fotosunu secebilir

  @US018_TC_005
  Scenario: TC_005
    Given K10 MedunnaUrl adresine gider
       *  K10 Sign in butonunu tiklar
       *  K10 Gecerli bir username girer
       *  K10 Gecerli bir password girer
       *  K10 Sign butonunu tiklar
       *  K10 Item&titles ten physician butonuna basar.
       *  K10 create a new physician butonuna basilir.
       *  K10 Physiciani  editleyebilir
       *  K10 Physician'i silebilir




