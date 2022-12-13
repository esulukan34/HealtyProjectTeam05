package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import pages.Page_05;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class US008 {
    Page_05 page = new Page_05();

    String sifre;
    String eskiSifre;
    String bos;
    String filePath;
    FileInputStream fis;
    Workbook workbook;
    FileOutputStream fos;
    Row row;
    Cell cell;
    Sheet sheet;

    @Given("K5 kullanici {string} url'e gider")
    public void K5kullaniciUrlEGider(String url) {

        Driver.getDriver().get(ConfigReader.getProperty(url));
    }

    @When("K5 kullanici login olur")
    public void K5kullaniciLoginOlur() {

        page.accountMenu.click();
        page.signIn.click();
        page.usernameBox.sendKeys(ConfigReader.getProperty("userUsername"));
        page.passwordBox.sendKeys(ConfigReader.getProperty("userPassword"));
        page.signInButton.click();


    }

    @Then("K5 kullanici account menuden password link tiklar")
    public void K5kullaniciAccountMenudenPasswordLinkTiklar() {

        page.accountMenu.click();
        page.passwordLink.click();
    }

    @And("K5 kullanici current password girer")
    public void K5kullaniciCurrentPasswordGirer() {

        ReusableMethods.waitFor(2);
        page.currentPasswordBox.sendKeys(ConfigReader.getProperty("userPassword"));
    }

    @And("K5 kullanici new password girer")
    public void K5kullaniciNewPasswordGirer() {
        ReusableMethods.waitFor(2);
        page.newPasswordBox.sendKeys(ConfigReader.getProperty("userPassword"));
    }

    @And("K5 kullanici new password confirmation girer")
    public void K5kullaniciNewPasswordConfirmationGirer() {
        ReusableMethods.waitFor(2);
        page.confirmPasswordBox.sendKeys(ConfigReader.getProperty("userPassword"));
    }

    @And("K5 kullanici {string} mesajinin gorunur olmadigini dogrular")
    public void K5kullaniciMesajininGorunurOlmadiginiDogrular(String message) throws IOException {


        try {
            assertFalse(page.notMatchTextMessage.isDisplayed());
        } catch (Exception e) {
            ReusableMethods.waitFor(2);
            ReusableMethods.getScreenshotWebElement("SSpasword", page.passwordScreen);
        }

    }

    @And("K5 sayfayi kapatir")
    public void K5sayfayiKapatir() {

        Driver.closeDriver();
    }

    @And("K5 kullanici Password strenght seviyesinin limegreen oldugunu dogrular")
    public void kullaniciPasswordStrenghtSeviyesininLimegreenOldugunuDogrular() throws IOException {

        assertEquals(4, page.limeGreenStrength.size());
        ReusableMethods.getScreenshotWebElement("limegreenSS", page.strengthBar);
    }

    @And("K5 kullanici Password strength seviyesinin green oldugunu dogrular")
    public void kullaniciPasswordStrengthSeviyesininGreenOldugunuDogrular() throws IOException {

        assertEquals(5, page.greenStrength.size());
        ReusableMethods.getScreenshotWebElement("SSgreen", page.strengthBar);
    }

    @And("K5 kullanici kucuk harf,buyuk harf,rakam ve ozel karakter sartlarindan herhangi ucu ile{string} girer")
    public void K5kullaniciKucukHarfBuyukHarfRakamVeOzelKarakterSartlarindanHerhangiUcuIleGirer(String password) {

        page.newPasswordBox.sendKeys(password);
    }

    @And("K5 kullanici {string} girmedigi sifre sartini ekler")
    public void K5kullaniciGirmedigiSifreSartiniEkler(String karakter) {

        page.newPasswordBox.sendKeys(karakter);
    }


    @And("K5 kullanici {int} saniye bekler")
    public void K5kullaniciSaniyeBekler(int sn) {

        ReusableMethods.waitFor(sn);
    }

    @And("K5 kullanici kucuk harf,buyuk harf,rakam ve ozel karakter ile en az yedi karakterli new password girer")
    public void K5kullaniciKucukHarfBuyukHarfRakamVeOzelKarakterIleEnAzYediKarakterliNewPasswordGirer() {

        page.newPasswordBox.sendKeys("javA011!!");
    }

    @And("K5 kullanici save butonuna tiklar")
    public void K5kullaniciSaveButonunaTiklar() {


        page.saveButton.click();
    }

    @And("K5 kullanici Password changed! uyarisinin gorunur olmadigini dogrular")
    public void K5kullaniciPasswordChangedUyarisininGorunurOlmadiginiDogrular() {

        try {

            ReusableMethods.waitForVisibility(page.passwordChangedMessage, 15);
            assertTrue(page.passwordChangedMessage.isDisplayed());
            ReusableMethods.getScreenshot("eskisifrekullanildi");

        } catch (Exception e) {

            System.out.println("Eski sifre kullanilabildi");
            try {
                ReusableMethods.getScreenshot("EskiSifreKullanildi");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    @And("K5 kullanici new password box'a sifre girer")
    public void K5kullaniciNewPasswordBoxASifreGirer() {

        page.newPasswordBox.sendKeys("qwwertA!w");
    }

    @And("K5 kullanici new password confirmation box'a new passworddan farkli sifre girer")
    public void K5kullaniciNewPasswordConfirmationBoxANewPassworddanFarkliSifreGirer() {

        page.confirmPasswordBox.sendKeys("qwrwett!A");
        page.saveButton.click();
    }

    @And("K5 kullanici {string} mesajinin gorunur oldugunu dogrular")
    public void K5kullaniciMesajininGorunurOldugunuDogrular(String message) throws IOException {

        assertTrue(page.notMatchTextMessage.isDisplayed());
        ReusableMethods.getScreenshotWebElement("dontMatch", page.notMatchTextMessage);
    }

    @And("K5 kullanici kucuk harf,buyuk harf,rakam ve ozel karakter ile en fazla alti karakterli new password girer")
    public void K5kullaniciKucukHarfBuyukHarfRakamVeOzelKarakterIleEnFazlaAltiKarakterliNewPasswordGirer() {

        page.newPasswordBox.sendKeys("A23!aa");
    }

    @And("K5 kullanici Password strength seviyesinin red oldugunu dogrular")
    public void K5kullaniciPasswordStrengthSeviyesininRedOldugunuDogrular() throws IOException {

        assertEquals(1, page.redStrength.size());
        ReusableMethods.getScreenshotWebElement("redStrength", page.strengthBar);
    }


    @And("K5 Kullanici {string} boxa en az yedi karakter girerek strenght bar'in farkli durumlarini test eder.")
    public void K5kullaniciBoxaEnAzYediKarakterGirerekStrenghtBarInFarkliDurumlariniTestEder(String password) throws IOException {

        page.newPasswordBox.sendKeys(password);
        ReusableMethods.getScreenshotWebElement(password, page.strength);
    }


    @When("K5 kullanici login olup account menuden password linke tiklar")
    public void K5kullaniciLoginOlupAccountMenudenPasswordLinkeTiklar() throws IOException {


        filePath = "src/resources/excelTest.xlsx";
        fis = new FileInputStream(filePath);
        workbook = WorkbookFactory.create(fis);


        sifre = workbook.getSheet("Sayfa1").getRow(0).getCell(0).toString();
        eskiSifre = workbook.getSheet("Sayfa1").getRow(1).getCell(0).toString();
        bos = "";


        page.accountMenu.click();
        ReusableMethods.waitFor(2);
        page.signIn.click();
        ReusableMethods.waitFor(2);
        page.usernameBox.sendKeys(ConfigReader.getProperty("excelUsername2"));
        ReusableMethods.waitFor(2);
        page.passwordBox.sendKeys(sifre);
        ReusableMethods.waitFor(2);
        page.signInButton.click();
        page.accountMenu.click();
        ReusableMethods.waitFor(2);
        page.passwordLink.click();
        ReusableMethods.waitFor(2);
    }

    @Then("K5 kullanici current passwordu girer ve new password ve confirm password'e eski sifreyi girer")
    public void K5kullaniciCurrentPassworduGirerVeNewPasswordVeConfirmPasswordEEskiSifreyiGirer() throws IOException {

        filePath = "src/resources/excelTest.xlsx";

        page.currentPasswordBox.sendKeys(sifre);
        ReusableMethods.waitFor(2);
        page.newPasswordBox.sendKeys(eskiSifre);
        ReusableMethods.waitFor(2);
        page.confirmPasswordBox.sendKeys(eskiSifre);
        ReusableMethods.waitFor(2);

        bos = sifre;
        sifre = eskiSifre;
        eskiSifre = bos;

        System.out.println("sifre = " + sifre);
        System.out.println("eskiSifre = " + eskiSifre);

        sheet = workbook.getSheet("Sayfa1");
        row = sheet.getRow(0);
        cell = row.getCell(0);
        row.removeCell(cell);
        fos = new FileOutputStream(filePath);
        workbook.write(fos);

        sheet = workbook.getSheet("Sayfa1");
        row = sheet.getRow(1);
        cell = row.getCell(0);
        fos = new FileOutputStream(filePath);
        row.removeCell(cell);
        workbook.write(fos);

        workbook.getSheet("Sayfa1").getRow(0).createCell(0).setCellValue(sifre);
        workbook.getSheet("Sayfa1").getRow(1).createCell(0).setCellValue(eskiSifre);
        fos = new FileOutputStream(filePath);
        workbook.write(fos);

        fos.close();
        fis.close();
        workbook.close();
    }

}
