package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class DoktorPage {

    public DoktorPage() { // Bu Constructor buradaki Locate eden @FindBy
        // icin olmazsa olmazdir cunku Driver getiriyor.

        PageFactory.initElements(Driver.getDriver(), this);
    }

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

    @FindBy(xpath = "//*[text()='ahmet pars']")
    public WebElement doktorName;

    @FindBy(xpath = "//*[text()='MY PAGES']")
    public WebElement myPagesButton;

    @FindBy(xpath = "(//*[text()='My Appointments'])[1]")
    public WebElement myAppointmentUstButton;

    @FindBy(css = "#appointment-heading")
    public WebElement appointmentsPage;

    @FindBy(xpath = "//tbody//td[12]")
    public List<WebElement> listOfPatient;

    @FindBy(xpath = "(//*[text()='Edit'])[1]")
    public WebElement patientAhmEditButton;

    @FindBy(xpath = "//*[text()='Request A Test']")
    public WebElement requestATestBox;

    @FindBy(css = "#c-test-item-heading")
    public WebElement testItemText;

    @FindBy(xpath = "//*[text()='Sign out']")
    public WebElement signOutButton;

    @FindBy(xpath = "//*[text()='THANK YOU FOR CHOOSING US...']")
    public WebElement thankYouText;

    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> listOfTestName;

    @FindBy(xpath = "//tbody//td[1]")
    public List<WebElement> listOfTestId;


    @FindBy(xpath = "//*[text()='ID']")
    public WebElement idButton;

    @FindBy(xpath = "//*[text()='Start DateTime']")
    public WebElement startDateTimeButton;

    @FindBy(xpath = "//*[text()='End DateTime']")
    public WebElement endDateTimeButton;

    @FindBy(xpath = "//*[text()='Status']")
    public WebElement statusButton;


    @FindBy(xpath = "//*[text()='Physician']")
    public WebElement physicianButton;

    @FindBy(xpath = "//*[text()='Patient']")
    public WebElement patientButton;

    @FindBy(xpath = "//*[text()='Anamnesis']")
    public WebElement anamnesisButton;

    @FindBy(xpath = "//textarea[@name='anamnesis']")
    public WebElement anamnesisTextButton;

    @FindBy(xpath = "//*[text()='Treatment']")
    public WebElement treatmentButton;

    @FindBy(xpath = "//textarea[@name='treatment']")
    public WebElement treatmentTextButton;

    @FindBy(xpath = "//*[text()='Diagnosis']")
    public WebElement diagnosisButton;

    @FindBy(xpath = "//textarea[@name='diagnosis']")
    public WebElement diagnosisTextButton;

    @FindBy(xpath = "//*[text()='Prescription']")
    public WebElement prescriptionButton;

    @FindBy(xpath = "//textarea[@name='prescription']")
    public WebElement prescriptionTextButton;

    @FindBy(xpath = "//*[text()='Description']")
    public WebElement descriptionButton;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionTextButton;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveButton;

    @FindBy(xpath = "//input[@name]")
    public List<WebElement> IdStartEndTimesTextBoxList;

    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement> hastaBilgileriList;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement upLoadButton;

    @FindBy(xpath = "//*[text()='This field is required.']")
    public WebElement fielRequiredButton;

    @FindBy(xpath = "//select[@name='status']")
    public WebElement statusSelectButton;

    @FindBy(xpath = "(//*[text()='My Inpatients'])[1]")
    public WebElement myInPatientsButton;


    @FindBy(xpath = "//select[@id='in-patient-room']")
    public WebElement roomSelectButton;

















    //enes
    @FindBy(xpath = "//a[@class='btn btn-danger btn-sm']")
    public WebElement showTestResultButton;

    @FindBy(xpath = "//span[@class='d-none d-md-inline']")
    public WebElement viewResultButton;

    @FindBy(xpath = "//button[@class='btn btn-warning btn-sm']")
    public WebElement requestInpatientButton;

























    //kadir




    @FindBy(xpath = "//*[text()='Appointment']")
    public WebElement myInPatientsAppointment;

    @FindBy(xpath = "//*[text()='ID']")
    public WebElement myInPatientsId;

    @FindBy(xpath = "//*[text()='Start Date']")
    public WebElement myInPatientsStartDate;

    @FindBy(xpath = "//*[text()='End Date']")
    public WebElement myInPatientsEndDate;

    @FindBy(xpath = "//*[text()='Status']")
    public WebElement myInPatientsStatus;

    @FindBy(xpath = "//*[text()='Description']")
    public WebElement myInPatientsDescription;

    @FindBy(xpath = "//*[text()='Created Date']")
    public WebElement myInPatientsCreatedDate;

    @FindBy(xpath = "//*[text()='Room']")
    public WebElement myInPatientsRoom;

    @FindBy(xpath = "//*[text()='Patient']")
    public WebElement myInPatientsPatient;

    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement myInPatientsEditButton;

    @FindBy(xpath = "(//div[@class='form-group'])[8]")
    public WebElement myInPatientsStatusBox;

    @FindBy(xpath = "(//div[@class='form-group'])[9]")
    public WebElement myInPatientsRoomSelectBox;


}

