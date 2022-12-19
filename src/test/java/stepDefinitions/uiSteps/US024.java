package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.Page_04;
import pages.Page_04;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US024   {

    Page_04 page04 = new Page_04();
    Actions actions = new Actions(Driver.getDriver());

    @When("K1 kullanıcı\\(patient) geçerli bir username girer")
    public void k1_kullanıcı_patient_geçerli_bir_username_girer() {
       page04.username.sendKeys("hstteam05");
    }
    @When("K1 kullanıcı \\(patient)geçerli bir pasword girer")
    public void k1_kullanıcı_patient_geçerli_bir_pasword_girer() {
        actions.sendKeys(Keys.TAB).sendKeys("123456").perform();
      /* page04.password.sendKeys("123456");*/
    }


    @And("K1 kullanıcı myPages\\(patient) ı tıklar")
    public void kKullanıcıMyPagesPatientITıklar() {
        ReusableMethods.waitForVisibility(page04.mypg,9);
        ReusableMethods.jsclick(page04.mypg);
    }


    @And("K1 kulanıcı  MyAppointmens ı tıklar")
    public void kKulanıcıMyAppointmensITıklar( ) {
        page04.MyAppointmensPatient.click();
    }
}
