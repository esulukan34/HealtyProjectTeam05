package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Page_06 {


    public Page_06() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = ".d-flex.align-items-center.dropdown-toggle")  public WebElement ana_user_Link;
    @FindBy(xpath ="(//*[@class=\"d-flex align-items-center dropdown-toggle nav-link\"])[3]")  public WebElement fake_user_Link;
    @FindBy(xpath = "//*[@class='dropdown-item'][1]")
    public WebElement signin_text;
    @FindBy(xpath = "//*[@id=\"account-menu\"]/a/span")
    public WebElement user_icon;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement username_textbox;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password_textbox;
    @FindBy(xpath = "//*[@class='btn btn-primary']")
    public WebElement signin_button;
    @FindBy(xpath = "//span[text()='Administration']")
    public WebElement administiration_menu;
    @FindBy(xpath = "//*[text()='Zehra Şen']")
    public WebElement kullaniciadi;
    @FindBy(xpath = "//*[@href='/account/settings']")
    public WebElement settings;
    @FindBy(xpath = "//*[@id=\"firstName\"]")
    public WebElement first_name;
    @FindBy(xpath = "//*[@id='lastName']")
    public WebElement last_name;
    @FindBy(xpath = "//*[@id='email']")
    public WebElement email;
    @FindBy(xpath = "//*[@type=\"submit\"]")
    public WebElement save_button;
    @FindBy(xpath = "//span[text()='HOME']")
    public WebElement anasayfa_button;
    @FindBy(xpath = "//*[text()='Your first name is required.']")
    public WebElement isim_bos_mesaji;
    @FindBy(xpath = "//*[text()='Your last name is required.']")
    public WebElement soy_isim_bos_mesaji;
    @FindBy(xpath = "//*[text()='Your email is required.']")
    public WebElement email_bos_mesaji;


    //  ### Randevular Kısmı ###

    @FindBy(xpath = "//span[text()='MY PAGES(PATIENT)']")    public WebElement patient_menu;
    @FindBy(xpath = "//span[text()='My Appointments']")    public WebElement my_Appointments;
    @FindBy(xpath = "//span[text()='Make an Appointment']")    public WebElement make_Appointments;
    @FindBy(xpath = "//input[@name='phone']")    public WebElement phone_text_box;
    @FindBy(xpath = "//button[@type='submit']")    public WebElement send_an_appointment_butonu;
    @FindBy(xpath = "//input[@id='appoDate']")    public WebElement date_textbox;
    @FindBy(xpath = "//span[text()='Appointment date can not be past date!']")    public WebElement date_hatasi_mesaji;
    @FindBy(xpath = "//div[text()='Phone number is invalid']")    public WebElement phone_hatasi_mesaji;
    @FindBy(xpath = "//a[text()='Zehra Şen']")    public List<WebElement> hasta_adi_Listi;


    // ###  US-020 Admin Locateleri ###
    // ### Register ##
    @FindBy(xpath = "(//span[text()='Register'])[1]")    public WebElement Register_Register_Link;
    @FindBy(xpath = "//input[@name='ssn']")    public WebElement Register_ssn_textbox;
    @FindBy(xpath = "//input[@name='firstName']")    public WebElement Register_firstname_textbox;
    @FindBy(xpath = "//input[@name='lastName']")    public WebElement Register_lastname_textbox;
    @FindBy(xpath = "//input[@name='username']")    public WebElement Register_username_textbox;
    @FindBy(xpath = "//input[@name='email']")    public WebElement Register_e_mail_textbox;
    @FindBy(xpath = "//input[@name='firstPassword']")    public WebElement Register_first_pasword_textbox;
    @FindBy(xpath = "//input[@name='secondPassword']")    public WebElement Register_second_pasword_textbox;
    @FindBy(xpath = "//*[@id='register-submit']")    public WebElement Register_Submit_Button;


    @FindBy(xpath = "//span[text()='Administration']")    public WebElement Administration_Link;
    @FindBy(xpath = "//span[text()='User management']")    public WebElement User_Management_Link;
    @FindBy(xpath = "//span[text()='ID']")    public WebElement ID_Siralama;
    @FindBy(xpath = "//thead//tr//th")    public List<WebElement> sutun_sayisi;
    @FindBy(xpath = "//tbody//tr[1]//td[1]")    public WebElement birinci_satir_id;
    @FindBy(xpath = "//tbody//tr[1]//td[2]")    public WebElement birinci_satir_username;
    @FindBy(xpath = "//tbody//tr[1]//td[3]")    public WebElement birinci_satir_ssn;
    @FindBy(xpath = "//tbody//tr[1]//td[4]")    public WebElement birinci_satir_email;



    // ## ssn göre locate alma yöntemi
    @FindBy(xpath = "//*[text()='002-70-9099']/following-sibling::td[8]/div/a[1]")    public WebElement standart_ssn_View_Button;
    @FindBy(xpath = "//*[text()='002-70-9099']/following-sibling::td[8]/div/a[2]")    public WebElement standart_ssn_Edit_Button;
    @FindBy(xpath = "//*[text()='002-70-9099']/following-sibling::td[8]/div/a[3]")    public WebElement standart_ssn_Delete_Button;

    // ## Birinci satıra göre locate alma yöntemi
    @FindBy(xpath = "(//span[text()='View'])[1]")    public WebElement BirinciSatir_User_View_Button;
    @FindBy(xpath = "(//span[text()='Edit'])[1]")    public WebElement BirinciSatir_User_Edit_Button;
    @FindBy(xpath = "(//span[text()='Delete'])[1]")    public WebElement BirinciSatir_User_Delete_Button;
    @FindBy(xpath = "(//button[@type='button'])[2]")    public WebElement BirinciSatir_Active_Deactive_Button;
    @FindBy(xpath = "//tbody//tr[1]//td[5]")    public WebElement BirinciSatir_Active_Deactive_Sutun;

    @FindBy(xpath = "(//span[text()='Delete'])[21]")    public WebElement menu_delete_butonu;
    @FindBy(xpath = "//span[text()='Hüseyin Avni Şen']")    public WebElement HuseyinAvniSen;

    @FindBy(xpath = "//*[@data-icon='sign-out-alt']")    public WebElement Sign_Out;


    // ## Create or edit a user
    @FindBy(xpath = "//input[@id='id']")    public WebElement Create_User_Edit_Id_Textbox;
    @FindBy(xpath = "//input[@name='login']")    public WebElement Create_User_Edit_Login_Textbox;
    @FindBy(xpath = "//input[@name='firstName']")    public WebElement Create_User_Edit_Firstname_Textbox;
    @FindBy(xpath = "//input[@name='lastName']")    public WebElement Create_User_Edit_Lastname_Textbox;
    @FindBy(xpath = "//input[@name='email']")    public WebElement Create_User_Edit_Email_Textbox;
    @FindBy(xpath = "//input[@name='ssn']")    public WebElement Create_User_Edit_SSN_Textbox;
    @FindBy(xpath = "//*[@id='activated']")    public WebElement Create_User_Edit_Activated_Checkbox;



    @FindBy(xpath = "//select[@id='authorities']")    public WebElement Create_User_Edit_Profiles_Select;
    @FindBy(xpath = "//span[text()='Save']")    public WebElement Create_User_Edit_Save_Button;


    // ## User View locateleri
    @FindBy(xpath = "(//dd)[1]")    public WebElement user_view_username;
    @FindBy(xpath = "(//dd)[2]")    public WebElement user_view_firstname;
    @FindBy(xpath = "(//dd)[3]")    public WebElement user_view_lastname;
    @FindBy(xpath = "(//dd)[4]")    public WebElement user_view_e_mail;
    @FindBy(xpath = "//span[text()='Back']")    public WebElement user_view_Back_Butonu;

    // ## Fake Hesap locateleri
    @FindBy(xpath = "(//*[@class='d-flex align-items-center dropdown-toggle nav-link'])[3]")  public WebElement Fake_Hesap_Login;
    @FindBy(xpath = "//strong[text()='Failed to sign in!']")  public WebElement Failed_to_sign_in_Texti;



    // #### US 21 LOCATELERİ  #######
    // #### Staff Ana Menü Locateleri  - Personel  #######
    @FindBy(xpath = "//span[text()='MY PAGES']")  public WebElement Staff_My_Pages_Menu_Linki;
    @FindBy(xpath = "//span[text()='Search Patient']")  public WebElement Staff_Search_Patient_Linki;
    @FindBy(xpath = "//input[@name='ssn']")  public WebElement Patients_SSN_Textbox;
    @FindBy(xpath = "//span[text()='View']")  public WebElement Patients_View_Button;
    @FindBy(xpath = "//span[text()='Edit']")  public WebElement Patients_Edit_Button;
    @FindBy(xpath = "//span[text()='Show Appointments']")  public WebElement Patients_Show_Appointments_Button;

    // #### Create or Edit an Appointment Page - Randevu Sayfası#######
    @FindBy(xpath = "//*[@id='appointment-status']")  public WebElement Appointment_Status_Select;
    @FindBy(xpath = "//select[@id='appointment-physician']")  public WebElement Appointment_Physician_Select;
    @FindBy(xpath = "//*[@id='appointment-anamnesis']")  public WebElement Appointment_Anamnesis_Textbox;
    @FindBy(xpath = "//*[@id='appointment-treatment']")  public WebElement Appointment_Treatment_Textbox;
    @FindBy(xpath = "//*[@id='appointment-diagnosis']")  public WebElement Appointment_Diagnosis_Textbox;
    @FindBy(xpath = "//button[@id='save-entity']")  public WebElement Appointment_Save_Button;

    // #### Create or edit a Patient Page - Hasta  #######
    @FindBy(xpath = "//input[@name='firstName']")  public WebElement Patient_Edit_Page_FirstName;
    @FindBy(xpath = "//input[@name='lastName']")  public WebElement Patient_Edit_Page_LastName;
    @FindBy(xpath = "//span[text()='Save']")  public WebElement Patient_Edit_Page_Save_Butonu;

    // #### Appointments Page  - O hastanın Tüm Randevuları #######
    @FindBy(xpath = "(//*[@class='btn btn-warning btn-sm'])[1]")  public WebElement Appointments_Page_Birinci_Edit_Button;
    @FindBy(xpath = "(//span[text()='Show Tests'])[1]")  public WebElement Appointments_Page_Birinci_Show_Test_Button;
    //@FindBy(xpath = "//tbody//tr//td[2]")  public List<WebElement> Appointments_Page_User_Name_Listi;



    // #### Tests Page  #######
    @FindBy(xpath = "//h2[@id='c-test-heading']")  public WebElement Tests_Page_Test_Texti;

    // #### Patient view Page  #######
    @FindBy(xpath = "//a[@class='btn btn-primary']")  public WebElement Patient_View_Page_Edit_Buton;
}

