package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Page_07 {
    public Page_07() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//a[@class='appointment-btn scrollto']") public WebElement makeAnAppointmentButton;
    @FindBy (xpath = "//input[@id='firstName']") public WebElement firstName;
    @FindBy (xpath = "//input[@id='lastName']") public WebElement lastName;
    @FindBy (xpath = "//input[@id='ssn']") public WebElement ssn;
    @FindBy (xpath = "//input[@id='email']") public WebElement email;
    @FindBy (xpath = "//input[@id='phone']") public WebElement phone;
    @FindBy (xpath = "//input[@id='appoDate']") public WebElement appoDate;
    @FindBy (xpath = "//span[text()='Send an Appointment Request']") public WebElement sendAndAppointmentRequestButton;
    @FindBy (xpath = "/*[contains(text(),'Appointment registration saved!')]") public WebElement randevuKaydedildiYazisi;

    @FindBy (xpath = "//div[@role='alert']") public WebElement randevuKaydedildiYazisiSHub;


    @FindBy (xpath = "//div[text()='Your FirstName is required.']") public WebElement firstnameRequiredText;
    @FindBy (xpath = "//div[text()='Phone number is invalid']") public WebElement phoneNumberInvalidText;
    @FindBy (xpath = "//div[text()='Your SSN is required.']") public WebElement ssnRequiredText;
    @FindBy (xpath = "//div[text()='Your LastName is required.']") public WebElement lastnameRequiredText;
    @FindBy (xpath = "//div[text()='Phone number is required.']") public WebElement phonenumberRequiredText;
    @FindBy (xpath = "//li[@id='account-menu']") public WebElement accountMenu;
    @FindBy (xpath = "//span[text()='Sign in']") public WebElement signInButton;
    @FindBy (xpath = "//input[@id='username']") public WebElement username;
    @FindBy (xpath = "//input[@id='password']") public WebElement password;
    @FindBy (xpath = "(//span[text()='Sign in'])[3]") public WebElement signIn2Button;
    @FindBy (xpath = "//span[text()='MY PAGES(PATIENT)']") public WebElement myPageSheet;
    @FindBy (xpath = "//span[text()='My Appointments']") public WebElement myAppointmentButton;
    @FindBy (xpath = "//h2[@id='appointment-heading']") public WebElement appointmentBasligi;


  //  @FindBy (xpath = "(//span[text()='Sign in'])[3]") public WebElement signIn2Button;

    @FindBy (xpath = "(//tr)[2]") public List<WebElement> appointmentFirstRowWE;
    @FindBy (css = "#newPassword.is-touched") public WebElement PhoneBoxBlueFrame;
    @FindBy (xpath = "//tbody//tr//td[1]") public List<WebElement> idSutunElemanlariWE;
    @FindBy (xpath = "//span[text()='Make an Appointment']") public WebElement makeAnAppointment2;
    @FindBy (xpath = "//span[text()='CONTACT']") public WebElement contactMenu;
    @FindBy (xpath = "//input[@id='name']") public WebElement fullNameBox;
    @FindBy (xpath = "//input[@id='email']") public WebElement emailBox;
    @FindBy (xpath = "//input[@id='subject']") public WebElement subjectBox;
    @FindBy (xpath = "//textarea[@id='message']") public WebElement messageBox;
    @FindBy (xpath = "//span[text()='Send']") public WebElement sendButton;
    @FindBy (xpath = "//section[@id='contact']") public WebElement contactSayfasi;
    @FindBy (xpath = "//*[text()='Your message has been received']") public WebElement mesajIletildiYazisi;
    @FindBy (xpath = "//*[contains(text(),'Your message has been received')]") public WebElement mesajIletildiYazisiContains;
    @FindBy (xpath = "//li[@id='entity-menu']") public WebElement itemTitlesMenu;
    @FindBy (xpath = "//span[text()='Messages']") public WebElement messagesButton;
   // @FindBy (xpath = "//tbody//tr[1]") public List<WebElement> mesajPortalFirstRowList;
    @FindBy (xpath = "//tbody/tr[1]/td") public List<WebElement> mesajPortalFirstRowList;
    @FindBy (xpath = "//tbody/tr[1]/td[5]") public WebElement mesajPortalMesajSutun5;
    @FindBy (xpath = "//tbody/tr[1]/td[2]") public WebElement mesajPortalIsimSutun2;
    @FindBy (xpath = "//tbody/tr[1]/td[5]") public WebElement mesajPortalEmailSutun3;
    @FindBy (xpath = "//a[@id='jh-create-entity']") public WebElement createANewMessageButton;
    @FindBy (xpath = "//input[@id='c-message-name']") public WebElement adminMessageNameBox;
    @FindBy (xpath = "//input[@id='c-message-email']") public WebElement adminMessageEmailBox;
    @FindBy (xpath = "//input[@id='c-message-subject']") public WebElement adminMessageSubjectBox;
    @FindBy (xpath = "//input[@id='c-message-message']") public WebElement adminMessageYazBox;
    @FindBy (xpath = "//button[@id='save-entity']") public WebElement messageSavedButton;
    @FindBy (xpath = "//div[@role='alert']") public WebElement mesajCreatedText;
    @FindBy (xpath = "//tbody//tr//td[1]") public List<WebElement> mesajIdListWE;
    @FindBy (xpath = "//th[1]//*[name()='svg']") public WebElement mesajRefreshOk;
    @FindBy (xpath = "//div[@role='alert']") public WebElement mesajUpdatedText;
    @FindBy (xpath = "//button[@id='jhi-confirm-delete-cMessage']") public WebElement deleteButton2;

    @FindBy (xpath = "//div[@role='alert']") public WebElement mesajDeletedText;


















































    public static String tarih_Uret(int gun) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, gun);
        String date = sdf.format(calendar.getTime());
        return date;
    }




}
