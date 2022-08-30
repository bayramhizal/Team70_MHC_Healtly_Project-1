package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.uiStepDefinitions.US_27;
import utilities.Driver;

import java.util.List;

public class AdminPage {

    public AdminPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    // Arif 16- 79

    @FindBy (xpath ="//*[text()=\"CONTACT\"]" )
    public WebElement contactButton;
    @FindBy (xpath ="//*[text()=\"Contact\"]" )
    public WebElement contactYazi;
    @FindBy (xpath = "//input[@name=\"name\"]")
    public WebElement nameButonu;
    @FindBy(xpath = "//button[@id=\"register-submit\"]")
    public WebElement sendButonu;
     @FindBy(xpath ="//span[text()=\"Items&Titles\"]")
    public WebElement itemButton;
    @FindBy(xpath = "//span[text()=\"Staff\"]")
    public WebElement staffButton;
      @FindBy(xpath = "//span[text()=\"Create a new Staff\"]")
    public WebElement creatButton;
    @FindBy(xpath = "//input[@name=\"searchSSN\"]")
    public WebElement ssnSearch;
    @FindBy(xpath = "//input[@id=\"useSSNSearch\"]")
    public WebElement useSearchButton;
    @FindBy(xpath = "//button[text()=\"Search User\"]")
    public  WebElement searchUserButton;
    @FindBy(xpath = "//div[text()=\"User found with search SSN\"]")
    public WebElement alertYazi;
    @FindBy(xpath = "(//span[text()=\"View\"])[1]")
    public WebElement viewButton;
    @FindBy(xpath = "(//span[text()=\"Staff\"])[2]")
    public WebElement staffYazisi;
    @FindBy(xpath = "(//span[text()=\"Edit\"])[1]")
    public WebElement editButton;
    @FindBy(xpath = "//input[@id=\"staff-id\"]")
    public WebElement staffIDButton;
    @FindBy(xpath = "//input[@id=\"staff-lastName\"]")
    public WebElement staffLastNameButton;
    @FindBy(xpath = "//input[@id=\"staff-birthDate\"]")
    public WebElement staffBirthDateBt;
    @FindBy(xpath = "//span[text()=\"Save\"]")
    public WebElement saveButton;
    @FindBy(xpath = "//div[text()=\"A Staff is updated with identifier 211233\"]")
    public WebElement alertYazi2;
    @FindBy(xpath = "//input[@id=\"staff-createdDate\"]")
    public WebElement staffcreatButton;
    @FindBy(xpath = "(//span[text()=\"Delete\"])[1]")
    public WebElement deleteButton;
    @FindBy(xpath = "(//span[text()=\"Delete\"])[21]")
    public WebElement alertDeleteButoon;
    @FindBy(xpath = "//div[text()=\"A Staff is deleted with identifier 211233\"]")
    public WebElement alert3;
    @FindBy (xpath = "//input[@name=\"firstName\"]")
    public WebElement staffFirstname;
    @FindBy (xpath = "//div[@role='alert']")
    public WebElement alert;
    @FindBy (xpath = "//span[text()='Delete']")
    public List<WebElement> delete;









    // Seyfullah  80-159
   @FindBy(xpath = "//li[@id='entity-menu']")
   public WebElement itemsTitlesDropdownButon;

    @FindBy(xpath = "//span[text()='Patient']")
    public WebElement itemsTitlesPatientButon;

    @FindBy(id = "cancel-save")
    public WebElement createPatientBackButon;

    @FindBy(xpath = "/html/body/div/div/div/div[4]/div/div/div/div/div[1]/div/table/thead/tr/th")
    public List <WebElement> hastaBilgileriSutunBasliklari;

    @FindBy(xpath = "//input[@name='firstName']" )
    public WebElement patientFirstName;

    @FindBy(xpath = "//input[@name='lastName']" )
    public WebElement patientLastName;

    @FindBy(xpath = "//input[@name='birthDate']" )
    public WebElement patientBirthDate;

    @FindBy(xpath = "//input[@name='email']" )
    public WebElement patientEmail;

    @FindBy(xpath = "//select[@name='gender']" )
    public WebElement patientGender;

    @FindBy(xpath = "//select[@name='bloodGroup']" )
    public WebElement patientBloodGroup;

    @FindBy(xpath = "//input[@name='adress']" )
    public WebElement patientAdress;

    @FindBy(xpath = "//textarea[@name='description']" )
    public WebElement patientDescription;

    @FindBy(xpath = "//select[@name='user.id']" )
    public WebElement patientUserSelect;

    @FindBy(xpath = "//select[@name='country.id']" )
    public WebElement patientCountry;

    @FindBy(xpath = "//select[@name='cstate.id']" )
    public WebElement patientStateCity;

    @FindBy (xpath = "//button[@type=\"submit\"]")
    public WebElement patientSaveButtonn;

    @FindBy (xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement patientEditButtonn;

    @FindBy (xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement alertYazisiGenel;

    @FindBy(xpath = "//input[@name='phone']" )
    public WebElement patientPhone;

    @FindBy(xpath="//div/label")
    public List <WebElement> hastaDuzenlemeBilgileriSutunBasliklari;

    @FindBy (xpath = "//div[text()='Internal server error.']")
    public WebElement deleteAlertErrorYazisi;

    @FindBy (xpath = "(//a[@class='btn btn-danger btn-sm'])[1]")
    public WebElement patientDeleteButtonn;

    @FindBy (id = "jhi-confirm-delete-patient")
    public WebElement patientDeleteConfirmButtonn;

    @FindBy (xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement deleteAlertSuccessYazisi;








    // Ahmet 160-239















































































    // Adem 240-319
   @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement ItemsTitle;

   @FindBy(xpath = "(//a[@class='dropdown-item'])[6]")
    public WebElement romms;

   @FindBy(xpath = "//span[text()='Status']")
    public WebElement status1;

    @FindBy(id= "jh-create-entity")
    public WebElement createANewButton;

    @FindBy(xpath = "//*[text()='Create or edit a Room']")
    public WebElement createRoom;

    @FindBy(xpath = "//input[@name='roomNumber']")
    public WebElement roomNumber;

    @FindBy(xpath = "//select[@name='roomType']")
    public WebElement roomTypeSelect;

    @FindBy(id="room-status")
    public WebElement status2;

    @FindBy(xpath = "//input[@name='price']")
    public WebElement price;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement descriptionTextButton;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement savedButton;

    @FindBy(xpath = "//span[text()='Status']")
    public WebElement status3;

   @FindBy(xpath = "//input[@name='createdDate']")
   public WebElement createdDatee;

  @FindBy(xpath = "//div[@role='alert']")
  public WebElement alertButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameAdmin;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordAdmin;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton2;

   @FindBy(xpath="//div[@class='invalid-feedback']")
   public WebElement rommZorunlu;
   @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
   public WebElement roomUyariRakamHarf;

@FindBy(xpath = "//div[@class='invalid-feedback']")
public WebElement priceUyariRakamHarf;

@FindBy(xpath = "//div[@class='invalid-feedback']")

public WebElement priceZorunlu;

@FindBy(xpath = "//span[text()='Room Type']")
public WebElement roomTypeBaslik;

@FindBy(xpath = "//tbody//td[3]")
public List<WebElement> roomTypList;

@FindBy(xpath = "(//li[@class='page-item'])[4]")
public WebElement sayfaDegistir;

@FindBy(xpath = "(//span[text()='Delete'])[18]")
public WebElement deleteHasta;





// Enes 320-399



    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement PhysicianDropdownButton;


    @FindBy(xpath = "//span[text()='Physicians']")
    public WebElement PhysicianPageVisible;


    @FindBy(xpath = "(//span[text()='View'])[1]")
    public WebElement PhysicianPageViewButton;


    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public WebElement PhysicianPageEditButton;


    @FindBy(xpath = "(//span[text()='Create or edit a Physician'])[1]")
    public WebElement PhysicianEditPageVisible;


    @FindBy(id = "file_image")
    public WebElement imageButton;

    @FindBy(xpath = "//input[@name='examFee']")
    public WebElement examFeeBox;


    @FindBy(xpath = "(//span[text()='Delete'])[1]")
    public WebElement PhysicianPageDeleteButton;













































    //Kadir 400-450
    @FindBy(xpath = "(//a[@href=\"/c-message\"])[2]")
    public WebElement messageButton;

    @FindBy(xpath = "//span[text()='Create a new Message']")
    public WebElement createANewMessageButton;

    @FindBy(xpath = "//div[@class='jh-card card']")
    public WebElement messagesPage;

    @FindBy(xpath = "//span[text()='ID']")
    public WebElement messagesPageIdButton;

    @FindBy(xpath = "//span[text()='Name']")
    public WebElement messagesPageNameButton;

    @FindBy(xpath = "//span[text()='Email']")
    public WebElement messagesPageEmailButton;

    @FindBy(xpath = "//span[text()='Subject']")
    public WebElement messagesPageSubjectButton;

    @FindBy(xpath = "//span[text()='Message']")
    public WebElement messagesPageMessageButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement messagesPageMessageAlertYazi;

    @FindBy(xpath = "//input[@id='c-message-name']")
    public WebElement createMessagePageNameButton;

    @FindBy(xpath = "(//a[@href=\"/c-message/237815\"])[2]")
    public WebElement createdMessageViewButton;

    @FindBy(xpath = "//input[@id='c-message-name']")
    public WebElement editMessageNameButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement messagesPageMessageEditAlertYazi;

    @FindBy(xpath = "//a[@href=\"/c-message/240263/delete\"]")
    public WebElement createdMessageDeleteButton;







    //Sentürk 450-519





































































}
