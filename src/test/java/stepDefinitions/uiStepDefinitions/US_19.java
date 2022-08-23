package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;
import pages.AdminPage;
import utilities.Methods;

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



    }
    @Then("Kullanici Acilan sayfada SSN kutusuna gecerli staff {string} bilgisini girer")
    public void kullanici_acilan_sayfada_ssn_kutusuna_gecerli_staff_bilgisini_girer(String string) {



    }
    @Then("Kullanici {string} secimi yapar ve {string} butonuna basar")
    public void kullanici_secimi_yapar_ve_butonuna_basar(String string, String string2) {



    }
    @Then("Kullanici {string} mesajini gorur")
    public void kullanici_mesajini_gorur(String string) {



    }
    @Then("Kullanici girmis oldugu SSN bilgisine gore {string} bilgilerini dogrular")
    public void kullanici_girmis_oldugu_ssn_bilgisine_gore_bilgilerini_dogrular(String string) {



    }

    @And("Kullanici acilan sayfada herhangi bir kullaniciyi goruntuler")
    public void kullaniciAcilanSayfadaHerhangiBirKullaniciyiGoruntuler() {
        
    }

    @And("Kullanici acilan sayfanin {string} sayfasi oldugunu gorur")
    public void kullaniciAcilanSayfaninSayfasiOldugunuGorur(String arg0) {
        
    }

    @And("Kullanici acilan sayfada herhangi bir kullanici icin {string} butonuna basar")
    public void kullaniciAcilanSayfadaHerhangiBirKullaniciIcinButonunaBasar(String arg0) {
        
    }

    @And("Kullanici Staff bilgilerini gunceller ve {string} tusuna basar")
    public void kullaniciStaffBilgileriniGuncellerVeTusunaBasar(String arg0) {
        
    }

    @And("Acilan pencerede {string} uyarisini gorur")
    public void acilanPenceredeUyarisiniGorur(String arg0) {
    }
}
