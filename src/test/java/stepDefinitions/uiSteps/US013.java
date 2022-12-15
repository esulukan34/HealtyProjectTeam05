package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.bouncycastle.cert.crmf.Control;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Page_09;
import utilities.Driver;
import utilities.ReusableMethods;

public class US013 {

    Page_09 page09 = new Page_09();
    JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();

    @And("DoctorCollins Glucose, Urea, Creatinine, Sodium, Potassium, Total protein, Albumin, Hemoglobin seceneklerini secer")
    public void doktorGlucoseUreaCreatinineSodiumPotassiumTotalProteinAlbuminHemoglobinSecenekleriniSecer() {

        js.executeScript("document.body.style.zoom = '0.9'");


        ReusableMethods.jsScrollClick(page09.ureaCheckBox);
        ReusableMethods.jsScrollClick(page09.albuminCheckBox);
        ReusableMethods.jsScrollClick(page09.totalProteinCheckBox);
        ReusableMethods.jsScrollClick(page09.hemoglobinCheckBox);
        ReusableMethods.jsScrollClick(page09.glucoseCheckBox);
        ReusableMethods.jsScrollClick(page09.creatinineCheckBox);
        ReusableMethods.jsScrollClick(page09.sodiumCheckBox);
        ReusableMethods.jsScrollClick(page09.potassiumCheckBox);
    }

    @Then("DoctorCollins Save butonuna tiklar")
    public void doktorSaveButonunaTiklar() {
        ReusableMethods.jsScrollClick(page09.saveButton);

    }

    @Then("DoctorCollins Show Test Results butonuna tiklar")
    public void doktorShowTestResultsButonunaTiklar() {
        page09.testResults.click();

    }

    @And("DoctorCollins View Results butonuna tiklar")
    public void doktorViewResultsButonunaTiklar() {
        page09.viewResults.click();
    }

    @Then("DoctorCollins id, name, default max value, default min value, test, description and the date bilgilerinin goruldugunu dogrular")
    public void doktorIdNameDefaultMaxValueDefaultMinValueTestDescriptionAndTheDateBilgilerininGoruldugunuDogrular() {
        Assert.assertTrue(page09.idValue.isDisplayed());
        Assert.assertTrue(page09.nameValue.isDisplayed());
        Assert.assertTrue(page09.defaultMinValue.isDisplayed());
        Assert.assertTrue(page09.defaultMaxValue.isDisplayed());
        Assert.assertTrue(page09.testValue.isDisplayed());
        Assert.assertTrue(page09.descriptionValue.isDisplayed());
        Assert.assertTrue(page09.dateValue.isDisplayed());

    }


    @Then("DoctorCollins acilan sayfada Request Inpatienta tiklayabilir")
    public void doktorAcilanSayfadaRequestInpatientaTiklayabilir() {
        Assert.assertTrue(page09.requestInpatient.isEnabled());

    }


}
