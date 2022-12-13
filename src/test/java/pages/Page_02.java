package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Page_02 {
    public Page_02(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="//*[@id='account-menu']")
    public WebElement us10signin;
    @FindBy(xpath = "//*[@id='login-item']")
    public WebElement us10signin1;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement us10username;
    @FindBy(xpath = "//*[text()='MY PAGES']")
    public WebElement us10mypages;
    @FindBy(xpath = "(//*[text()='My Appointments'])[1]")
    public WebElement us10myappoinments;
    @FindBy(xpath = "//*[@id='fromDate']")
    public WebElement us10fromDate;
    @FindBy(xpath = "//*[@id='toDate']")
    public WebElement us10toDate;
    @FindBy(xpath = "//tbody//tr//td")
    public WebElement us10patientid;
    @FindBy (xpath = "//tbody//tr")
    public WebElement us10randevu;
    @FindBy (xpath = "//tbody//tr//td[2]")
    public WebElement startDateTime;

    @FindBy (xpath = "//tbody//tr//td[3]")
    public WebElement endDateTime;

    @FindBy (xpath = "//tbody//tr//td[4]")
    public WebElement status;
    @FindBy (xpath = "(//a[contains(@class,'btn btn-primary btn-sm')])[1]")
    public WebElement us11Edit;
    @FindBy (xpath = "//*[text()='Anamnesis']")
    public WebElement us11Anamnesis;
    @FindBy (xpath = "//*[text()='Treatment']")
    public WebElement us11Treatment;
    @FindBy (xpath = "//*[text()='Diagnosis']")
    public WebElement us11Diagnosis;
    @FindBy (xpath = "//*[text()='Prescription']")
    public WebElement us11Prescription;
    @FindBy (xpath = "//*[text()='Description']")
    public WebElement us11Description;
    @FindBy (xpath = "//*[text()='Status']")
    public WebElement us11Status;
    @FindBy (xpath = "(//div[contains(@class,'invalid-feedback')])[1]")
    public WebElement us11Feedback;
    @FindBy (xpath = "//*[@class='invalid-feedback']")
    public WebElement us11invalidFeedback;
    @FindBy (xpath = "//*[@id='appointment-anamnesis']")
    public WebElement Us11Anamnesisbox;
    @FindBy (xpath = "(//textarea[contains(@class,'')])[4]")
    public WebElement Us11bosprescription;
    @FindBy (xpath = "(//textarea[contains(@class,'')])[5]")
    public WebElement Us11bosdescribtion;
    @FindBy (xpath = "//*[@class='form-control']")
    public WebElement Us22SSNBox;
    @FindBy (xpath = "(//*[text()='Search Patient'])[1]")
    public WebElement Us22SearchPatient;
    @FindBy (xpath = "//*[text()='750-35-3545']")
    public WebElement Us22SSN;
    @FindBy (xpath = "//*[text()='Show Appointments']")
    public WebElement Us22ShowAppointments;
    @FindBy (xpath = "//*[text()='Show Tests']")
    public WebElement Us22ShowTest;
    @FindBy (xpath = "//*[text()='View Results']")
    public WebElement Us22ViewResults;
    @FindBy (xpath = "//*[text()='Test Results']")
    public WebElement Us22TestResults;
    @FindBy (xpath = "//*[text()='Edit']")
    public WebElement Us22Edit;
    @FindBy (xpath = "//*[@value='365782']")
    public WebElement Us22id;
    @FindBy (xpath = "//*[@value='HASTA']")
    public WebElement Us22name;
    @FindBy (xpath = "//*[@value='KİMBLE']")
    public WebElement Us22lastname;
    @FindBy (xpath = "//*[text()='Save']")
    public WebElement Us22save;
    @FindBy (xpath = "//div[@class='Toastify__toast-body']")
    public WebElement Us22update;
    @FindBy (xpath = "//*[text()='Create or edit a Patient']")
    public WebElement Us22validate;


}
