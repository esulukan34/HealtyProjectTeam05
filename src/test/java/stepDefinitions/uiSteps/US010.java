package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Page_02;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US010 {
    Page_02 obj=new Page_02();
    Actions actions=new Actions(Driver.getDriver());

    @Given("K2 Kullanici {string} adresine gider")
    public void kKullaniciAdresineGider(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @When("K2 Kullanici signin butonuna tiklar")
    public void kKullaniciSigninButonunaTiklar() {
        ReusableMethods.waitFor(2);
        obj.us10signin.click();
        ReusableMethods.waitFor(3);
        obj.us10signin1.click();
    }

    @Then("K2 Kullanici username ve password ile giris yapar")
    public void kKullaniciUsernameVePasswordIleGirisYapar() {
        ReusableMethods.waitFor(2);
        actions.sendKeys("DrKimble").sendKeys(Keys.TAB).sendKeys("drkimble750.A")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }

    @And("K2 Acilan sayfada MyPages sekmesini tiklar")
    public void kAcilanSayfadaMyPagesSekmesiniTiklar() {
        ReusableMethods.waitFor(2);
        obj.us10mypages.click();
    }

    @And("K2 Kullanici My appointments sekmesini tiklar")
    public void kKullaniciMyAppointmentsSekmesiniTiklar() {
        obj.us10myappoinments.click();
    }

    @And("K2 Randevu listesi ve zaman dilimlerinin görüldüğü doğrulanir")
    public void kRandevuListesiVeZamanDilimlerininGörüldüğüDoğrulanir() {
        Assert.assertTrue(obj.us10fromDate.isDisplayed());
        Assert.assertTrue(obj.us10toDate.isDisplayed());
        Assert.assertTrue(obj.us10randevu.isDisplayed());
    }

    @Then("K2 Kullanici {string} bilgilerinin goruldugu dogrulanir")
    public void kKullaniciBilgilerininGorulduguDogrulanir(String arg1) {
        Assert.assertTrue(obj.us10patientid.isDisplayed());
        Assert.assertTrue(obj.startDateTime.isDisplayed());
        Assert.assertTrue(obj.endDateTime.isDisplayed());
        Assert.assertTrue(obj.status.isDisplayed());
    }
    @And("K2 Sayfa kapatilir")
    public void kSayfaKapatilir() {
        Driver.closeDriver();
    }
}
