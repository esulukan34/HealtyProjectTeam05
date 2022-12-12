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

    @FindBy( xpath="//*[@id='file_image']")
    public WebElement phys_AddImage;

    @FindBy( xpath="//*[text()='Save']")
    public WebElement phys_SaveButton;

    @FindBy( xpath="//*[text()='User found with search SSN']")
    public WebElement phys_FoundAlert;


}
