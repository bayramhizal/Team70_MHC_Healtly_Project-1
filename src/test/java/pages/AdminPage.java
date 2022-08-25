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















































































 // Ahmet 160-239















































































    // Adem 240-319















































































    // Enes 320-399















































































    //Kadir 400-450

















































//Sentürk 450-519






































































}
