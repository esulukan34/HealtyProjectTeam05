package stepDefinitions.uiSteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import pages.Page_06;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;


public class US020 {
    WebDriver driver;
    //WebDriverManager.chromedriver().setup();
    //driver = new ChromeDriver();



    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Page_06 page = new Page_06();

    Faker faker = new Faker();

    String faker_ssn ="002-70-9099";
    String faker_firstname = "Faker Name " + faker.name().firstName();
    String faker_lastname = faker.name().lastName();
    String faker_username = "faker_user_"+faker.name().username();
    String faker_e_mail = faker.internet().emailAddress();
    String faker_pasword = faker.internet().password(6, 8);

    String User_View_Username;
    String User_View_Email;
    String User_View_Firstname;
    String User_View_Lastname;


    @Given("KullaniciAlti medunna.com adresine gider")
    public void kullanici_alti_medunna_com_adresine_gider() {
        Driver.getDriver().get("https://medunna.com/");
    }

    @Then("KullaniciAlti user iconuna tiklar")
    public void kullanici_alti_user_iconuna_tiklar() {
        page.ana_user_Link.click();
    }

    @Then("KullaniciAlti Register linkine tiklar")
    public void kullanici_alti_register_linkine_tiklar() {
        page.Register_Register_Link.click();
    }

    @Then("KullaniciAlti Fake bir kullanici olusturur")
    public void kullanicialtiFakeBirKullaniciOlusturur() {

        System.out.println("######  FAKER KULLANICI HESABI BİLGİLERİ #######");
        System.out.println("faker_ssn       = " + faker_ssn);
        System.out.println("faker_firstname = " + faker_firstname);
        System.out.println("faker_lastname  = " + faker_lastname);
        System.out.println("faker_username  = " + faker_username);
        System.out.println("faker_mail      = " + faker_e_mail);
        System.out.println("faker_pasword   = " + faker_pasword);

        page.Register_ssn_textbox.sendKeys(faker_ssn);
        page.Register_firstname_textbox.sendKeys(faker_firstname);
        page.Register_lastname_textbox.sendKeys(faker_lastname);
        page.Register_username_textbox.sendKeys(faker_username);
        page.Register_e_mail_textbox.sendKeys(faker_e_mail);
        page.Register_first_pasword_textbox.sendKeys(faker_pasword);
        page.Register_second_pasword_textbox.sendKeys(faker_pasword);

        ReusableMethods.bulveTikla(page.Register_Submit_Button);

    }

    @Then("KullaniciAlti Admin login olur")
    public void kullanicialtiAdminOlarakLoginOlur() {
        page.ana_user_Link.click();
        ReusableMethods.waitFor(1);
        page.signin_text.click();
        page.username_textbox.sendKeys("havnisen");
        ReusableMethods.waitFor(1);
        page.password_textbox.sendKeys("Muhammed61q");
        ReusableMethods.waitFor(1);
        page.signin_button.click();
    }

    @Then("KullaniciAlti Admin sifresi girilir")
    public void kullanicialtiAdminsifresigirilir() {
        page.username_textbox.sendKeys("havnisen");
        page.password_textbox.sendKeys("Muhammed61q");
        page.signin_button.click();
    }

    @Then("KullaniciAlti Admin user management linkine tiklar")
    public void kullanicialtiUserManagementLinkineTiklar() {
        page.Administration_Link.click();
        ReusableMethods.waitFor(1);
        page.User_Management_Link.click();
    }


    @Then("KullaniciAlti Admin kullanicilari tersten siralar")
    public void kullanicialtiKullanicilariTerstenSiralar() {
        page.ID_Siralama.click();
        ReusableMethods.waitFor(3);
    }

    @Then("KullaniciAlti Admin Fake kullanici bilgilerini dogrular")
    public void kullanicialtiFakeKullaniciBilgileriniDogrular() {

        String OkunanUserId = page.Create_User_Edit_Id_Textbox.getAttribute("value");
        String OkunanUserLoginName = page.Create_User_Edit_Login_Textbox.getAttribute("value");;
        String OkunanFirstName = page.Create_User_Edit_Firstname_Textbox.getAttribute("value");;
        String OkunanLastName = page.Create_User_Edit_Lastname_Textbox.getAttribute("value");;
        String OkunanEmail = page.Create_User_Edit_Email_Textbox.getAttribute("value");;
        String OkunanUserSsn = page.Create_User_Edit_SSN_Textbox.getAttribute("value");;


        System.out.println();
        System.out.println("#### CREATE OR EDİT USER SAYFASINDAN OKUNAN DEĞERLER  ####");
        System.out.println("Okunan User Id           = " + OkunanUserId);
        System.out.println("Okunan User Login Name   = " + OkunanUserLoginName);
        System.out.println("Okunan First Name        = " + OkunanFirstName);
        System.out.println("Okunan Last Name         = " + OkunanLastName);
        System.out.println("Okunan User Ssn          = " + OkunanUserSsn);
        System.out.println("Okunan Email             = " + OkunanEmail);


        Assert.assertEquals(faker_username, OkunanUserLoginName);
        Assert.assertEquals(faker_ssn, OkunanUserSsn);
        Assert.assertEquals(faker_firstname, OkunanFirstName);
        Assert.assertEquals(faker_lastname, OkunanLastName);
        Assert.assertEquals(faker_e_mail, OkunanEmail);
        Assert.assertEquals(faker_ssn, OkunanUserSsn);


    }

    @Then("KullaniciAlti Admin Fake kullaniciyi Active yapar")
    public void kullanicialtiAdminFakeKullaniciyiActiveYapar() {
        ReusableMethods.waitFor(1);
        ReusableMethods.bulveTikla(page.Create_User_Edit_Activated_Checkbox);
    }

    @Then("KullaniciAlti Admin logout olur")
    public void kullanicialtiAdminLogoutOlur() {
        page.HuseyinAvniSen.click();
        ReusableMethods.waitFor(1);
        page.Sign_Out.click();
    }


    @Then("KullaniciAlti Fake kullanici login olur")
    public void kullanicialtiFakeKullaniciLoginOlur() {
        page.ana_user_Link.click();
        page.signin_text.click();
        ReusableMethods.waitFor(1);
        page.username_textbox.sendKeys(faker_username);
        ReusableMethods.waitFor(1);
        page.password_textbox.sendKeys(faker_pasword);
        ReusableMethods.waitFor(1);
        page.signin_button.click();
    }

    @Then("KullaniciAlti Fake kullanicinin login oldugu dogrulanir")
    public void kullanicialtiFakeKullanicininLoginOlduguDogrulanir() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(page.Administration_Link.isDisplayed());


    }

    @Then("KullaniciAlti Admin Fake kullaniciyi Edit yapmak icin Edit linkine tiklar")
    public void kullanicialtiAdminFakeKullaniciyiEditYapmakIcinEditLinkineTiklar() {
        page.BirinciSatir_User_Edit_Button.click();
        ReusableMethods.waitFor(2);
    }


    @Then("KullaniciAlti Admin Fake kullaniciya bir rol atar")
    public void kullanici_alti_admin_fake_kullaniciya_bir_rol_atar() {

        jse.executeScript("arguments[0].scrollIntoView(true);", page.Create_User_Edit_Profiles_Select);
        ReusableMethods.waitFor(1);
        ReusableMethods.bulveTikla(page.Create_User_Edit_Profiles_Select);

        ReusableMethods.waitFor(1);
        Select select = new Select(page.Create_User_Edit_Profiles_Select);
        select.selectByValue("ROLE_ADMIN");
        select.selectByValue("ROLE_USER");
        //select.selectByValue("ROLE_PATIENT");
        //select.selectByValue("ROLE_STAFF");
        // select.selectByValue("ROLE_PHYSICIAN");
        page.Create_User_Edit_Save_Button.click();

    }


    @Then("KullaniciAlti Sayfa kapatilir")
    public void kullanici_alti_sayfa_kapatilir() {
        Driver.quitDriver();
    }

    @Then("KullaniciAlti Admin Fake hesabi siler")
    public void kullanici_alti_fake_hesabi_siler() {

        ReusableMethods.bulveTikla(page.standart_ssn_Delete_Button);
        ReusableMethods.bulveTikla(page.menu_delete_butonu);

    }

    @Then("KullaniciAlti Admin kullanici user view butonuna tiklar")
    public void kullanicialtiAdminKullaniciUserViewButonunaTiklar() {
        page.standart_ssn_View_Button.click();
        ReusableMethods.waitFor(1);
    }

    @Then("KullaniciAlti Admin kullanici user bilgilerini dogrular")
    public void kullanicialtiAdminKullaniciUserBilgileriniDogrular() {
        ReusableMethods.waitFor(2);
        User_View_Username = page.user_view_username.getText();
        User_View_Firstname = page.user_view_firstname.getText();
        User_View_Lastname = page.user_view_lastname.getText();
        User_View_Email = page.user_view_e_mail.getText();

        //Assert.assertEquals(faker_username, User_View_Username);
        Assert.assertEquals(faker_firstname, User_View_Firstname);
        Assert.assertEquals(faker_lastname, User_View_Lastname);
        Assert.assertEquals(faker_e_mail, User_View_Email);

        System.out.println();
        System.out.println("######  USER VIEW'DEN OKUNAN DEĞERLER  #######");
        System.out.println("User_View_Username          = " + User_View_Username);
        System.out.println("User_View_Firstname         = " + User_View_Firstname);
        System.out.println("User_View_Lastname          = " + User_View_Lastname);
        System.out.println("User_View_Email             = " + User_View_Email);

    }

    @Then("KullaniciAlti Admin Back butonuna tiklar")
    public void kullanicialtiAdminBackButonunaTiklar() {
        ReusableMethods.bulveTikla(page.user_view_Back_Butonu);
        ReusableMethods.waitFor(1);
    }

    @Then("KullaniciAlti Fake kullanici logout olur")
    public void kullanicialtiFakeKullaniciLogoutOlur() {
        ReusableMethods.bulveTikla(page.fake_user_Link);
        ReusableMethods.waitFor(1);
        page.Sign_Out.click();

    }

    @Then("KullaniciAlti Fake hesap silindigi icin login olamadigi dogrulanir")
    public void kullanicialtiFakeHesapSilindigiIcinLoginOlamadigiDogrulanir() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(page.Failed_to_sign_in_Texti.isDisplayed());
    }

    @Then("KullaniciAlti Fake kullanici Edit url'e gidilir")
    public void kullanicialtiFakeKullaniciEditUrlEGidilir() {
        // WebElement deneme1 = Driver.getDriver().findElement(By.xpath(""));
        //List <WebElement> denemeList =Driver.getDriver().findElements(By.xpath(""));
        ReusableMethods.waitFor(2);
        String Fake_Edit_Url = "https://www.medunna.com/admin/user-management/"+ faker_username+"/edit";
        Driver.getDriver().get(Fake_Edit_Url);

    }

    @Then("KullaniciAlti Admin Fake hesabi save eder")
    public void kullanicialtiAdminFakeHesabiSaveEder() {
        ReusableMethods.bulveTikla(page.Create_User_Edit_Save_Button);
        ReusableMethods.waitFor(6);
    }
}
