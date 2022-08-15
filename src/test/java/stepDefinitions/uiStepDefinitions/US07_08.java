package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.PatientPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class US07_08 {

    PatientPage patientpage = new PatientPage();


    @Given("Hasta medunna ana sayfasina gider")
    public void hasta_medunna_ana_sayfasina_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }
    @Then("Hasta sag ust kosedeki kullanici ikonunu tiklar")
    public void hasta_sag_ust_kosedeki_kullanici_ikonunu_tiklar() {
        patientpage.kullaniciIkonu.click();
    }
    @Then("Hasta ikonu altinda Sign in sekmesine tiklar")
    public void hasta_ikonu_altinda_sign_in_sekmesine_tiklar() {
        patientpage.signInButton.click();
    }
    @Then("Hasta textbox a  kullanici adini girer")
    public void hasta_textbox_a_kullanici_adini_girer() {
        patientpage.userNameBox.sendKeys(ConfigReader.getProperty("PatientUserName"));
    }
    @Then("Hasta Password textbox a sifresini girer")
    public void hasta_password_textbox_a_sifresini_girer() {
        patientpage.passwordBox.sendKeys(ConfigReader.getProperty("Patientpassword"));
    }
    @Then("Hasta Sign in butonuna tiklar")
    public void hasta_sign_in_butonuna_tiklar() {
        patientpage.signInButton2.click();
    }
    @Then("Hasta sag ust kosedeki MyPages\\(Paients) butonuna tiklar")
    public void hasta_sag_ust_kosedeki_my_pages_paients_butonuna_tiklar() {
        patientpage.myPagePatient.click();

    }
    @Then("Hasta Make an Appointment sekmesini tiklar")
    public void hasta_make_an_appointment_sekmesini_tiklar() {
        patientpage.makeAnAppointment.click();
    }
    @Then("Hasta Appontment Date Time Boxta guncel veya ileri tarih secer")
    public void hasta_appontment_date_time_boxta_guncel_veya_ileri_tarih_secer() {

        LocalDate lokaldate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        patientpage.dateBox.sendKeys(dateTimeFormatter.format(lokaldate.plusDays(12)));
    }
    @Then("Hasta kullanici guncel veya ileri tarih sectiginde uyari yazisi almaz")
    public void hasta_kullanici_guncel_veya_ileri_tarih_sectiginde_uyari_yazisi_almaz() {
        Assert.assertTrue((patientpage.uyariYazisi.size()==0));
    }

    @Then("Hasta Appontment Date Time Boxta tarih sirasini gun ay ve yil olarak girebilmeli")
    public void hastaAppontmentDateTimeBoxtaTarihSirasiniGunAyYilOlarakGirebilmeli() {
        LocalDate lokaldate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        patientpage.dateBox.sendKeys(dateTimeFormatter.format(lokaldate.plusDays(12)));
    }

    @Then("Hasta Phone Box a telefon numarasini girer")
    public void hasta_phone_box_a_telefon_numarasini_girer() {
        patientpage.phoneNummer.sendKeys(ConfigReader.getProperty("phoneNummer"));

    }

    @Then("Hasta Send an Appointment Request butonuna tiklar")
    public void hasta_send_an_appointment_request_butonuna_tiklar(){
        patientpage.sendButton.submit();


    }

    @Then("Hasta My Appointment sekmesini tiklar")
    public void hastaMyAppointmentSekmesiniTiklar() {
        patientpage.myAppointment.click();
    }

    @And("Hasta randevunun gun ay ve yil olarak olustugunu dogrular")
    public void hastaRandevununGunAyVeYilOlarakOlustugunuDogrular() {
        Assert.assertTrue(patientpage.randevuTarihi.isDisplayed());
    }


    @Then("Hasta tekrar kullanici ikonuna tiklar")
    public void hasta_tekrar_kullanici_ikonuna_tiklar() {
        patientpage.kullaniciIkonu2.click();
    }
    @Then("Hasta kullanici ikonun altinda Password sekmesine tiklar")
    public void hasta_kullanici_ikonun_altinda_password_sekmesine_tiklar() {
        patientpage.passwordSekmesi.click();
    }
    @Then("Hasta Current password textbox a mevcut passwordu girer")
    public void hasta_current_password_textbox_a_mevcut_passwordu_girer() {
        patientpage.currentPassword.sendKeys(ConfigReader.getProperty("Patientpassword"));
    }
    @Then("Hasta New password textbox a  yeni passwordu girer")
    public void hasta_new_password_textbox_a_yeni_passwordu_girer() {
        patientpage.newPassword.sendKeys(ConfigReader.getProperty("newPassword"));
    }
    @Then("Hasta New password confirmation textbox ina yeni passwordunu girer")
    public void hasta_new_password_confirmation_textbox_ina_yeni_passwordunu_girer() {
        patientpage.confirmPassword.sendKeys(ConfigReader.getProperty("newPassword"));
    }
    @Then("Hasta herhangi bir uyari yazisi almaz")
    public void hasta_herhangi_bir_uyari_yazisi_almaz() {
        Assert.assertTrue((patientpage.uyariYazisi2.size()==0));

    }

    @Then("Hasta New password confirmation textbox ina en az bir kucuk harf, buyuk harf, rakam ve ozel karakterden olusan en az {int} karakter girer")
    public void hasta_new_password_confirmation_textbox_ina_en_az_bir_kucuk_harf_buyuk_harf_rakam_ve_ozel_karakterden_olusan_en_az_karakter_girer(Integer int1) {
        patientpage.newPassword.sendKeys(ConfigReader.getProperty("Patientpassword"));
    }
    @Then("Hasta Password strength seviyesini yesil renkte gormelidir")
    public void hasta_password_strength_seviyesini_yesil_renkte_gormelidir() {
        Assert.assertTrue(patientpage.passwordStrength.isDisplayed());
        patientpage.currentPassword.sendKeys(ConfigReader.getProperty("Patientpassword"));
    }

    @Then("Hasta New password confirmation textbox ina da mevcut passwordu girer")
    public void hasta_new_password_confirmation_textbox_ina_da_mevcut_passwordu_girer() {
        patientpage.newPassword.sendKeys(ConfigReader.getProperty("Patientpassword"));
    }
    @Then("Hasta password confirmation textbox ina da mevcut passwordu girer")
    public void hasta_password_confirmation_textbox_ina_da_mevcut_passwordu_girer() {
        patientpage.confirmPassword.sendKeys(ConfigReader.getProperty("Patientpassword"));

    }
    @Then("Hasta Save butonuna tiklar")
    public void hasta_save_butonuna_tiklar() {
        patientpage.saveButton.submit();


    }

    @Then("Hasta The password and its confirmation do not match! uyarisi almali")
    public void hasta_the_password_and_its_confirmation_do_not_match_uyarisi_almali() {

        String actual = patientpage.passwordChanged.getText();
        Assert.assertTrue(patientpage.passwordChanged.isDisplayed());


    }







}
