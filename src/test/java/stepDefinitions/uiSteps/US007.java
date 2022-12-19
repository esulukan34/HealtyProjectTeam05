package stepDefinitions.uiSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.Page_06;
import utilities.Driver;
import utilities.ReusableMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class US007 {
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Page_06 page = new Page_06();
    String expected_firstname = "Zehra";
    String expected_lastname = "Şen";
    String expected_mail = "zehrasen1947@gmail.com";
    Faker faker = new Faker();
    String faker_firstname = faker.name().firstName();
    String faker_lastname = faker.name().lastName();
    String faker_mail = faker.internet().emailAddress();
    int randevu_sayisi_2;
    int randevu_sayisi_1;

    public static String tarih_Uret(int gun) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, gun);
        String date = sdf.format(calendar.getTime());
        return date;
    }

    @Given("K6 medunna.com adresine gider")
    public void medunna_com_adresine_gider() {
        Driver.getDriver().get("https://medunna.com/");
    }

    @Then("K6 Kullanici Signin olmak icin Signin iconuna tiklar")
    public void kullanici_signin_olmak_icin_signin_iconuna_tiklar() {
        jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid black;');", page.ana_user_Link);
        ReusableMethods.waitFor(1);
        page.ana_user_Link.click();
        ReusableMethods.waitFor(2);
        jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid black;');", page.signin_text);
        page.signin_text.click();
    }

    @Then("K6 Acilan menude hasta kaydi sirasinda secilen username girilir")
    public void acilan_menude_hasta_kaydi_sirasinda_secilen_username_girilir() {
        jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid black;');", page.username_textbox);
        ReusableMethods.waitFor(1);
        page.username_textbox.sendKeys("zehrasen");
        ReusableMethods.waitFor(1);
    }

    @Then("K6 Hasta kaydi sirasinda secilen pasword girilir.")
    public void hasta_kaydi_sirasinda_secilen_pasword_girilir() {
        jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid black;');", page.password_textbox);
        ReusableMethods.waitFor(1);
        page.password_textbox.sendKeys("zehrasen1947");
        ReusableMethods.waitFor(1);
    }

    @Then("K6 Signin butonuna tiklanir")
    public void signin_butonuna_tiklanir() {
        jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid black;');", page.signin_button);
        ReusableMethods.waitFor(1);
        page.signin_button.click();
    }

    @Then("K6 Kullanici olarak sayfaya girdigini dogrular")
    public void kullanici_olarak_sayfaya_girdigini_dogrular() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(page.administiration_menu.isDisplayed());
        Driver.getDriver().navigate().refresh();
    }

    @Then("K6 Kullanici adina tiklar, acilan menuden Settings tiklar")
    public void kullanici_adina_tiklar_acilan_menuden_settings_tiklar() {
        jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid black;');", page.user_icon);
        ReusableMethods.waitFor(1);
        page.user_icon.click();

        jse.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 3px solid black;');", page.settings);
        ReusableMethods.waitFor(1);
        page.settings.click();
    }

    @Then("K6 Firstname kutusundaki ismin, kayit sirasinda secilen isim ile ayni oldugu dogrulanir")
    public void firstname_kutusundaki_ismin_kayit_sirasinda_secilen_isim_ile_ayni_oldugu_dogrulanir() {
        String actaul_firstname = page.first_name.getAttribute("value");
        Assert.assertEquals(expected_firstname, actaul_firstname);
    }

    @Then("K6 Lastname kutusundaki soyismin, kayit sirasinda secilen soyisim ile ayni oldugu dogrulanir")
    public void lastname_kutusundaki_soyismin_kayit_sirasinda_secilen_soyisim_ile_ayni_oldugu_dogrulanir() {
        String actaul_lastname = page.last_name.getAttribute("value");
        Assert.assertEquals(expected_lastname, actaul_lastname);
    }

    @And("K6 Email kutusundaki mailin, kayit sirasinda secilen mail ile ayni oldugu dogrulanir")
    public void email_kutusundaki_mailin_kayit_sirasinda_secilen_mail_ile_ayni_oldugu_dogrulanir() {
        String actaul_email = page.email.getAttribute("value");
        Assert.assertEquals(expected_mail, actaul_email);
    }

    @Given("K6 Firstname kutusundaki ismi siler ve yerine herhangi bir isim girer")
    public void firstnameKutusundakiIsmiSilerVeYerineAyseBilgisiniGirer() {
        page.first_name.clear();
        ReusableMethods.waitFor(1);
        page.first_name.sendKeys(faker_firstname);
        ReusableMethods.waitFor(1);
    }

    @Then("K6 Kayit butonuna tiklar")
    public void kayitButonunaTiklar() {
        page.save_button.click();
    }


    @Then("K6 Firstname kutusundaki ismin rastgele girilen isim oldugunu dogrular")
    public void firstnameKutusundakiIsminRastgeleAtananIsimOldugunuDogrular() {
        String actaul_firstname = page.first_name.getAttribute("value");
        System.out.println("actaul_firstname = " + actaul_firstname);
        Assert.assertEquals(faker_firstname, actaul_firstname);
    }

    @Then("K6 Test sonrasi islemlerin dogru olmasi icin Firstname kismina yeniden Zehra girer")
    public void testSonrasiIslemlerinDogruOlmasiIcinFirstnameKisminaYenidenZehraGirer() {
        page.first_name.clear();
        ReusableMethods.waitFor(1);
        page.first_name.sendKeys("Zehra");
        ReusableMethods.waitFor(1);
    }

    @Given("K6 Lastname kutusundaki soyismi siler ve yerine herhangi bir soyisim girer")
    public void lastnameKutusundakiIsmiSilerVeYerineYilmazBilgisiniGirer() {
        page.last_name.clear();
        ReusableMethods.waitFor(1);
        page.last_name.sendKeys(faker_lastname);
        ReusableMethods.waitFor(1);
    }

    @Then("K6 Lastname kutusundaki soyismin rastgele girilen soyisim oldugunu dogrular")
    public void lastnameKutusundakiSoyisminRastgeleGirilenSoyisimOldugunuDogrular() {
        String actaul_lastname = page.last_name.getAttribute("value");
        Assert.assertEquals(faker_lastname, actaul_lastname);
    }

    @Then("K6 Test sonrasi islemlerin dogru olmasi icin Lastname kismina yeniden Sen girer")
    public void testSonrasiIslemlerinDogruOlmasiIcinLastnameKisminaYenidenSenGirer() {
        page.last_name.clear();
        ReusableMethods.waitFor(1);
        page.last_name.sendKeys("Şen");
        ReusableMethods.waitFor(1);
    }

    @Then("K6 sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.quitDriver();
    }


    @Then("K6 Sayfayi yeniler")
    public void sayfayiYeniler() {
        Driver.getDriver().navigate().refresh();
    }

    @Then("K6 email kutusundaki bilgiyi siler ve yerine rastgele bir email girer")
    public void emailKutusundakiBilgiyiSilerVeYerineRastgeleBirEmailGirer() {
        page.email.clear();
        ReusableMethods.waitFor(1);
        page.email.sendKeys(faker_mail);
        ReusableMethods.waitFor(1);
    }

    @Then("K6 email kutusundaki mailin rastgele girilen mail oldugunu dogrular")
    public void emailKutusundakiMailinRastgeleGirilenMailOldugunuDogrular() {
        String actaul_email = page.email.getAttribute("value");
        Assert.assertEquals(faker_mail, actaul_email);
    }


    @Then("K6 Test sonrasi islemlerin dogru olmasi icin mail kismina yeniden orjinal maili girer")
    public void testSonrasiIslemlerinDogruOlmasiIcinMailKisminaYenidenOrjinalMailiGirer() {
        page.email.clear();
        ReusableMethods.waitFor(1);
        page.email.sendKeys("zehrasen1947@gmail.com");
        ReusableMethods.waitFor(1);
    }

    @Then("K6 isim kutusundaki bilgiyi siler ve hata mesajini dogrular")
    public void isimKutusundakiBilgiyiSilerVeHataMesajiniDogrular() {
        page.first_name.clear();
        ReusableMethods.waitFor(2);
        kayitButonunaTiklar();
        Assert.assertTrue(page.isim_bos_mesaji.isDisplayed());
    }

    @Then("K6 soyisim kutusundaki bilgiyi siler ve hata mesajini dogrular")
    public void soyisimKutusundakiBilgiyiSilerVeHataMesajiniDogrular() {
        page.last_name.clear();
        ReusableMethods.waitFor(2);
        kayitButonunaTiklar();
        Assert.assertTrue(page.soy_isim_bos_mesaji.isDisplayed());
    }

    @Then("K6 email kutusundaki bilgiyi siler ve hata mesajini dogrular")
    public void emailKutusundakiBilgiyiSilerVeHataMesajiniDogrular() {
        page.email.clear();
        ReusableMethods.waitFor(2);
        kayitButonunaTiklar();
        Assert.assertTrue(page.email_bos_mesaji.isDisplayed());
    }


// Randevu Bölümü

    @Then("K6 Kullanici myPage menusune tiklar")
    public void dddTiklar() {
        ReusableMethods.waitFor(1);
        page.patient_menu.click();
        ReusableMethods.waitFor(1);
    }

    @Then("K6 phone kismina on haneli bir telefon girer")
    public void kPhoneKisminaHaneliBirTelefonGirer() {
        page.phone_text_box.sendKeys("5325788061");
        ReusableMethods.waitFor(1);
    }

    @Then("K6 kaydet butonuna tiklar")
    public void KaydetButonunaTiklar() {
        jse.executeScript("arguments[0].click();", page.send_an_appointment_butonu);
        ReusableMethods.waitFor(2);
    }


    @Then("K6 make appointment linkine tiklar")
    public void AppointmentLinkineTiklar() {
        ReusableMethods.waitFor(1);
        page.make_Appointments.click();
    }


    @Then("K6 guncel tarihten ileri bir tarihi girer")
    public void kGuncelTarihtenSonrakiBirTarihiGirer() {
        String ileri_tarih = tarih_Uret(5);
        System.out.println("ileri_tarih = " + ileri_tarih);
        page.date_textbox.clear();
        page.date_textbox.sendKeys(ileri_tarih);
    }


    @Then("K6 guncel tarihten onceki bir tarihi girer")
    public void k6_guncel_tarihten_onceki_bir_tarihi_girer() {
        String geri_tarih = tarih_Uret(-1);
        System.out.println("geri_tarih = " + geri_tarih);
        page.date_textbox.clear();
        page.date_textbox.sendKeys(geri_tarih);
        ReusableMethods.waitFor(2);
    }

    @Then("K6 Appointment date can not be past date! hata mesajini dogrular")
    public void k6_appointment_date_can_not_be_past_date_hata_mesajini_dogrular() {
        Assert.assertTrue(page.date_hatasi_mesaji.isDisplayed());
        ReusableMethods.waitFor(2);
    }

    @Then("K6 my appointment linkine tiklar")
    public void kMyAppointmentLinkineTiklar() {
        page.my_Appointments.click();
    }


    @Then("sayfadaki ilk appointment adetini hesaplar")
    public void sayfadakiAppointmentAdetiniHesaplar() {
        randevu_sayisi_1 = page.hasta_adi_Listi.size();
    }

    @Then("K6 appointment adetinin artigini dogrular")
    public void appointmentAdetininArtiginiDogrular() {
        System.out.println("randevu_sayisi_1 = " + randevu_sayisi_1);
        System.out.println("randevu_sayisi_2 = " + randevu_sayisi_2);
        int sorgu=0;
        if (randevu_sayisi_2>randevu_sayisi_1) sorgu =1;
        Assert.assertEquals("Randevu Oluşturamadı",1, sorgu);
    }

    @Then("K6 sayfadaki ikinci appointment adetini hesaplar")
    public void sayfadakiIkinciAppointmentAdetiniHesaplar() {
        randevu_sayisi_2 = page.hasta_adi_Listi.size();
    }


    @Then("K6 Web driver {int} sn bekler")
    public void web_driver_sn_bekler(Integer sn) {
        ReusableMethods.waitFor(sn);
    }


    @Then("K6 phone kismina hatali bir telefon girer")
    public void k6_phone_kismina_hatali_bir_telefon_girer() {
        page.phone_text_box.sendKeys("532");
    }

    @Then("K6 Phone number is invalid hata mesajini dogrular")
    public void PhoneNumberIsInvalidHataMesajiniDogrular() {
        Assert.assertTrue(page.phone_hatasi_mesaji.isDisplayed());
    }


}
