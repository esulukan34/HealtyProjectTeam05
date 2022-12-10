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
}
