package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.Page_09;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US012 {

    Page_09 page09 = new Page_09();
    JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();

    @Given("DoctorCollins Medunna anasayfasinda")
    public void doktor_medunna_anasayfasinda() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @Given("DoctorCollins sign in butonuna tiklar")
    public void doktor_sign_in_butonuna_tiklar() {
        page09.accountMenu.click();
        page09.signin.click();

    }

    @Then("DoctorCollins gecerli bir username girer")
    public void doktor_gecerli_bir_username_girer() {
        page09.username.sendKeys(ConfigReader.getProperty("DoctorValidUsername"));
    }

    @Then("DoctorCollins gecerli bir password girer")
    public void doktor_gecerli_bir_password_girer() {
        page09.password.sendKeys(ConfigReader.getProperty("DoctorValidPassword"));
    }

    @Then("DoctorCollins sign_in butonuna tiklar")
    public void doktorSign_inButonunaTiklar() {
        page09.sign_in.click();
    }

    @And("DoctorCollins acilan sayfada My Pages butonuna tiklar")
    public void doktorAcilanSayfadaMyPagesButonunaTiklar() {
        page09.myPages.click();
    }

    @Then("DoctorCollins My Appointments butonuna tiklar")
    public void doktorMyAppointmentsButonunaTiklar() {
        page09.myAppointments.click();
    }

    @And("DoctorCollins randevu sayfasinda edit butonuna tiklar")
    public void doktorRandevuSayfasindaEditButonunaTiklar() {
        page09.editButton.click();
    }

    @Then("DoctorCollins acilan sayfada 'Request a Test'e tiklayabilir")
    public void doktor_acilan_sayfada_request_a_test_e_tiklayabilir() {
        Assert.assertTrue(page09.requestaTest.isEnabled());

    }

    @And("DoctorCollins test iceriginde Glucose, Urea, Creatinine, Sodium, Potassium, Total protein, Albumin, Hemoglobin seceneklerinin oldugunu dogrular")
    public void doktorTestIcerigindeGlucoseUreaCreatinineSodiumPotassiumTotalProteinAlbuminHemoglobinSeceneklerininOldugunuDogrular() {


        Assert.assertTrue(page09.urea.isDisplayed());
        Assert.assertTrue(page09.albumin.isDisplayed());

        ReusableMethods.jsScroll( page09.totalProtein);
        Assert.assertTrue(page09.totalProtein.isDisplayed());
        ReusableMethods.jsScroll(page09.hemoglobin);
        Assert.assertTrue(page09.hemoglobin.isDisplayed());
        ReusableMethods.jsScroll(page09.glucose);
        Assert.assertTrue(page09.glucose.isDisplayed());
        ReusableMethods.jsScroll(page09.sodium);
        Assert.assertTrue(page09.sodium.isDisplayed());
        ReusableMethods.jsScroll(page09.creatinine);
        Assert.assertTrue(page09.creatinine.isDisplayed());
        ReusableMethods.jsScroll(page09.potassium);
        Assert.assertTrue(page09.potassium.isDisplayed());

    }

    @Then("DoctorCollins sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();

    }

    @Then("DoctorCollins acilan sayfada RequestaTeste tiklar")
    public void doktorAcilanSayfadaRequestATesteTiklar() {
        ReusableMethods.waitForVisibility(page09.requestaTest, 3);
        page09.requestaTest.click();
    }
}

