package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_27 {

    @Given("kullanici Medunna adresine gider")
    public void kullaniciMedunnaAdresineGider() {
    }

    AdminPage adminPage = new AdminPage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Then("Kullanıcı sayfanın altındakı messages butonuna tıklar")
    public void kullanici_sayfanin_altindaki_messages_butonuna_tiklar() {

        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        jse.executeScript("arguments[0].click();", adminPage.messageButton);
        ReusableMethods.waitFor(2);


    }

    @Then("Kullanıcı mesajlar sayfasının goruntulendıgını kontrol eder")
    public void kullanici_mesajlar_sayfasinin_goruntulendigini_kontrol_eder() {
        Assert.assertTrue(adminPage.messagesPage.isDisplayed());


    }

    @Then("Kullanıcı mesaj portalında tum mesajları yazarlarını ve e postaların goruntulenebılır oldugunu kontrol eder")
    public void kullanici_mesaj_portalinda_tum_mesajlari_yazarlarini_ve_e_postalarin_goruntulenebilir_oldugunu_kontrol_eder() {
        Assert.assertTrue(adminPage.messagesPageIdButton.isDisplayed());
        Assert.assertTrue(adminPage.messagesPageEmailButton.isDisplayed());
        Assert.assertTrue(adminPage.messagesPageSubjectButton.isDisplayed());
        Assert.assertTrue(adminPage.messagesPageNameButton.isDisplayed());
        Assert.assertTrue(adminPage.messagesPageMessageButton.isDisplayed());


    }

    //Test Case 2


    @Then("Kullanici Create a new message butonunu tiklar")
    public void kullanici_create_a_new_message_butonunu_tiklar() {
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        jse.executeScript("arguments[0].click();", adminPage.messageButton);
        ReusableMethods.waitFor(2);

    }

    @Then("Kullanici acilan pencerede yeni bir mesaj olusturur ve save butonuna tiklar")
    public void kullanici_acilan_pencerede_yeni_bir_mesaj_olusturur_ve_save_butonuna_tiklar() {
        adminPage.createANewMessageButton.click();
        adminPage.createMessagePageNameButton.click();
        adminPage.createMessagePageNameButton.sendKeys("Ali");
        actions.sendKeys(Keys.TAB).sendKeys("kado@gmail.com").
                sendKeys(Keys.TAB).sendKeys("sikayet mesaji").
                sendKeys(Keys.TAB).sendKeys("lutfen sikayetmi duzeltin").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();


    }

    @Then("Kullanici olusturulan mesajin kaydedildigini kontrol eder")
    public void kullanici_olusturulan_mesajin_kaydedildigini_kontrol_eder() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(adminPage.messagesPageMessageAlertYazi.isDisplayed());


    }

    @Then("Kullanıcı olusturdugu mesajin uzerine gelerek viev tusuna basarak mesajin goruntulendigini kontrol eder")
    public void kullanici_olusturdugu_mesajin_uzerine_gelerek_viev_tusuna_basarak_mesajin_goruntulendigini_kontrol_eder() {


    }

    @Then("Kullanici olusturdugu mesajin uzerindeki edit tusuna basarak mesaji guncelleyebilmeli")
    public void kullanici_olusturdugu_mesajin_uzerindeki_edit_tusuna_basarak_mesaji_guncelleyebilmeli() {


    }

    @Then("Kullanici olusturdugu mesajin uzerindeki delete tusuna basarak mesaji guncelleyebilmeli")
    public void kullanici_olusturdugu_mesajin_uzerindeki_delete_tusuna_basarak_mesaji_guncelleyebilmeli() {


    }


}