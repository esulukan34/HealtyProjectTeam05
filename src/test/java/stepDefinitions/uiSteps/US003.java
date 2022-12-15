package stepDefinitions.uiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.Page_10;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;
import java.util.List;

public class US003 {

    Page_10 page10 = new Page_10();

    @Given("{string} sayfasina gider")
    public void sayfasinaGider(String arg0) {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        ReusableMethods.waitFor(2);
    }

    @Then("Sign Dropdown butonuna basar")
    public void signDropdownButonunaBasar() {
        page10.signDropDown.click();
        ReusableMethods.waitFor(1);
    }

    @And("Register butonuna basar ve sayfasina  gider")
    public void registerButonunaBasarVeSayfasinaGider() {
        ReusableMethods.waitForVisibility(page10.registerButton, 3);
        page10.registerButton.click();

    }

    @Then("New Password kismina tiklar")
    public void newPasswordKisminaTiklar() {
        ReusableMethods.waitForVisibility(page10.newPassword, 3);
        ReusableMethods.jsScrollClick(page10.newPassword);
        //Actions actions =new Actions(Driver.getDriver());
        //actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);


    }


    @And("Guclu sifre icin en az bir kucuk harf icermeli")
    public void gucluSifreIcinEnAzBirKucukHarfIcermeli() {
        String actualPassword = ConfigReader.getProperty("password.kucukharfolmayan");
        page10.newPassword.sendKeys(actualPassword);
        ReusableMethods.waitFor(3);
        //List<WebElement> passwordisikleri = Driver.getDriver().findElements(By.xpath("//li[@style='background-color: rgb(0, 255, 0);']"));
        //System.out.println("Password isiklari adedi ="+passwordisikleri.size());
        Assert.assertNotEquals(5, page10.strenthisiklari.size());
    }

    @Then("Ve Password Strength degisimi dogrulanir.")
    public void vePasswordStrengthDegisimiDogrulanir() {
        String expectedPassword = ConfigReader.getProperty("password.+kucukharf");
        page10.newPassword.sendKeys(expectedPassword);
        ReusableMethods.waitFor(2);
        //List<WebElement> passwordisikleri = Driver.getDriver().findElements(By.xpath("//li[@style='background-color: rgb(0, 255, 0);']"));
        //Assert.assertEquals(5,passwordisikleri.size());
        Assert.assertEquals(5, page10.strenthisiklari.size());

    }
    @And("Sayfayi kapatir.")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }

    @And("Guclu sifre icin en az bir Buyuk harf icermeli")
    public void gucluSifreIcinEnAzBirBuyukHarfIcermeli() {
        String actualPassword = ConfigReader.getProperty("password.buyukharfolmayan");
        page10.newPassword.sendKeys(actualPassword);
        ReusableMethods.waitFor(3);
        Assert.assertNotEquals(5, page10.strenthisiklari.size());
    }

    @Then("Ve Buyuk harf icin Password Strength degisimi dogrulanir.")
    public void veBuyukHarfIcinPasswordStrengthDegisimiDogrulanir() {
        String expectedPassword = ConfigReader.getProperty("password.+buyukharf");
        page10.newPassword.sendKeys(expectedPassword);
        ReusableMethods.waitFor(2);
        Assert.assertEquals(5, page10.strenthisiklari.size());
    }

    @And("Guclu sifre icin en az bir rakam icermeli")
    public void gucluSifreIcinEnAzBirRakamIcermeli() {
        String actualPassword = ConfigReader.getProperty("password.rakamolmayan");
        page10.newPassword.sendKeys(actualPassword);
        ReusableMethods.waitFor(3);
        Assert.assertNotEquals(5, page10.strenthisiklari.size());
    }

    @Then("Ve Rakam icin Password Strength degisimi dogrulanir.")
    public void veRakamIcinPasswordStrengthDegisimiDogrulanir() {
        String expectedPassword = ConfigReader.getProperty("password.+rakam");
        page10.newPassword.sendKeys(expectedPassword);
        ReusableMethods.waitFor(2);
        Assert.assertEquals(5, page10.strenthisiklari.size());
    }

    @And("Guclu sifre icin en az bir ozel karakter icermeli")
    public void gucluSifreIcinEnAzBirOzelKarakterIcermeli() {
        String actualPassword = ConfigReader.getProperty("password.ozelkarakterolmayan");
        page10.newPassword.sendKeys(actualPassword);
        ReusableMethods.waitFor(3);
        Assert.assertNotEquals(5, page10.strenthisiklari.size());
    }

    @Then("Ve Ozel karakter icin Password Strength degisimi dogrulanir.")
    public void veOzelKarakterIcinPasswordStrengthDegisimiDogrulanir() {
        String expectedPassword = ConfigReader.getProperty("password.+ozelkarakter");
        page10.newPassword.sendKeys(expectedPassword);
        ReusableMethods.waitFor(2);
        Assert.assertEquals(5, page10.strenthisiklari.size());
    }

    @And("Guclu sifre icin en az yedi karakter icermeli")
    public void gucluSifreIcinEnAzYediKarakterIcermeli() {
        String actualPassword = ConfigReader.getProperty("password.7karakterdenaz");
        page10.newPassword.sendKeys(actualPassword);
        ReusableMethods.waitFor(3);
        Assert.assertNotEquals(5, page10.strenthisiklari.size());

    }

    @Then("Ve En az karakter olmasi icin Password Strength degisimi dogrulanir.")
    public void veEnAzKarakterOlmasiIcinPasswordStrengthDegisimiDogrulanir() {
        String expectedPassword = ConfigReader.getProperty("password.7karakter+");
        page10.newPassword.sendKeys(expectedPassword);
        ReusableMethods.waitFor(2);
        Assert.assertEquals(5, page10.strenthisiklari.size());
    }
}
