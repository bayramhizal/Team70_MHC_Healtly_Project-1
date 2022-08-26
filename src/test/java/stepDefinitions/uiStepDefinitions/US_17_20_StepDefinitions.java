package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.TestItemPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static utilities.ReusableMethods.*;

public class US_17_20_StepDefinitions {
    TestItemPage testItem = new TestItemPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    Actions actions = new Actions(Driver.getDriver());

    @Given("Admin Medunna Anasayfaya gider")
    public void admin_medunna_anasayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @When("Admin kullanici iknonuna tiklar")
    public void admin_kullanici_iknonuna_tiklar() {
        testItem.kullaniciResmibutonu.click();
    }

    @Then("Admin sign in butonuna tiklar")
    public void admin_sign_in_butonuna_tiklar() {
        testItem.signInButton.click();
    }

    @Then("Admin kendi Username ve Password bilgileri ile giris yapar")
    public void admin_kendi_username_ve_password_bilgileri_ile_giris_yapar() {
        testItem.usernameBox.sendKeys("adminahmpar");
        testItem.passwordBox.sendKeys("Adana01");
        testItem.signInButton2.click();
        waitFor(1);
    }

    @Then("Admin Item&Titles butonuna basar")
    public void admin_item_titles_butonuna_basar() {
        waitFor(2);

        jse.executeScript("arguments[0].scrollIntoView(true);", testItem.itemsTitlesButton);
        jse.executeScript("arguments[0].click();", testItem.itemsTitlesButton);

    }

    @Then("Admin acilan Drop Downdan Test item'i secer")
    public void admin_acilan_drop_downdan_test_item_i_secer() {
        waitFor(1);
        jse.executeScript("arguments[0].click();", testItem.testItem);
    }

    @Given("Admin acilan yeni pencerenin Test Items penceresi oldugunu gorur")
    public void admin_acilan_yeni_pencerenin_test_items_penceresi_oldugunu_gorur() {
        assertTrue(testItem.testItemText.isDisplayed());
    }

    @Then("Admin Create a new Test Item butonuna basar")
    public void admin_create_a_new_test_item_butonuna_basar() {
        waitFor(1);
        testItem.createAnewTestItem.click();
    }

    @Given("Admin {string},{string}, {string}, {string}, {string}  ve {string} metin kutucuklarinin oldugunu gorur")
    public void admin_ve_metin_kutucuklarinin_oldugunu_gorur(String name, String description, String price,
                                                             String defaultMinValue, String defaultMaxValue, String createdDate) {
        waitFor(2);
        System.out.println("testItem.testItemNameBox.getText() = " + testItem.testItemNameText.getText());
        System.out.println("testItem.testItemDescriptionBox = " + testItem.testItemDescriptionText.getText());
        System.out.println("testItem.testItemPriceBox.getText() = " + testItem.testItemPriceText.getText());
        System.out.println("testItem.testItemdefaultValMinBox = " + testItem.testItemDefaultValMinText.getText());
        System.out.println("testItem.testItemdefaultValMaxBox.getText() = " + testItem.testItemDefaultValMaxText.getText());
        System.out.println("testItem.testItemdecreatedDateBox.getText() = " + testItem.testItemCreatedDateText.getText());

        assertTrue(testItem.testItemNameText.getText().contains(name));
        assertTrue(testItem.testItemDescriptionText.getText().contains(description));
        assertTrue(testItem.testItemPriceText.getText().contains(price));
        assertTrue(testItem.testItemDefaultValMinText.getText().contains(defaultMinValue));
        assertTrue(testItem.testItemDefaultValMaxText.getText().contains(defaultMaxValue));
        assertTrue(testItem.testItemCreatedDateText.getText().contains(createdDate));
    }


    @Given("Admin MedunnaUrl Anasayfaya gider")
    public void adminMedunnaUrlAnasayfayaGider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @And("Admin acilan sayfanin Create or edit a Test Item oldugunu gorur")
    public void adminAcilanSayfaninCreateOrEditATestItemOldugunuGorur() {
        waitFor(1);
        assertTrue(testItem.createOrEditATestItemPage.isDisplayed());
    }

    @Then("Admin {string},{string}, {string}, {string}, {string}  ve {string} bilgilerini yazar")
    public void adminVeBilgileriniYazar(String name, String description, String price,
                                        String defaultMinValue, String defaultMaxValue, String createdDate) {
        testItem.testItemNameBox.sendKeys(name);
        testItem.testItemDescriptionBox.sendKeys(description);
        testItem.testItemPriceBox.sendKeys(price);
        testItem.testItemdefaultValMinBox.sendKeys(defaultMinValue);
        testItem.testItemdefaultValMaxBox.sendKeys(defaultMaxValue);
        //   actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        //   testItem.testItemdecreatedDateBox.sendKeys(createdDate);
        waitFor(1);

    }

    @And("Admin Save tusuna basar acilan sayfada olusturdugu test Item'in bilgilerinin dogru oldugunu gorur")
    public void adminSaveTusunaBasarAcilanSayfadaOlusturduguTestItemInBilgilerininDogruOldugunuGorur() {
        jse.executeScript("arguments[0].scrollIntoView(true);", testItem.testItemSave);
        jse.executeScript("arguments[0].click();", testItem.testItemSave);
        waitFor(3);
        testItem.createdDateSiralamaButonu.click();
        waitFor(1);
        List<String> testItemsList = new ArrayList<>();
        for (WebElement each : testItem.listOfTestItemsName
        ) {
            testItemsList.add(each.getText());
        }
        System.out.println(testItemsList);
        assertTrue(testItemsList.contains("ZuckerUi"));

        //    System.out.println(Driver.getDriver().switchTo().alert().getText());
        //    assertTrue(Driver.getDriver().switchTo().alert().getText().contains("error."));

    }

    @And("Admin Test Item sayfasinda olusturdu Test Item'in yaninda bulunan Edit butonuna basar")
    public void adminTestItemSayfasindaOlusturduTestItemInYanindaBulunanEditButonunaBasar() {
        waitFor(1);
        testItem.testItemsEdit.click();
    }

    @And("Admin {string},{string}, {string}, {string}, ve {string} bilgilerini girerek test item'i gunceller")
    public void adminVeBilgileriniGirerekTestItemIGunceller(String name, String description, String price,
                                                            String defaultMinValue, String defaultMaxValue) {
        waitFor(2);
        testItem.testItemNameBox.clear();
        testItem.testItemNameBox.sendKeys(name);
        testItem.testItemDescriptionBox.clear();
        testItem.testItemDescriptionBox.sendKeys(description);
        testItem.testItemPriceBox.clear();
        testItem.testItemPriceBox.sendKeys(price);
        testItem.testItemdefaultValMinBox.clear();
        testItem.testItemdefaultValMinBox.sendKeys(defaultMinValue);
        testItem.testItemdefaultValMaxBox.clear();
        testItem.testItemdefaultValMaxBox.sendKeys(defaultMaxValue);
    }

    @And("Admin Save tusuna basar ve acilan sayfada Edit ettigi Test Item'i {string} gorur")
    public void adminSaveTusunaBasarVeAcilanSayfadaEditEttigiTestItemIGorur(String name) {
        jse.executeScript("arguments[0].scrollIntoView(true);", testItem.testItemSave);
        jse.executeScript("arguments[0].click();", testItem.testItemSave);
        waitFor(3);
        List<String> testItemsEditList = new ArrayList<>();
        for (WebElement each : testItem.listOfTestItemsName
        ) {
            testItemsEditList.add(each.getText());
        }
        System.out.println(testItemsEditList);
        assertTrue(testItemsEditList.contains(name));
    }

    @And("Admin en son guncelledigi Test Item'i siler ve olmadigini gorur")
    public void adminEnSonGuncelledigiTestItemISilerVeOlmadiginiGorur() {
        jse.executeScript("arguments[0].scrollIntoView(true);", testItem.testItemsDelete);
        jse.executeScript("arguments[0].click();", testItem.testItemsDelete);
        waitFor(1);
        jse.executeScript("arguments[0].scrollIntoView(true);", testItem.warningDelete);
        jse.executeScript("arguments[0].click();", testItem.warningDelete);
        waitFor(2);
        testItem.createdDateSiralamaButonu.click();
        waitFor(2);
        testItem.createdDateSiralamaButonu.click();
        waitFor(2);
        List<String> testItemsDeleteList = new ArrayList<>();
        for (WebElement each : testItem.listOfTestItemsName
        ) {
            testItemsDeleteList.add(each.getText());
        }
        System.out.println(testItemsDeleteList);
        assertFalse(testItemsDeleteList.contains("OhneZucker"));

    }

    @And("Admin Administration butonuna basar")
    public void adminAdministrationButonunaBasar() {
        waitFor(2);

        jse.executeScript("arguments[0].scrollIntoView(true);", testItem.administrationButton);
        jse.executeScript("arguments[0].click();", testItem.administrationButton);
    }

    @And("Admin acilan Drop Downdan User Management secer")
    public void adminAcilanDropDowndanUserManagementSecer() {
        waitFor(1);
        jse.executeScript("arguments[0].click();", testItem.userManagement);
    }

    @And("Admin olusturulan User'in login Name {string} ile Edit butonuna basar")
    public void adminOlusturulanUserInLoginNameIleEditButonunaBasar(String loginName) {
        waitForVisibility(testItem.createANewUser,5);
        jse.executeScript("arguments[0].click();", testItem.createANewUser);
        waitForVisibility(testItem.createUserLoginBox,5);
      //  jse.executeScript("arguments[0].click();", testItem.createUserLoginBox);
        testItem.createUserLoginBox.sendKeys("team70_us20");
        testItem.createUserFirstnameBoxBos.sendKeys("ahmet");
        testItem.createUserLastnameBoxBos.sendKeys("koru");
        testItem.createUserEmailBoxBos.sendKeys("ahr@gsmail.com");
        testItem.createUserSsnBox.sendKeys("475-85-1569");

        jse.executeScript("arguments[0].scrollIntoView(true);", testItem.createUserSaveButton);
        jse.executeScript("arguments[0].click();", testItem.createUserSaveButton);

        waitFor(2);
        jse.executeScript("arguments[0].click();", testItem.usersModifiedDate);
        waitForVisibility(testItem.userEditButton,5);
        jse.executeScript("arguments[0].click();", testItem.userEditButton);


    }
    @Then("Admin olusturdugu kullaniciyi siler")
    public void adminOlusturduguKullaniciyiSiler() {
        jse.executeScript("arguments[0].scrollIntoView(true);", testItem.createUserBackButton);
        jse.executeScript("arguments[0].click();", testItem.createUserBackButton);

        waitFor(2);
        jse.executeScript("arguments[0].click();", testItem.usersModifiedDate);
        waitForVisibility(testItem.userDeleteButton,5);
        jse.executeScript("arguments[0].click();", testItem.userDeleteButton);
        waitFor(1);
        jse.executeScript("arguments[0].click();", testItem.userWarningDelete);
        waitFor(1);

    }

    @And("Admin kayitli kullanicilarin {string},{string}, {string} gibi bilgilerini gorur")
    public void adminKayitliKullanicilarinGibiBilgileriniGorur(String name, String lastname, String email) {
        waitFor(2);
        assertTrue(testItem.createUserFirstnameBox.getAttribute("value").contains(name));
        assertTrue(testItem.createUserLastnameBox.getAttribute("value").contains(lastname));
        assertTrue(testItem.createUserEmailBox.getAttribute("value").contains(email));
    }

    @When("Admin kullanicinin Activated kutucugunun secili oldugunu gorur")
    public void adminKullanicininActivatedKutucugununSeciliOldugunuGorur() {
        waitFor(2);
        assertTrue(testItem.createUserCheckbox.getAttribute("value").contains("true"));
    }

    @When("Admin kullanicinin Activated kutucuguna bir kez tiklar ve kutucugun secili olmadigini gorur")
    public void adminKullanicininActivatedKutucugunaBirKezTiklarVeKutucugunSeciliOlmadiginiGorur() {
        clickWithJScript(testItem.createUserCheckbox);
        waitForVisibility(testItem.createUserCheckbox,5);
        assertTrue(testItem.createUserCheckbox.getAttribute("value").contains("false"));
    }


    @Then("Admin kullanicinin Activated kutucuguna bir kez daha tiklar ve kutucugun tekrar secili oldugunu gorur")
    public void adminKullanicininActivatedKutucugunaBirKezDahaTiklarVeKutucugunTekrarSeciliOldugunuGorur() {
        clickWithJScript(testItem.createUserCheckbox);
        waitForVisibility(testItem.createUserCheckbox,5);
        assertTrue(testItem.createUserCheckbox.getAttribute("value").contains("true"));
    }

    @And("Admin Profiles Drop Down sekmesinden {string} secer ve Save tusuna basar")
    public void adminProfilesDropDownSekmesindenSecerVeSaveTusunaBasar(String roleAdmin) {
        jse.executeScript("arguments[0].scrollIntoView(true);", testItem.createUserProfileSelect);
        selectAnItemFromDropdown(testItem.createUserProfileSelect,roleAdmin);
        waitFor(1);
        clickWithJScript(testItem.createUserSaveButton);


    }

    @And("Admin edit ettigi kullanicinin Aktivated ve Profilinin {string} oldugunu gorur ve daha sonra Edit tusuna basar")
    public void adminAcilanEditEttigiKullanicininAktivatedVeProfilininOldugunuGorurVeDahaSonraEditTusunaBasar(String role) {
        waitFor(2);
        jse.executeScript("arguments[0].click();", testItem.usersModifiedDate);
        waitFor(2);
        System.out.println("Profil " + testItem.userProfilesRole.getText());
        assertTrue(testItem.userActivatedYesil.isDisplayed());
        assertEquals(role,testItem.userProfilesRole.getText());
        clickWithJScript(testItem.userEditButton);
        waitFor(2);
        Select select = new Select(testItem.createUserProfileSelect);
        select.deselectByVisibleText(role);
        waitFor(1);
    }

    @And("Admin edit ettigi kullanicinin Aktivated ve Profilinin {string} oldugunu gorur")
    public void adminEditEttigiKullanicininAktivatedVeProfilininOldugunuGorur(String role) {
        waitFor(2);
        jse.executeScript("arguments[0].click();", testItem.usersModifiedDate);
        waitFor(2);
        System.out.println("Profil " + testItem.userProfilesRole.getText());
        assertTrue(testItem.userActivatedYesil.isDisplayed());
        assertEquals(role,testItem.userProfilesRole.getText());
    }

    @And("Admin ROLE_PHYSICIAN olan kullaniciyi sorunsuz siler")
    public void adminROLE_PHYSICIANOlanKullaniciyiSorunsuzSiler() {
        waitForVisibility(testItem.userDeleteButton,5);
        jse.executeScript("arguments[0].click();", testItem.userDeleteButton);
        waitFor(1);
        jse.executeScript("arguments[0].click();", testItem.userWarningDelete);
        waitFor(1);
    }
}