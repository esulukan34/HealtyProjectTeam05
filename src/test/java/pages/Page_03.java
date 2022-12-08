package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Page_03 {
    public Page_03(){    PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//*[@data-icon='user']")
    public WebElement registerSignInIkon;
    @FindBy(xpath = "//*[text()='Register']")
    public WebElement registerButon;
    @FindBy(xpath = "//*[@name='ssn']")
    public WebElement ssnTextbox;
    @FindBy(xpath = "//*[@id='register-submit']")
    public WebElement registerSubmit;
    @FindBy(xpath = "//*[text()='Registration Saved']")
    public WebElement registerSavedTextMessage;
    @FindBy(xpath = "//*[text()='Your username is required.']")
    public WebElement usernameRequired;
    @FindBy(xpath = "//*[text()='Login name already used!']")
    public WebElement loginUsed;
    @FindBy(xpath = "//*[text()='This field is invalid']")
    public WebElement fieldInvalid;
    @FindBy(xpath = "//a[@id='login-item']")
    public WebElement signInButon;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameTextBox;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordTextBox;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInSubmit;
    @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement itemsTitlesDDM;
    @FindBy(xpath = "//span[text()='Room']")
    public WebElement roomSelect;
    @FindBy(xpath = "//a[@id='jh-create-entity']")
    public WebElement createRoomButon;
    @FindBy(xpath = "//input[@id='room-roomNumber']")
    public WebElement roomNumberTextBox;
    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButon;
    @FindBy(xpath = "//*[contains(text(),'A new Room is created with identifier')]")
    public WebElement roomCreatedMessage;
    @FindBy(xpath = "//span[text()='Room Type']")
    public WebElement roomTypeBaslik;
    @FindBy(xpath = "//tbody//td[3]")
    public List<WebElement> roomTypeSutun;
    @FindBy(xpath = "//span[text()='Created Date']")
    public WebElement createdDateBasligi;
    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> roomNumberSutun;
    @FindBy(xpath = "//tbody//td[1]")
    public List<WebElement> idSutun;
    @FindBy(xpath = "//span[text()='Edit']")
    public WebElement roomEditButon;
    @FindBy(xpath = "//*[contains(text(),'A Room is updated with identifier')]")
    public WebElement roomUpdateMessage;
    @FindBy(xpath = "//tbody//td[8]//span[text()='Delete']")
    public List<WebElement> deleteRoomSutun;
    @FindBy(xpath = "//button[@id='jhi-confirm-delete-room']")
    public WebElement popUpDeleteButon;
    @FindBy(xpath = "//div[@id='hospitalmsappfrontendApp.room.delete.question']")
    public WebElement popUpRoomText;
    @FindBy(xpath = "//*[contains(text(),'A Room is deleted with identifier ')]")
    public WebElement deletedRoomMessage;
    @FindBy(xpath = "//span[text()='Country']")
    public WebElement countrySelect;
    @FindBy(xpath = "//span[text()='Create a new Country']")
    public WebElement createNewCountryButon;
    @FindBy(xpath = "//input[@id='country-name']")
    public WebElement countryNameTextbox;
    @FindBy(xpath = "//*[contains(text(),'A Country is deleted with identifier')]")
    public WebElement deletedCountryMessage;
    @FindBy(xpath = "//*[contains(text(),'A new Country is created with identifier')]")
    public WebElement createdCountryMessage;
    @FindBy(xpath = "//span[text()='State/City']")
    public WebElement stateCitySelect;
    @FindBy(xpath = "//input[@id='c-state-name']")
    public WebElement stateCityNameTextBox;
    @FindBy(xpath = "//span[text()='Create a new State/City']")
    public WebElement createdNewStateCityButon;
    @FindBy(xpath = "//select[@id='c-state-state']")
    public WebElement countryDDM;
    @FindBy(xpath = "//*[@class='Toastify__toast-body']")
    public WebElement notCreatedCityMessage;
    @FindBy(xpath = "//tbody//td[1]")
    public List<WebElement> countryIdSutunu;
    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> countryNameSutunu;
    @FindBy(xpath = "//tbody//td[4]//span[text()='Delete']")
    public List<WebElement> deleteCountrySutunu;
    @FindBy(xpath = "//div[@id='hospitalmsappfrontendApp.country.delete.question']")
    public WebElement popUpCountryText;
    @FindBy(xpath = "//button[@id='jhi-confirm-delete-country']")
    public WebElement popUpCountryDeleteButon;
    @FindBy(xpath = "//div[text()='Room information is not consistent. Room number must be unique']")
    public WebElement notUniqueRoomMessage;
}
