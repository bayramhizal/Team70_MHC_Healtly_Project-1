package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class StaffPage {

    public StaffPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement myPage;
    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement searchPatient;
    @FindBy(xpath = "//span[text()='Patients']")
    public WebElement patient;
    @FindBy(xpath = "//span[text()='Edit']")
    public List<WebElement> edit;
    @FindBy (xpath = "//input[@id='patient-firstName']")
    public WebElement patientFM;
    @FindBy (xpath = "//select[@id='patient-cstate']")
    public WebElement stateCity;
    @FindBy (xpath = "//button[@id='save-entity']")
    public WebElement save;
    @FindBy (xpath = "//input[@class='form-control']")
    public WebElement ssnBox;
    @FindBy (xpath = "//tbody//td[2]")
    public WebElement ssnPatient;
//div//dt




    //Adem 40-99
//@FindBy(xpath = "//*[text()='MY PAGES']")
  //  public WebElement MyPageButton;

    @FindBy(xpath = "//input")
    public WebElement patientSSN;

    @FindBy(xpath = "//span[text()='Show Appointments']")
    public WebElement showAppointments;

    @FindBy(xpath = "(//span[text()='Edit'])[2]")
    public WebElement EditButton;

    @FindBy(xpath = "//input[@name=\"startDate\"]")
    public WebElement startDate;

    @FindBy(xpath = "//input[@name=\"endDate\"]")
    public WebElement endDate;

    @FindBy(xpath = "//select[@id=\"appointment-status\"]")
    public WebElement statusSelectButton;

    @FindBy(xpath = "(//textarea)[1]")
    public WebElement anamnesisButton;

    @FindBy(xpath = "(//textarea)[2]")
    public WebElement treatmentButton;

    @FindBy(xpath = "(//textarea)[3]")
    public WebElement diagnosisButton;

    @FindBy(xpath = "(//textarea)[4]")
    public WebElement prescriptionButton;

    @FindBy(xpath = "(//textarea)[5]")
    public WebElement descriptionButton;

    @FindBy(xpath = "//select[@id='appointment-physician']")
    public WebElement physicianButton;

    @FindBy(id = "save-entity")
    public WebElement savedButton;

    @FindBy(xpath = "//div[@role='alert]")
    public WebElement alertButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameStaff;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordStaff;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton2;








    @FindBy(xpath = "(//span[text()='Show Tests'])[1]")
    public WebElement showTestsButton;

    @FindBy(xpath = "(//span[text()='View Results'])[1]")
    public WebElement viewTestResultsButton;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement patientEditButton;

    @FindBy(xpath = "(//span[text()='Create or edit a Patient'])[1]")
    public WebElement EditSayfasiKontrol;















































    //Enes    100-159



























































// Serhan 160-219



























































}
