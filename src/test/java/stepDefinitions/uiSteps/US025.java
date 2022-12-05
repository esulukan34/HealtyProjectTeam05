package stepDefinitions.uiSteps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.Page_01;
import utilities.Driver;
import utilities.ReusableMethods;


public class US025 {
    WebDriver driver;
    Page_01 page01 = new Page_01();
    Actions actions = new Actions(Driver.getDriver());


/*
    @Then("K4 Account menu butonuna tiklar")
    public void k4_account_menu_butonuna_tiklar() {
        page01.account.click();
    }
    @Then("K4 Register butonuna tiklar")
    public void k4_register_butonuna_tiklar() {
        ReusableMethods.waitFor(1);
        page01.register.click();
    }
    @Then("K4 Gecerli bir SSN girer")
    public void k4_gecerli_bir_ssn_girer() {
       page01.ssn.sendKeys("123-60-6060");
    }
    @Then("K4 Gecerli bir firstname girer")
    public void k4_gecerli_bir_firstname_girer() {
        page01.firstname.sendKeys("Ahmet");
    }
    @Then("K4 Gecerli bir lastname girer")
    public void k4_gecerli_bir_lastname_girer() {
        page01.lastname.sendKeys("Durmus");
    }
    @Then("K4 Gecerli bir username girer")
    public void k4_gecerli_bir_username_girer() {
        page01.username.sendKeys("aadurmus");
    }
    @Then("K4 Gecerli bir email girer")
    public void k4_gecerli_bir_email_girer() {
        page01.email.sendKeys("aadurmus@gmail.com");
    }
    @Then("K4 Gecerli bir password girer")
    public void k4_gecerli_bir_password_girer() {
        // page01.password.click();
        // actions.sendKeys("Adurmus.9").
        //         sendKeys(Keys.TAB).
        //         sendKeys("Adurmus.9").
        //         sendKeys(Keys.TAB,Keys.ENTER);

        page01.password.sendKeys("Adurmus.9");
        page01.password2.sendKeys("Adurmus.9");
        ReusableMethods.jsScrollClick(page01.gecersizRegister);
        //id:365175
        //Hesabı silme
    }
    */

    @Then("K4 Account menu butonuna tiklar")
    public void k4_account_menu_butonuna_tiklar() {
        page01.account.click();
    }
    @Then("K4 Sign In butonuna tiklar")
    public void k4_sign_ın_butonuna_tiklar() {
        page01.signIn.click();
    }

    @Then("K4 Hasta hesabıyla giris yapar")
    public void k4_hasta_hesabıyla_giris_yapar() {
        page01.patientUsername.sendKeys("adurmus");
        page01.patientPassword.sendKeys("Adurmus.9", Keys.ENTER);
    }

    @Then("K4 Hasta hesabıyla myPages butonuna tiklar")
    public void k4_hasta_hesabıyla_my_pages_butonuna_tiklar() {
        ReusableMethods.clickWithTimeOut(page01.myPages,2);
    }
    @Then("K4 MyAppointments butonuna tiklar")
    public void k4_my_appointments_butonuna_tiklar() {
        page01.mAppointment.click();
    }
    @Then("K4 Gecerli bir telefon numarasi girer")
    public void k4_gecerli_bir_telefon_numarasi_girer() {
        page01.phone.sendKeys("555-345-6060");
    }
    @Then("K4 Randevu icin tarih secer")
    public void k4_randevu_icin_tarih_secer() {
        page01.date.sendKeys("25.12.2022");
    }
    @Then("K4 Randevu tamamlamak icin SendAppointment tusuna basar")
    public void k4_randevu_tamamlamak_icin_send_appointment_tusuna_basar() {
        page01.sendAppointment.click();
    }
    @Then("K4 randevu alindigini onaylar")
    public void k4_randevu_alindigini_onaylar() {
        //String actualData = page01.randevuOnayi.getText();
        //String expecData = "Appointment registration saved!";
        //assertTrue(actualData.contains(expecData));
     }


}
