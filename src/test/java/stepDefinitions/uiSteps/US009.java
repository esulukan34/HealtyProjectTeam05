package stepDefinitions.uiSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.Page_08;
import pojos.PatientEditPojo;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class US009 {
    String SSN="317-16-6114";
    PatientEditPojo obj = new PatientEditPojo("318261","Jack","Hook","22.12.2022","15:12","try@patient.com","666-666-6666","MALE","0+","aaaa","aaa","patient","Turkey","Oslo");
    Page_08 page08 = new Page_08();
    @Given("US09 Kullanici URL'ye gider")
    public void uS09KullaniciURLYeGider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @Then("US09 Giris simgesine ve Sign In'e tiklar")
    public void uS09GirisSimgesineVeSignInETiklar() {
        page08.LoginIcon.click();
        ReusableMethods.waitForVisibility(page08.signIn,3);
        page08.signIn.click();
        //ReusableMethods.waitForClickablility()
    }

    @Then("US09 Personel kullanicisina ait kullanici adi ve sifre girer")
    public void uS09PersonelKullanicisinaAitKullaniciAdiVeSifreGirer() {
        page08.userName.sendKeys("personel05", Keys.TAB,"Personel05+",Keys.ENTER);
    }

    @Then("US09 MY PAGES'e tiklar")
    public void uS09MyPAGESETiklar() {
        ReusableMethods.waitForVisibility(page08.myPages,3);
        page08.myPages.click();
    }

    @Then("US09 Search Patient'e tiklar")
    public void uS09SearchPatientETiklar() {
        ReusableMethods.waitForVisibility(page08.searchPatient,3);
        page08.searchPatient.click();
    }

    @And("US09 Tum hasta bilgilerinin goruldugunu dogrular")
    public void uS09TumHastaBilgilerininGoruldugunuDogrular() {
        ReusableMethods.waitForVisibility(page08.totalNumberOfPatientsText,3);
        ReusableMethods.jsScroll(page08.totalNumberOfPatientsText);
        String totalPatient = page08.totalNumberOfPatientsText.getText().replaceAll("\\D","");
        totalPatient=totalPatient.substring(3,totalPatient.length()); //toplam hasta sayısını alır

        //  Assert.assertEquals(3775,Integer.parseInt(totalPatient)); //hasta sayısını kontrol eder

        List<WebElement> listem = Driver.getDriver().findElements(By.xpath("//tbody/tr[1]/td"));
        Assert.assertEquals(15, listem.size()-1);//tum o sayfadaki hasta bilgilerini gorebildigine bakmak icin
                                                                //ilk satırda 15 hucre yi gorebildigini test ettik
    }
    @And("US09 Sayfa kapatilir")
    public void uS09SayfaKapatilir() {
        Driver.closeDriver();
    }

    @Then("US09 Patient SSN bolumune hastanin SSN nosu girilir")
    public void uS09PatientSSNBolumuneHastaninSSNNosuGirilir() {
        page08.patientSSN.sendKeys(SSN);
    }

    @Then("US09 Edit'e tiklanir")
    public void uS09EditETiklanir() {
        ReusableMethods.waitFor(5);
        ReusableMethods.waitForVisibility(page08.editOfPatientButton,2);
        page08.editOfPatientButton.click();
    }

    @Then("US09 Gelen bilgiler uzerinde degisiklikler yapilir ve Save buttonuna tiklanir")
    public void uS09GelenBilgilerUzerindeDegisikliklerYapilirVeSaveButtonunaTiklanir() {
        page08.descriptionTextBox.clear();

        page08.firstNameTextBox.click();
        page08.firstNameTextBox.clear();
        page08.firstNameTextBox.sendKeys(obj.getFirstName());

        page08.lastNameTextBox.clear();
        page08.lastNameTextBox.sendKeys(obj.getLastName());

        page08.birthDateTextBox.sendKeys(obj.getBirthDate(),Keys.TAB,obj.getBirthDateHour_Munite());

//        page08.emailTextBox.clear();
//        page08.emailTextBox.sendKeys(obj.getEmail());

        page08.phoneTextBox.clear();
        page08.phoneTextBox.sendKeys(obj.getPhone());

        page08.genderTextBox.sendKeys(obj.getGender());

        page08.bloodGroupTextBox.sendKeys(obj.getBloodGroup());

        page08.addressTextBox.clear();
        page08.addressTextBox.sendKeys(obj.getAddress());

        page08.descriptionTextBox.clear();
        page08.descriptionTextBox.sendKeys(obj.getDescription());

        page08.userTextBox.sendKeys(obj.getUser());

        page08.countryTextBox.sendKeys(obj.getCountry());

        page08.state_CityTextBox.sendKeys(obj.getState_City());

        ReusableMethods.jsScrollClick(page08.saveButton);

        ReusableMethods.waitFor(5);
    }

    @And("US09 Tum bilgilerinin uzerinde degisiklik yapildigi gozlemlenir")
    public void uS09TumBilgilerininUzerindeDegisiklikYapildigiGozlemlenir() {
        //   Assert.assertEquals(page08.idText.getText(),obj.getId());

        assertTrue(page08.editAlert.isDisplayed());
        Assert.assertEquals(obj.getFirstName(),page08.firstNameText.getText());
        Assert.assertEquals(obj.getLastName(),page08.lastNameText.getText());
        //Assert.assertEquals(obj.getEmail(),page08.emailText.getText());
        //   Assert.assertEquals(obj.getGender(),page08.genderText.getText());
        //   Assert.assertEquals(obj.getBloodGroup(),page08.bloodGroupText.getText());
        Assert.assertEquals(obj.getAddress(),page08.addressText.getText());
        Assert.assertEquals(obj.getDescription(),page08.descriptionText.getText());
        //Assert.assertEquals(obj.getUser(),page08.userText.getText());
        //Assert.assertEquals(obj.getCountry(),page08.countryText.getText());

        //    Assert.assertEquals(page08.state_CityText.getText(),obj.getState_City());

    }

    @Then("US09 View buttonuna tiklar")
    public void uS09ViewButtonunaTiklar() {
        ReusableMethods.waitFor(3);
        page08.viewButton.click();
    }

    @And("US09 Kullanici hasta kaydinin tum bilgilerin girildigini gorur")
    public void uS09KullaniciHastaKaydininTumBilgilerinGirildiginiGorur() {
        ReusableMethods.waitFor(3);
        /*   System.out.println("page08.SSNText.getText() = " + page08.editmenuText.getText());
        System.out.println("page08.texttextetxt = " + page08.texttextetxt.getText());*/
        assertTrue(Driver.getDriver().getPageSource().contains(SSN));
        assertTrue(Driver.getDriver().getPageSource().contains(obj.getFirstName()));
        assertTrue(Driver.getDriver().getPageSource().contains(obj.getLastName()));
        assertTrue(Driver.getDriver().getPageSource().contains(obj.getEmail()));
 //       Assert.assertTrue(Driver.getDriver().getPageSource().contains(obj.getGender()));
//        Assert.assertTrue(Driver.getDriver().getPageSource().contains(page08.bloodGroupText.getText()));
 //       Assert.assertTrue(Driver.getDriver().getPageSource().contains(obj.getAddress()));
 //       Assert.assertTrue(Driver.getDriver().getPageSource().contains(obj.getDescription()));
  //      Assert.assertTrue(Driver.getDriver().getPageSource().contains(obj.getCountry()));
   //     Assert.assertTrue(Driver.getDriver().getPageSource().contains(obj.getState_City()));
    }

    @And("US09 Hastanin First Name, Last Name, Email, Phone bilgilerini siler")
    public void uS09HastaninFirstNameLastNameEmailPhoneBilgileriniSiler() {
        ReusableMethods.waitForVisibility(page08.idTextBox,3);
        page08.adminLoginTextBox.clear();
        page08.adminFirstNameTextBox.clear();
        page08.adminLastNameTextBox.clear();
        page08.adminEmailTextBox.clear();
        page08.adminSSNTextBox.clear();


    }

    @And("US09 Save buttonuna tiklar")
    public void uS09SaveButtonunaTiklar() {
        ReusableMethods.jsScrollClick(page08.adminSaveButton);
    }

    @And("US09 Gereklidir uyarisi verildigini gorur")
    public void uS09GereklidirUyarisiVerildiginiGorur() {
        ReusableMethods.waitFor(3);
        ReusableMethods.jsScroll(page08.adminFirstNameTextBox);
        List<WebElement> girilmediUyarisiList = Driver.getDriver().findElements(By.xpath("//*[@class='invalid-feedback']"));
        System.out.println("girilmediUyarisiList.size() = " + girilmediUyarisiList.size());
        Assert.assertTrue(girilmediUyarisiList.get(0).isDisplayed());
        Assert.assertTrue(girilmediUyarisiList.get(1).isDisplayed());
        Assert.assertTrue(girilmediUyarisiList.get(2).isDisplayed());
      //  Assert.assertTrue(girilmediUyarisiList.get(3).isDisplayed());
        ReusableMethods.waitFor(3);

    }

    @Then("US09 Admin kullanicisina ait kullanici adi ve sifre girer")
    public void uS09AdminKullanicisinaAitKullaniciAdiVeSifreGirer() {
        page08.userName.sendKeys("Batch81", Keys.TAB,"Batch81+",Keys.ENTER);
    }

    @Then("US09 Administration'a tiklar")
    public void uS09AdministrationATiklar() {
        page08.administration.click();
    }

    @Then("US09 User management'e tiklar")
    public void uS09UserManagementETiklar() {
        ReusableMethods.waitForVisibility(page08.user_Management,3);
        page08.user_Management.click();
        ReusableMethods.waitForVisibility(page08.modifiedDate,3);
        page08.modifiedDate.click();
        ReusableMethods.waitForVisibility(page08.modifiedDate,3);
        page08.modifiedDate.click();
    }
    @And("US09 Hastanin {string},{string},{string},{string},{string} bilgilerini gunceller")
    public void uS09HastaninBilgileriniGunceller(String login, String firstName, String lastName, String email, String ssn) {
        Faker faker = new Faker();
        login=faker.color().name();
        firstName=faker.name().firstName();
        lastName=faker.name().lastName();
        email=faker.internet().emailAddress();
        ssn=faker.idNumber().ssnValid();
        page08.adminLoginTextBox.clear();
        page08.adminLoginTextBox.sendKeys(login,Keys.TAB,firstName,Keys.TAB,lastName,Keys.TAB,email,Keys.TAB,ssn);

    }
    @And("US09 Update yapildigina dair uyari verildigini gorur")
    public void uS09UpdateYapildiginaDairUyariVerildiginiGorur() {
        ReusableMethods.waitForVisibility(page08.saveAlert,3);
        assertTrue(page08.saveAlert.isDisplayed());
    }

    @And("US09 Kullanici Save buttonuna tiklar")
    public void uS09KullaniciSaveButtonunaTiklar() {
        ReusableMethods.jsScrollClick(page08.saveButton);
    }

    @And("US09 Kullanici hastanin First Name, Last Name, Email, Phone bilgilerini siler")
    public void uS09KullaniciHastaninFirstNameLastNameEmailPhoneBilgileriniSiler() {
        ReusableMethods.waitForVisibility(page08.idTextBox,3);

        page08.firstNameTextBox.clear();
        page08.lastNameTextBox.clear();
        page08.emailTextBox.clear();
        page08.phoneTextBox.clear();
    }

    @And("US09 Kullanici gereklidir uyarisi verildigini gorur")
    public void uS09KullaniciGereklidirUyarisiVerildiginiGorur() {
        ReusableMethods.waitFor(3);
        ReusableMethods.jsScroll(page08.firstNameTextBox);
        List<WebElement> girilmediUyarisiList = Driver.getDriver().findElements(By.xpath("//*[@class='invalid-feedback']"));
        System.out.println("girilmediUyarisiList.size() = " + girilmediUyarisiList.size());
        Assert.assertTrue(girilmediUyarisiList.get(0).isDisplayed());
        Assert.assertTrue(girilmediUyarisiList.get(1).isDisplayed());
        Assert.assertTrue(girilmediUyarisiList.get(2).isDisplayed());
        //  Assert.assertTrue(girilmediUyarisiList.get(3).isDisplayed());
        ReusableMethods.waitFor(3);
    }
}
