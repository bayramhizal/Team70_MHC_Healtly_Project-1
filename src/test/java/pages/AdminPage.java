package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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














   // Seyfullah  80-159
   @FindBy(xpath = "//li[@id='entity-menu']")
   public WebElement itemsTitlesDropdownButon;

    @FindBy(xpath = "//span[text()='Patient']")
    public WebElement itemsTitlesPatientButon;

    @FindBy(id = "cancel-save")
    public WebElement createPatientBackButon;







































































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




















    //Sentürk 450-519





































































}
