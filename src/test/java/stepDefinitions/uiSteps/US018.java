package stepDefinitions.uiSteps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.Page_10;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;

public class US018 {
    Page_10 page10 = new Page_10();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Given("K10 MedunnaUrl adresine gider")
    public void k10_medunna_url_adresine_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        ReusableMethods.waitFor(2);
    }
    @Given("K10 Sign in butonunu tiklar")
    public void k10_sign_in_butonunu_tiklar() {
        page10.signDropDown.click();
        ReusableMethods.waitForVisibility(page10.signInButton, 3);
        page10.signInButton.click();

    }
    @Given("K10 Gecerli bir username girer")
    public void k10_gecerli_bir_username_girer() {
        ReusableMethods.waitForVisibility(page10.username, 3);
        page10.username.sendKeys(ConfigReader.getProperty("admin.username"));

    }
    @Given("K10 Gecerli bir password girer")
    public void k10_gecerli_bir_password_girer() {
        ReusableMethods.waitForVisibility(page10.password, 3);
        page10.password.sendKeys(ConfigReader.getProperty("admin.password"));

    }
    @Given("K10 Sign butonunu tiklar")
    public void k10_sign_butonunu_tiklar() {
        ReusableMethods.waitFor(1);
        page10.signIn.click();
    }
    @Given("K10 Admin sayfasinda oldugunu dogrular")
    public void k10_admin_sayfasinda_oldugunu_dogrular() {
        ReusableMethods.waitForVisibility(page10.adminName, 3);
        assertTrue(page10.adminName.isDisplayed());
    }
    @Given("K10 Item&titles ten physician butonuna basar")
    public void k10_item_titles_ten_physician_butonuna_basar() {
        ReusableMethods.waitFor(1);
        page10.items_Titles.click();
        page10.physician_Button.click();
    }
    @Given("K10 Physician sayfasini goruntuledigini dogrular")
    public void k10_physician_sayfasini_goruntuledigini_dogrular() {
        page10.physician_Button.click();
        ReusableMethods.waitFor(1);
        assertTrue("Physicain sayfasi goruntulenemedi.",page10.physiciansPage.isDisplayed());
    }
    @Given("K10 create a new physician butonuna basilir.")
    public void k10_create_a_new_physician_butonuna_basilir() {
        page10.createNewPhysician.click();
        ReusableMethods.waitFor(1);
    }
    @Given("K10 SSN girerek seach yapabilir")
    public void k10_ssn_girerek_seach_yapabilir() {
        page10.useSearchButton.click();
        ReusableMethods.waitFor(1);
        page10.searchSSn.sendKeys(ConfigReader.getProperty("doktor.ssn"));
        ReusableMethods.waitFor(1);
        page10.searchSSnButton.click();
    }
    @Given("K10 Secili Physicianin {string} {string} {string} {string} bilgilerini doldurabilir.")
    public void k10_secili_physicianin_bilgilerini_doldurabilir(String name, String lastName, String birthday, String phoneNumber) {
        ReusableMethods.waitForVisibility(page10.phys_FirtsName,3 );
        page10.phys_FirtsName.sendKeys(name);
        ReusableMethods.waitFor(1);
        page10.phys_LastName.sendKeys(lastName);
        ReusableMethods.waitFor(1);
        page10.phys_BirthDay.sendKeys(birthday);
        ReusableMethods.waitFor(1);
        page10.phys_Phone.sendKeys(phoneNumber);
        ReusableMethods.waitFor(1);
        page10.phys_SaveButton.click();

    }
    @Given("K10 Physicianin {string} secebilmelidir")
    public void k10_physicianin_secebilmelidir(String uzmanlik) {
        ReusableMethods.waitForVisibility(page10.phys_Speciality,3 );
        page10.phys_Speciality.sendKeys(uzmanlik);
    }
    @Then("K10 Physicianin {string} sunu secebilir")
    public void k10_physicianin_sunu_secebilir(String dosyaYolu) {
        ReusableMethods.waitForVisibility(page10.phys_FirtsName,3 );
        page10.phys_AddImage.sendKeys(dosyaYolu);

    }
    @Given("K10 Physiciani editleyebilir")
    public void k10_physiciani_editleyebilir() {
        jse.executeScript("arguments[0].scrollIntoView(true);", page10.SSN);
        ReusableMethods.waitForVisibility(page10.editButton,3);
        jse.executeScript("arguments[0].click();", page10.editButton);
        //page10.editButton.click();
        ReusableMethods.waitFor(1);
        assertTrue(page10.editPage.isDisplayed());
        ReusableMethods.waitFor(1);
        Driver.getDriver().navigate().back();
    }

    @Given("K10 Physician'i silebilir")
    public void k10_physician_i_silebilir() {
        //js.executeScript("document.body.style.zoom='75%';");
        ReusableMethods.jsScroll(page10.deleteButton);
        ReusableMethods.waitForVisibility(page10.deleteButton,3 );
        page10.deleteButton.click();
        assertTrue(page10.deleteConfirmation.isDisplayed());

    }
    @Given("K10 Administration butonuna tiklar")
    public void k10_administration_butonuna_tiklar() {
        ReusableMethods.waitForVisibility(page10.administrationButton,3 );
        page10.administrationButton.click();
        ReusableMethods.waitFor(1);
        page10.userManagementButton.click();
        ReusableMethods.waitFor(2);
        page10.SSN1.click();
        ReusableMethods.waitFor(1);
        page10.SSN1.click();



    }





}
