package stepDefinitions.uiSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Page_07;
import utilities.ReusableMethods;

public class US026 {

    Page_07 page_07 = new Page_07();
    Faker faker = new Faker();

    @When("md Contact menusune tiklar")
    public void md_contact_menusune_tiklar() {
        page_07.contactMenu.click();


    }
    @Then("md Name kutusunun enable oldugunu test eder")
    public void md_name_kutusunun_enable_oldugunu_test_eder() {
        Assert.assertTrue(page_07.fullNameBox.isEnabled());


    }
    @Then("md Email kutusunun enable oldugunu test eder")
    public void md_email_kutusunun_enable_oldugunu_test_eder() {
        Assert.assertTrue(page_07.emailBox.isEnabled());


    }
    @Then("md Subject kutusunun enable oldugunu test eder")
    public void md_subject_kutusunun_enable_oldugunu_test_eder() {
        Assert.assertTrue(page_07.subjectBox.isEnabled());


    }
    @Then("md Message kutusunun enable oldugunu test eder")
    public void md_message_kutusunun_enable_oldugunu_test_eder() {
        Assert.assertTrue(page_07.messageBox.isEnabled());


    }
    @Then("md Mesaj gonder butonunun enable oldugunu test eder")
    public void md_mesaj_gonder_butonunun_enable_oldugunu_test_eder() {
        Assert.assertTrue(page_07.sendButton.isEnabled());

    }

    @When("md Gecerli bir isim ve soyisim girer")
    public void md_gecerli_bir_isim_ve_soyisim_girer() {
        page_07.fullNameBox.sendKeys(faker.name().fullName());

    }

    @When("md Herhangi bir email adresi girer")
    public void md_herhangi_bir_email_adresi_girer() {
        page_07.emailBox.sendKeys(faker.internet().emailAddress());

    }

    @When("md Mesajin konusunu yazar")
    public void md_mesajin_konusunu_yazar() {
        page_07.subjectBox.sendKeys(faker.lorem().characters(4,9));

    }

    @When("md Mesajini yazar")
    public void md_mesajini_yazar() {
        page_07.messageBox.sendKeys(faker.lorem().sentence(5));

    }

    @When("md Send butonunu tiklar")
    public void md_send_butonunu_tiklar() {
        ReusableMethods.jsScrollClick(page_07.sendButton);

    }

    @Then("md Mesajin basariyla iletildigini test eder")
    public void md_mesajin_basariyla_iletildigini_test_eder() {

        Assert.assertTrue(page_07.mesajIletildiYazisi.getText().contains("Your message has been received"));
    // Assert.assertTrue(page_07.mesajIletildiYazisiContains.getText().contains("Your message has been received"));

    }

}
