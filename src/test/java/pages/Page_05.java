package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Page_05 {
    public Page_05() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#account-menu>a")
    public WebElement accountMenu;
    @FindBy(id = "login-item")
    public WebElement signInId;
    @FindBy(xpath = "//*[.='Sign in']")
    public WebElement signIn;
    @FindBy(xpath = "//*[@name='username']") //css input[name=username]
    public WebElement usernameBox;
    @FindBy(xpath = "//*[@name='password']") // css input[name=password]
    public WebElement passwordBox;
    @FindBy(css = ".btn.btn-primary") // xpath //*[@type='submit']
    public WebElement signInButton;
    // xpath  //div//a[@class='dropdown-item']//span[.='Password']
    @FindBy(css = ".dropdown-menu-right.show>:nth-child(2)>span")
    public WebElement passwordLink;
    @FindBy(xpath = "//*[@name='currentPassword']") // css input[name=currentPassword]
    public WebElement currentPasswordBox;
    @FindBy(css = "#newPassword")   // xpath //*[@id='newPassword']
    public WebElement newPasswordBox;
    @FindBy(css = "#confirmPassword") // xpath //*[@id='confirmPassword']
    public WebElement confirmPasswordBox;
    @FindBy(css = ".btn.btn-success>span") // xpath //button//span[.='Save']
    public WebElement saveButton;
    // @FindBy(xpath = "//*[contains(text(), 'Password changed')]")
    @FindBy(xpath = "//*[contains(text(), 'Password changed!')]")
    public WebElement passwordChangedMessage;
    @FindBy(css = "div.col-md-8")
    public WebElement passwordScreen;
    // Password Strength
    @FindBy(css = "#strengthBar")
    public WebElement strengthBar;
    @FindBy(css = "#strength")
    public WebElement strength;
    @FindBy(xpath = "//li[@style='background-color: rgb(255, 0, 0);']") // size = 1
    public List<WebElement> redStrength;  // css  #strengthBar>:nth-child(1)
    //@FindBy(xpath = "//li[@style='background-color: rgb(255, 153, 0);']")
    //public WebElement orangeStrength;
    @FindBy(xpath = "//li[@style='background-color: rgb(255, 153, 0);']") // size = 2
    public List<WebElement> orangeStrengthList;
    @FindBy(xpath = "//li[@style='background-color: rgb(255, 255, 0);']") // size = 3
    public List<WebElement> yellowStrength;
    @FindBy(xpath = "//li[@style='background-color: rgb(153, 255, 0);']") // size = 4
    public List<WebElement> limeGreenStrength;
    @FindBy(xpath = "//li[@style='background-color: rgb(0, 255, 0);']") // size = 5
    public List<WebElement> greenStrength;
    @FindBy(xpath = "//*[.='The password and its confirmation do not match!']")
    public WebElement notMatchTextMessage;  // css  .invalid-feedback

    // DOCTOR
    @FindBy(xpath = "//a//*[.='MY PAGES']")
    public WebElement myPages;
    //@FindBy(xpath = "//a//*[.='My Inpatients']")
    //public WebElement myInpatients;
    @FindBy(linkText = "My Inpatients")
    public WebElement myInpatients;

    @FindBy(xpath = "//thead//tr//th")
    public List<WebElement> patientTableTitles;

    @FindBy(xpath = "//thead")
    public WebElement titles;
    @FindBy(xpath = "//span//*[.='Edit']")
    public List<WebElement> editButtons;
    @FindBy(xpath = "//span//*[.='Edit']")
    public WebElement editButton;
    @FindBy(css = "#in-patient-status")   //   xpath   //*[@id='in-patient-status']   css - select[name=status]
    public WebElement statusDdm;
    @FindBy(css = "#in-patient-room")  //   xpath   //*[@id='in-patient-room']
    public WebElement roomDdm;
    @FindBy(css = "table.table")  // xpath    //table[@class='table']
    public WebElement patientTable;
    @FindBy(css = "#in-patient-appointment")
    public WebElement appointmentDdm;
    @FindBy(css = "#save-entity>span")
    public WebElement saveButtonCreatePatient;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']") // kaybolan yazilarin locate ini tek öocate ile aldik burda text bkullanmadik bu locate uc yaziyida veriyor
    public WebElement inPatientSaveMassage;

    //*[@class='Toastify__toast-body' and contains(text(), 'The In Patient is updated with identifier')]
    //*[contains(text(), 'The In Patient is updated with identifier')]
    //@FindBy(xpath = "//*[contains(text(), 'InPatient status can not be changed with this type of status')]")
    //public WebElement inPatientSaveMassage2;
    //@FindBy(xpath = "//*[contains(text(), 'The room already reserved')]")
    //public WebElement inPatientSaveMassage3;
    //@FindBy(xpath = "//*[contains(text(), 'The room already reserved')]")
    //public WebElement inPatientSaveMassage4;

    //  -> //a[starts-with(@id,'login')]
    //   -> //*[contains(text(), 'Authentication information not correct.')]
    //  ->   //div[text()='Authentication information not correct.']
    //  -> //a[@href='#appointment' and @class='btn-get-started scrollto']
    //  -> //*[@type='submit' and @id='register-submit']
    // -> li.nav-item>a[href*="tor"]
    // -> li.nav-item>a[href^="/depart"]
    // -> li.nav-item>a[href$="ct"]  sonu iceriyor
    // -> #entity-menu>div>a[href^='/st']  /st ile baslayan
    // ->  #entity-menu>div>a[href$='aff']  aff ile biten
    // -> div[class="collapse navbar-collapse"] a[href$='ut']
    // -> ul#header-tabs>:last-child


    // US015
    @FindBy(css = "#entity-menu>a>span")
    public WebElement itemsAndTitles;

    @FindBy(xpath = "//*[.='Patient']")
    public WebElement patientLink;
    @FindBy(css = "#jh-create-entity>span")  // xpath //*[@id='jh-create-entity']//span
    public WebElement createNewPatientButton;

    @FindBy(css = "#jh-create-entity>span")
    public WebElement createNewAppointmentButton;
    @FindBy(xpath = "//*[@name='firstName']")
    public WebElement firstnameBoxPatient;
    @FindBy(xpath = "//*[@name='lastName']")
    public WebElement lastnameBoxPatient;
    @FindBy(xpath = "//*[@id='patient-birthDate']")
    public WebElement birthDayBoxPatient;
    @FindBy(xpath = "//*[@name='email']")
    public WebElement emailBoxPatient;
    @FindBy(xpath = "//*[@name='phone']")
    public WebElement phoneBoxPatient;
    @FindBy(xpath = "//*[@id='patient-gender']")
    public WebElement genderDdmPatient;
    @FindBy(xpath = "//*[@id='patient-bloodGroup']")
    public WebElement bloodGroupDdmPatient;
    @FindBy(xpath = "//*[@id='patient-adress']")
    public WebElement addressBoxPatient;
    @FindBy(xpath = "//*[@id='patient-description']")
    public WebElement descriptionBoxPatient;
    @FindBy(xpath = "//*[@name='user.id']")
    public WebElement userDdmPatient;
    @FindBy(xpath = "//*[@id='patient-country']")
    public WebElement countryDdmPatient;
    @FindBy(xpath = "//*[@id='patient-cstate']")
    public WebElement stateDdmPatient;
    @FindBy(xpath = "//*[@id='save-entity']//span")
    public WebElement saveButtonPatient;
    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement inPatientSaveMassagePatient;
    @FindBy(css = ".jh-card.card")
    public WebElement patientListTable;


    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement firstnameFeedbackPatient;
    @FindBy(xpath = "(//div[@class='invalid-feedback'])[2]")
    public WebElement lastnameFeedbackPatient;
    @FindBy(xpath = "//*[text()='Your email is required.']")
    public WebElement mailFeedbackPatient;
    @FindBy(xpath = "//*[text()='Phone number is required.']")
    public WebElement phoneFeedbackPatient;

    @FindBy(xpath = "//*[text()='Appointment']")
    public WebElement appointmentDdmPatient;

    @FindBy(xpath = "//*[text()='Create a new Appointment']")
    public WebElement appointmentCreate;

    @FindBy(xpath = "//th//*[.='ID']")
    public WebElement idTitle;

    @FindBy(css = "#appointment-endDate")
    public WebElement appointmentEndDate;

    @FindBy(xpath="//select[@name='status']")
    public WebElement appointmentStatus;

    @FindBy(xpath="//select[@name='physician.id']")
    public WebElement appointmentDoctorSelect;

    @FindBy(xpath="//select[@name='patient.id']")
    public WebElement appointmentPatientSelect;

    @FindBy(xpath="//span[text()='Diagnosis']")
    public WebElement Diagnosis;

    @FindBy(xpath = "//a[@class='btn btn-danger btn-sm']//span//*[.='Delete']")
    public List<WebElement> deleteButtonList;
    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm']//span//*[.='Delete'])[1]")
    public List<WebElement> firstDeleteButton;
    @FindBy(css = "#jhi-confirm-delete-patient>span")
    public WebElement alertDeleteButton;

    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement deleteMassagePatient;


    @FindBy(xpath = "//tbody//tr//td//a[@class='btn btn-link btn-sm']")
    public List<WebElement> idListPatient;

}
