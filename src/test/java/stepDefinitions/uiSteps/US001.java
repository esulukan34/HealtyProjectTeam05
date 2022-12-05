package stepDefinitions.uiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.Page_01;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US001 {

    Page_01 page01 = new Page_01();

    @Given("K4 Medunna sayfasina gider")
    public void kullanici_medunna_sayfasina_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));

    }
    @Then("K4 Account menu butonu tiklanir")
    public void account_menu_butonu_tiklanir() {

        page01.account.click();
    }
    @Then("K4 Register butonuna tiklar")
    public void register_butonuna_tiklar() {

        ReusableMethods.waitFor(1);
        page01.register.click();
    }
    @Then("K4 Gecerli bir SSN girilir")
    public void gecerli_bir_ssn_girilir() {

        page01.ssn.sendKeys("123-54-6060");
    }
    @Then("K4 Gecerli bir firstname girilir")
    public void gecerli_bir_firstname_girilir() {

        page01.firstname.sendKeys("Team");
    }
    @Then("K4 Gecerli bir lastname girilir")
    public void gecerli_bir_lastname_girilir() {

        page01.lastname.sendKeys("Project_05");
    }

    @Given("K4 Gecersiz bir SSN girilir")
    public void gecersiz_bir_ssn_girilir() {

        ReusableMethods.waitFor(2);
        Driver.getDriver().navigate().refresh();

        page01.ssn.sendKeys("12345678", Keys.TAB);
        String expectedText = "Your SSN is invalid";
        String actualText = page01.gecersizSsn.getText();
        Assert.assertEquals(expectedText,actualText);


    }

    @Then("K4 Register2 butonuna tiklar")
    public void register2_butonuna_tiklar() {
        ReusableMethods.waitFor(2);
        Driver.getDriver().navigate().refresh();

        ReusableMethods.jsScrollClick(page01.gecersizRegister);
    }


    @Then("K4 SSN,firstname ve lastname bos birakilir")
    public void ssn_firstname_ve_lastname_bos_birakilir() {

        Assert.assertEquals("Your SSN is required.",page01.requiredSsn.getText());
        Assert.assertEquals("Your FirstName is required.",page01.requiredName.getText());
        Assert.assertEquals("Your LastName is required.",page01.requiredLastname.getText());

    }
    @Then("K4 Sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.closeDriver();
    }


}
