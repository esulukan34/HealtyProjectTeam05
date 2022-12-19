package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Page_01;
import pages.Page_04;
import pages.Page_04;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US023 {

    Page_01 page01 = new Page_01();
    Actions actions = new Actions(Driver.getDriver());


    @And("K1 kullanıcı Search Patient i tıklar")
    public void kullanıcıSearchPatientITıklar() {
      page01.SeachPatient.click();
    }

    @Given("K1  kullanici Medunna sayfasina gider")
    public void kKullaniciMedunnaSayfasinaGider( ) {
      Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @Then("K1 Account menu butonu tiklanir")
    public void kAccountMenuButonuTiklanir() {
      page01.accountmenu.click();
    }

    @Given("K1 kullacı{int} sn bekler")
    public void sn_bekler(Integer int1) {
      try {
        Thread.sleep(int1 * 1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    @Then("K1 kullanıcı sıgn ın a tıklar")
    public void kKullanıcıSıgnInATıklar() {
      page01.signIn.click();
    }

    @When("K1 kullanıcı geçerli bir username girer")
    public void kKullanıcıGeçerliBirUsernameGirer() {
      page01.username.sendKeys("Personelteam05");
    }

    @And("K1 kullanıcı geçerli bir pasword girer")
    public void kKullanıcıGeçerliBirPaswordGirer() {
      actions.sendKeys(Keys.TAB).sendKeys("147258").perform();
      /*page04.password.sendKeys("147258");*/
    }

    @And("K1 Kullanıcı sıgn ın butonunu tıklar")
    public void kKullanıcıSıgnInButonunuTıklar() {
      page01.SignBtn.click();
    }

    @When("K1 kullacı {int} saniye bekler")
    public void kKullacıSaniyeBekler(int arg0) {
    }

    @Then("K1 kullanıcı ssnPatient ı tıklar")
    public void kKullanıcıSsnPatientITıklar() {
      page01.SsnPatient.sendKeys("147-47-1477",Keys.ENTER);
    }

    @And("K1 kullanıcı myPages ı tıklar")
    public void kKullanıcıMyPagesITıklar() {
        ReusableMethods.waitForVisibility(page01.mypg,9);
        ReusableMethods.jsclick(page01.mypg);
     /* ReusableMethods.jsclick(Driver.getDriver().findElement(By.xpath(" \"//span[text()='MY PAGES']\")")));
      /*actions.sendKeys(page04.MyPages).click().perform();*/
        /*actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.jsclick(page04.mypg);
       /* WebElement ddmList =Driver.getDriver().findElement(By.xpath("//*[@id=\"entity-menu\"]"));
        Select select = new Select(ddmList);
        select.selectByIndex(2);*/

    }

    @And("K1 kulanıcı show Appointmens ı tıklar")
    public void kKulanıcıShowAppointmensITıklar( ) {
        ReusableMethods.waitForVisibility(page01.ShowAppointmens,9);
        ReusableMethods.jsScrollClick(page01.ShowAppointmens);
       /* actions.sendKeys(page04.ShowAppointmens).perform();*/
    }


}
  
