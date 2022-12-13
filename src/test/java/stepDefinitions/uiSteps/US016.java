package stepDefinitions.uiSteps;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.Page_03;
import pojos.Room;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import java.util.List;

import static org.junit.Assert.*;
import static utilities.DatabaseUtility.room;

public class US016 {
    Page_03 medunnaPage=new Page_03();
    String roomId;


    @When("K3 Admin Sign in sekmesine tiklar")
    public void k3AdminSignInSekmesineTiklar() {
        medunnaPage.registerSignInIkon.click();
        medunnaPage.signInButon.click();
    }

    @And("K3 Admin Username kutusuna gecerli bir {string} girer")
    public void k3AdminUsernameKutusunaGecerliBirGirer(String username) {
        medunnaPage.usernameTextBox.sendKeys(ConfigReader.getProperty(username));

    }

    @And("K3 Admin Password kutusuna gecerli bir {string} girer")
    public void k3AdminPasswordKutusunaGecerliBirGirer(String password) {
        medunnaPage.passwordTextBox.sendKeys(ConfigReader.getProperty(password));
    }

    @And("K3 Admin Sign in butonuna tiklar")
    public void k3AdminSignInButonunaTiklar() {
        medunnaPage.signInSubmit.click();
    }

    @And("K3 Admin Items&Titles acilir menusune tiklar")
    public void k3AdminItemsTitlesAcilirMenusuneTiklar() {
        medunnaPage.itemsTitlesDDM.click();
    }

    @And("K3 Admin acilir menuden Room secenegine tiklar")
    public void k3AdminAcilirMenudenRoomSecenegineTiklar() {
        medunnaPage.roomSelect.click();
    }

    @And("K3 Admin Create a new Room butonuna tiklar")
    public void k3AdminCreateANewRoomButonunaTiklar() {
        medunnaPage.createRoomButon.click();
    }

    @And("K3 Admin Room Number kutusuna unique bir {string} girer")
    public void k3AdminRoomNumberKutusunaUniqueBirGirer(String roomNumber) {
        room=new Room();

        if (roomNumber.equals("")) {
            ReusableMethods.waitForVisibility(medunnaPage.roomNumberTextBox,5);
            medunnaPage.roomNumberTextBox.click();

        }else {
            ReusableMethods.waitForVisibility(medunnaPage.roomNumberTextBox,5);
            medunnaPage.roomNumberTextBox.clear();
            medunnaPage.roomNumberTextBox.sendKeys(roomNumber);
            room.setRoomNumber(Integer.parseInt(roomNumber));
        }

    }

    @And("K3 Admin Room Type secenegini {string} secer")
    public void k3AdminRoomTypeSeceneginiSecer(String roomType) {
        ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys(roomType).perform();
        room.setRoomType(roomType);
    }

    @And("K3 Admin {string} belirtir")
    public void k3AdminStatusBelirtir(String status) {
        if (status.equals("true")){
            ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
            room.setStatus(Boolean.parseBoolean(status));
        }else  {
            ReusableMethods.getActions().sendKeys(Keys.TAB).perform();
            room.setStatus(Boolean.parseBoolean(status));
        }
    }

    @And("K3 Admin Price kutusuna {string} girer")
    public void k3AdminPriceKutusunaGirer(String price) {
        if(price.equals("")){
            ReusableMethods.getActions().sendKeys(Keys.TAB).perform();
        }else {
            ReusableMethods.getActions().sendKeys(Keys.TAB).sendKeys(price).perform();
            room.setPrice(Integer.parseInt(price));
        }
    }

    @And("K3 Admin Description kutusuna {string} girer")
    public void k3AdminDescriptionKutusunaGirer(String odaBilgileri) {
        ReusableMethods.getActions()
                .sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty(odaBilgileri)).perform();
        room.setDescription(ConfigReader.getProperty(odaBilgileri));
    }

    @And("K3 Admin Created Date kutusuna {string} girer")
    public void k3AdminCreatedDateKutusunaGirer(String tarih) {
        switch (tarih) {
            case "guncelTarih":
                ReusableMethods.getActions()
                        .sendKeys(Keys.TAB)
                        .sendKeys(ReusableMethods.Tarih())
                        .sendKeys(Keys.RIGHT).sendKeys(ReusableMethods.saat()).perform();
                break;
            case "ileriTarih":
                ReusableMethods.getActions()
                        .sendKeys(Keys.TAB)
                        .sendKeys(ReusableMethods.ileriTarih())
                        .sendKeys(Keys.RIGHT).sendKeys(ReusableMethods.saat()).perform();
                break;
            case "gecmisTarih":
                ReusableMethods.getActions()
                        .sendKeys(Keys.TAB)
                        .sendKeys(ReusableMethods.gecmisTarih())
                        .sendKeys(Keys.RIGHT).sendKeys(ReusableMethods.saat()).perform();
                break;
            default:
                ReusableMethods.getActions()
                        .sendKeys(Keys.TAB)
                        .sendKeys(tarih)
                        .sendKeys(Keys.RIGHT).sendKeys(ReusableMethods.saat()).perform();
                break;
        }
    }

    @And("K3 Admin Save butonuna tiklar")
    public void k3AdminSaveButonunaTiklar() {
        ReusableMethods.jsScrollClick(medunnaPage.saveButon);
    }

    @Then("K3 Admin {string} yapar")
    public void k3AdminYeniOdaOlusturuldugunuDogrular(String verify) {
        switch (verify) {
            case "yeniKayit":
                ReusableMethods.waitForVisibility(medunnaPage.roomCreatedMessage, 5);
                assertTrue("yeni oda olusturulamadi", medunnaPage.roomCreatedMessage.isDisplayed());
                String text = medunnaPage.roomCreatedMessage.getText();
                text = text.substring(text.length() - 6);
                int roomId2 = Integer.parseInt(text);
                System.out.println("roomId2 = " + roomId2);
                room.setId(roomId2);
                System.out.println("room.getId() = " + room.getId());
                System.out.println("room.toString() = " + room.toString());
                break;
            case "guncelleme":
                ReusableMethods.waitForVisibility(medunnaPage.roomUpdateMessage, 5);
                assertTrue("oda guncellemesi yapilamadi", medunnaPage.roomUpdateMessage.isDisplayed());
                break;
            case "silme":
                ReusableMethods.waitForVisibility(medunnaPage.deletedRoomMessage, 5);
                assertTrue("oda silme yapilamadi", medunnaPage.deletedRoomMessage.isDisplayed());
                break;
        }
    }

    @And("K3 Admin Price kutusunu bos birakir")
    public void k3AdminPriceKutusunuBosBirakir() {
        ReusableMethods.getActions().sendKeys(Keys.TAB).perform();
    }

    @Then("K3 Admin yeni oda olusturulmadigini {string}")
    public void k3AdminYeniOdaOlusturulmadiginiDogrular(String verify) {
        switch (verify) {
            case "price":
            case "room number":
                ReusableMethods.waitForVisibility(medunnaPage.saveButon, 3);
                assertTrue("Oda olusturuldu", medunnaPage.saveButon.isDisplayed());
                break;
            case "tarih":
                ReusableMethods.waitForVisibility(medunnaPage.roomCreatedMessage, 5);
                assertFalse("Oda olusturuldu", medunnaPage.roomCreatedMessage.isDisplayed());
                break;
            case "ayni oda":
                ReusableMethods.waitForVisibility(medunnaPage.notUniqueRoomMessage, 5);
                assertTrue(medunnaPage.notUniqueRoomMessage.isDisplayed());
                break;
        }
    }


    @And("K3 Admin Room Type basligina tiklar")
    public void k3AdminRoomTypeBasliginaTiklar() {
        ReusableMethods.jsScrollClick(medunnaPage.roomTypeBaslik);
    }

    @Then("K3 Admin {string} oda tiplerini gorur")
    public void k3AdminOdaTipleriniGorur(String roomType) {
        ReusableMethods.waitFor(2);
        List<WebElement> roomtypeSutunu= medunnaPage.roomTypeSutun;
        for (WebElement each:roomtypeSutunu) {
            assertEquals(roomType,each.getText());
        }
    }

    @And("K3 Admin guncelleme yapilacak {string} gider")
    public void k3AdminGuncellemeYapilacakGider(String roomNumber) {
        medunnaPage.createdDateBasligi.click();
        ReusableMethods.waitFor(2);
        List<WebElement>roomNumberSutun= medunnaPage.roomNumberSutun;
        List<WebElement>idSutun= medunnaPage.idSutun;

        for (int i = 0; i <roomNumberSutun.size() ; i++) {
            if (roomNumberSutun.get(i).getText().equals(roomNumber)){
                idSutun.get(i).click();
                break;
            }
        }
    }

    @And("K3 Admin Edit butonuna tiklar")
    public void k3AdminEditButonunaTiklar() {

        ReusableMethods.waitFor(3);
        medunnaPage.roomEditButon.click();
    }
    @And("K3 Admin silinecek {string} gider ve Delete butonuna tiklar")
    public void k3AdminSilinecekOdayaGiderVeDeleteButonunaTiklar(String roomNumber) {
        medunnaPage.createdDateBasligi.click();
        ReusableMethods.waitFor(2);
        List<WebElement>roomNumberSutun= medunnaPage.roomNumberSutun;
        List<WebElement>idSutun= medunnaPage.idSutun;
        List<WebElement>deleteSutun= medunnaPage.deleteRoomSutun;

        for (int i = 0; i <roomNumberSutun.size() ; i++) {
            if (roomNumberSutun.get(i).getText().equals(roomNumber)){
                deleteSutun.get(i).click();
                roomId= idSutun.get(i).getText();
                break;
            }
        }
    }

    @And("K3 Admin Pop-Up'ta cikan Delete butonuna tiklar")
    public void k3AdminPopuptaCikanDeleteButonunaTiklar() {
        ReusableMethods.waitForVisibility(medunnaPage.popUpRoomText,3);
        if (medunnaPage.popUpRoomText.getText().contains(roomId)){
            medunnaPage.popUpDeleteButon.click();
        }
    }
}
