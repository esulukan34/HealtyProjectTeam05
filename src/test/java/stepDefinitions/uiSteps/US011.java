package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Page_02;
import utilities.Driver;
import utilities.ReusableMethods;

public class US011 {
    Page_02 obj=new Page_02();
    Actions actions=new Actions(Driver.getDriver());

    @And("K2 Acilan sayfada Edit butonunu tiklar")
    public void kAcilanSayfadaEditButonunuTiklar() {
        obj.us11Edit.click();
    }

    @Then("K2 Acilan sayfada kullanici hastanın Anamnesis, Treatment ve Diagnosis bilgilerini görebilmeli")
    public void k2AcilanSayfadaKullaniciHastanınAnamnesisTreatmentVeDiagnosisBilgileriniGörebilmeli() {
        Assert.assertTrue(obj.us11Anamnesis.isDisplayed());
        Assert.assertTrue(obj.us11Treatment.isDisplayed());
        Assert.assertTrue(obj.us11Diagnosis.isDisplayed());
    }

    @Then("K2 Acilan sayfada kullanici hastanın prescription ve description ve status bilgilerini görebilmeli")
    public void k2AcilanSayfadaKullaniciHastanınPrescriptionVeDescriptionVeStatusBilgileriniGörebilmeli() {
        Assert.assertTrue(obj.us11Prescription.isDisplayed());
        Assert.assertTrue(obj.us11Description.isDisplayed());
        Assert.assertTrue(obj.us11Status.isDisplayed());
    }

    @Then("K2 Kullanici Anamnesis, Treatment ve Diagnosis alanlarini doldurabilmeli")
    public void kKullaniciAnamnesisTreatmentVeDiagnosisAlanlariniDoldurabilmeli() {
        ReusableMethods.jsScrollClick(obj.Us11Anamnesisbox);
        actions.sendKeys("he have a cold ").sendKeys(Keys.TAB).
                sendKeys("1 tablet in the morning and evening on a full stomach")
                .sendKeys(Keys.TAB).sendKeys("sniffles").perform();
    }

    @And("K2 Anamnesis, Treatment ve Diagnosis alanlari doldurulmadiginda {string} uyarisi almali")
    public void kAnamnesisTreatmentVeDiagnosisAlanlariDoldurulmadigindaUyarisiAlmali(String arg1) {
        String warn="This field is required.";
        ReusableMethods.jsScrollClick(obj.Us11Anamnesisbox);
        actions.sendKeys("").sendKeys(Keys.TAB).
                sendKeys("")
                .sendKeys(Keys.TAB).sendKeys("").sendKeys(Keys.TAB)
                .perform();
        Assert.assertEquals(warn,obj.us11Feedback.getText());
    }

    @Then("K2 Kullanici prescription ve description alanlarini doldurabilmeli")
    public void kKullaniciPrescriptionVeDescriptionAlanlariniDoldurabilmeli() {
        ReusableMethods.jsScrollClick(obj.Us11Anamnesisbox);
        actions.sendKeys("he have a cold ").sendKeys(Keys.TAB).
                sendKeys("1 tablet in the morning and evening on a full stomach")
                .sendKeys(Keys.TAB).sendKeys("sniffles").sendKeys(Keys.TAB)
                .sendKeys("theraflu tablet")
                .sendKeys(Keys.TAB).sendKeys("flu").perform();
    }

    @And("K2 Kullanici prescription ve description alanlarini doldurmadıgında herhangi bir uyarı almamalı")
    public void kKullaniciPrescriptionVeDescriptionAlanlariniDoldurmadıgındaHerhangiBirUyarıAlmamalı() {
        String warn="This field is required.";

        ReusableMethods.jsScrollClick(obj.Us11Anamnesisbox);
        actions.sendKeys("he have a cold ").sendKeys(Keys.TAB).
                sendKeys("1 tablet in the morning and evening on a full stomach")
                .sendKeys(Keys.TAB).sendKeys("sniffles").sendKeys(Keys.TAB)
                .sendKeys("")
                .sendKeys(Keys.TAB).sendKeys("").perform();
        Assert.assertFalse(obj.us11invalidFeedback.isDisplayed());
        // Assert.assertNotEquals(warn,obj.Us11bosprescription.getText());
        // Assert.assertNotEquals(warn,obj.Us11bosdescribtion.getText());
    }

    @Then("K2 Kullanici Status kismini pending olarak secer")
    public void kKullaniciStatusKisminiPendingOlarakSecer() {
        actions.sendKeys(obj.us11Status,"PENDING").perform();
    }

    @Then("K2 Kullanici Status kismini completed olarak secer")
    public void kKullaniciStatusKisminiCompletedOlarakSecer() {
        actions.sendKeys(obj.us11Status,"COMPLETED").perform();
    }

    @Then("K2 Kullanici Status kismini cancelled olarak secer")
    public void kKullaniciStatusKisminiCancelledOlarakSecer() {
        actions.sendKeys(obj.us11Status,"CANCELLED").perform();
    }
}

