package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.DoktorPage;
import pages.MedunnaPage;
import utilities.Driver;

import static utilities.ReusableMethods.waitFor;

public class US_003 {
    MedunnaPage medunnaPage=new MedunnaPage();
    DoktorPage doktorPage = new DoktorPage();

    @When("kullanici registration icin resme tiklar")
    public void kullaniciRegistrationIcinResmeTiklar() {
        doktorPage.kullaniciResmibutonu.click();
        waitFor(1);
    }
    @Then("kullanici register butonuna tiklar")
    public void kullaniciRegisterButonunaTiklar() {
        medunnaPage.ikonAltiRegisterButton.click();
    }

    @And("Kullanici new Password kutusuna Tiklar")
    public void kullaniciNewPasswordKutusunaTiklar() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).perform();
        waitFor(1);
        medunnaPage.newPasswordBox.click();
    }
    @And("Kullanici en az yedi karakter uzunlugunda sadece kucuk harf iceren {string} sifre girer")
    public void kullaniciEnAzYediKarakterUzunlugundaSadeceKucukHarfIcerenSifreGirer(String ilkPassword) {
        medunnaPage.newPasswordBox.sendKeys(ilkPassword);
    }
    @And("Kullanıcı  Password strength seviyesinin degismedigini gorur")
    public void kullaniciPasswordStrengthSeviyesininDegismediginiGorur() {
        Assert.assertTrue(medunnaPage.passwordStrengtTekCizgi.isDisplayed());
    }
    @And("Kullanıcı New Password kutusundaki eski sifreyi siler")
    public void kullaniciNewPasswordKutusundakiEskiSifreyiSiler() {
        medunnaPage.newPasswordBox.clear();
    }
    @Then("Kullanici onceki girdigi sifreyi icerisinde bir buyuk harf olacak sekilde degistirir {string} ve yeniden girer")
    public void kullaniciOncekiGirdigiSifreyiIcerisindeBirBuyukHarfOlacakSekildeDegistirirVeYenidenGirer(String ikinciPassword) {
        medunnaPage.newPasswordBox.sendKeys(ikinciPassword);
    }
    @And("Kullanıcı Password strength seviyesinin iki turuncu cizgiye yukseldigini görür.")
    public void kullaniciPasswordStrengthSeviyesininIkiTuruncuCizgiyeYukseldiginiGorur() {
        Assert.assertTrue(medunnaPage.passwordStrengthIkiCizgi.isDisplayed());
    }
    @Then("Kullanici bu defa onceki  girdigi sifreyi, icerisinde bir buyuk harf ve rakam olacak sekilde degistirir {string} ve yeniden girer")
    public void kullaniciBuDefaOncekiGirdigiSifreyiIcerisindeBirBuyukHarfVeRakamOlacakSekildeDegistirirVeYenidenGirer(String ucuncuPassword) {
        medunnaPage.newPasswordBox.sendKeys(ucuncuPassword);
    }
    @And("Kullanıcı Password strength seviyesinin dort yesil cizgiye yukseldigini görür.")
    public void kullaniciPasswordStrengthSeviyesininDortYesilCizgiyeYukseldiginiGorur() {
        Assert.assertTrue(medunnaPage.passwordStrengthDortCizgi.isDisplayed());
    }
    @Then("Kullanici onceki  girdigi sifreyi, icerisinde bir buyuk harf , rakam ve ozel karakter olacak sekilde degistirir {string} ve yeniden girer")
    public void kullaniciOncekiGirdigiSifreyiIcerisindeBirBuyukHarfRakamVeOzelKarakterOlacakSekildeDegistirirVeYenidenGirer(String dorduncuPassword) {
        medunnaPage.newPasswordBox.sendKeys(dorduncuPassword);
    }
    @And("Kullanıcı Guclu sifre yani Password strength seviyesinin max. bes cizgi ve yesil oldugunu gorur")
    public void kullaniciGucluSifreYaniPasswordStrengthSeviyesininMaxBesCizgiVeYesilOldugunuGorur() {
        Assert.assertTrue(medunnaPage.passwordStrengtBesCizgi.isDisplayed());
    }
}