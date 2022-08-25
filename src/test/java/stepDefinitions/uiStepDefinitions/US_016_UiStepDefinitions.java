package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;

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
      adminPage.creatButton.isDisplayed();
    }

}
