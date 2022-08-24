package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_26 {


    @Given("kullanici Medunna adresine gider")
    public void kullanici_medunna_adresine_gider()  {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        ReusableMethods.waitFor(3);

    }
    @Then("contact portalina tiklar")
    public void contact_portalina_tiklar() {
        AdminPage adminPage=new AdminPage();
    adminPage.contactButton.click();

    }
    @Then("Contact sayfasinin acildigini goruntuler")
    public void contact_sayfasinin_acildigini_goruntuler() {
        AdminPage adminPage=new AdminPage();
        Assert.assertTrue(adminPage.contactYazi.isDisplayed());
        ReusableMethods.waitFor(2);

    }

    @And("Name, Email, Subject, Message bölümlerini doldurur")
    public void nameEmailSubjectMessageBolumleriniDoldurur() {

        Actions actions=new Actions(Driver.getDriver());
        AdminPage adminPage=new AdminPage();
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        actions.click(adminPage.nameButonu).sendKeys("Veli", Keys.TAB,"velimeli@gmail.com",Keys.TAB ,"Sikayet",Keys.TAB,
                "Kan tahlili sonucumun gecikmesi").perform();

        ReusableMethods.waitFor(3);

    }

    @And("send tusuna basar")
    public void sendTusunaBasar() {

        AdminPage adminPage=new AdminPage();
        adminPage.sendButonu.click();

    }
}
