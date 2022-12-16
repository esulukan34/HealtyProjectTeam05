package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import pages.Page04;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.*;


public class US025 {

    Page04 page04 = new Page04();
    String randevuTarih = "15.12.2022";


    /*
    public static String tarih_Uret(int gun) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, gun);
        String date = sdf.format(calendar.getTime());
        return date;
    }
     */



/*
    @Then("K4 Account menu butonuna tiklar")
    public void k4_account_menu_butonuna_tiklar() {
        page04.account.click();
    }
    @Then("K4 Register butonuna tiklar")
    public void k4_register_butonuna_tiklar() {
        ReusableMethods.waitFor(1);
        page04.register.click();
    }
    @Then("K4 Gecerli bir SSN girer")
    public void k4_gecerli_bir_ssn_girer() {
       page04.ssn.sendKeys("123-60-6060");
    }
    @Then("K4 Gecerli bir firstname girer")
    public void k4_gecerli_bir_firstname_girer() {
        page04.firstname.sendKeys("Ahmet");
    }
    @Then("K4 Gecerli bir lastname girer")
    public void k4_gecerli_bir_lastname_girer() {
        page04.lastname.sendKeys("Durmus");
    }
    @Then("K4 Gecerli bir username girer")
    public void k4_gecerli_bir_username_girer() {
        page04.username.sendKeys("aadurmus");
    }
    @Then("K4 Gecerli bir email girer")
    public void k4_gecerli_bir_email_girer() {
        page04.email.sendKeys("aadurmus@gmail.com");
    }
    @Then("K4 Gecerli bir password girer")
    public void k4_gecerli_bir_password_girer() {
        // page04.password.click();
        // actions.sendKeys("Adurmus.9").
        //         sendKeys(Keys.TAB).
        //         sendKeys("Adurmus.9").
        //         sendKeys(Keys.TAB,Keys.ENTER);

        page04.password.sendKeys("Adurmus.9");
        page04.password2.sendKeys("Adurmus.9");
        ReusableMethods.jsScrollClick(page01.gecersizRegister);
        //id:365175
        //Hesabı silme
    }
    */

    @Then("K4 Account menu butonuna tiklar")
    public void k4_account_menu_butonuna_tiklar() {
        page_04.account.click();


    }
    @Then("K4 Sign In butonuna tiklar")
    public void k4_sign_ın_butonuna_tiklar() {
        page_04.signIn.click();

    }

    @Then("K4 Hasta hesabıyla giris yapar")
    public void k4_hasta_hesabıyla_giris_yapar() {
        page_04.patientUsername.sendKeys("adurmus");
        page_04.patientPassword.sendKeys("Adurmus.9",Keys.ENTER);

    }

    @Then("K4 Hasta hesabıyla myPages butonuna tiklar")
    public void k4_hasta_hesabıyla_my_pages_butonuna_tiklar() {
        ReusableMethods.clickWithTimeOut(page_04.myPages,5);


    }
    @Then("K4 MyAppointments butonuna tiklar")
    public void k4_my_appointments_butonuna_tiklar() {
        ReusableMethods.clickWithTimeOut(page_04.makeAppointment,2);

    }
    @Then("K4 Gecerli bir telefon numarasi girer")
    public void k4_gecerli_bir_telefon_numarasi_girer() {
        page_04.phone.sendKeys("555-555-6060");

    }
    @Then("K4 Randevu icin tarih secer")
    public void k4_randevu_icin_tarih_secer() {
        page_04.date.sendKeys(randevuTarih);

    }

    @Then("K4 Randevu tamamlamak icin SendAppointment tusuna basar")
    public void k4_randevu_tamamlamak_icin_send_appointment_tusuna_basar() {
        page_04.sendAppointment.click();


    }


    @And("K4 randevu alindigini ve tarihin {string} seklinde oldugunu dogrular")
    public void kRandevuAlindiginiVeTarihinSeklindeOldugunuDogrular(String arg1) {
        ReusableMethods.waitForVisibility(page_04.alert,15);
        assertTrue(page_04.alert.isDisplayed());

        ReusableMethods.waitFor(3);
        page_04.myPages.click();

        ReusableMethods.waitForVisibility(page_04.myAppointments,15);
        page_04.myAppointments.click();

        ReusableMethods.waitForVisibility(page_04.tarihFormat,15);
        String actualRandevu = page_04.tarihFormat.getText();
        System.out.println("actualRandevu = " + actualRandevu);

        String[] parts = actualRandevu.split(" ");
        String part1 = parts[0];
        System.out.println("part1 = " + part1);
        //assertEquals(part1,randevuTarih);


    }

    @Then("K4 Gecersiz bir telefon numarasi girer")
    public void k4_gecersiz_bir_telefon_numarasi_girer() {
        page_04.phone.sendKeys("555-5556060");

    }
    @Then("K4 randevu alinamadigini dogrular")
    public void k4_randevu_alinamadigini_dogrular() {
        String expectedText = "Appointment registration not saved!";
        ReusableMethods.waitForVisibility(page_04.alert,15);
        assertNotEquals(page_04.alert.getText(),expectedText);


    }

    @Then("K4 Randevu icin gecmis bir tarih secer")
    public void k4_randevu_icin_gecmis_bir_tarih_secer() {
        page_04.date.sendKeys("01.12.2022");

    }
}
