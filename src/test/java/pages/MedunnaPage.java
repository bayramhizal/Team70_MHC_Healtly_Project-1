package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class MedunnaPage {

    public MedunnaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "account-menu")
    public WebElement accountLinki;

    @FindBy(xpath = "//*[@id='account-menu']/div/a[2]/span")
    public WebElement registerLink;

    @FindBy(xpath = "//*[@id='ssn']")
    public WebElement ssnTextbox;

    @FindBy(xpath = "//div[text()='Your SSN is invalid']")
    public WebElement ssnInvalidMessage;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement ssnInvalidMessage2;

    @FindBy(xpath = "//input[@class='is-touched is-dirty av-valid form-control']")
    public WebElement ssnValidForm;

    @FindBy(xpath = "//div[text()='Your SSN is required.']")
    public WebElement ssnRequiredMessage;

    @FindBy(xpath = "//div[text()='Your FirstName is required.']")
    public WebElement firstnameRequiredMessage;

    @FindBy (xpath= "//input[@class='is-touched is-dirty av-valid form-control']")
    public WebElement firstnameValidForm;

    @FindBy(xpath = "//div[text()='Your LastName is required.']")
    public WebElement lastnameRequiredMessage;

    @FindBy(xpath = "//div[text()='Your username is required.']")
    public WebElement usernameRequiredMessage;

    @FindBy(xpath = "//div[text()='Your username is invalid.']")
    public WebElement usernameInvalidMessage;

    @FindBy(xpath = "//div[text()='Your email is required.']")
    public WebElement emailRequiredMessage;

    @FindBy(xpath = "//div[text()='Your email is required to be at least 5 characters.']")
    public WebElement emailAtLeast5CharMessage;

    @FindBy(xpath = "//div[text()='This field is invalid']")
    public WebElement emailInvalidMessage;

    @FindBy(xpath = "//*[@id='firstName']")
    public WebElement firstnameTextbox;

    @FindBy(xpath = "//*[@id='lastName']")
    public WebElement lastnameTextbox;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement usernameTextbox;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailTextbox;

    @FindBy (xpath = "//div[@class='text-danger form-group']")
    public List <WebElement>   InvalidFormGroupControl;















    ////////
    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenu;
    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signIn;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement userName;
    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement signOut;










// ahmet
    @FindBy (xpath = "//*[text()='Register']")
    public WebElement ikonAltiRegisterButton;

    @FindBy (xpath = "//*[@name='firstPassword']")
    public WebElement newPasswordBox;

    @FindBy (xpath = "//*[@style='background-color: rgb(255, 0, 0);']")
    public WebElement passwordStrengtTekCizgi; // asdfghj

    @FindBy (xpath = "//*[@style='background-color: rgb(255, 153, 0);']")
    public WebElement passwordStrengthIkiCizgi; //Asdfghj

    @FindBy (xpath = "//*[@style='background-color: rgb(153, 255, 0);']")
    public WebElement passwordStrengthDortCizgi; //A1sdfghj

    @FindBy (xpath = "//*[@style='background-color: rgb(0, 255, 0);']")
    public WebElement passwordStrengtBesCizgi; // A1*sdfgh









    /////
    @FindBy(xpath = "//label[@for=\"username\"]")
    public WebElement usernameButton;

    @FindBy(xpath = "//label[@for=\"password\"]")
    public WebElement passwordButton;

    @FindBy(xpath = "//span[text()='Remember me']")
    public WebElement rememberMeButton;

    @FindBy(xpath = "//input[@name='rememberMe']")
    public WebElement rememberMeClickButton;

    @FindBy(xpath = "//a[@href=\"/account/reset/request\"]")
    public WebElement didYouForgetPasswordButton;

    @FindBy(xpath = "(//a[@href='/account/register'])[2]")
    public WebElement registerAnewAccount;

    @FindBy(xpath = "//span[text()=\"You don't have an account yet?\"]")
    public WebElement youDontHaveAaccountButton;

    @FindBy(xpath = "(//button[@type=\"button\"])[3]")
    public WebElement cancelButton;

    @FindBy(xpath = "//span[text()='Reset your password']")
    public WebElement resetYourPasswordButton;

    @FindBy(xpath = "//h1")
    public WebElement wellcomeToMedunna;

    @FindBy(xpath = "(//div[@class='alert alert-warning fade show'])[2]")
    public WebElement youDontRegisterButton;

}