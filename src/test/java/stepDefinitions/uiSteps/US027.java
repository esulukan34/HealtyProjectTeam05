package stepDefinitions.uiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Page_07;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static utilities.ReusableMethods.*;

public class US027 {

    Page_07 page_07 = new Page_07();

    @Given("md Anasayfada kullanici girisi simgesine tiklar")
    public void md_anasayfada_kullanici_girisi_simgesine_tiklar() {
        page_07.accountMenu.click();

    }
    @Given("md Sign in'e tiklar")
    public void md_sign_in_e_tiklar() {
        page_07.signInButton.click();
    }
    @Given("md Gecerli admin username girer")
    public void md_gecerli_admin_username_girer() {
        page_07.username.sendKeys(ConfigReader.getProperty("adminUserName"));

    }
    @Given("md Gecerli admin password girer")
    public void md_gecerli_admin_password_girer() {
        page_07.password.sendKeys(ConfigReader.getProperty("adminPassword"));

    }
    @Given("md Girisi onaylamak icin Sign in butonuna tiklar")
    public void md_girisi_onaylamak_icin_sign_in_butonuna_tiklar() {
        page_07.signIn2Button.click();

    }
    @Given("md items_Titles menusune tiklar")
    public void md_items_titles_menusune_tiklar() {
        ReusableMethods.waitFor(3);
        page_07.itemTitlesMenu.click();

    }
    @Given("md Messages'e tiklar")
    public void md_messages_e_tiklar() {
        ReusableMethods.waitFor(3);
        page_07.messagesButton.click();

    }
    @Given("md Messages sayfasinda mesajlarin gorundugunu test eder")
    public void md_messages_sayfasinda_mesajlarin_gorundugunu_test_eder() {
        ReusableMethods.waitFor(7);
        String mesajPotalSutun5Str = page_07.mesajPortalMesajSutun5.getText();
        System.out.println("mesajPotalSutun5Str = " + mesajPotalSutun5Str);
        Assert.assertTrue(mesajPotalSutun5Str.length()>0);

    }
    @Given("md Messages sayfasinda isimlerin gorundugunu test eder")
    public void md_messages_sayfasinda_isimlerin_gorundugunu_test_eder() {
        String mesajPotalSutun2Str = page_07.mesajPortalIsimSutun2.getText();
        System.out.println("mesajPotalSutun2Str = " + mesajPotalSutun2Str);
        Assert.assertTrue(mesajPotalSutun2Str.length()>0);

    }
    @Given("md Messages sayfasinda epostalarin gorundugunu test eder")
    public void md_messages_sayfasinda_epostalarin_gorundugunu_test_eder() {
        String mesajportalSutun3Str = page_07.mesajPortalEmailSutun3.getText();
        System.out.println("mesajportalSutun3Str = " + mesajportalSutun3Str);
        Assert.assertTrue(mesajportalSutun3Str.length()>0);

    }
//...................//
    @Given("md Create new messages butonuna tiklar")
    public void md_create_new_messages_butonuna_tiklar() {
        page_07.createANewMessageButton.click();

    }
    @Given("md Name kutusuna bir isim soyisim girer")
    public void md_name_kutusuna_bir_isim_soyisim_girer() {

        ReusableMethods.waitFor(2);
        page_07.adminMessageNameBox.sendKeys(getFaker().name().fullName());
    }
    @Given("md Email kutusuna bir email girer")
    public void md_email_kutusuna_bir_email_girer() {
        page_07.adminMessageEmailBox.sendKeys(getFaker().internet().emailAddress());
    }
    @Given("md Subject kutusuna bir konu girer")
    public void md_subject_kutusuna_bir_konu_girer() {
        page_07.adminMessageSubjectBox.sendKeys(getFaker().lorem().word());
    }
    @Given("md Messages kutusuna mesajini yazar")
    public void md_messages_kutusuna_mesajini_yazar() {
        page_07.adminMessageYazBox.sendKeys(getFaker().lorem().sentence(4));
    }
    @Given("md Save butonuna tiklar")
    public void md_save_butonuna_tiklar() {
        waitFor(2);
        page_07.messageSavedButton.click();


    }
    @Then("md Mesajin olusturuldugunu test eder")
    public void md_mesajin_olusturuldugunu_test_eder() {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(page_07.mesajCreatedText.getText().contains("A new Message is created with identifier"));


    // A new Message is created with identifier 383849

    }
    //...................///
    @Given("md Admin kendi olusturdugu mesajda edit butonunu tiklar")
    public void md_admin_kendi_olusturdugu_mesajda_edit_butonunu_tiklar() {

        String mesajCreatedText = page_07.mesajCreatedText.getText();    System.out.println("mesajCreatedText = " + mesajCreatedText);
        List<String> mesajCreatedSplitList = List.of(mesajCreatedText.split(" "));     System.out.println("mesajCreatedSplitList = " + mesajCreatedSplitList);
        // mesajCreatedSplitList = [A, new, Message, is, created, with, identifier, 388010]

        String mesajId = mesajCreatedSplitList.get(mesajCreatedSplitList.size()-1);     System.out.println("mesajId = " + mesajId);
        //388010

        //waitFor(10);
        page_07.mesajRefreshOk.click();
        ReusableMethods.waitFor(2);
        List<String> idNums = ReusableMethods.getElementsText(page_07.mesajIdListWE);    System.out.println("idNums = " + idNums);
        //@FindBy (xpath = "//tbody//tr//td[1]") public List<WebElement> mesajIdListWE;
        int mesajIndexNum = 0;
        for (String w:idNums) {
            if(w.equals(mesajId)) {
                mesajIndexNum = idNums.indexOf(w)+1;
                break;
            }
        }
        System.out.println("mesajIndexNum = " + mesajIndexNum);
        ReusableMethods.waitFor(3);
        WebElement editButton = Driver.getDriver().findElement(By.xpath("(//*[@class='btn btn-primary btn-sm'])["+mesajIndexNum+"]"));
        editButton.click();
    }
    @Given("md Mesaj kutusunda guncelleme yapar")
    public void md_mesaj_kutusunda_guncelleme_yapar() {

        ReusableMethods.waitFor(3);
        page_07.adminMessageYazBox.clear();
        ReusableMethods.waitFor(2);
        page_07.adminMessageYazBox.sendKeys("Mesaj update edildi");

    }
    @Then("md Mesajin update isleminin basariyla yapildigini test eder")
    public void md_mesajin_update_isleminin_basariyla_yapildigini_test_eder() {
        waitForVisibility(page_07.mesajUpdatedText,5);
        Assert.assertTrue(page_07.mesajUpdatedText.getText().contains("A Message is updated with identifier"));

    }

    @Then("md Admin kendi olusturdugu mesajda delete butonunu tiklar")
    public void md_admin_kendi_olusturdugu_mesajda_delete_butonunu_tiklar() {
        String mesajCreatedText = page_07.mesajCreatedText.getText();    System.out.println("mesajCreatedText = " + mesajCreatedText);
        List<String> mesajCreatedSplitList = List.of(mesajCreatedText.split(" "));     System.out.println("mesajCreatedSplitList = " + mesajCreatedSplitList);
        // mesajCreatedSplitList = [A, new, Message, is, created, with, identifier, 388010]

        String mesajId = mesajCreatedSplitList.get(mesajCreatedSplitList.size()-1);     System.out.println("mesajId = " + mesajId);
        //388010

        page_07.mesajRefreshOk.click();
        ReusableMethods.waitFor(2);
        List<String> idNums = ReusableMethods.getElementsText(page_07.mesajIdListWE);    System.out.println("idNums = " + idNums);
        //@FindBy (xpath = "//tbody//tr//td[1]") public List<WebElement> mesajIdListWE;
        int mesajIndexNum = 0;
        for (String w:idNums) {
            if(w.equals(mesajId)) {
                mesajIndexNum = idNums.indexOf(w)+1;
                break;
            }
        }
        System.out.println("mesajIndexNum = " + mesajIndexNum);
        ReusableMethods.waitFor(3);
        WebElement deleteButton = Driver.getDriver().findElement(By.xpath("(//a[@class='btn btn-danger btn-sm'])["+mesajIndexNum+"]"));
        deleteButton.click();

    }
    @Then("md Silme islemini onaylamak icin gelen Delete butonuna tiklar")
    public void md_silme_islemini_onaylamak_icin_gelen_delete_butonuna_tiklar() {
        waitFor(3);
        page_07.deleteButton2.click();
    }
    @Then("md Mesajin silindigini test eder")
    public void md_mesajin_silindigini_test_eder() {
        waitFor(3);
        Assert.assertTrue(page_07.mesajDeletedText.getText().contains("A Message is deleted with identifier"));

    }

}
