package stepDefinitions.uiSteps;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.Page_10;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US018 {
    Page_10 page10 = new Page_10();
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
        Assert.assertTrue(page10.adminName.isDisplayed());
    }
    @Given("K10 Item&titles ten physician butonuna basar.")
    public void k10_item_titles_ten_physician_butonuna_basar() {
        ReusableMethods.waitFor(1);
        page10.items_Titles.click();
        page10.physician_Button.click();
    }
    @Given("K10 Physician sayfasini goruntuledigini dogrular")
    public void k10_physician_sayfasini_goruntuledigini_dogrular() {
        page10.physician_Button.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue("Physicain sayfasi goruntulenemedi.",page10.physiciansPage.isDisplayed());
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




}
