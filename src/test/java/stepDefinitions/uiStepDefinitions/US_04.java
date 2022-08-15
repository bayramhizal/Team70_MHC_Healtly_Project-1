package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.DoktorPage;
import pages.MedunnaPage;
import utilities.ConfigReader;
import utilities.Driver;

import static utilities.ReusableMethods.waitFor;

public class US_04 {
    DoktorPage doktorPage = new DoktorPage();
    MedunnaPage medunnaPage = new MedunnaPage();
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Given("Kullanıcı User iconuna tıklar")
    public void kullanıcı_user_iconuna_tıklar() {
        doktorPage.kullaniciResmibutonu.click();
    }

    @Given("Kullanıcı Sign In butonuna tıklar")
    public void kullanıcı_sign_in_butonuna_tıklar() {
        doktorPage.signInButton.click();
    }

    @Given("Kullanıcı Username box a kullanıcı adı girer")
    public void kullanıcı_username_box_a_kullanıcı_adı_girer() {
        doktorPage.usernameBox.sendKeys(ConfigReader.getProperty("doktorUsername"));

    }

    @Given("Kullanıcı Password box a password girer")
    public void kullanıcı_password_box_a_password_girer() {
        doktorPage.passwordBox.sendKeys(ConfigReader.getProperty("doktorPassword"));
    }

    @Given("Kullanici Sign In butonuna gider ve tiklar")
    public void kullanici_sign_in_butonuna_gider_ve_tiklar() {
        doktorPage.signInButton2.click();
    }

    @Given("Kullanıcı WELCOME TO MEDUNNA mesajını gorur")
    public void kullanıcı_welcome_to_medunna_mesajını_gorur() {

        String expectedResult = "WELCOME TO MEDUNNA";
        String actualResult = medunnaPage.wellcomeToMedunna.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Given("Remember me sekmesi gorunur olmalidir")
    public void rememberMeSekmesiGorunurOlmalidir() {
        medunnaPage.rememberMeButton.isDisplayed();
    }

    @And("Remember me secilebilir olmalidir")
    public void rememberMeSecilebilirOlmalidir() {
        Assert.assertTrue(medunnaPage.rememberMeClickButton.isEnabled());
    }

    @Given("Did you forget your password\" gorunur olmalıdır")
    public void didYouForgetYourPasswordGorunurOlmalıdır() {
        medunnaPage.didYouForgetPasswordButton.isDisplayed();
    }


    @Then("Remember me tıklanabilir olmalidir")
    public void rememberMeTıklanabilirOlmalidir() {
        waitFor(2);
        medunnaPage.rememberMeClickButton.click();
    }

    @And("Reset your password sayfasi gorunur olmalıdır")
    public void resetYourPasswordSayfasiGorunurOlmalıdır() {
        medunnaPage.didYouForgetPasswordButton.click();
        waitFor(2);
        String expectedResult="Reset your password";
        String actualResult =medunnaPage.resetYourPasswordButton.getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Given("You don't have an account yet? Register a new account gorunur olmalıdır")
    public void youDonTHaveAnAccountYetRegisterANewAccountGorunurOlmalıdır() {
        medunnaPage.youDontRegisterButton.isDisplayed();
    }

    @Then("Register a new account tıklanabilir olmalidir")
    public void registerANewAccountTıklanabilirOlmalidir() {
        jse.executeScript("arguments[0].scrollIntoView(true);",medunnaPage.registerAnewAccount);
        jse.executeScript("arguments[0].click();", medunnaPage.registerAnewAccount);
       // hover(medunnaPage.registerAnewAccount);
       // medunnaPage.registerAnewAccount.click();
        waitFor(2);
    }

    @Then("Registration sayfası gorunur olmalıdır")
    public void registrationSayfasıGorunurOlmalıdır() {
        waitFor(2);
        String expectedResult="https://www.medunna.com/account/register";
       String actualResult= Driver.getDriver().getCurrentUrl();
        System.out.println("actualurl :"+actualResult);
      Assert.assertEquals(expectedResult, actualResult);
    }

    @Given("Cancel gorunur olmalıdır")
    public void cancelGorunurOlmalıdır() {
        medunnaPage.cancelButton.isDisplayed();
    }

    @And("Cancel erisilebilir olmalidir")
    public void cancelErisilebilirOlmalidir() {
        jse.executeScript("arguments[0].scrollIntoView(true);",medunnaPage.cancelButton);
        jse.executeScript("arguments[0].click();", medunnaPage.cancelButton);
            }

    @And("MEDUNNA  page donuldugu dogrulanir olmalidir.")
    public void medunnaPageDonulduguDogrulanirOlmalidir() {
             String expectedResult="https://www.medunna.com/home";
        String actualResult =Driver.getDriver().getCurrentUrl();
        System.out.println(actualResult);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
