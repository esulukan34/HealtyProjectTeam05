package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Page_04 {

    public Page_04(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css =".d-flex.align-items-center.dropdown-toggle")
    public WebElement account;

    @FindBy(xpath = "//*[@class='dropdown-item'][2]")
    public WebElement register;

    @FindBy(css = "#ssn")
    public WebElement ssn;

    @FindBy(css = "#firstName")
    public WebElement firstname;

    @FindBy(css = "#lastName")
    public WebElement lastname;

    @FindBy(css = ".invalid-feedback")
    public WebElement gecersizSsn;

    @FindBy(css = "#register-submit")
    public WebElement gecersizRegister;

    @FindBy(xpath = "//*[text()='Your SSN is required.']")
    public WebElement requiredSsn;

    @FindBy(xpath = "//*[text() = 'Your FirstName is required.']")
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

    @FindBy(xpath = "//tr//td//span[1]")
    public WebElement tarihFormat;


}
