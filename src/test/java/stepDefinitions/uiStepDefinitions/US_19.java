package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Methods;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US_19 {


    @Then("Kullanici sing-in sekmesine basar")
    public void kullanici_sing_in_sekmesine_basar() {


    }
    @Then("Kullanici Admin olarak giris yapar")
    public void kullanici_admin_olarak_giris_yapar() {

        Methods.adminGiris();

    }
    @Then("Kullanici Item and Titles den {string} secimi yapar")
    public void kullanici_item_and_titles_den_secimi_yapar(String string) {

        AdminPage adminPage=new AdminPage();
        adminPage.itemButton.click();
       // Select select=new Select(adminPage.itemButton);
       // select.selectByVisibleText("Staff");
        adminPage.staffButton.click();
    }
    @Then("Kullanici Create a new Staff butonuna basar")
    public void kullanici_create_a_new_staff_butonuna_basar() {
        AdminPage adminPage=new AdminPage();
        adminPage.creatButton.click();


    }
    @Then("Kullanici Acilan sayfada SSN kutusuna gecerli staff {string} bilgisini girer")
    public void kullanici_acilan_sayfada_ssn_kutusuna_gecerli_staff_bilgisini_girer(String string) {
        AdminPage adminPage=new AdminPage();
        Actions actions=new Actions(Driver.getDriver());

        ReusableMethods.waitFor(2);
    actions.click(adminPage.ssnSearch).sendKeys(ConfigReader.getProperty("createeSSN")).perform();

    }
    @Then("Kullanici {string} secimi yapar ve {string} butonuna basar")
    public void kullanici_secimi_yapar_ve_butonuna_basar(String string, String string2) {
        AdminPage adminPage=new AdminPage();
        adminPage.useSearchButton.click();
        adminPage.searchUserButton.click();

        ReusableMethods.waitFor(2);

    }
    @Then("Kullanici {string} mesajini gorur")
    public void kullanici_mesajini_gorur(String string) {
        AdminPage adminPage=new AdminPage();
        String expectedResult="User found with search SSN";
        String actualResult=adminPage.alertYazi.getText();

        System.out.println(actualResult);

        Assert.assertTrue(expectedResult.contains(actualResult));

    }
    @Then("Kullanici girmis oldugu SSN bilgisine gore {string} bilgilerini dogrular")
    public void kullanici_girmis_oldugu_ssn_bilgisine_gore_bilgilerini_dogrular(String string) {

        AdminPage adminPage=new AdminPage();

        List<String> actualValue = new ArrayList<>(Arrays.asList(adminPage.staffFirstname.getAttribute("value"),adminPage.staffLastNameButton.getAttribute("value")));
        List<String> expectedValue = new ArrayList<>(Arrays.asList("teamfifthone_9","team51_45"));

        Assert.assertTrue(actualValue.containsAll(expectedValue));

    }

    @And("Kullanici acilan sayfada herhangi bir kullaniciyi goruntuler")
    public void kullaniciAcilanSayfadaHerhangiBirKullaniciyiGoruntuler() {
        AdminPage adminPage=new AdminPage();
        adminPage.viewButton.click();

        
    }

    @And("Kullanici acilan sayfanin {string} sayfasi oldugunu gorur")
    public void kullaniciAcilanSayfaninSayfasiOldugunuGorur(String arg0) {
        AdminPage adminPage=new AdminPage();

        Assert.assertTrue(adminPage.staffYazisi.isDisplayed());
        
    }

    @And("Kullanici acilan sayfada herhangi bir kullanici icin {string} butonuna basar")
    public void kullaniciAcilanSayfadaHerhangiBirKullaniciIcinButonunaBasar(String arg0) {
        AdminPage adminPage=new AdminPage();
        adminPage.editButton.click();
        adminPage.ssnSearch.sendKeys("145-17-126");
        adminPage.staffIDButton.sendKeys("Ali");
        adminPage.staffLastNameButton.sendKeys("Veli");
        adminPage.staffBirthDateBt.sendKeys("20.08.2025 15:00");
        adminPage.staffcreatButton.sendKeys("21.12.2026");
        ReusableMethods.waitFor(3);
        Actions actions=new Actions(Driver.getDriver());

        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();


    }

    @And("Kullanici Staff bilgilerini gunceller ve {string} tusuna basar")
    public void kullaniciStaffBilgileriniGuncellerVeTusunaBasar(String arg0) {
        AdminPage adminPage=new AdminPage();
        adminPage.saveButton.click();

        ReusableMethods.waitFor(2);
    }

    @And("Acilan pencerede {string} uyarisini gorur")
    public void acilanPenceredeUyarisiniGorur(String arg0) {

        AdminPage adminPage=new AdminPage();

        String expectedData="A Staff is updated with identifier";
        String alert= adminPage.alertYazi2.getText().replaceAll("\\D","");
        System.out.println(alert);
        Assert.assertTrue(expectedData.contains(alert));
    }

    @And("Kullanici acilan sayfada herhangi bir kullanici icin {string} butonunanana basar")
    public void kullaniciAcilanSayfadaHerhangiBirKullaniciIcinButonunananaBasar(String arg0) {
        AdminPage adminPage=new AdminPage();
      //  Actions actions=new Actions(Driver.getDriver());
      //  actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();
        adminPage.deleteButton.click();

        ReusableMethods.waitFor(2);
        adminPage.alertDeleteButoon.click();

        ReusableMethods.waitFor(2);
    }

    @And("Acilan pencerede {string} uyarisininini gorur")
    public void acilanPenceredeUyarisinininiGorur(String arg0) {

        AdminPage adminPage=new AdminPage();
        Assert.assertTrue(adminPage.alert3.isDisplayed());



    }
}
