package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.StaffPage;

import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Random;

public class US09_UiStepDefinitions {

    @Then("kullanici MyPage sekmesine basar")
    public void kullanici_my_page_sekmesine_basar() {
        StaffPage page=new StaffPage();
        page.myPage.click();

    }
    @Then("kullanici MyPage sekmesinde SearchPatients sekmesine tiklar")
    public void kullanici_my_page_sekmesinde_search_patients_sekmesine_tiklar() {
        StaffPage page=new StaffPage();
        page.searchPatient.click();
    }
    @Then("kullanici sayfanin acilmasini bekler")
    public void kullanici_sayfanin_acilmasini_bekler() {
        StaffPage page=new StaffPage();
        ReusableMethods.waitForVisibility(page.patient,10);
    }
    @Then("kullanici acilan pencerenin Patient sayfasi oldugunu kontrol eder")
    public void kullanici_acilan_pencerenin_patient_sayfasi_oldugunu_kontrol_eder() {
        StaffPage page=new StaffPage();
        Assert.assertTrue(page.patient.isDisplayed());

    }

    @And("kullanici rastgele bir hasta secimi yaparak edit butonuna basar")
    public void kullaniciRastgeleBirHastaSecimiYaparakEditButonunaBasar() {
        StaffPage page=new StaffPage();
        Random random=new Random();
        System.out.println("page.edit.size() = " + page.edit.size());
        JavascriptExecutor js=(JavascriptExecutor)Driver.getDriver();
        js.executeScript("arguments[0].click();",page.edit.get(17));

    }

    @And("kulanici hasta bilgilerini duzenler")
    public void kulaniciHastaBilgileriniDuzenler() {
        StaffPage page=new StaffPage();
        Actions actions=new Actions(Driver.getDriver());

        actions.click(page.patientFM).doubleClick().sendKeys("ALI",
                Keys.TAB,"YAPRAK", Keys.TAB,"01.02.1990",Keys.ARROW_RIGHT,"12","00",
                Keys.TAB,"aliYaprak@gmail.com",Keys.TAB,"277-271-2356",Keys.TAB,"MALE",
                Keys.TAB,"0+",Keys.TAB,"Mursel Uluc Mah. 852. Sok. No:10/5 Dikmen",
                Keys.TAB,Keys.CLEAR,"goz bozuklugu",Keys.TAB,"staff",Keys.TAB,"Türkye").
                perform();
        ReusableMethods.waitFor(3);
        page.stateCity.click();
        ReusableMethods.waitFor(3);
        page.stateCity.sendKeys("Adana");
        page.stateCity.click();
    }

    @Then("kullanici Create or edit a Patient sayfasinda Save butonuna basar")
    public void kullaniciCreateOrEditAPatientSayfasindaSaveButonunaBasar() {
        StaffPage page=new StaffPage();
        page.save.click();
    }

    @And("kullanici acilan sayfanin Patient sayfasi oldugunu kontrol eder")
    public void kullaniciAcilanSayfaninPatientSayfasiOldugunuKontrolEder() {
        
    }

    @And("Staff gecerli bir {string} bilgisini Patient SSN: alanına girer")
    public void staffGecerliBirBilgisiniPatientSSNAlaninaGirer(String ssn) {
        Actions actions=new Actions(Driver.getDriver());
        StaffPage page=new StaffPage();
        actions.click(page.ssnBox).sendKeys(ssn).perform();

    }

    @Then("SSN i girilen hastanin kayit bilgileri dogrulanir")
    public void ssnIGirilenHastaninKayitBilgileriDogrulanir() {
        StaffPage page=new StaffPage();
        String expectedSsn="415-15-2256";
        Assert.assertTrue(page.ssnPatient.getText().contains(expectedSsn));
        Assert.assertEquals(expectedSsn,page.ssnPatient.getText());

    }

}
