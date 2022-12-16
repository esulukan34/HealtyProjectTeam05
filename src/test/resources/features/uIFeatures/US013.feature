@us13
Feature: US013 Doktor "Test Results" işlemleri yapabilmeli

  @tc1
  Scenario: TC01 Doktor test sonuclarini talep edebilmelidir
    Given DoctorCollins Medunna anasayfasinda
    And   DoctorCollins sign in butonuna tiklar
    Then DoctorCollins gecerli bir username girer
    And DoctorCollins gecerli bir password girer
    Then DoctorCollins sign_in butonuna tiklar
    And DoctorCollins acilan sayfada My Pages butonuna tiklar
    Then DoctorCollins My Appointments butonuna tiklar
    And DoctorCollins randevu sayfasinda edit butonuna tiklar
    Then DoctorCollins acilan sayfada RequestaTeste tiklar
    And DoctorCollins Glucose, Urea, Creatinine, Sodium, Potassium, Total protein, Albumin, Hemoglobin seceneklerini secer
    Then DoctorCollins Save butonuna tiklar
    And DoctorCollins sayfayi kapatir

  @tc2
  Scenario: TC02 Doktor "id, name, default max value, default min value, test, description, date" bilgilerini gorebilmelidir
    Given DoctorCollins Medunna anasayfasinda
    And   DoctorCollins sign in butonuna tiklar
    Then DoctorCollins gecerli bir username girer
    And DoctorCollins gecerli bir password girer
    Then DoctorCollins sign_in butonuna tiklar
    And DoctorCollins acilan sayfada My Pages butonuna tiklar
    Then DoctorCollins My Appointments butonuna tiklar
    And DoctorCollins randevu sayfasinda edit butonuna tiklar
    Then DoctorCollins Show Test Results butonuna tiklar
    And DoctorCollins View Results butonuna tiklar
    Then DoctorCollins id, name, default max value, default min value, test, description and the date bilgilerinin goruldugunu dogrular
    And DoctorCollins sayfayi kapatir

  @tc3
  Scenario: TC03 Doktor hastaya yatili tedavi gormesi isteginde bulunabilmelidir
    Given DoctorCollins Medunna anasayfasinda
    And   DoctorCollins sign in butonuna tiklar
    Then DoctorCollins gecerli bir username girer
    And DoctorCollins gecerli bir password girer
    Then DoctorCollins sign_in butonuna tiklar
    And DoctorCollins acilan sayfada My Pages butonuna tiklar
    Then DoctorCollins My Appointments butonuna tiklar
    And DoctorCollins randevu sayfasinda edit butonuna tiklar
    Then DoctorCollins acilan sayfada Request Inpatienta tiklayabilir
    And DoctorCollins sayfayi kapatir
