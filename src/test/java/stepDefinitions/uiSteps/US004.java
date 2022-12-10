package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.Page_04;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US004 {
    Page_04 page_04=new Page_04();
    Actions actions = new Actions(Driver.getDriver());

    @Given("{int} sn bekler")
    public void sn_bekler(Integer int1) {
        try {
            Thread.sleep(int1 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("A kullanıcı sıgn ın a tıklar")
    public void kullanıcı_sıgn_ın_a_tıklar (){
        page_04.sign.click();

    }

    @When("A kullanıcı geçerli bir pasword girer")
    public void kullanıcı_geçerli_bir_pasword_girer () {
        page_04.pasword.sendKeys("012345");
    }
    @When("A Kullanıcı sıgn ın butonunu tıklar")
    public void kullanıcı_sıgn_ın_butonunu_tıklar () {
        page_04.signButon.click();
    }


    @When("A kullanıcı sayfa başlığnı görnürlüğünü doğrular")
    public void kullanıcı_sayfa_başlığnı_görnürlüğünü_doğrular () {
        String expected = "MEDUNNA";
        Assert.assertTrue(page_04.Medunna.isDisplayed());
    }


    @When("A kullacı {int} saniye bekler")
    public void kullacıSaniyeBekler(int a2rg0) {
    }


    @When("A kullanıcı geçerli bir username girer")
    public void kullanıcıGeçerliBirUsernameGirer() {
        page_04.username.sendKeys("hstumut");
    }




    @And("A kullanıcı Remmember me butonunun görünürlüğünü test eder")
    public void kullanıcıRemmemberMeButonununGörünürlüğünüTestEder() {
        String expected=page_04.Remem_me.getText();
        Assert.assertEquals(expected,page_04.Remem_me.getText());

    }


    @And("A kullanıcı Did you forget your password? butonunun görünürlüğünü test eder")
    public void kullanıcıDidYouForgetYourPasswordButonununGörünürlüğünüTestEder() {
        String expected=page_04.ŞifremiUnuttum.getText();
        Assert.assertTrue(expected.contains(page_04.ŞifremiUnuttum.getText()));
    }

    @And("A kullanıcı You don't have an account yet? Register a new account butonunun görünürlüğünü test eder")
    public void kullanıcıYouDonTHaveAnAccountYetRegisterANewAccountButonununGörünürlüğünüTestEder() {
        String expected=page_04.Register_a_new_account.getText();
        Assert.assertTrue(expected.contains(page_04.Register_a_new_account.getText()));

    }

    @And("A {string} seçeneği olmalıdır.")
    public void seçeneğiOlmalıdır(String arg0) {
        String expected=page_04.cancel.getText();
        Assert.assertTrue(expected.contains(page_04.cancel.getText()));

    }

    @And("A sayfayı kapatır")
    public void sayfayıKapatır() {
        Driver.closeDriver();
    }

    @And("A gecersiz username girer")
    public void gecersizUsernameGirer() {
        page_04.username.sendKeys("ahmet");
    }

    @And("A gecersiz password girer")
    public void gecersizPasswordGirer() {
        page_04.pasword.sendKeys("1111");
    }

    @Then("A sayfaya giris yapilamadigini kontrol eder")
    public void sayfayaGirisYapilamadiginiKontrolEder() {

        String expected=page_04.Başarısızmesajı.getText();
        Assert.assertTrue(expected.contains(page_04.Başarısızmesajı.getText()));

    }



    @And("A kullanıcı{string} username girer")
    public void kullanıcıUsernameGirer(String geçersizUsername) {
        page_04.username.sendKeys(geçersizUsername);
    }

    @And("A kullanıcı {string} password girer")
    public void kullanıcıPasswordGirer(String geçersizPassword) {
        actions.sendKeys(Keys.TAB).sendKeys(geçersizPassword).perform();
    }

    @Given("A  kullanici Medunna sayfasina gider")
    public void aKullaniciMedunnaSayfasinaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @Then("A Account menu butonu tiklanir")
    public void aAccountMenuButonuTiklanir() {
        page_04.accountmenu.click();
    }




}

