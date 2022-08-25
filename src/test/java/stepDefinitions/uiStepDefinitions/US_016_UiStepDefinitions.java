package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.IOException;
import java.util.List;

import static utilities.ReusableMethods.*;

public class US_016_UiStepDefinitions {
    AdminPage adminPage = new AdminPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


    @Then("Kullanici Admin olarak sisteme giris yapar")
    public void kullanici_admin_olarak_sisteme_giris_yapar() {
        adminPage.usernameAdmin.sendKeys(ConfigReader.getProperty("adminUsername"));
        adminPage.passwordAdmin.sendKeys(ConfigReader.getProperty("adminPassword"));
        adminPage.signInButton2.click();
    }

    @Then("Kullanici Item&Title sekmesine gider Room elementini tiklar")
    public void kullanici_item_title_sekmesine_gider_room_elementini_tiklar() {
        adminPage.ItemsTitle.click();
        adminPage.romms.click();
    }

    @Then("Create a new Room sekmesine tiklar")
    public void create_a_new_room_sekmesine_tiklar() {
        adminPage.createANewButton.click();
    }

    @Given("Create or edit a Room yazisinin gorunur oldugunu test eder")
    public void create_or_edit_a_room_yazisinin_gorunur_oldugunu_test_eder() {
        adminPage.createRoom.isDisplayed();
    }

    @Given("Kullanici Room Number sekmesinin zorunlu alan oldugunu test eder\\(This field is required.)")
    public void kullaniciRoomNumberSekmesininZorunluAlanOldugunuTestEderThisFieldIsRequired() {
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.savedButton);
        jse.executeScript("arguments[0].click();", adminPage.savedButton);


        String expectedResult = "This field is required.";
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.rommZorunlu);
        String actualResult = adminPage.rommZorunlu.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Then("Kullanici Room Number sekmesine rakam ve harfler olusan deger girer \\(This field should be a number.)")
    public void kullaniciRoomNumberSekmesineRakamVeHarflerOlusanDegerGirerThisFieldShouldBeANumber() {
        adminPage.roomNumber.sendKeys(ConfigReader.getProperty("roomInvalidDeger"));
        String expectedResult = "This field should be a number.";
        String actualResult = adminPage.roomUyariRakamHarf.getText();
        Assert.assertEquals(expectedResult, actualResult);
        adminPage.roomNumber.clear();
        waitFor(2);
        adminPage.roomNumber.sendKeys(ConfigReader.getProperty("roomInvalidDeger2"));
        String expectedResult2 = "This field should be a number.";
        String actualResult2 = adminPage.roomUyariRakamHarf.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @And("Kullanici Room Types secerek butun opsiyonlari gorur")
    public void kullaniciRoomTypesSecerekButunOpsiyonlariGorur() {
        Select select = new Select(adminPage.roomTypeSelect);
        select.selectByVisibleText("TWIN");
        System.out.println(select.getFirstSelectedOption().getText());
        waitFor(1);
        select.selectByVisibleText("DELUXE");
        System.out.println(select.getFirstSelectedOption().getText());
        waitFor(1);
        select.selectByVisibleText("SUITE");
        System.out.println(select.getFirstSelectedOption().getText());
        waitFor(1);
        select.selectByVisibleText("DAYCARE");
        System.out.println(select.getFirstSelectedOption().getText());
        waitFor(1);
        List<WebElement> optionList = select.getOptions();
        System.out.println("==============================");
        System.out.println(getElementsText(optionList));

    }

    @Given("Kullanici Status sekmesini bulur")
    public void kullaniciStatusSekmesiniBulur() {
        Assert.assertTrue(adminPage.status3.isDisplayed());
    }

    @And("Kullanici Status sekmesinin secilebilir oldugunu test eder")
    public void kullaniciStatusSekmesininSecilebilirOldugunuTestEder() {
        Assert.assertFalse(adminPage.status3.isSelected());
    }

    @Given("Price text boxu bulunur once deger girilmeden zorunlu alan oldugu test edilir")
    public void priceTextBoxuBulunurOnceDegerGirilmedenZorunluAlanOlduguTestEdilir() {
        adminPage.price.click();

        waitFor(4);
        adminPage.status2.click();
        waitFor(2);

        String expectedData = "This field is required.";
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.priceZorunlu);
        String actualData = adminPage.priceZorunlu.getText();
        Assert.assertEquals(expectedData, actualData);
    }

    @Then("Kullanici Price text boxina rakam ve harflerden olusan deger girer")
    public void kullaniciPriceTextBoxinaRakamVeHarflerdenOlusanDegerGirer() {
        adminPage.price.sendKeys(ConfigReader.getProperty("pricesInvalid"));
    }

    @And("Kullanici \\(This field should be at least .) yazisini dogrular")
    public void kullaniciThisFieldShouldBeAtLeastYazisiniDogrular() {

        String expectedData = "This field should be at least 0.";
        String actualData = adminPage.priceUyariRakamHarf.getText();

        Assert.assertEquals(expectedData, actualData);
    }

    @Given("Kullanici Description kutucugunu bulur")
    public void kullaniciDescriptionKutucugunuBulur() {
        adminPage.descriptionTextButton.isDisplayed();
    }

    @Then("Kullanici Description zorunlu alan olmadigini test eder")
    public void kullaniciDescriptionZorunluAlanOlmadiginiTestEder() {
        adminPage.descriptionTextButton.sendKeys("dfefedg");
    }

    @Given("Kullanici Created Date elementini bulur")
    public void kullaniciCreatedDateElementiniBulur() {
        adminPage.createdDatee.isDisplayed();
    }


    @And("Kullanici gecmis bir tarihle  oda olusturalamayacagini gorur")
    public void kullaniciGecmisBirTarihleOdaOlusturalamayacaginiGorur() throws IOException {
        jse.executeScript("arguments[0].scrollIntoView(true);", adminPage.savedButton);
        jse.executeScript("arguments[0].click();", adminPage.savedButton);
        Assert.assertTrue(adminPage.alertButton.isDisplayed());
        getScreenshot("Admin tarih geri ayarlamamali");

    }


    @And("Kullanici gecmis bir tarihi ayarlar ve saved butonuna basar")
    public void kullaniciGecmisBirTarihiAyarlarVeSavedButonunaBasar() {
        adminPage.roomNumber.sendKeys("21599");
        adminPage.status3.click();
        adminPage.price.sendKeys("359");
        adminPage.descriptionTextButton.sendKeys("team70");
        adminPage.createdDatee.sendKeys("08121988");
    }

    @Then("Kullanici tarih sablonunu Gun-Ay-Yil seklinde oldugunu kontrol eder")
    public void kullaniciTarihSablonunuGunAyYilSeklindeOldugunuKontrolEder() {
        System.out.println(adminPage.createdDatee.getAttribute("value"));
    }

    @Given("Kullanici RoomType basligini bulur ve tiklar")
    public void kullaniciRoomTypeBasliginiBulurVeTiklar() {
        Driver.getDriver().navigate().back();
        adminPage.roomTypeBaslik.click();

    }

    @Then("Kullanici oda turlerinin alt alta siralandigini gorur")
    public void kullaniciOdaTurlerininAltAltaSiralandiginiGorur() {
        System.out.println(getElementsText(adminPage.roomTypList));
    }

    @Given("Kullanici Room Type elementini bulur ve tiklar")
    public void kullaniciRoomTypeElementiniBulurVeTiklar() {
        adminPage.roomTypeSelect.isDisplayed();


    }

    @Then("Kullanici oda turlerinin secilebilir oldugunu gorur ve opsiyonu degistirebilir")
    public void kullaniciOdaTurlerininSecilebilirOldugunuGorurVeOpsiyonuDegistirebilir() {
        Select select = new Select(adminPage.roomTypeSelect);
        System.out.println(getElementsText(select.getOptions()));
        select.selectByVisibleText("DELUXE");
        System.out.println(select.getFirstSelectedOption().getText());
    }

    @Given("Admin silmek istedigi hastayi bulur ve siler")
    public void adminSilmekIstedigiHastayiBulurVeSiler() {
        Driver.getDriver().navigate().back();
        jse.executeScript("arguments[0].scrollIntoView(true);",adminPage.sayfaDegistir);
        jse.executeScript("arguments[0].click();",adminPage.sayfaDegistir);
        waitFor(2);
        jse.executeScript("arguments[0].scrollIntoView(true);",adminPage.sayfaDegistir);
        jse.executeScript("arguments[0].click();",adminPage.sayfaDegistir);
        waitFor(2);
        jse.executeScript("arguments[0].scrollIntoView(true);",adminPage.sayfaDegistir);
        jse.executeScript("arguments[0].click();",adminPage.sayfaDegistir);
        waitFor(2);
        jse.executeScript("arguments[0].scrollIntoView(true);",adminPage.sayfaDegistir);
        jse.executeScript("arguments[0].click();",adminPage.sayfaDegistir);
        waitFor(2);
        jse.executeScript("arguments[0].scrollIntoView(true);",adminPage.deleteHasta);
        jse.executeScript("arguments[0].click();",adminPage.deleteHasta);


    }
}
