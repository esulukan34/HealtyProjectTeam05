package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Page_08 {
    public Page_08() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@data-icon='user']")
    public WebElement LoginIcon;
    @FindBy(xpath = "//*[@id='login-item']")
    public WebElement signIn;
    @FindBy(xpath = "//*[@name='username']")
    public WebElement userName;
    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;
    @FindBy(xpath = "//*[@type='submit']")
    public WebElement signInButton;
    @FindBy(xpath = "//*[text()='MY PAGES']")
    public WebElement myPages;
    @FindBy(xpath = "(//*[text()='Search Patient'])[1]")
    public WebElement searchPatient;
    @FindBy(xpath = "//*[@name='ssn']")
    public WebElement patientSSN;
    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> listOfPatient;
    @FindBy (xpath = "//*[@class='info jhi-item-count']")
    public WebElement totalNumberOfPatientsText;
    @FindBy (xpath = "(//*[@class='d-none d-md-inline'])[2]")
    public WebElement editOfPatientButton;
    @FindBy (xpath = "//*[@name='id']")
    public WebElement idTextBox;
    @FindBy (xpath = "//*[@id='patient-description']")
    public WebElement descriptionTextBox;
    @FindBy (xpath = "(//*[@data-prefix='fas'])[23]")
    public WebElement viewButton;
    @FindBy (xpath = "(//b)[1]")
    public WebElement idText;

    @FindBy (xpath = "(//dd)[1]")
    public WebElement SSNText;

    @FindBy (xpath = "(//dd)[2]")
    public WebElement firstNameText;

    @FindBy (xpath = "(//dd)[3]")
    public WebElement lastNameText;

    @FindBy (xpath = "(//dd)[4]")
    public WebElement birthDateText;
    @FindBy (xpath = "(//dd)[10]")
    public WebElement createdDateText;
    @FindBy (xpath = "(//dd)[5]")
    public WebElement phoneText;


    @FindBy (xpath = "(//dd)[5]")
    public WebElement emailText;

    @FindBy (xpath = "(//dd)[6]")
    public WebElement genderText;

    @FindBy (xpath = "(//dd)[7]")
    public WebElement bloodGroupText;

    @FindBy (xpath = "(//dd)[8]")
    public WebElement addressText;

    @FindBy (xpath = "(//dd)[9]")
    public WebElement descriptionText;

    @FindBy (xpath = "(//dd)[11]")
    public WebElement userText;

    @FindBy (xpath = "(//dd)[12]")
    public WebElement countryText;

    @FindBy (xpath = "(//dd)[13]")
    public WebElement state_CityText;

    @FindBy (xpath = "//*[@class='jh-entity-details']")
    public WebElement editmenuText;

    @FindBy (xpath = "//*[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement editAlert;//   //div[@class='Toastify__toast Toastify__toast--success toastify-toast']
    @FindBy (xpath = "//*[@id='patient-firstName']")
    public WebElement firstNameTextBox;
    @FindBy (xpath = "//input[@id='staff-firstName']")
    public WebElement firstNameTextBoxStaff;
    @FindBy (xpath = "//span[text()='Created Date']")
    public WebElement createdDate;
    @FindBy (xpath = "//input[@id='staff-lastName']")
    public WebElement lastNameTextBoxStaff;

    @FindBy (xpath = "//tbody//tr[1]//td[1]")
    public WebElement tableOfFirstId;

    @FindBy (xpath = "//input[@id='login']")
    public WebElement adminLoginTextBox;

    @FindBy (xpath = "//*[@id='firstName']")
    public WebElement adminFirstNameTextBox;
    @FindBy (xpath = "//*[@id='lastName']")
    public WebElement adminLastNameTextBox;
    @FindBy (xpath = "//*[@id='ssn']")
    public WebElement adminSSNTextBox;
    @FindBy (xpath = "//*[@id='email']")
    public WebElement adminEmailTextBox;
    @FindBy (xpath = "//*[text()='Save']")
    public WebElement adminSaveButton;
    @FindBy (xpath = "//*[@id='patient-lastName']")
    public WebElement lastNameTextBox;

    @FindBy (xpath = "//*[@id='email']")
    public WebElement emailTextBox;

    @FindBy (xpath = "//*[@id='patient-phone']")
    public WebElement phoneTextBox;
    @FindBy (xpath = "//*[@id='patient-birthDate']")
    public WebElement birthDateTextBox;
    @FindBy (xpath = "//*[@id='patient-gender']")
    public WebElement genderTextBox;

    @FindBy (xpath = "//*[@id='patient-adress']")
    public WebElement addressTextBox;

    @FindBy (xpath = "//*[@id='patient-description']")
    public WebElement getDescriptionTextBox
            ;

    @FindBy (xpath = "//*[@id='patient-bloodGroup']")
    public WebElement bloodGroupTextBox;


    @FindBy (xpath = "//*[@id='patient-user']")
    public WebElement userTextBox;

    @FindBy (xpath = "//*[@id='patient-country']")
    public WebElement countryTextBox;

    @FindBy (xpath = "//*[@id='patient-cstate']")
    public WebElement state_CityTextBox;
    @FindBy (xpath = "//*[@id='save-entity']")
    public WebElement saveButton;
    @FindBy (xpath = "//span[text()='Administration']")
    public WebElement administration;
    @FindBy (xpath = "//span[text()='User management']")
    public WebElement user_Management;
    @FindBy (xpath = "//div[@class='Toastify__toast-body' and @role='alert']")
    public WebElement saveAlert;
    @FindBy (xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement fieldUserCannotBeEmpty;
    @FindBy (xpath = "//div[@class='Toastify__toast Toastify__toast--field toastify-toast']")
    public WebElement fieldUserCannotBeEmpty2;
    @FindBy (xpath = "//div[@class='Toastify__toast Toastify__toast--error toastify-toast']")
    public WebElement internalServerError;

    @FindBy (xpath = "//span[text()='Modified date']")
    public WebElement modifiedDate;
    @FindBy (css = "[name='user.id']")
    public WebElement userDDL;
    @FindBy (xpath = "//span[text()='Items&Titles']")
    public WebElement items_Titles;

    @FindBy (xpath = "//a[@href='/staff' and @class='dropdown-item']")
    public WebElement staff;
    @FindBy (xpath = "//span[text()='Create a new Staff']")
    public WebElement createANewStaff;

    @FindBy (xpath = "//input[@name='searchSSN']")
    public WebElement adminStaffSsnTextBox;

    @FindBy (xpath = "//button[text()='Search User']")
    public WebElement ssnSearchButton;
    @FindBy (xpath = "//input[@name='useSSNSearch']")
    public WebElement useSearch;
    @FindBy (xpath = "//tbody")
    public WebElement table;

    @FindBy (xpath = "//a[@href='javascript:void(0)' and @aria-label='Next']")
    public WebElement nextButton;
    @FindBy (xpath = "//button[@id='jhi-confirm-delete-staff']")
    public WebElement deleteButton;

}
