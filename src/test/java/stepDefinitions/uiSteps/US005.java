package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Page_07;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static pages.Page_07.tarih_Uret;

public class US005 {
    Page_07 page_07 = new Page_07();
    Actions actions = new Actions(Driver.getDriver());
    Integer idSutunSize;

    @Given("md Kullanici {string} url adresine gider")
    public void md_kullanici_url_adresine_gider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @When("md Make an appointment butonuna tiklar")
    public void md_make_an_appointment_butonuna_tiklar() {
        page_07.makeAnAppointmentButton.click();
    }

    @Given("md Gecerli bir firstname girer")
    public void md_gecerli_bir_firstname_girer() {
        page_07.firstName.sendKeys(ConfigReader.getProperty("firstname"));
    }

    @When("md Gecerli bir lastname girer")
    public void md_gecerli_bir_lastname_girer() {
        page_07.lastName.sendKeys(ConfigReader.getProperty("lastname"));

    }

    @When("md Gecerli kayitli bir SSN girer")
    public void md_gecerli_kayitli_bir_ssn_girer() {
        page_07.ssn.sendKeys(ConfigReader.getProperty("ssn"));

    }

    @When("md Gecerli bir email adresi girer")
    public void md_gecerli_bir_email_adresi_girer() {
        page_07.email.sendKeys(ConfigReader.getProperty("email"));
    }

    @When("md Gecerli bir telefon numarasi girer")
    public void md_gecerli_bir_telefon_numarasi_girer() {
        page_07.phone.sendKeys(ConfigReader.getProperty("phone"));

    }

    @When("md Gecerli bir appointment tarihi girer")
    public void md_gecerli_bir_appointment_tarihi_girer() {
        page_07.appoDate.sendKeys(ConfigReader.getProperty("appoDate"));

    }

    @When("md Send An Appointment Request'e tiklar")
    public void md_send_an_appointment_request_e_tiklar() {

        ReusableMethods.jsScrollClick(page_07.sendAndAppointmentRequestButton);

    }

    @Then("md Randevunun basariyla olusturuldugunu test eder")
    public void md_randevunun_basariyla_olusturuldugunu_test_eder() {
        Assert.assertTrue(page_07.randevuKaydedildiYazisiSHub.getText().contains("Appointment registration saved!"));

    }

    @When("md Kullanici {int} saniye bekler")
    public void md_kullanici_saniye_bekler(Integer beklemeSuresi) {
        ReusableMethods.waitFor(beklemeSuresi);
    }

    @Given("md Firstname kutusunu bos birakir")
    public void md_firstname_kutusunu_bos_birakir() {
        page_07.firstName.sendKeys("");

    }

    @Then("md Randevu isleminin gerceklesmedigini, firstname'in bos birakilalamayacagini test eder")
    public void md_randevu_isleminin_gerceklesmedigini_firstname_in_bos_birakilalamayacagini_test_eder() {
        Assert.assertTrue(page_07.firstnameRequiredText.isDisplayed());

    }

    @When("md SSN numarasi kustusunu bos birakir")
    public void md_ssn_numarasi_kustusunu_bos_birakir() {
        page_07.ssn.sendKeys("");

    }

    @Then("md Randevu isleminin gerceklesmedigini, ssn'in bos birakilalamayacagini test eder")
    public void md_randevu_isleminin_gerceklesmedigini_ssn_in_bos_birakilalamayacagini_test_eder() {
        Assert.assertTrue(page_07.ssnRequiredText.isDisplayed());
    }

    @When("md Lastname kustusunu bos birakir")
    public void md_lastname_kustusunu_bos_birakir() {
        page_07.lastName.sendKeys("");
    }

    @Then("md Randevu isleminin gerceklesmedigini, lastname'in bos birakilalamayacagini  test eder")
    public void md_randevu_isleminin_gerceklesmedigini_lastname_in_bos_birakilalamayacagini_test_eder() {
        Assert.assertTrue(page_07.lastnameRequiredText.isDisplayed());

    }

    @When("md {string} girildiginde Phone number is invalid uyarisi verdigini test eder")
    public void md_girildiginde_phone_number_is_invalid_uyarisi_verdigini_test_eder(String invalidPhone) {

        page_07.phone.sendKeys(invalidPhone);
        actions.sendKeys(Keys.TAB).perform();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(page_07.phoneNumberInvalidText.isDisplayed());
        // Assert.assertEquals("Phone number is invalid",page_07.invalidPhoneNumberText.getText());
        page_07.phone.clear();

    }

    @When("Telefon numarasi kutusunu bos birakir")
    public void telefon_numarasi_kutusunu_bos_birakir() {
        page_07.phone.sendKeys("");
    }

    @When("md Kullanici farkli karakterleri iceren {string} girer")
    public void md_kullanici_farkli_karakterleri_iceren_girer(String firstname) {
        page_07.firstName.sendKeys(firstname);

    }

    @When("md Kullanici farkli karakterlerden olusan {string} girer")
    public void md_kullanici_farkli_karakterlerden_olusan_girer(String lastname) {
        page_07.lastName.sendKeys(lastname);

    }


    @Then("md Randevu isleminin gerceklesmedigini, telefon numarasinin bos birakilamayacagini test eder")
    public void md_randevu_isleminin_gerceklesmedigini_telefon_numarasinin_bos_birakilamayacagini_test_eder() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(page_07.phonenumberRequiredText.isDisplayed());

    }

    @Then("md Sayfada sign in bolumune gider")
    public void md_sayfada_sign_in_bolumune_gider() {
        page_07.accountMenu.click();
    }

    @Then("md Hasta olarak oturum acar")
    public void md_hasta_olarak_oturum_acar() {
        page_07.signInButton.click();
        page_07.username.sendKeys(ConfigReader.getProperty("username"));
        page_07.password.sendKeys(ConfigReader.getProperty("password"));
        page_07.signIn2Button.click();
        ReusableMethods.waitFor(1);

    }
    @Then("md MyPages\\(Patient) ve MyAppointments butonuna tiklar")
    public void md_my_pages_patient_ve_my_appointments_butonuna_tiklar() {
        page_07.myPageSheet.click();
        page_07.myAppointmentButton.click();
        ReusableMethods.waitFor(2);
    }




    @And("md id sutunundaki id'lerin sayisini hesaplar")
    public void mdIdSutunundakiIdLerinSayisiniHesaplar() {
        List<String> idSutunElemanlariListText = ReusableMethods.getElementsText(page_07.idSutunElemanlariWE);
        idSutunSize = idSutunElemanlariListText.size();
        System.out.println("idSutunElemanlariListText = " + idSutunElemanlariListText);
        System.out.println("idSutunElemanlariListText.size() = " + idSutunElemanlariListText.size());

    }

    @And("md MyPages ve Make An Appointment butonuna tiklar")
    public void mdMyPagesVeMakeAnAppointmentButonunaTiklar() {
        page_07.myPageSheet.click();
        page_07.makeAnAppointment2.click();
    }

    @And("md Bu gunden sonraki bir appointment tarihi girer")
    public void mdBuGundenSonrakiBirAppointmentTarihiGirer() {
        page_07.appoDate.sendKeys(tarih_Uret(3));
    }


    @Then("md Aldigi randevunun ekranda goruntulendigini test eder")
    public void md_aldigi_randevunun_ekranda_goruntulendigini_test_eder() {

        // Id'lerin sayisi 2. defa alinir
        ReusableMethods.waitFor(20);

        List<String> idSutunElemanlariListText2 = ReusableMethods.getElementsText(page_07.idSutunElemanlariWE);
        System.out.println("idSutunElemanlariListText2 = " + idSutunElemanlariListText2);
        System.out.println("idSutunElemanlariListText2.size() = " + idSutunElemanlariListText2.size());

        Assert.assertTrue(idSutunElemanlariListText2.size()>idSutunSize);

    }

}
