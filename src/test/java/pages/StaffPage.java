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



























































 //Enes    100-159



























































// Serhan 160-219



























































}
