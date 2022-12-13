package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import pages.Page_05;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class US014 {

    Page_05 page = new Page_05();

    @When("K5 doktor olarak login olur")
    public void K5doktorOlarakLoginOlur() {
        page.accountMenu.click();
        page.signIn.click();
        page.usernameBox.sendKeys(ConfigReader.getProperty("physicianUsername"));
        page.passwordBox.sendKeys(ConfigReader.getProperty("physicianPassword"));
        page.signInButton.click();
    }

    @Then("K5 doktor Mypages menusunden MyInpatient'e tiklar")
    public void K5doktorMypagesMenusundenMyInpatientETiklar() {

        page.myPages.click();
        ReusableMethods.waitFor(3);
        page.myInpatients.click();
        ReusableMethods.waitFor(3);
    }

    @And("K5 Doctor ID, start and end dates, description, created date appointment id, status, room and patient bilgilerini gorunur oldugunu dogrular")
    public void K5doctorIDStartAndEndDatesDescriptionCreatedDateAppointmentIdStatusRoomAndPatientBilgileriniGorunurOldugunuDogrular() throws IOException {

        // List<WebElement> expected = page.patientTableTitles;

        for (WebElement w : page.patientTableTitles) {  // direkt page sayfasindan list'i aldik
            assertTrue(w.isDisplayed());
        }
        ReusableMethods.getScreenshotWebElement("PatientTable", page.patientTable);
    }

    @Then("K5 doctor bilgilerini guncellemek istedigi hastaya edit yapar")
    public void K5doctorBilgileriniGuncellemekIstedigiHastayaEditYapar() {

        ReusableMethods.waitForClickable(page.editButton, 20);
        ReusableMethods.waitForVisibility(page.editButton, 15);
        int index = ReusableMethods.random().nextInt(page.editButtons.size() - 1);
        ReusableMethods.jsScrollClick(page.editButtons.get(index));
    }

    @And("K5 {int} saniye bekler")
    public void K5saniyeBekler(int sn) {

        ReusableMethods.waitFor(sn);
    }

    @Then("K5 doctor status bilgisi secer ve dogrular")
    public void K5doctorStatusBilgisiSecerVeDogrular() {


        List<WebElement> statusDDm = ReusableMethods.select(page.statusDdm).getOptions(); // 0 1 2 3
        int index = ReusableMethods.random().nextInt(statusDDm.size()) - 1;
        ReusableMethods.select(page.statusDdm).selectByIndex(index);
        ReusableMethods.jsScrollClick(statusDDm.get(index));
        String selectedOption = ReusableMethods.select(page.statusDdm).getFirstSelectedOption().getText();
        System.out.println(selectedOption);
        try {
            ReusableMethods.getScreenshot("StatusMenu");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        K5saniyeBekler(3);
    }

    @And("K5 doctor rezerve edilmis hasta odasini gunceller")
    public void K5doctorRezerveEdilmisHastaOdasiniGunceller() {

        List<WebElement> roomDDM = ReusableMethods.select(page.roomDdm).getOptions();
        int index = 0;
        while (index == 0) {
            index = ReusableMethods.random().nextInt(roomDDM.size()) - 1;
        }
        System.out.println("index = " + index);
        ReusableMethods.select(page.roomDdm).selectByIndex(index);
        String selectedOption = ReusableMethods.select(page.roomDdm).getFirstSelectedOption().getText();
        System.out.println(selectedOption);
        try {
            ReusableMethods.getScreenshot("RoomMenu");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @And("K5 doctor save butonuna tiklar ve uyariyi dogrular")
    public void K5doctorSaveButonunaTiklarVeUyariyiDogrular() throws IOException {

        ReusableMethods.jsScrollClick(page.saveButtonCreatePatient);
        String expectedData = "InPatient status can not be changed with this type of status";
        String expectedData2 = "The In Patient is updated with identifier";
        String expectedData3 = "The room already reserved";
        String expectedData4 = "Such a room not found";

        try {
            ReusableMethods.waitForClickable(page.inPatientSaveMassage, 15);
            ReusableMethods.waitForVisibility(page.inPatientSaveMassage, 15);

            if (expectedData.equals(page.inPatientSaveMassage.getText())) {

                assertEquals(expectedData, page.inPatientSaveMassage.getText());

            } else if (expectedData3.equals(page.inPatientSaveMassage.getText())) {

                assertEquals(expectedData3, page.inPatientSaveMassage.getText());

            } else if (page.inPatientSaveMassage.getText().equals(expectedData4)) {

                assertEquals(expectedData4, page.inPatientSaveMassage.getText());
            } else {

                assertTrue(page.inPatientSaveMassage.getText().contains(expectedData2));
            }
            ReusableMethods.getScreenshotWebElement("Save", page.inPatientSaveMassage);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
