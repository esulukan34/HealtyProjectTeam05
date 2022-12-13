package stepDefinitions.uiSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.Page_05;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.ReusableMethods.setTheDateByRandom;

public class US015 {

    Page_05 page = new Page_05();
    public static String firstname;
    public static String lastname;

    @Given("FA admin {string} e gider")
    public void faAdminEGider(String url) {

        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @When("FA admin login olur")
    public void faAdminLoginOlur() {

        page.accountMenu.click();
        page.signIn.click();
        page.usernameBox.sendKeys(ConfigReader.getProperty("adminFa"));
        page.passwordBox.sendKeys(ConfigReader.getProperty("adminSifreFa"));
        page.signInButton.click();
    }

    @Then("FA admin Items&Titles menuden Patient tiklar")
    public void faAdminItemsTitlesMenudenPatientTiklar() {
        ReusableMethods.waitFor(2);
        ReusableMethods.jsScrollClick(page.itemsAndTitles);
        ReusableMethods.waitFor(2);
        ReusableMethods.jsScrollClick(page.patientLink);

    }

    @Then("FA admin acilan pencerede Create a new Patient butonunun gorunur oldugunu dogrular ve tiklar")
    public void faAdminAcilanPenceredeCreateANewPatientButonununGorunurOldugunuDogrularVeTiklar() {

        assertTrue(page.createNewPatientButton.isDisplayed());
        page.createNewPatientButton.click();
    }

    @And("FA admin acilan pencerede gecerli bilgileri girer ve save buttonuna tiklar")
    public void faAdminAcilanPenceredeGecerliBilgileriGirerVeSaveButtonunaTiklar() {

        LocalDateTime date1 = LocalDateTime.now().minusYears(24).minusHours(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String date = date1.format(formatter);

        firstname = Faker.instance().name().lastName();
        lastname = Faker.instance().name().lastName();

        page.firstnameBoxPatient.sendKeys(firstname);
        page.lastnameBoxPatient.sendKeys(lastname);
        page.birthDayBoxPatient.sendKeys(date);
        page.emailBoxPatient.sendKeys(Faker.instance().internet().emailAddress());
        page.phoneBoxPatient.sendKeys(Faker.instance().number().digits(10));
        page.genderDdmPatient.sendKeys("FEMALE");
        page.bloodGroupDdmPatient.sendKeys("O+");
        page.addressBoxPatient.sendKeys(Faker.instance().address().fullAddress());
        page.descriptionBoxPatient.sendKeys("feyzayhn");
        page.countryDdmPatient.sendKeys("Türkiyem");
        ReusableMethods.waitFor(3);
        page.stateDdmPatient.sendKeys("Isparta");
        ReusableMethods.waitFor(3);
        ReusableMethods.jsScrollClick(page.saveButtonPatient);
        ReusableMethods.waitFor(3);

    }

    @And("FA admin kayit isleminin gerceklestigini dogrular")
    public void faAdminKayitIslemininGerceklestiginiDogrular() throws IOException {

        ReusableMethods.waitFor(3);
        Assert.assertTrue(page.inPatientSaveMassage.isDisplayed());
        ReusableMethods.getScreenshotWebElement("Save Kayit Mesaji", page.inPatientSaveMassage);
    }


    @And("FA Admin acilan pencerede SSN,First Name,Last Name,Birth Date,Phone, Gender,Blood Group,Address,Description,Created Date,User,Country and stateCity title'larinin gorunur oldugunu dogrular")
    public void faAdminAcilanPenceredeSSNFirstNameLastNameBirthDatePhoneGenderBloodGroupAddressDescriptionCreatedDateUserCountryAndStateCityTitleLarininGorunurOldugunuDogrular() throws IOException {

        for (WebElement w : page.patientTableTitles) {

            Assert.assertTrue(w.isDisplayed());

        }
        ReusableMethods.getScreenshotWebElement("tableTitles", page.titles);
    }

    @Then("FA hasta {int} saniye bekler")
    public void faHastaSaniyeBekler(int sn) {

        ReusableMethods.waitFor(sn);
    }

    @And("FA admin id tiklar olusturulan hastaya edit yapar")
    public void faAdminIdTiklarOlusturulanHastayaEditYapar() {

        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(5);
        ReusableMethods.jsScrollClick(page.idTitle);
        ReusableMethods.waitFor(5);
        ReusableMethods.jsScrollClick(page.editButtons.get(0));
    }

    @Then("FA admin hastanin email,phone,adres,description bilgisini gunceller ve save butonuna tiklar")
    public void faAdminHastaninEmailPhoneAdresDescriptionBilgisiniGunceller() {

        page.emailBoxPatient.clear();
        ReusableMethods.waitFor(1);
        page.emailBoxPatient.sendKeys(Faker.instance().internet().emailAddress());

        page.phoneBoxPatient.clear();
        ReusableMethods.waitFor(1);
        page.phoneBoxPatient.sendKeys(Faker.instance().number().digits(10));

        page.addressBoxPatient.clear();
        ReusableMethods.waitFor(1);
        page.addressBoxPatient.sendKeys(Faker.instance().address().fullAddress());

        page.descriptionBoxPatient.clear();
        ReusableMethods.waitFor(1);
        page.descriptionBoxPatient.sendKeys(Faker.instance().toString());

        ReusableMethods.waitFor(3);
        ReusableMethods.jsScrollClick(page.saveButtonPatient);

    }

   /* @And("FA {string} mesajinin gorundugunu dogrular")
    public void faSaveButtonunaTiklarVeMesajininGorundugunuDogrular(String message) throws IOException {

        ReusableMethods.waitForVisibility(page.inPatientSaveMassage, 10);
        Assert.assertTrue(page.inPatientSaveMassage.getText().contains(message));
        ReusableMethods.getScreenshotWebElement("updateMessage", page.inPatientSaveMassage);
    }*/

    @Then("FA admin Items&Titles menuden Appointment tiklar")
    public void faAdminItemsTitlesMenudenAppointmentTiklar() {

        page.itemsAndTitles.click();
        page.appointmentDdmPatient.click();
    }

    @And("FA admin Create a new Appointment butonuna tiklar")
    public void faAdminCreateANewAppointmentButonunaTiklar() {

        page.createNewAppointmentButton.click();
    }

    @Then("FA admin gecerli randevu tarihlerini secer")
    public void faAdminGecerliRandevuTarihleriniSecer() {

        ReusableMethods.waitFor(3);
        String date = setTheDateByRandom("dd-MM-yyyy", 0, "FEATURE");
        page.appointmentEndDate.sendKeys(date);
    }

    @Then("FA admin status,physician ve patient bilgisi secer ve save butonuna tiklar")
    public void faAdminStatusPhysicianVePatientBilgisiSecer() {

        List<WebElement> appointmentStatus = ReusableMethods.select(page.appointmentStatus).getOptions();
        int index = ReusableMethods.random().nextInt(appointmentStatus.size());
        ReusableMethods.waitFor(3);
        ReusableMethods.select(page.appointmentStatus).selectByIndex(index);


        ReusableMethods.jsScroll(page.Diagnosis);


        List<WebElement> physiciamDdm = ReusableMethods.select(page.appointmentDoctorSelect).getOptions();
        index = ReusableMethods.random().nextInt(physiciamDdm.size());
        ReusableMethods.waitFor(4);
        ReusableMethods.waitForClickable(physiciamDdm.get(0), 25);
        ReusableMethods.select(page.appointmentDoctorSelect).selectByIndex(index);


        List<WebElement> patientDdm = ReusableMethods.select(page.appointmentPatientSelect).getOptions();
        index = ReusableMethods.random().nextInt(patientDdm.size());
        ReusableMethods.waitFor(4);
        ReusableMethods.select(page.appointmentPatientSelect).selectByIndex(index);


        ReusableMethods.waitFor(4);
        ReusableMethods.jsScrollClick(page.saveButtonPatient);

    }

    @And("FA admin {string} mesajinin gorundugunu dogrular")
    public void faAdminSaveButtonunaTiklarVeMesajininGorundugunuDogrular(String message) throws IOException {


        ReusableMethods.waitForVisibility(page.inPatientSaveMassage, 10);
        assertTrue(page.inPatientSaveMassage.getText().contains(message));
        ReusableMethods.getScreenshotWebElement("us015tc004updateMessage", page.inPatientSaveMassage);

    }

    @And("FA admin acilan pencerede Country ve State disindaki hasta bilgilerini girer ve save butonuna tiklar")
    public void faAdminAcilanPenceredeCountryVeStateDisindakiHastaBilgileriniGirer() {

        LocalDateTime date1 = LocalDateTime.now().minusYears(24).minusHours(5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String date = date1.format(formatter);

        page.firstnameBoxPatient.sendKeys(Faker.instance().name().lastName());
        page.lastnameBoxPatient.sendKeys(Faker.instance().name().lastName());
        page.birthDayBoxPatient.sendKeys(date);
        page.emailBoxPatient.sendKeys(Faker.instance().internet().emailAddress());
        page.phoneBoxPatient.sendKeys(Faker.instance().number().digits(10));
        page.genderDdmPatient.sendKeys("FEMALE");
        page.bloodGroupDdmPatient.sendKeys("O+");
        page.addressBoxPatient.sendKeys(Faker.instance().address().fullAddress());
        page.descriptionBoxPatient.sendKeys("feyzayhn");

        ReusableMethods.waitFor(3);
        ReusableMethods.jsScrollClick(page.saveButtonPatient);
    }


    @And("FA admin {string} mesajinin gorunur olmadıgini dogrular")
    public void faAdminSaveButonunaTiklarVeMesajininGorunurOlmadıginiDogrular(String message) throws IOException {

        ReusableMethods.waitForVisibility(page.inPatientSaveMassage, 15);
        assertTrue(page.inPatientSaveMassage.isDisplayed());
        ReusableMethods.getScreenshotWebElement("countryStateBug", page.inPatientSaveMassage);
    }


    @And("FA admin id tiklar olusturulan hastaya delete yapar ve popUpta delete button'a tiklar")
    public void faAdminIdTiklarOlusturulanHastayaDeleteYaparVePopUptaDeleteButtonATiklar() {

        ReusableMethods.waitFor(3);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.jsScrollClick(page.idTitle);
        ReusableMethods.waitFor(3);
        ReusableMethods.jsScrollClick(page.deleteButtonList.get(0));
        ReusableMethods.waitFor(3);
        ReusableMethods.jsScrollClick(page.alertDeleteButton);
    }

    @And("FA {string} mesajinin gorundugunu dogrular")
    public void faMesajininGorundugunuDogrular(String arg0) throws IOException {

        ReusableMethods.waitForVisibility(page.deleteMassagePatient, 15);
        assertTrue(page.deleteMassagePatient.isDisplayed());
        ReusableMethods.getScreenshotWebElement("deletePatientSS", page.deleteMassagePatient);
    }


    @Then("FA admin gecersiz randevu tarihlerini secer ve save butonuna tiklar")
    public void faAdminGecersizRandevuTarihleriniSecer() {

        LocalDateTime date1 = LocalDateTime.now().minusDays(1).minusYears(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String date = formatter.format(date1);
        page.appointmentEndDate.sendKeys(date);

        ReusableMethods.waitFor(3);
        ReusableMethods.jsScrollClick(page.saveButtonPatient);
    }
}
