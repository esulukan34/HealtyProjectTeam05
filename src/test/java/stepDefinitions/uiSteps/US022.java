package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Page_02;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US022 {

    Page_02 obj=new Page_02();
    Actions actions=new Actions(Driver.getDriver());
    @And("K2 Kullanici search patient sekmesini tiklar")
    public void kKullaniciSearchPatientSekmesiniTiklar() {
        obj.Us22SearchPatient.click();
    }

    @And("K2 Acilan sayfada patient SSN kısmına SSN girişi yapar")
    public void kAcilanSayfadaPatientSSNKısmınaSSNGirişiYapar() {
        obj.Us22SSNBox.click();
        actions.sendKeys("750-35-3545").perform();
    }

    @Then("K2 Kullanici SSN ile yapilan  arama sonuclarini goruntuler")
    public void kKullaniciSSNIleYapilanAramaSonuclariniGoruntuler() {
        String SSN = "750-35-3545";
        assertEquals(SSN,obj.Us22SSN.getText());

    }

    @And("K2 Acilan sayfada hastanin show appointment sekmesine tiklar")
    public void kAcilanSayfadaHastaninShowAppointmentSekmesineTiklar() {
        ReusableMethods.waitFor(2);
        obj.Us22ShowAppointments.click();

    }

    @And("K2 Acilan sayfada show test sekmesine tiklar")
    public void kAcilanSayfadaShowTestSekmesineTiklar() {
        ReusableMethods.waitFor(2);
        obj.Us22ShowTest.click();
    }

    @And("K2 Acilan sayfada view results sekmesine tiklar")
    public void kAcilanSayfadaViewResultsSekmesineTiklar() {
        ReusableMethods.waitFor(5);
        obj.Us22ViewResults.click();
    }

    @Then("K2 Acilan sayfada hastanin test sonuclari goruntulendigi dogrulanir")
    public void kAcilanSayfadaHastaninTestSonuclariGoruntulendigiDogrulanir() {
        assertTrue(obj.Us22TestResults.isDisplayed());
    }

    @And("K2 Acilan sayfada edit sekmesine tiklar")
    public void kAcilanSayfadaEditSekmesineTiklar() {
       ReusableMethods.waitFor(2);
        obj.Us22Edit.click();
    }

    @And("K2 Acilan sayfada hastanin  sonuc bilgilerinin goruntulendigi dogrulanir")
    public void kAcilanSayfadaHastaninSonucBilgilerininGoruntulendigiDogrulanir() {

        obj.Us22validate.isDisplayed();
    }

    @And("K2 Acilan sayfada save butonuna tiklar")
    public void kAcilanSayfadaSaveButonunaTiklar() {
        ReusableMethods.jsScrollClick(obj.Us22save);
    }

    @Then("K2 Acilan sayfada hastanin  sonuc bilgilerinin guncellendigi dogrulanir")
    public void kAcilanSayfadaHastaninSonucBilgilerininGuncellendigiDogrulanir() {
        ReusableMethods.waitFor(3);
        assertTrue(obj.Us22update.isDisplayed());

    }

    @And("K2 Kullanici \\(staff) username ve password ile giris yapar")
    public void kKullaniciStaffUsernameVePasswordIleGirisYapar() {
        ReusableMethods.waitFor(2);
        actions.sendKeys("staffkamil").sendKeys(Keys.TAB).sendKeys("drkimble750.A")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

    }
}
