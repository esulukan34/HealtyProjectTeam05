package stepDefinitions.uiSteps;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Page_03;
import pojos.Country;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.country;

public class US028 {
    Page_03 medunnaPage=new Page_03();

    static String countryId;



    @And("K3 Admin acilir menuden Country secenegine tiklar")
    public void k3AdminAcilirMenudenCountrySecenegineTiklar() {
        medunnaPage.countrySelect.click();
    }

    @And("K3 Admin +Create a new Country butonuna tiklar")
    public void kAdminCreateANewCountryButonunaTiklar() {
        medunnaPage.createNewCountryButon.click();
    }

    @And("K3 Admin Country Name kutusuna yeni {string} adini girer")
    public void kAdminCountryNameKutusunaYeniUlkeAdiniGirer(String countryName) {
        ReusableMethods.waitForVisibility(medunnaPage.countryNameTextbox,5);
        medunnaPage.countryNameTextbox.sendKeys(ConfigReader.getProperty(countryName));
        country=new Country();
        country.setName(ConfigReader.getProperty(countryName));
    }

    @Then("K3 Admin yeni ulke olusturuldugunu dogrular")
    public void kAdminYeniUlkeOlusturuldugunuDogrular() {
        ReusableMethods.waitForVisibility(medunnaPage.createdCountryMessage,10);
        assertTrue(medunnaPage.createdCountryMessage.isDisplayed());
        String text=medunnaPage.createdCountryMessage.getText();
        countryId=text.substring(text.length()-6);
        System.out.println("countryId 1= " + countryId);
        country.setId(Integer.parseInt(countryId));

    }

    @And("K3 Admin acilir menuden State-City secenegine tiklar")
    public void k3AdminAcilirMenudenStateCitySecenegineTiklar() {
        medunnaPage.stateCitySelect.click();
    }

    @And("K3 Admin +Create a new State-City butonuna tiklar")
    public void k3AdminCreateANewStateCityButonunaTiklar() {
        ReusableMethods.waitForVisibility(medunnaPage.createdNewStateCityButon,5);
        medunnaPage.createdNewStateCityButon.click();
    }

    @And("K3 Admin Name kutusuna {string} adini girer")
    public void k3AdminNameKutusunaStateCityAdiniGirer(String cityName) {
        ReusableMethods.waitForVisibility(medunnaPage.stateCityNameTextBox,5);
        medunnaPage.stateCityNameTextBox.sendKeys(ConfigReader.getProperty(cityName));
    }

    @And("K3 Admin State-City menusunden {string} secer")
    public void k3AdminStateCityMenusundenSecer(String ulke) {

        medunnaPage.countryDDM.click();
        medunnaPage.countryDDM.sendKeys(ConfigReader.getProperty(ulke));

    }

    @Then("K3 Admin ulkeye ait eyalet-sehir olusturdugunu dogrular")
    public void k3AdminUlkeyeAitEyaletSehirOlusturdugunuDogrular() {
        ReusableMethods.waitForVisibility(medunnaPage.notCreatedCityMessage,5);
        assertFalse("State-City olusturulamadi",medunnaPage.notCreatedCityMessage.isDisplayed());
        System.out.println("medunnaPage.notCreatedCityMessage.getText() = " + medunnaPage.notCreatedCityMessage.getText());
    }


    @And("K3 Admin silinecek {string} gider ve delete butonuna tiklar")
    public void k3AdminSilinecekUlkeyeGiderVeDeleteButonunaTiklar(String ulke) {
        //*[text()='383068']

        System.out.println("countryId 2= " + countryId);
        WebElement countryIdWE= Driver.getDriver().findElement(By.xpath("//*[text()='"+countryId+"']"));
        ReusableMethods.jsScroll(countryIdWE);

        //ReusableMethods.waitFor(10);

        List<WebElement> countryIdSutunu=medunnaPage.countryIdSutunu;
        List<WebElement> countryNameSutunu=medunnaPage.countryNameSutunu;
        List<WebElement> deleteCountrySutunu=medunnaPage.deleteCountrySutunu;



        //ReusableMethods.waitForVisibility(countryIdSutunu.get(0),5);
        //ReusableMethods.getActions()
        //        .keyDown(Keys.CONTROL)
        //        .sendKeys(Keys.PAGE_DOWN)
        //        .keyUp(Keys.CONTROL)
        //        .perform();
        for (int i = countryIdSutunu.size()-1; i > 0 ; i--) {
            if (countryIdSutunu.get(i).getText().equals(countryId)){
                //countryId=countryIdSutunu.get(i).getText();
                ReusableMethods.jsScrollClick(deleteCountrySutunu.get(i));
                break;
            }
        }
    }

    @And("K3 Admin country icin Pop-Up'ta cikan Delete butonuna tiklar")
    public void k3AdminCountryIcinPopUpTaCikanDeleteButonunaTiklar() {
        ReusableMethods.waitForVisibility(medunnaPage.popUpCountryText,5);
        if (medunnaPage.popUpCountryText.getText().contains(countryId)) {
            medunnaPage.popUpCountryDeleteButon.click();
        }
    }

    @Then("K3 Admin ulkeyi sildiginin dogrular")
    public void k3AdminUlkeyiSildigininDogrular() {
        ReusableMethods.waitForVisibility(medunnaPage.deletedCountryMessage,5);
        assertTrue(medunnaPage.deletedCountryMessage.isDisplayed());
    }
}
