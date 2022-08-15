package stepDefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PatientPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

import static utilities.Driver.driver;
import static utilities.Driver.getDriver;

public class US05_06 {
    PatientPage patientPage = new PatientPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor js= (JavascriptExecutor) getDriver();
    Faker faker = new Faker();

    @When("Kullanici make an appointment butonuna tiklamali")
    public void kullanici_make_an_appointment_butonuna_tiklamali() {
        patientPage.make_an_appointment.click();
    }
    @When("Kullanici firstname girmelidir")
    public void kullanici_firstname_girmelidir() {
        patientPage.firstName.sendKeys(faker.name().firstName());
    }
    @When("Kullanici lastname girmelidir")
    public void kullanici_lastname_girmelidir() {
        patientPage.lastName.sendKeys(faker.name().lastName());
    }
    @When("Kullanici ssn numarasini girmelidir")
    public void kullanici_ssn_numarasini_girmelidir() {
        patientPage.ssn.sendKeys(faker.numerify("###-##-####"));
    }
    @When("Kullanici email bilgilerini girmelidir")
    public void kullanici_email_bilgilerini_girmelidir() {
        patientPage.email.sendKeys(faker.internet().emailAddress());
    }
    @When("Kullanici on haneli telefon no girmeli")
    public void kullanici_haneli_telefon_no_girmeli() {
        patientPage.phone.sendKeys(faker.numerify("###-###-####"));

    }
    @When("Kullanici send an appointment butonuna tiklamali")
    public void kullanici_send_and_appointment_butonuna_tiklamali() {
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(patientPage.sendRequestSubmit));
        patientPage.sendRequestSubmit.click();
    }
    @Then("Kullanici kaydedildi mesajini gorebilmelidir")
    public void kullanici_kaydedildi_mesajini_gorebilmelidir() {
        Assert.assertTrue(patientPage.TestCase1Assertion.isDisplayed());
    }


    @And("Kullanici send an appointment butonuna tiklamalidir")
    public void kullaniciSendAnAppointmentButonunaTiklamalidir() {
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(patientPage.sendRequestSubmit));
        js.executeScript("arguments[0].click();",patientPage.sendRequestSubmit);
    }

    @Then("kullanici hata mesajlarini almalidir")
    public void kullaniciHataMesajlariniAlmalidir() {
        Assert.assertTrue(patientPage.firstnameInvalidText.isDisplayed());
        Assert.assertTrue(patientPage.lastnameInvalidText.isDisplayed());
        Assert.assertTrue(patientPage.emailInvalidText.isDisplayed());
        Assert.assertTrue(patientPage.ssnInvalidText.isDisplayed());
        Assert.assertTrue(patientPage.phoneInvalidText.isDisplayed());
    }









    @When("Kullanici Sign-in butonuna tiklamali")
    public void kullanici_sign_in_butonuna_tiklamali() {
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(patientPage.accountMenuSigninOncesi));
        patientPage.accountMenuSigninOncesi.click();
        patientPage.ikinciSignIn.click();
    }
    @When("Kullanici username girmelidir")
    public void kullanici_username_girmelidir() {
        patientPage.userName.sendKeys("Mesved");
    }
    @When("Kullanici password girmelidir")
    public void kullanici_password_girmelidir() {
        patientPage.password.sendKeys("Canberk1975-*-");
    }
    @When("Kullanici Signin butonuna tiklamalidir")
    public void kullanici_signin_butonuna_tiklamalidir() {
        patientPage.SifreSonrasiSignin.click();
    }
    @When("Kullanici profil ismine tiklamalidir")
    public void kullanici_profil_ismine_tiklamalidir() {
        patientPage.profilBilgleriniGorme.click();
    }
    @When("Kullanici settings butonuna tiklamalidir")
    public void kullanici_settings_butonuna_tiklamalidir() {
        patientPage.settings.click();
    }
    @When("kullanici adini,soyadini,emailini guncellemelidir")
    public void kullanici_adini_soyadini_emailini_guncellemelidir() {
        patientPage.firstName.clear();
        patientPage.firstName.sendKeys("james");
        patientPage.lastName.clear();
        patientPage.lastName.sendKeys("bond");
        patientPage.email.clear();
        patientPage.email.sendKeys("zubeyr35@gmail.com");

    }
    @When("Kullannici save butonuna tiklamalidir")
    public void kullannici_save_butonuna_tiklamalidir() {
        patientPage.submit.click();
    }
    @Then("Kullanici kaydedildi yazisini gorebilmelidir")
    public void kullanici_kaydedildi_yazisini_gorebilmelidir() {
        Assert.assertTrue(patientPage.saveTextButonu.isDisplayed());
    }


}



