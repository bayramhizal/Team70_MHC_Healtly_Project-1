package stepDefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.PatientPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class US05_06 {
    PatientPage patientPage = new PatientPage();
    Actions actions = new Actions(Driver.driver);
    Faker faker = new Faker();


    @Given("User anasayfaya gider")
    public void user_anasayfaya_gider() {

    }

    @Then("Kullanici sisteme signIn yapar")
    public void kullanici_sisteme_sign_in_yapar() {
        actions.moveToElement(patientPage.ilkAccountMenuSignIn).click().perform();

    }

    @Then("Firstname girer")
    public void firstname_girer() {
        patientPage.firstName.sendKeys(faker.name().firstName());
    }

    @Then("Lastname girer")
    public void lastname_girer() {
        patientPage.lastName.sendKeys(faker.name().lastName());
    }

    @Then("SSN no girer")
    public void ssn_no_girer() {
        patientPage.ssn.sendKeys(faker.numerify(""));
    }

    @Then("On rakamli telefon no girer")
    public void On_rakamli_telefon_no_girer() {
        patientPage.phone.sendKeys(faker.number().digits(10));
    }

    @Then("email adresini girer")
    public void email_adresini_girer() {
        patientPage.email.sendKeys("zubeyr35@gmail.com");
    }

    @Then("Send an appointment Request sekmesini tiklar")
    public void send_an_appointment_request_sekmesini_tiklar() {
        patientPage.sendRequestSubmit.submit();
    }

    @Then("Sag ustteki profil ismini tiklar")
    public void sag_ustteki_profil_ismini_tiklar() {
        actions.moveToElement(patientPage.ikinciSignIn).click().perform();
    }

    @Then("Setting kismini secer")
    public void setting_kismini_secer() throws InterruptedException {
        Thread.sleep(1000);
        patientPage.userName.sendKeys("Mesved");
        patientPage.password.sendKeys("Canberk1975-*-");
        patientPage.submit.click();
    }

    @Then("Kullanici profilini goruntuler")
    public void kullanici_profilini_goruntuler() {
        patientPage.make_an_appointment_text.isDisplayed();

    }

    @Given("Main page gidilir")
    public void main_page_gidilir() {

    }

    @When("Tiklanir accounta")
    public void tiklanir_accounta() {
        actions.moveToElement(patientPage.ilkAccountMenuSignIn).click().perform();
    }

    @Then("Tiklanir signIn")
    public void tiklanir_sign_in() {
        patientPage.ikinciSignIn.click();
    }

    @Then("Username ve password girilir ve submite tiklanir")
    public void username_ve_password_girilir_ve_submite_tiklanir() {
        patientPage.userName.sendKeys("Mesved");

        patientPage.password.sendKeys("Canberk1975-*-");
        patientPage.submit.click();
    }

    @Then("Yine Profil accounta tiklanir")
    public void yine_profil_accounta_tiklanir() throws InterruptedException {
        Thread.sleep(3000);
        patientPage.profilBilgleriniGorme.click();
    }

    @Then("Setting butonu secilir")
    public void setting_butonu_secilir() {
        patientPage.settings.click();
    }

    @Then("firstname lastname ve email guncellenir save butonuna tiklanir")
    public void firstname_lastname_ve_email_guncellenir_save_butonuna_tiklanir() {
        patientPage.firstName.clear();
        patientPage.firstName.sendKeys("james");
        patientPage.lastName.clear();
        patientPage.lastName.sendKeys("bond");
        patientPage.email.clear();
        patientPage.email.sendKeys("zubeyr35@gmail.com");
        patientPage.submit.click();
    }

    @Then("Save edildi yazisi goruntulendigi teyit edilir")
    public void save_edildi_yazisi_goruntulendigi_teyit_edilir() {
        Assert.assertTrue(patientPage.saveTextButonu.isDisplayed());

    }

}
