@us12
Feature: US012 Doktor test isteyebilmeli

  @tc01
  Scenario: TC01 Doktor test isteyebilmeli
    Given DoctorCollins Medunna anasayfasinda
    And   DoctorCollins sign in butonuna tiklar
    Then DoctorCollins gecerli bir username girer
    And DoctorCollins gecerli bir password girer
    Then DoctorCollins sign_in butonuna tiklar
    And DoctorCollins acilan sayfada My Pages butonuna tiklar
    Then DoctorCollins My Appointments butonuna tiklar
    And DoctorCollins randevu sayfasinda edit butonuna tiklar
    Then DoctorCollins acilan sayfada 'Request a Test'e tiklayabilir
    And DoctorCollins sayfayi kapatir

  @tc02
  Scenario: TC02 Test iceriginde "Glucose, Urea, Creatinine, Sodium, Potassium, Total Protein, Albumin, Hemoglobin" secenekleri olmalidir
    Given DoctorCollins Medunna anasayfasinda
    And   DoctorCollins sign in butonuna tiklar
    Then DoctorCollins gecerli bir username girer
    And DoctorCollins gecerli bir password girer
    Then DoctorCollins sign_in butonuna tiklar
    And DoctorCollins acilan sayfada My Pages butonuna tiklar
    Then DoctorCollins My Appointments butonuna tiklar
    And DoctorCollins randevu sayfasinda edit butonuna tiklar
    Then DoctorCollins acilan sayfada RequestaTeste tiklar
    And DoctorCollins test iceriginde Glucose, Urea, Creatinine, Sodium, Potassium, Total protein, Albumin, Hemoglobin seceneklerinin oldugunu dogrular
    And DoctorCollins sayfayi kapatir
