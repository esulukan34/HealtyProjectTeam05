package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Page_09 {

    public Page_09(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (id = "account-menu")
    public WebElement accountMenu;

    @FindBy(linkText = "Sign in")
    public WebElement signin;

    @FindBy(xpath = "//input[contains(@placeholder,'username')]")
    public WebElement username;

    @FindBy(xpath = "//input[contains(@placeholder,'password')]")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement sign_in;

    @FindBy(linkText = "MY PAGES")
    public WebElement myPages;

    @FindBy( linkText = "My Appointments")
    public WebElement myAppointments;

    @FindBy( xpath = "//span[contains(@class,'inline')]")
    public WebElement editButton;

    @FindBy( xpath = "//a[@href='/physician_test/343954']")
    public WebElement requestaTest;


    @FindBy( xpath = "//td[text()='Urea']")
    public WebElement urea;


    @FindBy( xpath = "//*[text()='Albumin']")
    public WebElement albumin;


    @FindBy( xpath = "//*[text()='Total Protein-']")
    public WebElement totalProtein;

    @FindBy( xpath = "//*[text()='Hemoglobin']")
    public WebElement hemoglobin;


    @FindBy( xpath = "//*[text()='glucose']")
    public WebElement glucose;


    @FindBy( xpath = "//*[text()='sodium']")
    public WebElement sodium;
    @FindBy( xpath = "//*[text()='Creatinine-']")
    public WebElement creatinine;

    @FindBy( xpath = "//*[text()='Potassium-']")
    public WebElement potassium;

    @FindBy( xpath = "//input[@name=\"1402\" and @id=\"1402\"]")
    public WebElement ureaCheckBox;

    @FindBy( xpath = "//input[@name=\"1407\" and @id=\"1407\"]")
    public WebElement albuminCheckBox;

    @FindBy( xpath = "//input[@name=\"132796\" and @id=\"132796\"]")
    public WebElement totalProteinCheckBox;

    @FindBy( xpath = "//input[@name=\"1408\" and @id=\"1408\"]")
    public WebElement hemoglobinCheckBox;


    @FindBy( xpath = "//input[@name=\"132751\" and @id=\"132751\"]")
    public WebElement glucoseCheckBox;


    @FindBy( xpath = "//input[@name=\"132793\" and @id=\"132793\"]")
    public WebElement creatinineCheckBox;

    @FindBy( xpath = "//input[@name=\"132794\" and @id=\"132794\"]")
    public WebElement sodiumCheckBox;

    @FindBy( xpath = "//input[@name=\"132795\" and @id=\"132795\"]")
    public WebElement potassiumCheckBox;


    @FindBy( xpath = "//*[text()='Save']")
    public WebElement saveButton;

    @FindBy( xpath = "//a[@href='/tests/appointment/343954']")
    public WebElement testResults;

    @FindBy( xpath = "//*[@href='/testresult/test/342873']")
    public WebElement viewResults;

    @FindBy( xpath = "//span[text()='ID']")
    public WebElement idValue;

    @FindBy( xpath = "//span[text()='Name']")
    public WebElement nameValue;

    @FindBy( xpath = "//span[text()='Default Max. Value']")
    public WebElement defaultMaxValue;

    @FindBy( xpath = "//span[text()='Default Min. Value']")
    public WebElement defaultMinValue;

    @FindBy( xpath = "//span[text()='Test']")
    public WebElement testValue;

    @FindBy( xpath = "//span[text()='Description']")
    public WebElement descriptionValue;

    @FindBy( xpath = "//span[text()='Date']")
    public WebElement dateValue;

    @FindBy( xpath = "//button[text()='Request Inpatient']")
    public WebElement requestInpatient;

    @FindBy(xpath = "//*[text()='Items&Titles']")
    public WebElement itemsTitles;

    @FindBy( linkText = "Test Item")
    public WebElement testItem;

    @FindBy( xpath = "//span[text()='Create a new Test Item']")
    public WebElement createANewTestItem;

    @FindBy( xpath = "//input[@id='c-test-item-name']")
    public WebElement nameBox;

    @FindBy( xpath = "//input[@id='c-test-item-description']")
    public WebElement descriptionBox;

    @FindBy( xpath = "//input[@id='c-test-item-price']")
    public WebElement priceBox;

    @FindBy( xpath = "//input[@id='c-test-item-defaultValMin']")
    public WebElement defaultMinValueBox;

    @FindBy( xpath = "//input[@id='c-test-item-defaultValMax']")
    public WebElement defaultMaxValueBox;

    @FindBy( xpath = "//button[@id='save-entity']")
    public WebElement save;

    @FindBy( xpath = "//*[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement testItemCreated;

    @FindBy( xpath = "//a[text()='95']")
    public WebElement pageNinetyFive;

    @FindBy( xpath = "(//*[@data-prefix='fas' and @data-icon='eye'])[15]")
    public WebElement viewTestItemButton;

    @FindBy( xpath = "//*[@class='col-md-8']")
    public WebElement testItemCanBeSeen;

    @FindBy( xpath = "//*[@href='/c-test-item/359360/edit?page=95&sort=id,asc']")
    public WebElement editTestItemButton;

    @FindBy( xpath = "_")
    public WebElement testItemCanBeEdited;

    @FindBy( xpath = "//*[@href='/c-test-item/359360/delete?page=95&sort=id,asc']")
    public WebElement deleteTestItemButton;

    @FindBy( xpath = "//button[@id='jhi-confirm-delete-cTestItem']")
    public WebElement confirmDeleteOperation;

    @FindBy( xpath = "//*[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement testItemDeleted;

}