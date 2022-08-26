package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestItemPage {

    public TestItemPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id="ssn")
    public WebElement ssnTextBox;
    @FindBy(id = "firstName")
    public WebElement firstnameTextBox;
    @FindBy(id = "lastName")
    public WebElement lastnameTextBox;
    @FindBy(id = "username")
    public WebElement usernameTextBox;
    @FindBy(id = "email")
    public WebElement emailTextbox;
    @FindBy(xpath = "//*[text()='New password']/following::input")
    public WebElement firstPasswordTextBox;
    @FindBy(id= "secondPassword")
    public WebElement newPasswordTextBox;
    @FindBy(id = "register-submit")
    public WebElement registerButton;
    @FindBy(xpath = "//*[contains(text(),'Registration Saved')]")
    public WebElement successMessageToastContainer;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 0, 0)')]")
    public WebElement passwordStrength1;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 153, 0)')]")
    public WebElement passwordStrength2;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(153, 255, 0)')]")
    public WebElement passwordStrength3;

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement kullaniciResmibutonu;

    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement signInButton;

    @FindBy(css = "#username")
    public WebElement usernameBox;

    @FindBy(css = "#password")
    public WebElement passwordBox;

    @FindBy(xpath = "(//*[text()='Sign in'])[3]")
    public WebElement signInButton2;

    @FindBy(xpath = "(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[1]")
    public WebElement itemsTitlesButton;

    @FindBy(xpath = "(//*[text()='Test Item'])[1]")
    public WebElement testItem;

    @FindBy(xpath = "//*[text()='Test Items']")
    public WebElement testItemText;

    @FindBy(xpath = "//*[text()='Create a new Test Item']")
    public WebElement createAnewTestItem;

    @FindBy(xpath = "//*[text()='Create or edit a Test Item']")
    public WebElement createOrEditATestItemPage;

    @FindBy(css = "#c-test-item-name")
    public WebElement testItemNameBox;

    @FindBy(css = "#c-test-item-description")
    public WebElement testItemDescriptionBox;

    @FindBy(css = "#c-test-item-price")
    public WebElement testItemPriceBox;

    @FindBy(css = "#c-test-item-defaultValMin")
    public WebElement testItemdefaultValMinBox;

    @FindBy(css = "#c-test-item-defaultValMax")
    public WebElement testItemdefaultValMaxBox;

    @FindBy(css = "#c-test-item-createdDate")
    public WebElement testItemdecreatedDateBox;

    @FindBy(css = "#save-entity")
    public WebElement testItemSave;

    @FindBy(xpath = "//*[text()='Created Date']")
    public WebElement createdDateSiralamaButonu;

    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> listOfTestItemsName;

    @FindBy(xpath = "(//*[text()='Edit'])[1]")
    public WebElement testItemsEdit;

    @FindBy(xpath = "(//*[text()='Delete'])[1]")
    public WebElement testItemsDelete;

    @FindBy(css = "#jhi-confirm-delete-cTestItem")
    public WebElement warningDelete;

    @FindBy(xpath = "(//*[text()='Delete'])[21]")
    public WebElement userWarningDelete;

    @FindBy(css = "#nameLabel")
    public WebElement testItemNameText;

    @FindBy(css = "#descriptionLabel")
    public WebElement testItemDescriptionText;

    @FindBy(css = "#priceLabel")
    public WebElement testItemPriceText;

    @FindBy(css = "#defaultValMinLabel")
    public WebElement testItemDefaultValMinText;

    @FindBy(css = "#defaultValMaxLabel")
    public WebElement testItemDefaultValMaxText;

    @FindBy(css = "#createdDateLabel")
    public WebElement testItemCreatedDateText;

    @FindBy(xpath = "(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[2]")
    public WebElement administrationButton;

    @FindBy(xpath = "//*[text()='User management']")
    public WebElement userManagement;

    @FindBy(xpath = "//*[@href='/admin/user-management/team70_us20/edit']")
    public WebElement userEditButton;
    @FindBy(xpath = "//*[@href='/admin/user-management/team70_us20/delete']")
    public WebElement userDeleteButton;

    @FindBy(css = "#modified-date-sort")
    public WebElement usersModifiedDate;

    @FindBy(xpath = "//*[@value='ahmet']")
    public WebElement createUserFirstnameBox;

    @FindBy(css = "#firstName")
    public WebElement createUserFirstnameBoxBos;

    @FindBy(xpath = "//*[@value='koru']")
    public WebElement createUserLastnameBox;

    @FindBy(css = "#lastName")
    public WebElement createUserLastnameBoxBos;

    @FindBy(xpath = "//*[@value='true']")
    public WebElement createUserCheckboxTrue;

    @FindBy(xpath = "//*[@value='false']")
    public WebElement createUserCheckboxfalse;

    @FindBy(css = "#activated")
    public WebElement createUserCheckbox;

    @FindBy(xpath = "//*[@value='ahr@gsmail.com']")
    public WebElement createUserEmailBox;

    @FindBy(css = "#email")
    public WebElement createUserEmailBoxBos;
    @FindBy(xpath = "//*[text()='Create a new user']")
    public WebElement createANewUser;

    @FindBy(css = "#login")
    public WebElement createUserLoginBox;

    @FindBy(css = "#ssn")
    public WebElement createUserSsnBox;

    @FindBy(xpath = "//*[text()='Save']")
    public WebElement createUserSaveButton;

    @FindBy(xpath = "//*[text()='Back']")
    public WebElement createUserBackButton;

    @FindBy(css = "#authorities")
    public WebElement createUserProfileSelect;

    @FindBy(xpath = "(//*[text()='Activated'])[1]")
    public WebElement userActivatedYesil;

    @FindBy(xpath = "(//*[@class='badge badge-info'])[1]")
    public WebElement userProfilesRole;

//(//*[text()='ROLE_ADMIN'])[2]
}