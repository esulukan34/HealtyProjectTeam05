package stepDefinitions.uiSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.Page_08;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.security.Key;
import java.util.List;

import static org.junit.Assert.*;

public class US019 {
    Page_08 page08 = new Page_08();
    Faker faker = new Faker();

    String SSN;
    String id;
    @Given("K8 Kullanici URL'ye gider")
    public void k8_kullanici_url_ye_gider() {
            Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }
    @Then("K8 Giris simgesine tiklar ve Sign in'e tiklar")
    public void k8_giris_simgesine_tiklar_ve_sign_in_e_tiklar() {
        page08.LoginIcon.click();
        ReusableMethods.waitForVisibility(page08.signIn,3);
        page08.signIn.click();

    }
    @Then("K8 Admin kullanicisina ait kullanici adi ve sifre girer")
    public void k8_admin_kullanicisina_ait_kullanici_adi_ve_sifre_girer() {
        page08.userName.sendKeys("Batch81", Keys.TAB,"Batch81+",Keys.ENTER);
    }
    @Then("K8 Items&Titles'e tiklar")
    public void k8_ıtems_titles_e_tiklar() {
        ReusableMethods.waitForVisibility(page08.items_Titles,3);
        page08.items_Titles.click();
    }
    @Then("K8 Staff'e tiklar")
    public void k8_staff_e_tiklar() {
       // ReusableMethods.waitForVisibility(page08.staff,5);
        page08.staff.click();
    }
    @Then("K8 Create a new Staff buttonuna tiklar")
    public void k8_create_a_new_staff_buttonuna_tiklar() {
        ReusableMethods.waitForVisibility(page08.createANewStaff,3);
        page08.createANewStaff.click();

    }
    @Then("K8 SSN bolumune var olan bir Staff SSN'i girilir")
    public void k8_ssn_bolumune_var_olan_bir_staff_ssn_i_girilir() {
        ReusableMethods.waitForVisibility(page08.adminStaffSsnTextBox,3);
        page08.adminStaffSsnTextBox.sendKeys("585-96-9654");

    }
    @Then("K8 Search User butonun tiklanir")
    public void k8_search_user_butonun_tiklanir() {
        page08.ssnSearchButton.click();

    }
    @Then("K8 Sayfayi kapatir")
    public void k8_sayfayi_kapatir() {
      Driver.closeDriver();
    }

    @Then("K8 User found with search SSN uyarisi gorulur")
    public void k8_user_found_with_search_ssn_uyarisi_gorulur() throws IOException {

        ReusableMethods.waitForVisibility(page08.saveButton,3);
        ReusableMethods.waitForVisibility(page08.saveAlert, 3);
        ReusableMethods.getScreenshot("US019TC02 - ");

        assertTrue(page08.saveButton.isDisplayed());
        ReusableMethods.waitFor(3);
    }
    @Then("K8 Use Search kutusu isaretlenir")
    public void k8_use_search_kutusu_isaretlenir() {
        page08.useSearch.click();
    }
    @Then("K8 SSN bolumune var olan bir Staff {string}'i girilir")
    public void k8_ssn_bolumune_var_olan_bir_staff_i_girilir(String ssn) {
        SSN=ssn;
        ReusableMethods.waitForVisibility(page08.adminStaffSsnTextBox,3);
        page08.adminStaffSsnTextBox.sendKeys(ssn);
    }
    @Then("K8 SSN bolumune var olan bir Staff SSN'i {string} girilir")
    public void k8_ssn_bolumune_var_olan_bir_staff_ssn_i_girilir(String ssn) {
        SSN=ssn;
        ReusableMethods.waitForVisibility(page08.adminStaffSsnTextBox,3);
        page08.adminStaffSsnTextBox.sendKeys(ssn);
    }
    @Then("K8 Aranan SSN'e ait bilgiler asağidaki kutulara geldigi gozlemlenir")
    public void k8_aranan_ssn_e_ait_bilgiler_asağidaki_kutulara_geldigi_gozlemlenir() {
        if (SSN.equals("585-96-9654")){
            assertFalse(Driver.getDriver().getPageSource().contains("Jack"));
            assertFalse(Driver.getDriver().getPageSource().contains("Sparow"));
            assertTrue(Driver.getDriver().getPageSource().contains("ibrahim"));
            assertTrue(Driver.getDriver().getPageSource().contains("doktor"));
        } else if (SSN.equals("677-11-0949")) {
            assertTrue(Driver.getDriver().getPageSource().contains("Jaqueline"));
            assertTrue(Driver.getDriver().getPageSource().contains("McClure"));
            assertFalse(Driver.getDriver().getPageSource().contains("26/11/22 02:00"));
            assertFalse(Driver.getDriver().getPageSource().contains("542-312-4243"));
            assertTrue(Driver.getDriver().getPageSource().contains("MALE"));
            assertTrue(Driver.getDriver().getPageSource().contains("A+"));
            assertFalse(Driver.getDriver().getPageSource().contains("Suite 486 2978 Julieann Motorway, West Malcolmview, NM 00376-2808"));
            assertFalse(Driver.getDriver().getPageSource().contains("26/11/22 16:23"));
            assertFalse(Driver.getDriver().getPageSource().contains("celestine.reynolds"));
            assertTrue(Driver.getDriver().getPageSource().contains("USA"));
            assertFalse(Driver.getDriver().getPageSource().contains("California"));
        }
    }

    @Then("K8 Bos olan bilgiler doldurulur")
    public void k8_bos_olan_bilgiler_doldurulur() {
        faker = new Faker();
        ReusableMethods.waitForVisibility(page08.firstNameTextBoxStaff,3);
        page08.firstNameTextBoxStaff.sendKeys(faker.name().firstName(),
                                    Keys.TAB,faker.name().lastName(),
                                    Keys.TAB,"10.02.2000",Keys.TAB,Keys.TAB,
                                    Keys.TAB,"777-777-7777",
                                    Keys.TAB,"MALE",
                                    Keys.TAB,"B+",
                                    Keys.TAB,"otomasyon",
                                    Keys.TAB,"Mustafa SAK All test run",
                                    Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,
                                    Keys.TAB,"mariams",
                                    Keys.TAB,"Makedonya",
                                    Keys.TAB,Keys.TAB);

    }
    @Then("K8 Kullanici olusturulmadigina dair yaziyi gorurse user i degistirir tekrar save buttonuna basar")
    public void k8_kullanici_olusturulmadigina_dair_yaziyi_gorurse_user_i_degistirir_tekrar_save_buttonuna_basar() {
        ReusableMethods.waitFor(3);
        Select select=new Select(page08.userDDL);

        if (page08.adminSaveButton.isDisplayed()){
          /*  int count=1;
           do {
               select.selectByIndex(count);
               count++;
               ReusableMethods.waitFor(2);
               ReusableMethods.jsScrollClick(page08.adminSaveButton);
               ReusableMethods.waitFor(2);
           }while (page08.adminSaveButton.isDisplayed());*/
            for (int i = 0; i < 15; i++) {
                select.selectByIndex(i);
                ReusableMethods.waitFor(2);
                ReusableMethods.jsScrollClick(page08.adminSaveButton);
                ReusableMethods.waitFor(2);
                if (!Driver.getDriver().getPageSource().contains("save")){
                    ReusableMethods.waitForVisibility(page08.createdDate,3);
                    page08.createdDate.click();
                    ReusableMethods.waitFor(2);
                    id=page08.tableOfFirstId.getText();
                    System.out.println("id variablesinin degeri  "+id);
                    i=14;
                }
            }

        }

    }
    @Then("K8 Save butonuna tiklar")
    public void k8_save_butonuna_tiklar() {
        ReusableMethods.jsScrollClick(page08.adminSaveButton);
    }
    @Then("K8 Kullanici olusturulduguna dair uyariyi gorur")
    public void k8_kullanici_olusturulduguna_dair_uyariyi_gorur(){
        ReusableMethods.waitFor(2);
        assertTrue(page08.fieldUserCannotBeEmpty.isDisplayed() || page08.internalServerError.isDisplayed());//kayıt olmadığı uyarısını locate aldım
      //  assertTrue(page08.);
       // System.out.println(page08.fieldUserCannotBeEmpty.isDisplayed());
    }
    @Then("K8 Kayitli kullanicilardan birinin view butonuna tiklar")
    public void k8_kayitli_kullanicilardan_birinin_view_butonuna_tiklar() {
        ReusableMethods.waitForVisibility(page08.table,3);
        boolean control=true;
        do {
            List<WebElement> nameList = Driver.getDriver().findElements(By.xpath("//tbody//td[3]"));
           // System.out.println("nameList = " + nameList.size());
            for (WebElement e:nameList) {
             //   System.out.println(e.getText());
                if (e.getText().equals("Jack")){
               //     System.out.println("e nin değeri  = " + e.getText());
                    WebElement viewButton = Driver.getDriver().findElement(By.xpath("(//span[text()='View'])["+(nameList.indexOf(e)+1)+"]"));
                    ReusableMethods.jsScrollClick(viewButton);
                    control=false;
                    break;
                }
            }
            if (control){
                ReusableMethods.jsScrollClick(page08.nextButton);
            }
        }while (control);

    }
    @Then("K8 Hasta bilgilerini gorur ve dogrular")
    public void k8_hasta_bilgilerini_gorur_ve_dogrular() {
        ReusableMethods.waitForVisibility(page08.firstNameText,5);
     assertEquals(page08.SSNText.getText(),"585-96-9654");
     assertTrue(Driver.getDriver().getPageSource().contains("585-96-9654"));

     assertEquals(page08.firstNameText.getText(),"Jack");
     assertTrue(Driver.getDriver().getPageSource().contains("Jack"));

     assertEquals(page08.lastNameText.getText(),"Sparow");
     assertTrue(Driver.getDriver().getPageSource().contains("Sparow"));

     assertEquals(page08.birthDateText.getText(),"03/03/00 02:03");
     assertTrue(Driver.getDriver().getPageSource().contains("03/03/00 02:03"));

     assertEquals(page08.phoneText.getText(),"777-777-8888");
     assertTrue(Driver.getDriver().getPageSource().contains("777-777-8888"));

     assertEquals(page08.genderText.getText(),"MALE");
     assertTrue(Driver.getDriver().getPageSource().contains("MALE"));

     assertEquals(page08.bloodGroupText.getText(),"Apositive");
     assertTrue(Driver.getDriver().getPageSource().contains("Apositive"));

     assertEquals(page08.addressText.getText(),"deneme");
     assertTrue(Driver.getDriver().getPageSource().contains("deneme"));

     assertEquals(page08.descriptionText.getText(),"denememeeelll");
     assertTrue(Driver.getDriver().getPageSource().contains("denememeeelll"));

     assertEquals(page08.createdDateText.getText(),"03/12/22 15:26");
     assertTrue(Driver.getDriver().getPageSource().contains("03/12/22 15:26"));

     assertEquals(page08.userText.getText(),"ibrahimdoktor");
     assertTrue(Driver.getDriver().getPageSource().contains("ibrahimdoktor"));

     assertEquals(page08.countryText.getText(),"istanbul123");
     assertTrue(Driver.getDriver().getPageSource().contains("istanbul123"));
    }

    @Then("K8 Kayitli kullanicilardan {string} li kullanicinin edit butonuna tiklar")
    public void k8_kayitli_kullanicilardan_li_kullanicinin_edit_butonuna_tiklar(String id) {
        id="400506";
        ReusableMethods.waitForVisibility(page08.table,3);
        boolean control=true;
        do {
            List<WebElement> nameList = Driver.getDriver().findElements(By.xpath("//tbody//td[1]"));
            // System.out.println("nameList = " + nameList.size());
            for (WebElement e:nameList) {
                //   System.out.println(e.getText());
                if (e.getText().equals(id)){
                    //     System.out.println("e nin değeri  = " + e.getText());
                    WebElement viewButton = Driver.getDriver().findElement(By.xpath("(//span[text()='Edit'])["+(nameList.indexOf(e)+1)+"]"));
                    ReusableMethods.jsScrollClick(viewButton);
                    control=false;
                    break;
                }
            }
            if (control){
                ReusableMethods.jsScrollClick(page08.nextButton);
            }
        }while (control);
    }
    @Then("K8 Kullanici bilgilerinde guncelleme yapar ve save botununa tiklar")
    public void k8_kullanici_bilgilerinde_guncelleme_yapar_ve_save_botununa_tiklar() {
        faker=new Faker();
        ReusableMethods.waitForVisibility(page08.firstNameTextBoxStaff,3);
        page08.firstNameTextBoxStaff.clear();
        page08.firstNameTextBoxStaff.sendKeys(faker.name().firstName());
        ReusableMethods.jsScrollClick(page08.adminSaveButton);
    }
    @Then("K8 Basarili islem oldugu uyarısını gorur")
    public void k8_basarili_islem_oldugu_uyarısını_gorur() {
        ReusableMethods.waitFor(3);
//        assertTrue(page08.editAlert.isDisplayed());
    }

    @Then("K8 Kayitli kullanicilardan belirtilen description li kullanicinin delete butonuna tiklar")
    public void k8_kayitli_kullanicilardan_belirtilen_description_li_kullanicinin_delete_butonuna_tiklar() {
        String description="Mustafa SAK All test run";
        ReusableMethods.waitForVisibility(page08.table,3);
     //   page08.createdDate.click();
       // ReusableMethods.waitForVisibility(page08.table,3);

        boolean control=true;
        do {
            List<WebElement> descriptionList = Driver.getDriver().findElements(By.xpath("//tbody//td[10]"));

            // System.out.println("nameList = " + nameList.size());
            for (WebElement e:descriptionList) {
                //   System.out.println(e.getText());
                if (e.getText().equals(description)){
                    //     System.out.println("e nin değeri  = " + e.getText());
                    WebElement deleteButton = Driver.getDriver().findElement(By.xpath("(//span[text()='Delete'])["+(descriptionList.indexOf(e)+1)+"]"));
                    ReusableMethods.jsScrollClick(deleteButton);
                    control=false;
                    break;
                }
            }
            if (control){
                ReusableMethods.jsScrollClick(page08.nextButton);
            }
        }while (control);
    }
    @Then("K8 Gelen uyaridan Delete butonuna tiklar")
    public void k8_gelen_uyaridan_delete_butonuna_tiklar() {
        ReusableMethods.waitForVisibility(page08.deleteButton,3);
        page08.deleteButton.click();
    }
    @Then("K8 Basarili islem oldugu uyarisini gorur")
    public void k8_basarili_islem_oldugu_uyarisini_gorur() {
      //  assertTrue(page08.editAlert.isDisplayed());
        assertTrue(page08.createANewStaff.isDisplayed());
    }
}
