package stepDefinitions.uiSteps;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import pages.Page_03;
import pojos.Registrant;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.registrant;

public class US002 {
    Page_03 medunnaPage=new Page_03();



    @Given("K3 {string} ana sayfasina gider")
    public void k3AnaSayfasinaGider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @When("K3 Kullanici Register sekmesine tiklar")
    public void k3KullaniciRegisterSekmesineTiklar() {
        medunnaPage.registerSignInIkon.click();
        medunnaPage.registerButon.click();
    }

    @And("K3 Kullanici SSN kutusuna {string} girer")
    public void k3KullaniciSSNKutusunaGirer(String ssn) {
        medunnaPage.ssnTextbox.sendKeys(ConfigReader.getProperty(ssn));
        registrant=new Registrant();
        registrant.setSsn(ConfigReader.getProperty(ssn));

    }

    @And("K3 Kullanici First Name kutusuna bir {string} girer")
    public void k3KullaniciFirstNameKutusunaBirGirer(String firstname) {
        ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty(firstname)).perform();
        registrant.setFirstName(ConfigReader.getProperty(firstname));
    }

    @And("K3 Kullanici Last Name kutusuna  bir {string} girer")
    public void k3KullaniciLastNameKutusunaBirGirer(String lastname) {
        ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty(lastname)).perform();
        registrant.setLastName(ConfigReader.getProperty(lastname));

    }

    @And("K3 Kullanici Username kutusuna gecerli bir {string} girer")
    public void k3KullaniciUsernameKutusunaGecerliBirGirer(String username) {
        ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty(username)).perform();
        registrant.setLogin(ConfigReader.getProperty(username));
    }

    @And("K3 Kullanici Email kutusuna gecerli bir {string} girer")
    public void k3KullaniciEmailKutusunaGecerliBirGirer(String email) {
        ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty(email)).perform();
        registrant.setEmail(ConfigReader.getProperty(email));
    }

    @And("K3 Kullanici New password kutusuna gecerli bir {string} girer")
    public void k3KullaniciNewPasswordKutusunaGecerliBirGirer(String password) {
        ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty(password)).perform();
        registrant.setPassword(ConfigReader.getProperty(password));
    }

    @And("K3 Kullanici New password confirmation kutusuna ayni {string} girer")
    public void us002KullaniciNewPasswordConfirmationKutusunaAyniGirer(String password) {
        ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty(password)).perform();
    }

    @And("K3 Kullanici Register butonuna tiklar")
    public void k3KullaniciRegisterButonunaTiklar() {
        ReusableMethods.jsScrollClick(medunnaPage.registerSubmit);
    }

    @Then("K3 Kullanici gecerli bir username ile kayit oldugunu dogrular")
    public void k3KullaniciGecerliBirUsernameIleKayitOldugunuDogrular() {
        ReusableMethods.waitForVisibility(medunnaPage.registerSavedTextMessage,5);
        assertTrue(medunnaPage.registerSavedTextMessage.isDisplayed());
    }

    @And("K3 Kullanici Username kutusunu bos birakir")
    public void k3KullaniciUsernameKutusunuBosBirakir() {
        ReusableMethods.getActions().sendKeys(Keys.TAB).perform();
    }

    @And("K3 Kullanici Username kutusuna unique olmayan bir {string} girer")
    public void k3KullaniciUsernameKutusunaUniqueOlmayanBirGirer(String username) {
        ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty(username)).perform();
    }

    @Then("K3 Kullanici unique olmayan username ile kayit olmadigini dogrular")
    public void k3KullaniciUniqueOlmayanUsernameIleKayitOlmadiginiDogrular() {
        ReusableMethods.waitForVisibility(medunnaPage.loginUsed,5);
        assertTrue(medunnaPage.loginUsed.isDisplayed());
    }

    @When("K3 Kullanici Email kutusuna gecersiz {string} girer")
    public void k3Kullanici_email_kutusuna_gecersiz_girer(String email) {
        ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys(email).perform();
    }

    @Then("K3 Kullanici kayit olmadigini dogrular")
    public void k3KullaniciKayitOlmadiginiDogrular() {
        ReusableMethods.waitForVisibility(medunnaPage.registerSubmit,5);
        assertTrue(medunnaPage.registerSubmit.isDisplayed());
    }

}
