package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class Page_04 {
    public Page_04(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath="//*[@id='login-item']")
    public WebElement sign;
    @FindBy(xpath = "//*[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement accountmenu;
    @FindBy(css = "#firstName")
    public WebElement firstname;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;
    @FindBy(css = "#lastName")
    public WebElement lastname;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement pasword;
    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement signButon;
    @FindBy (xpath = "//*[@src='content/images/logo.png']")
    public WebElement Medunna;


    @FindBy(xpath = "//*[text() = 'Your FirstName is required.']")
<<<<<<< HEAD
    public WebElement gecersizName;
    @FindBy (xpath = "//label[@class='form-check-label']")
    public WebElement Remem_me;
    @FindBy (xpath = "//div[text()='Authentication information not correct.']")
    public WebElement Başarısızmesajı;
    @FindBy (xpath = "//div[contains(text(),'Authentication information not correct.')]")
    public WebElement bsarımesajımı_acaba;
    @FindBy (xpath = "//*[@href=\"/account/reset/request\"]")
    public WebElement ŞifremiUnuttum;
    @FindBy (xpath = "//*[text()='Register a new account']")
    public WebElement Register_a_new_account;
    @FindBy (xpath = "//*[text()='Cancel']")
    public WebElement cancel;
=======
    public WebElement requiredName;

    @FindBy(xpath = "//*[text()='Your LastName is required.']")
    public WebElement requiredLastname;

    @FindBy(css = "#username")
    public WebElement username;

    @FindBy(css = "#email")
    public WebElement email;

    @FindBy(css = "#firstPassword")
    public WebElement password;

    @FindBy(css = "#secondPassword")
    public WebElement password2;

    @FindBy(xpath = "//*[text()='Register'][1]")
    public WebElement register2;

    @FindBy(xpath = "//*[text()='MY PAGES(PATIENT)']")
    public WebElement myPages;

    @FindBy(xpath = "//*[text()='Make an Appointment'][1]")
    public WebElement makeAppointment;

    @FindBy(xpath = "//*[text()='My Appointments'][1]")
    public WebElement myAppointments;


    @FindBy(css = "#phone")
    public WebElement phone;

    @FindBy(css = "#appoDate")
    public WebElement date;

    @FindBy(css = "#register-submit")
    public WebElement sendAppointment;
    //365175

    @FindBy(css =".Toastify__toast-body")
    public WebElement randevuOnayi;

    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement signIn;

    @FindBy(css = "#username")
    public WebElement patientUsername;

    @FindBy(css = "#password")
    public WebElement patientPassword;

    @FindBy(css = "#fromDate")
    public WebElement tarihBasla;

    @FindBy(css = "#toDate")
    public WebElement tarihBitir;

    @FindBy(xpath = "//tbody/tr[1]/td[3]/span")
    public WebElement tarihFormat;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement alert;


>>>>>>> bcc5063cd1bf808e68173881eb005536f1bc1a82
}
