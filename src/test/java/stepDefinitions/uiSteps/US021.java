package stepDefinitions.uiSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import pages.Page_06;
import utilities.Driver;
import utilities.ReusableMethods;

public class US021 {
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Page_06 page = new Page_06();

    Faker faker= new Faker();

    String Elmas_Halici_SSN = "610-61-6100";
    String Staff_Hasan_Karadeniz_Username = "hasankaradeniz";
    String Staff_Hasan_Karadeniz_Pasword = "hasankaradeniz1947";

    String Fake_First_Name=faker.name().firstName();
    String Fake_Last_Name=faker.name().lastName();
    String Fake_Mesaj = "BUG :"+ Fake_First_Name+" "+ Fake_Last_Name + "("+Staff_Hasan_Karadeniz_Username+")";



    String Patient_Gercek_Firstname = "Elmas";
    String Patient_Gercek_Lastname = "Halıcı";

    String Edit_Oncesi_Firstname;
    String Edit_Oncesi_LastName;
    String Edit_Sonrasi_FirstName;
    String Edit_Sonrasi_LastName;

    String Edit_Oncesi_Anamnesis;
    String Edit_Sonrasi_Anamnesis;
    String Edit_Oncesi_Treatment;
    String Edit_Sonrasi_Treatment;
    String Edit_Oncesi_Diagnosis;
    String Edit_Sonrasi_Diagnosis;

    @Then("KullaniciAlti Staff Login olur")
    public void kullanici_alti_staff_login_olur() {
        page.signin_text.click();
        page.username_textbox.sendKeys(Staff_Hasan_Karadeniz_Username);
        ReusableMethods.waitFor(1);
        page.password_textbox.sendKeys(Staff_Hasan_Karadeniz_Pasword);
        ReusableMethods.waitFor(1);
        page.signin_button.click();
    }

    @Then("KullaniciAlti Staff MyPages - Search Patient'te tiklar")
    public void kullanicialtiStaffMyPagesSearchPatientTeTiklar() {
        page.Staff_My_Pages_Menu_Linki.click();
        page.Staff_Search_Patient_Linki.click();
    }

    @Then("KullaniciAlti Staff Patientin SSN girer")
    public void kullanicialtiStaffPatientSSNGirer() {
        page.Patients_SSN_Textbox.sendKeys(Elmas_Halici_SSN);
        ReusableMethods.waitFor(3);

    }

    @Then("KullaniciAlti Staff Patienti duzenlemek icin Edite tiklar")
    public void kullanicialtiStaffPatientiDuzenlemekIcinEditeTiklar() {
        page.Patients_Edit_Button.click();
    }

    @Then("KullaniciAlti Staff Patientin isim ve soyisim bilgisini degiskene aktarir")
    public void kullanicialtiStaffPatientinIsimVeSoyisimBilgisiniDegiskeneAktarir() {
        ReusableMethods.waitFor(2);
        Edit_Oncesi_Firstname = page.Patient_Edit_Page_FirstName.getAttribute("value");
        Edit_Oncesi_LastName = page.Patient_Edit_Page_LastName.getAttribute("value");
        System.out.println("Edit_Oncesi_Firstname = " + Edit_Oncesi_Firstname);
        System.out.println("Edit_Oncesi_LastName = " + Edit_Oncesi_LastName);
    }

    @Then("KullaniciAlti Staff Patientin isim ve soyisim bilgisini degistirir")
    public void kullanicialtiStaffPatientinIsimVeSoyisimBilgisiniDegistirir() {
        page.Patient_Edit_Page_FirstName.clear();
        page.Patient_Edit_Page_FirstName.sendKeys(faker.name().firstName());
        page.Patient_Edit_Page_LastName.clear();
        page.Patient_Edit_Page_LastName.sendKeys(faker.name().lastName());

    }

    @Then("KullaniciAlti Staff Kaydet butonuna tiklar")
    public void kullanicialtiStaffKaydetButonunaTiklar() {
        ReusableMethods.bulveTikla(page.Patient_Edit_Page_Save_Butonu);
    }

    @Then("KullaniciAlti Staff Patient View Sayfasında Edite tiklar")
    public void kullanicialtiStaffPatientViewSayfasındaEditeTiklar() {
        ReusableMethods.bulveTikla(page.Patient_View_Page_Edit_Buton);
        ReusableMethods.waitFor(1);
    }

    @Then("KullaniciAlti Staff Patientin degisiklik sonrasi isim ve soyisim bilgisini degiskene aktarir")
    public void kullanicialtiStaffPatientinDegisiklikSonrasiIsimVeSoyisimBilgisiniDegiskeneAktarir() {
        ReusableMethods.waitFor(2);
        Edit_Sonrasi_FirstName = page.Patient_Edit_Page_FirstName.getAttribute("value");
        Edit_Sonrasi_LastName = page.Patient_Edit_Page_LastName.getAttribute("value");
        System.out.println("Edit_Sonrasi_Firstname = " + Edit_Sonrasi_FirstName);
        System.out.println("Edit_Sonrasi_LastName = " + Edit_Sonrasi_LastName);
    }

    @Then("KullaniciAlti isim ve soyisim bilgisinin degistigi dogrulanir_BUG")
    public void kullanicialtiIsimVeSoyisimBilgisininDegistigiDogrulanir() {
        Assert.assertNotEquals("İsim Değiştirilememedi", Edit_Oncesi_Firstname, Edit_Sonrasi_FirstName);
        Assert.assertNotEquals("Soyisim Değiştirilememedi", Edit_Oncesi_LastName, Edit_Sonrasi_LastName);
    }

    @Then("KullaniciAlti Hastanin gercek ismi ve soyismi tekrar girilir")
    public void kullanicialtiHastaninGercekIsmiVeSoyismiTekrarGirilirVeKaydedilir() {
        page.Patient_Edit_Page_FirstName.clear();
        page.Patient_Edit_Page_FirstName.sendKeys(Patient_Gercek_Firstname);
        page.Patient_Edit_Page_LastName.clear();
        page.Patient_Edit_Page_LastName.sendKeys(Patient_Gercek_Lastname);
    }

    @Then("KullaniciAlti Staff Patientin Randevularini goruntuler")
    public void kullanicialtiStaffPatientinRandevulariniGoruntuler() {
        ReusableMethods.bulveTikla(page.Patients_Show_Appointments_Button);
    }

    @Then("KullaniciAlti Staff Patientin Birinci Randevusunu Editlemek icin Edite tiklar")
    public void kullanicialtiStaffPatientinBirinciRandevusunuEditlemekIcinEditeTiklar() {
        ReusableMethods.bulveTikla(page.Appointments_Page_Birinci_Edit_Button);
    }

    @Then("KullaniciAlti Staff Patientin Status bilgisini duzenler ve dogrular")
    public void kullanicialtiStaffPatientinStatusBilgisiniDuzenlerVeDogrular() {
        Select select = new Select(page.Appointment_Status_Select);
        String value1 = "UNAPPROVED";
        String value2 = "PENDING";
        String value3 = "COMPLETED";
        String value4 = "CANCELLED";

        //select.selectByValue(value3);
        //ReusableMethods.waitFor(1);

        Assert.assertEquals(null, page.Appointment_Status_Select.getAttribute("disabled value"));

        Assert.assertNotEquals(null, page.Appointment_Status_Select.getAttribute("value"));


        ReusableMethods.bulveTikla(page.Appointment_Status_Select);
        select.selectByValue(value4);
        ReusableMethods.waitFor(1);
        Assert.assertEquals(value4, page.Appointment_Status_Select.getAttribute("value"));

        ReusableMethods.bulveTikla(page.Appointment_Status_Select);
        select.selectByValue(value2);
        ReusableMethods.waitFor(1);
        Assert.assertEquals(value2, page.Appointment_Status_Select.getAttribute("value"));

        ReusableMethods.bulveTikla(page.Appointment_Status_Select);
        select.selectByValue(value1);
        ReusableMethods.waitFor(1);
        Assert.assertEquals(value1, page.Appointment_Status_Select.getAttribute("value"));
    }

    @Then("KullaniciAlti Staff Patientin Anamnesis Treatment ve Diagnosis bilgilerini degiskene aktarir")
    public void kullanicialtiStaffPatientinAnamnesisTreatmentVeDiagnosisBilgileriniDegiskeneAktarir() {
        Edit_Oncesi_Anamnesis = page.Appointment_Anamnesis_Textbox.getText();
        Edit_Oncesi_Treatment = page.Appointment_Treatment_Textbox.getText();
        Edit_Oncesi_Diagnosis = page.Appointment_Diagnosis_Textbox.getText();
        System.out.println("Edit_Oncesi_Anamnesis = " + Edit_Oncesi_Anamnesis);
        System.out.println("Edit_Oncesi_Treatment = " + Edit_Oncesi_Treatment);
        System.out.println("Edit_Oncesi_Diagnosis = " + Edit_Oncesi_Diagnosis);
        System.out.println("#############################");
    }

    @Then("KullaniciAlti Staff Patientin Anamnesis Treatment ve Diagnosis metin kutularina FAKER metin girer, Save tiklar")
    public void kullanicialtiStaffPatientinAnamnesisTreatmentVeDiagnosisMetinKutularinaBUGMetniGirer() {

        page.Appointment_Anamnesis_Textbox.clear();
        page.Appointment_Anamnesis_Textbox.sendKeys(Fake_Mesaj);
        page.Appointment_Treatment_Textbox.clear();
        page.Appointment_Treatment_Textbox.sendKeys(Fake_Mesaj);
        page.Appointment_Diagnosis_Textbox.clear();
        page.Appointment_Diagnosis_Textbox.sendKeys(Fake_Mesaj);
        ReusableMethods.bulveTikla(page.Appointment_Save_Button);
    }

    @Then("KullaniciAlti Staff Patientin Anamnesis Treatment ve Diagnosis bilgilerini tekrar degiskene aktarir")
    public void kullanicialtiStaffPatientinAnamnesisTreatmentVeDiagnosisBilgileriniTekrarDegiskeneAktarir() {
        Edit_Sonrasi_Anamnesis = page.Appointment_Anamnesis_Textbox.getText();
        Edit_Sonrasi_Treatment = page.Appointment_Treatment_Textbox.getText();
        Edit_Sonrasi_Diagnosis = page.Appointment_Diagnosis_Textbox.getText();
        System.out.println("Edit_Sonrasi_Anamnesis = " + Edit_Sonrasi_Anamnesis);
        System.out.println("Edit_Sonrasi_Treatment = " + Edit_Sonrasi_Treatment);
        System.out.println("Edit_Sonrasi_Diagnosis = " + Edit_Sonrasi_Diagnosis);
        ReusableMethods.bulveTikla(page.Appointment_Save_Button);
    }

    @Then("KullaniciAlti Staff Patientin Anamnesis Treatment ve Diagnosis bilgilerinin degistigini dogrular")
    public void kullanicialtiStaffPatientinAnamnesisTreatmentVeDiagnosisBilgilerininDegistiginiDogrular() {
        Assert.assertNotEquals(Edit_Oncesi_Anamnesis, Edit_Sonrasi_Anamnesis);
        Assert.assertNotEquals(Edit_Oncesi_Treatment, Edit_Sonrasi_Treatment);
        Assert.assertNotEquals(Edit_Oncesi_Diagnosis, Edit_Sonrasi_Diagnosis);
    }

    @Then("KullaniciAlti Staff Patient icin Doktor atar ve dogrular")
    public void KullaniciAltiStaffPatienticinDoktoratarvedogrular() {
        Select select = new Select(page.Appointment_Physician_Select);
        ReusableMethods.waitFor(5);
        String value1 = "362070";
        String value2 = "229037";
        String value3 = "94211";

        ReusableMethods.bulveTikla(page.Appointment_Physician_Select);
        select.selectByValue(value1);
        ReusableMethods.waitFor(2);
        Assert.assertEquals(value1, page.Appointment_Physician_Select.getAttribute("value"));

        ReusableMethods.bulveTikla(page.Appointment_Physician_Select);
        select.selectByValue(value2);
        ReusableMethods.waitFor(2);
        Assert.assertEquals(value2, page.Appointment_Physician_Select.getAttribute("value"));

        ReusableMethods.bulveTikla(page.Appointment_Physician_Select);
        select.selectByValue(value3);
        ReusableMethods.waitFor(1);
        Assert.assertEquals(value3, page.Appointment_Physician_Select.getAttribute("value"));
    }

    @Then("KullaniciAlti Staff Patientin Birinci Randevu Test Sonuclarini Gormek icin Show Testse tiklar")
    public void kullanici_alti_staff_patientin_birinci_randevu_test_sonuclarini_gormek_icin_show_testse_tiklar() {
        page.Appointments_Page_Birinci_Show_Test_Button.click();
    }
    @Then("KullaniciAlti Staff Test Sayfasinin goruntulendigini dogrular")
    public void kullanici_alti_staff_test_sayfasinin_goruntulendigini_dogrular() {
        Assert.assertTrue(page.Tests_Page_Test_Texti.isDisplayed());

    }


}
