package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.driver;

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
        adminPage.createANewMessageButton.click();   }

    @Then("Kullanici acilan pencerede yeni bir mesaj olusturur ve save butonuna tiklar")
    public void kullanici_acilan_pencerede_yeni_bir_mesaj_olusturur_ve_save_butonuna_tiklar() {

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
        String message = adminPage.messagesPageMessageAlertYazi.getText();
        System.out.println(message);
        System.out.println(message.length());
        System.out.println(message.substring(41,message.length()));
        message=message.replaceAll("\\D","");
        System.out.println("son mesaj "+message);
        int mesajId= Integer.parseInt(message.replaceAll("\\D",""));

        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);



        WebElement createdMessageViewButton=driver.findElement(By.xpath("(//a[@href=\"/c-message/"+mesajId+"\"])[2]"));
           createdMessageViewButton.click();




    }

    @Then("Kullanıcı olusturdugu mesajin uzerine gelerek viev tusuna basarak mesajin goruntulendigini kontrol eder")
    public void kullanici_olusturdugu_mesajin_uzerine_gelerek_viev_tusuna_basarak_mesajin_goruntulendigini_kontrol_eder() {
       ReusableMethods.waitFor(4);



    }

    @Then("Kullanici olusturdugu mesajin uzerindeki edit tusuna basarak mesaji guncelleyebilmeli")
    public void kullanici_olusturdugu_mesajin_uzerindeki_edit_tusuna_basarak_mesaji_guncelleyebilmeli() {

       adminPage.editButton.click();
        adminPage.editMessageNameButton.click();
        adminPage.editMessageNameButton.sendKeys("kamuran");
        actions.sendKeys(Keys.TAB).sendKeys("kado@gmail.com").
                sendKeys(Keys.TAB).sendKeys("sikayet mesaji diyoruz duyan yokmu").
                sendKeys(Keys.TAB).sendKeys("hadi ama artik acil dedim").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);



    }

    @Then("Kullanici olusturdugu mesajin uzerindeki delete tusuna basarak mesaji silebilmeli")
    public void kullanici_olusturdugu_mesajin_uzerindeki_delete_tusuna_basarak_mesaji_silebilmeli() {
        Assert.assertTrue(adminPage.messagesPageMessageEditAlertYazi.isDisplayed());
        String message2 = adminPage.messagesPageMessageEditAlertYazi.getText();
        System.out.println(message2);
        message2=message2.replaceAll("\\D","");
        System.out.println("son mesaj "+message2);
        int mesaj2Id= Integer.parseInt(message2.replaceAll("\\D",""));

        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.messageButton);
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);

        WebElement deletedMessageViewButton=driver.findElement(By.xpath("(//a[@href=\"/c-message/\"+mesaj2Id+\"/delete\"]"));
        deletedMessageViewButton.click();

    }

}