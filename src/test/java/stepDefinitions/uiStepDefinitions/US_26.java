package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_26 {

    AdminPage adminPage;



    @Given("kullanici Medunna adresine gider")
    public void kullanici_medunna_adresine_gider()  {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        ReusableMethods.waitFor(3);

    }
    @Then("contact portalina tiklar")
    public void contact_portalina_tiklar() {
        
    adminPage.contactButton.click();

    }
    @Then("Contact sayfasinin acildigini goruntuler")
    public void contact_sayfasinin_acildigini_goruntuler() {

        Assert.assertTrue(adminPage.contactYazi.isDisplayed());

    }

    @And("Name, Email, Subject, Message bölümlerini doldurur")
    public void nameEmailSubjectMessageBölümleriniDoldurur() {



    }

    @And("send tusuna basar")
    public void sendTusunaBasar() {


    }
}
