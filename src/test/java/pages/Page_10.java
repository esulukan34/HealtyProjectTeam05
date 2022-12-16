package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Page_10 {
    public Page_10(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy( xpath="//*[@class='dropdown nav-item']" )
    public WebElement signDropDown;

    @FindBy( xpath="(//*[@class='dropdown-item'])[2]")
    public WebElement registerButton;

    @FindBy( css="#firstPassword")
    public WebElement newPassword;

    @FindBy( css="#secondPassword")
    public WebElement confirmNewPassword;

    @FindBy( xpath="(//li[@style='background-color: rgb(0, 255, 0);'])")
    public List<WebElement> strenthisiklari;
    // Pyscians
    @FindBy( xpath="(//*[@class='dropdown-item'])[1]")
    public WebElement signInButton;

    @FindBy( xpath="//*[@name='username']")
    public WebElement username;

    @FindBy( xpath="//*[@name='password']")
    public WebElement password;

    @FindBy( xpath="//button[@type='submit']")
    public WebElement signIn;
    @FindBy( xpath="//*[text()='Adminz Adminy']")
    public WebElement adminName;

    @FindBy( xpath="//span[text()='Items&Titles']")
    public WebElement items_Titles;

    @FindBy( xpath="(//*[@class='dropdown-item'])[3]")
    public WebElement physician_Button;

    @FindBy( xpath="//span[text()='Physicians']")
    public WebElement physiciansPage;

    @FindBy( xpath="//*[@id='jh-create-entity']")
    public WebElement createNewPhysician;

    @FindBy( xpath="//*[@id='useSSNSearch']")
    public WebElement useSearchButton;

    @FindBy( xpath="//*[@id='searchSSN']")
    public WebElement searchSSn;

    @FindBy( xpath="//*[text()='Search User']")
    public WebElement searchSSnButton;

    @FindBy( xpath="//*[@id='physician-firstName']")
    public WebElement phys_FirtsName;

    @FindBy( xpath="//*[@id='physician-lastName']")
    public WebElement phys_LastName;

    @FindBy( xpath="//*[@id='physician-phone']")
    public WebElement phys_Phone;

    @FindBy( xpath="//*[@id='physician1-birthDate']")
    public WebElement phys_BirthDay;

    @FindBy( xpath="//*[@id='physician-speciality']")
    public WebElement phys_Speciality;

    @FindBy( xpath="//*[@id='physician-examFee']")
    public WebElement phys_ExamFee;

    @FindBy( css= "#file_image")
    public WebElement phys_AddImage;

    @FindBy( xpath="//*[text()='Save']")
    public WebElement phys_SaveButton;

    @FindBy( xpath="//span[text()='001-01-0008']")
    public WebElement SSN;
    @FindBy( xpath="//span[text()='SSN']")
    public WebElement SSN1;

    @FindBy( xpath="//*[text()='001-01-0008']/following-sibling::td[8]/div/a[2]")
    //@FindBy(xpath="//*[@href=\"/admin/user-management/team05ali/edit\"]")
    public WebElement editButton;

    @FindBy( xpath="//*[text()='Create or edit a user']")
    public WebElement editPage;

    @FindBy( xpath="//*[text()='001-01-0008']/following-sibling::td[8]/div/a[3]")
    //@FindBy( xpath="//*[@href=\"/admin/user-management/team05ali/delete\"]")
    public WebElement deleteButton;

    @FindBy( xpath="//*[text()='Confirm delete operation']")
    public WebElement deleteConfirmation;

    @FindBy( xpath="//*[text()='Administration']")
    public WebElement administrationButton;

    @FindBy( xpath="//*[text()='User management']")
    public WebElement userManagementButton;

}
