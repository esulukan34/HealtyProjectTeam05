package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.Page_09;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US017 {

    Page_09 page09 = new Page_09();
    JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
    Actions actions;

    @Given("AdminNevcan Medunna anasayfasinda")
    public void adminnevcanMedunnaAnasayfasinda() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @And("AdminNevcan sign in butonuna tiklar")
    public void adminnevcanSignInButonunaTiklar() {
        page09.accountMenu.click();
        page09.signin.click();
    }

    @Then("AdminNevcan gecerli bir username girer")
    public void adminnevcanGecerliBirUsernameGirer() {
        page09.username.sendKeys(ConfigReader.getProperty("AdminValidUsername"));
    }

    @And("AdminNevcan gecerli bir password girer")
    public void adminnevcanGecerliBirPasswordGirer() {
        page09.password.sendKeys(ConfigReader.getProperty("AdminValidPassword"));
    }

    @Then("AdminNevcan sign_in butonuna tiklar")
    public void adminnevcanSign_inButonunaTiklar() {

        page09.sign_in.click();
    }

   /*
    @And("AdminNevcan acilan sayfada Items&Titles butonuna tiklar")
    public void adminnevcanAcilanSayfadaItemsTitlesButonunaTiklar() {
        page09.itemsTitles.click();
    }
    */

    @And("AdminNevcan acilan sayfada ItemsTitles butonuna tiklar")
    public void adminnevcanAcilanSayfadaItemsTitlesButonunaTiklar() {
        page09.itemsTitles.click();
    }

    @Then("AdminNevcan Test Item butonuna tiklar")
    public void adminnevcanTestItemButonunaTiklar() {
        page09.testItem.click();
    }

    @And("AdminNevcan CreateANewTestItem butonuna tiklayabilir")
    public void adminnevcanCreateANewTestItemButonunaTiklayabilir() {
        page09.createANewTestItem.click();
    }

    @Then("AdminNevcan Name,Description,Price,DefaultMinValue,DefaultMaxValue,CreatedDate degerlerini girer")
    public void adminnevcanNameDescriptionPriceDefaultMinValueDefaultMaxValueCreatedDateDegerleriniGirer() {
        page09.nameBox.sendKeys(ConfigReader.getProperty("name"));
        page09.descriptionBox.sendKeys(ConfigReader.getProperty("description"));
        page09.priceBox.sendKeys(ConfigReader.getProperty("price"));
        page09.defaultMinValueBox.sendKeys(ConfigReader.getProperty("minValue"));
        page09.defaultMaxValueBox.sendKeys(ConfigReader.getProperty("maxValue"));


    }

    @And("AdminNevcan save butonuna tiklar")
    public void adminnevcanSaveButonunaTiklar() {
        ReusableMethods.jsScrollClick(page09.save);

    }

    @Then("AdminNevcan yeni test ogesini olusturdugunu dogrular")
    public void adminnevcanYeniTestOgesiniOlusturdugunuDogrular() throws IOException {
        ReusableMethods.waitForVisibility(page09.testItemCreated, 10);
        ReusableMethods.getScreenshot("Test item is created");
    }

    @And("AdminNevcan sayfayi kapatir")
    public void adminnevcanSayfayiKapatir() {
        Driver.closeDriver();

    }

    @And("AdminNevcan pageNinetyFive tiklar")
    public void adminnevcanPageNinetyFiveTiklar() {
        ReusableMethods.jsScrollClick(page09.pageNinetyFive);

    }

    @Then("AdminNevcan test ogesinin edit butonuna tiklar")
    public void adminnevcanTestOgesininEditButonunaTiklar() {
        ReusableMethods.jsScrollClick(page09.editTestItemButton);

    }

    @And("AdminNevcan Name,Description,Price,DefaultMinValue,DefaultMaxValue,CreatedDate tekrar deger girer")
    public void adminnevcanNameDescriptionPriceDefaultMinValueDefaultMaxValueCreatedDateTekrarDegerGirer() {
        page09.nameBox.clear();
        actions.click(page09.nameBox).sendKeys(ConfigReader.getProperty("nameEdited")).perform();
        page09.descriptionBox.clear();
        actions.click(page09.descriptionBox).sendKeys(ConfigReader.getProperty("descriptionEdited")).perform();
        page09.priceBox.clear();
        actions.click(page09.priceBox).sendKeys(ConfigReader.getProperty("priceEdited")).perform();
        page09.defaultMinValueBox.clear();
        actions.click(page09.defaultMinValueBox).sendKeys(ConfigReader.getProperty("minValueEdited")).perform();
        page09.defaultMaxValueBox.clear();
        actions.click(page09.defaultMaxValueBox).sendKeys(ConfigReader.getProperty("maxValueEdited")).perform();
    }

    @And("AdminNevcan test ogesini guncelledigini dogrular")
    public void adminnevcanTestOgesiniGuncellediginiDogrular() throws IOException {
        ReusableMethods.waitForVisibility(page09.testItemCanBeEdited, 5);
        ReusableMethods.getScreenshot("Test item can be updated");
    }

    @Then("AdminNevcan test ogesinin view butonuna tiklar")
    public void adminnevcanTestOgesininViewButonunaTiklar() {
        ReusableMethods.jsScrollClick(page09.viewTestItemButton);

    }

    @And("AdminNevcan test ogesinin goruntulendigini dogrular")
    public void adminnevcanTestOgesininGoruntulendiginiDogrular() throws IOException {
        page09.testItemCanBeSeen.isDisplayed();
        ReusableMethods.getScreenshot("Test item can be seen");
    }

    @Then("AdminNevcan test ogesinin delete butonuna tiklar")
    public void adminnevcanTestOgesininDeleteButonunaTiklar() {
        ReusableMethods.jsScrollClick(page09.deleteTestItemButton);
    }

    @And("AdminNevcan popup_delete butonuna tiklar")
    public void adminnevcanPopup_deleteButonunaTiklar() {
        ReusableMethods.jsclick(page09.confirmDeleteOperation);
    }

    @Then("AdminNevcan test ogesinin silindigini dogrular")
    public void adminnevcanTestOgesininSilindiginiDogrular() throws IOException {
        ReusableMethods.waitForVisibility(page09.testItemDeleted, 10);
        ReusableMethods.getScreenshot("Test item is deleted");
    }
}
