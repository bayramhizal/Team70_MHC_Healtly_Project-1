package stepDefinitions.uiStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.MedunnaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US01_02 {

    MedunnaPage medunnaPage=new MedunnaPage();
    Actions action;
    Select select;
    Faker faker;
    ReusableMethods reusable;
    SoftAssert softAssert;
    JavascriptExecutor js;

    @Given("kullanici ana sayfaya gider")
    public void kullanici_ana_sayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @Given("kullanici ikonu altinda yer alan register butonuna tiklar")
    public void kullanici_ikonu_altinda_yer_alan_register_butonuna_tiklar() {
        medunnaPage.accountLinki.click();
        medunnaPage.registerLink.click();
    }

    @Given("kullanici SSN kutucuguna tiklar")
    public void kullanici_ssn_kutucuguna_tiklar() {
        Driver.getDriver().navigate().refresh();
        medunnaPage.ssnTextbox.click();
        reusable=new ReusableMethods();
        reusable.waitFor(5);
    }


    @Then("Your SSN is invalid uyari mesajinin goruntulenmedigini dogrular")
    public void your_ssn_is_invalid_uyari_mesajinin_goruntulenmedigini_dogrular() {
        Assert.assertTrue( medunnaPage.ssnValidForm.isDisplayed() );
        Assert.assertTrue( medunnaPage.ssnValidForm.isEnabled() );
        reusable=new ReusableMethods();
        reusable.waitFor(3);
    }

    // @Then("Kullanici SSN kutucuguna sadece harf ve özel karakter girer")
    // public void kullanici_ssn_kutucuguna_sadece_harf_ve_özel_karakter_girer() {



    @Then("Your SSN is invalid uyari mesajinin goruntulendigini dogrular")
    public void your_ssn_is_invalid_uyari_mesajinin_goruntulendigini_dogrular() {
        Assert.assertTrue(medunnaPage.ssnInvalidMessage.isDisplayed());
        reusable=new ReusableMethods();
        reusable.waitFor(5);
    }



    @Then("Kullanici herhangi bir uyari yazisi alinmadigini dogrular")
    public void kullanici_herhangi_bir_uyari_yazisi_alinmadigini_dogrular() {

    }

    @Given("kullanici kutucugu bos birakir")
    public void kullanici_kutucugu_bos_birakir() {
       // medunnaPage.ssnTextbox.sendKeys(ConfigReader.getProperty("firstnameBos"));
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.ssnTextbox).sendKeys(Keys.TAB).perform();
    }

    @Then("Your SSN is required uyari mesajinin goruntulendigini dogrular")
    public void your_ssn_is_required_uyari_mesajinin_goruntulendigini_dogrular() {
        Assert.assertTrue(medunnaPage.ssnRequiredMessage.isDisplayed());
    }


    @And("Kullanici SSN kutucuguna on rakam girer. Uc ve besinci rakamdan sonra - karakterini ekler")
    public void kullaniciSSNKutucugunaOnRakamGirerUcVeBesinciRakamdanSonraKarakteriniEkler() {
        Driver.getDriver().navigate().refresh();
        medunnaPage.ssnTextbox.sendKeys(ConfigReader.getProperty("SSNonbasamakli"));
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.ssnTextbox).sendKeys(Keys.TAB).perform();
        reusable=new ReusableMethods();
        reusable.waitFor(5);
    }

    @And("Kullanici SSN kutucuguna dokuz rakam girer. Uc ve besinci rakamdan sonra - karakterini eklemez")
    public void kullaniciSSNKutucugunaDokuzRakamGirerUcVeBesinciRakamdanSonraKarakteriniEklemez() {
        Driver.getDriver().navigate().refresh();
        medunnaPage.ssnTextbox.sendKeys(ConfigReader.getProperty("SSNdokuzbasamakliGecersiz"));
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.ssnTextbox).sendKeys(Keys.TAB).perform();
        reusable=new ReusableMethods();
        reusable.waitFor(5);
    }

    @And("Kullanici SSN kutucuguna dokuz rakam girer. Uc ve besinci rakamdan sonra - karakterini ekler")
    public void kullaniciSSNKutucugunaDokuzRakamGirerUcVeBesinciRakamdanSonraKarakteriniEkler() {

    }


   // @Given("kullanici First Name kutucuğuna tiklar ardindan bos birakir")
   // public void kullaniciFirstNameKutucuğunaTiklarArdindanBosBirakir() {


    @And("Your FirstName is required uyari mesajinin goruntulendigini dogrular")
    public void yourFirstNameIsRequiredUyariMesajininGoruntulendiginiDogrular() {
        Assert.assertTrue( medunnaPage.firstnameRequiredMessage.isDisplayed() );
    }

    @And("Kullanici herhangi bir karakter veya karakterler girer")
    public void kullaniciHerhangiBirKarakterVeyaKarakterlerGirer() {
        Driver.getDriver().navigate().refresh();
        medunnaPage.firstnameTextbox.click();
        medunnaPage.firstnameTextbox.sendKeys(ConfigReader.getProperty("firstnameGecerli"));
        reusable=new ReusableMethods();
        reusable.waitFor(4);
    }

    // @Then("Your FirstName is required uyarı mesajinin alinmadigini dogrular")
   // public void yourFirstNameIsRequiredUyarıMesajininAlinmadiginiDogrular() {



    @And("kullanici First Name kutucugunu doldurarak alt kutucuga gecer")
    public void kullaniciFirstNameKutucugunuDoldurarakAltKutucugaGecer() {
        action=new Actions(Driver.getDriver());
        Driver.getDriver().navigate().refresh();
        action.click(medunnaPage.firstnameTextbox)
                .sendKeys(Keys.DELETE).sendKeys(Keys.DELETE).sendKeys(Keys.DELETE).sendKeys(Keys.DELETE)
                .sendKeys(Keys.DELETE).sendKeys(Keys.DELETE).sendKeys(Keys.DELETE).sendKeys(Keys.DELETE)
                .sendKeys(Keys.DELETE).sendKeys(Keys.DELETE).sendKeys(Keys.DELETE).sendKeys(Keys.DELETE).sendKeys(Keys.DELETE)
                .sendKeys(ConfigReader.getProperty("firstnameGecerli"))
                .sendKeys(Keys.TAB)
                .perform();
    }

    @And("Your LastName is required uyari mesajinin goruntulendigini dogrular")
    public void yourLastNameIsRequiredUyariMesajininGoruntulendiginiDogrular() {
        Assert.assertTrue( medunnaPage.lastnameRequiredMessage.isDisplayed() );
    }

    @Then("Your LastName is required uyari mesajinin alinmadigini dogrular")
    public void yourLastNameIsRequiredUyariMesajininAlinmadiginiDogrular() {
        Assert.assertTrue(medunnaPage.firstnameValidForm.isDisplayed());
    }

    @And("kullanici Last Name kutucugunu doldurarak alt kutucuga gecer")
    public void kullaniciLastNameKutucugunuDoldurarakAltKutucugaGecer() {
        action=new Actions(Driver.getDriver());
        Driver.getDriver().navigate().refresh();
        action.click(medunnaPage.lastnameTextbox).sendKeys(ConfigReader.getProperty("lastnameGecerli"))
                .sendKeys(Keys.TAB)
                .perform();
    }


    // @And("Your email is required to be at least {int}characters uyarı mesajının görüntülendigini dogrular")
    // public void yourEmailIsRequiredToBeAtLeastCharactersUyarıMesajınınGörüntülendiginiDogrular(int arg0) {


    @Given("Kullanici User Name kutucuguna tiklar")
    public void kullaniciUserNameKutucugunaTiklar() {
        medunnaPage.usernameTextbox.click();
    }

    @And("Kullanici bos birakir ve alt satira gecer")
    public void kullaniciBosBirakirVeAltSatiraGecer() {
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.usernameTextbox).sendKeys(Keys.TAB).perform();
    }

    @Then("Your username is required uyari mesajinin goruntulendigini dogrular")
    public void yourUsernameIsRequiredUyariMesajininGoruntulendiginiDogrular() {
        Assert.assertTrue(medunnaPage.usernameRequiredMessage.isDisplayed());
    }

    @And("kullanici harflerden olusan bir karakter veya karakterler girer")
    public void kullaniciHarflerdenOlusanBirKarakterVeyaKarakterlerGirer() {
        Driver.getDriver().navigate().refresh();
        medunnaPage.usernameTextbox.sendKeys(ConfigReader.getProperty("usernameGecerli"));
    }

    @Then("Your username is required uyari mesajinin goruntulenmedigini dogrular")
    public void yourUsernameIsRequiredUyariMesajininGoruntulenmediginiDogrular() {
        Assert.assertTrue( medunnaPage.InvalidFormGroupControl.size()==0 );
    }

    @And("kullanici ozel karakter girer")
    public void kullaniciOzelKarakterGirer() {
        Driver.getDriver().navigate().refresh();
        medunnaPage.usernameTextbox.sendKeys(ConfigReader.getProperty("usernameKarakterli"));
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.usernameTextbox).sendKeys(Keys.TAB).perform();
    }

    @Then("Your username is invalid uyari mesajinin goruntulendigini dogrular")
    public void yourUsernameIsInvalidUyariMesajininGoruntulendiginiDogrular() {
        Assert.assertTrue(medunnaPage.usernameInvalidMessage.isDisplayed());
    }

    @And("kullanici basta ve sonda bosluk birakarak username girer")
    public void kullaniciBastaVeSondaBoslukBirakarakUsernameGirer() {
        Driver.getDriver().navigate().refresh();
        medunnaPage.usernameTextbox.sendKeys(ConfigReader.getProperty("usernameGecersizBosluklu"));
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.usernameTextbox).sendKeys(Keys.TAB).perform();
    }

    @And("kullanici harf ve rakamlardan olusan,herhangi bir karakter sinirlamasi olmayan username girer.")
    public void kullaniciHarfVeRakamlardanOlusanHerhangiBirKarakterSinirlamasiOlmayanUsernameGirer() {
        Driver.getDriver().navigate().refresh();
        medunnaPage.usernameTextbox.sendKeys(ConfigReader.getProperty("usernameGecerliHarfveRakam"));
    }

    @Then("kullanici uyari mesajinin goruntulenmedigini dogrular.")
    public void kullaniciUyariMesajininGoruntulenmediginiDogrular() {
        Assert.assertTrue(medunnaPage.InvalidFormGroupControl.size()==0);
    }

    @Given("Kullanici email kutucuguna bes karakterden az karakter girer")
    public void kullaniciEmailKutucugunaBesKarakterdenAzKarakterGirer() {
        medunnaPage.emailTextbox.sendKeys(ConfigReader.getProperty("emailUcKarakterli"));
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.emailTextbox).sendKeys(Keys.TAB).perform();
    }

    @And("Your email is required to be at least characters uyari mesajinin goruntulendigini dogrular")
    public void yourEmailIsRequiredToBeAtLeastCharactersUyariMesajininGoruntulendiginiDogrular() {
        Assert.assertTrue(medunnaPage.emailAtLeast5CharMessage.isDisplayed());
    }

    @And("kullanici @ ve . karakterlerini kullanmadan email kutucugunu doldurur")
    public void kullaniciVeKarakterleriniKullanmadanEmailKutucugunuDoldurur() {
        Driver.getDriver().navigate().refresh();
        medunnaPage.emailTextbox.sendKeys(ConfigReader.getProperty("emailGecersiz1"));
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.emailTextbox).sendKeys(Keys.TAB).perform();
    }

    @Then("This field is invalid mesajinin goruntulendigini dogrular")
    public void thisFieldIsInvalidMesajininGoruntulendiginiDogrular() {
        Assert.assertTrue( medunnaPage.emailInvalidMessage.isDisplayed() );
    }

    @And("kullanici @ ve . karakterlerini en basta veya en sonda kullanarak doldurur")
    public void kullaniciVeKarakterleriniEnBastaVeyaEnSondaKullanarakDoldurur() {
        Driver.getDriver().navigate().refresh();
        medunnaPage.emailTextbox.sendKeys(ConfigReader.getProperty("emailGecersizBasveSon"));
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.emailTextbox).sendKeys(Keys.TAB).perform();
    }

    @And("kullanici @ ve . karakterlerini kullanarak istenen formatta bir email adresi girer")
    public void kullaniciVeKarakterleriniKullanarakIstenenFormattaBirEmailAdresiGirer() {
        Driver.getDriver().navigate().refresh();
        medunnaPage.emailTextbox.sendKeys(ConfigReader.getProperty("emailGecerliSM"));

    }


    @And("Kullanici SSN kutucuguna sadece rakamlar girer, harf ve ozel karakter girmez")
    public void kullaniciSSNKutucugunaSadeceRakamlarGirerHarfVeOzelKarakterGirmez() {
       // medunnaPage.ssnTextbox.sendKeys(ConfigReader.getProperty("SSNdokuzbasamakliGecerli"));
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.ssnTextbox)
                .sendKeys(ConfigReader.getProperty("SSNdokuzbasamakliGecerli"))
                .sendKeys(Keys.TAB)
                .perform();
        reusable=new ReusableMethods();
        reusable.waitFor(5);
    }

    @And("Kullanici SSN kutucuguna sadece harf ve ozel karakter girer")
    public void kullaniciSSNKutucugunaSadeceHarfVeOzelKarakterGirer() {
        Driver.getDriver().navigate().refresh();
        medunnaPage.ssnTextbox.sendKeys(ConfigReader.getProperty("SSNrakamvekarakter"));
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.ssnTextbox).sendKeys(Keys.TAB).perform();
        reusable=new ReusableMethods();
        reusable.waitFor(5);
    }

    @Given("kullanici Last Name kutucuguna tiklar ardindan bos birakir")
    public void kullaniciLastNameKutucugunaTiklarArdindanBosBirakir() {

        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.lastnameTextbox)
                .sendKeys(ConfigReader.getProperty("lastnameBos"))
                .sendKeys(Keys.TAB)
                .perform();
    }


    @Then("Herhangi bir uyari mesaji alinmadigini dogrular")
    public void herhangiBirUyariMesajiAlinmadiginiDogrular() {
        Assert.assertTrue(medunnaPage.InvalidFormGroupControl.size()==0);
    }


    @Given("Kullanici email kutucuguna tiklar")
    public void kullaniciEmailKutucugunaTiklar() {
        // js = (JavascriptExecutor) Driver.getDriver();
       // js.executeScript("arguments[0].scrollIntoView()",medunnaPage.emailTextbox);
        action=new Actions(Driver.getDriver());
        // action.sendKeys(Keys.PAGE_DOWN).perform();
        action.click(medunnaPage.emailTextbox).click().perform();
        reusable=new ReusableMethods();
        reusable.waitFor(4);
    }

    @And("Kullanici email kutucugunu bos birakir")
    public void kullaniciEmailKutucugunuBosBirakir() {
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.emailTextbox)
                .sendKeys(Keys.TAB)
                .perform();
        reusable=new ReusableMethods();
        reusable.waitFor(4);
    }

    @Then("Your email is required uyari mesajini goruntulendigini dogrular")
    public void yourEmailIsRequiredUyariMesajiniGoruntulendiginiDogrular() {
        Assert.assertTrue(medunnaPage.emailRequiredMessage.isDisplayed());
    }

    @Given("Kullanici gecerli bir email adresi girer")
    public void kullaniciGecerliBirEmailAdresiGirer() {
        Driver.getDriver().navigate().refresh();
        reusable=new ReusableMethods();
        medunnaPage.emailTextbox.sendKeys(ConfigReader.getProperty("emailGecerliSM"));
        reusable.waitFor(4);
    }

    @Then("Kullanici herhangi bir uyari mesaji alinmadigini dogrular")
    public void kullaniciHerhangiBirUyariMesajiAlinmadiginiDogrular() {

       Assert.assertTrue(medunnaPage.InvalidFormGroupControl.size()==0);

    }


    @Given("kullanici First Name kutucuguna tiklar ardindan bos birakir")
    public void kullaniciFirstNameKutucugunaTiklarArdindanBosBirakir() {
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.ssnTextbox)
                .sendKeys(ConfigReader.getProperty("SSNdokuzbasamakliGecerli"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();
    }

    @Then("Your FirstName is required uyari mesajinin alinmadigini dogrular")
    public void yourFirstNameIsRequiredUyariMesajininAlinmadiginiDogrular() {
        action=new Actions(Driver.getDriver());
        action.click(medunnaPage.firstnameTextbox)
                .sendKeys(Keys.TAB)
                .perform();
        Assert.assertTrue(medunnaPage.firstnameValidForm.isDisplayed());
    }


    @And("Kullanici Last Name kutucuguna herhangi bir karakter veya karakterler girer")
    public void kullaniciLastNameKutucugunaHerhangiBirKarakterVeyaKarakterlerGirer() {
        Driver.getDriver().navigate().refresh();
        medunnaPage.lastnameTextbox.click();
        medunnaPage.lastnameTextbox.sendKeys(ConfigReader.getProperty("lastnameGecerli"));
        reusable=new ReusableMethods();
        reusable.waitFor(4);




    }




}
