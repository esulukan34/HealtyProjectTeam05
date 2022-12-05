package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Page_06 {

    public Page_06() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".d-flex.align-items-center.dropdown-toggle")
    public WebElement user;
    @FindBy(xpath = "//*[@class='dropdown-item'][1]")
    public WebElement signin_text;
    @FindBy(xpath = "//*[@id=\"account-menu\"]/a/span")
    public WebElement user_icon;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement username_textbox;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password_textbox;
    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement signin_button;
    @FindBy(xpath = "//span[text()='Administration']")
    public WebElement administiration_menu;
    @FindBy(xpath = "//*[text()='Zehra Şen']")
    public WebElement kullaniciadi;
    @FindBy(xpath = "//*[@href='/account/settings']")
    public WebElement settings;
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    public WebElement first_name;
    @FindBy(xpath = "//*[@id='lastName']")
    public WebElement last_name;
    @FindBy(xpath = "//*[@id='email']")
    public WebElement email;
    @FindBy(xpath = "//*[@type=\"submit\"]")
    public WebElement save_button;
    @FindBy(xpath = "//span[text()='HOME']")
    public WebElement anasayfa_button;
    @FindBy(xpath = "//*[text()='Your first name is required.']")
    public WebElement isim_bos_mesaji;
    @FindBy(xpath = "//*[text()='Your last name is required.']")
    public WebElement soy_isim_bos_mesaji;
    @FindBy(xpath = "//*[text()='Your email is required.']")
    public WebElement email_bos_mesaji;


    //  Randevular Kısmı

    @FindBy(xpath = "//span[text()='MY PAGES(PATIENT)']")
    public WebElement patient_menu;

    @FindBy(xpath = "//span[text()='My Appointments']")
    public WebElement my_Appointments;

    @FindBy(xpath = "//span[text()='Make an Appointment']")
    public WebElement make_Appointments;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phone_text_box;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement send_an_appointment_butonu;


}
