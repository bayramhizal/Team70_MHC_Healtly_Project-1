package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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







































   // Seyfullah  80-159















































































 // Ahmet 160-239















































































    // Adem 240-319
   @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement ItemsTitle;

   @FindBy(xpath = "//a[@class='dropdown-item active']")
    public WebElement romms;

   @FindBy(xpath = "//span[text()='Status']")
    public WebElement status1;

    @FindBy(id= "jh-create-entity")
    public WebElement createANewButton;

    @FindBy(xpath = "//span[text()='Create or edit a Room']")
    public WebElement createRoom;

    @FindBy(xpath = "//input[@name='roomNumber']")
    public WebElement roomNumber;

    @FindBy(xpath = "//select[@name='roomType']")
    public WebElement roomTypeSelect;

    @FindBy(id="room-status")
    public WebElement status2;

    @FindBy(xpath = "//input[@name='price']")
    public WebElement price;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement descriptionTextButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//span[text()='Status']")
    public WebElement status3;

   @FindBy(xpath = "//input[@name='createdDate']")
   public WebElement createdDatee;

  @FindBy(xpath = "//div[@role='alert']")
  public WebElement alertButton;






































    // Enes 320-399















































































//Kadir 400-450

















































//Sentürk 450-519






































































}
