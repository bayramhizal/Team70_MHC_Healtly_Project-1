package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.DoktorPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static utilities.ReusableMethods.waitFor;

public class US_012_TC01_ve_TC02 {

    DoktorPage doktorPage = new DoktorPage();
    List <String> testNameListStr;

    @Given("doktor {string} anasayfasindan")
    public void doktor_anasayfasindan(String medunna) {
        Driver.getDriver().get(ConfigReader.getProperty(medunna));
    }

    @When("doktor kullanici resmine tiklar")
    public void doktorKullaniciResmineTiklar() {
        doktorPage.kullaniciResmibutonu.click();
    }

    @Then("doktor Sign in butonuna tiklar")
    public void doktorSignInButonunaTiklar() {
        doktorPage.signInButton.click();
    }

    @And("doktor username ve Password bilgileri ile giris yapar")
    public void doktorUsernameVePasswordBilgileriIleGirisYapar() {
        doktorPage.usernameBox.sendKeys(ConfigReader.getProperty("doktorUsername"));
        doktorPage.passwordBox.sendKeys(ConfigReader.getProperty("doktorPassword"));
        doktorPage.signInButton2.click();
    }

    @And("doktor kendi sayfasina giris yaptigini gorur")
    public void doktorKendiSayfasinaGirisYaptiginiGorur() {
        String expectedName= ConfigReader.getProperty("doktorName");
        String actualName= doktorPage.doktorName.getText();
     //   System.out.println("expectedName = " + expectedName);
     //   System.out.println("actualName = " + actualName);
        Assert.assertEquals("doktor yanlis isme sahip sayfada",expectedName,actualName);
    }

    @And("doktor Appointments sayfasina ilerler")
    public void doktorAppointmentsSayfasinaIlerler() {
        doktorPage.myPagesButton.click();
        waitFor(1);
        Assert.assertTrue(doktorPage.myAppointmentUstButton.isDisplayed());
        doktorPage.myAppointmentUstButton.click();
    }

    @And("doktor acilan sayfanin Appointments sayfasi oldugunu gorur")
    public void doktorAcilanSayfaninAppointmentsSayfasiOldugunuGorur() {
        String expectedUrl=ConfigReader.getProperty("medunnaAppointmentsUrl");
        String actualUrl= Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("doktor hatali sayfada",expectedUrl,actualUrl);
    }

    @And("doktor Appointments sayfasinda {string} isimli hastasini gorur")
    public void doktorAppointmentsSayfasindaIsimliHastasiniGorur(String patientName) {
        List <String> patientsListStr= new ArrayList<>();
        for (WebElement each: doktorPage.listOfPatient
             ) {patientsListStr.add(each.getText());
        }
        //System.out.println("patientsListStr = " + patientsListStr);
        Assert.assertTrue(patientsListStr.contains(patientName));
    }

    @And("doktor test talep edecegi hastanin yaninda bulunan Edit butonunu gorur ve tiklar")
    public void doktorTestTalepEdecegiHastaninYanindaBulunanEditButonunuGorurVeTiklar() {
        Assert.assertTrue(doktorPage.patientAhmEditButton.isDisplayed());
        doktorPage.patientAhmEditButton.click();
    }

    @And("doktor Request A Test yazan yesil kutucugu gorur ve tiklar")
    public void doktorRequestATestYazanYesilKutucuguGorurVeTiklar() {
        Assert.assertTrue(doktorPage.requestATestBox.isDisplayed());
        waitFor(1);
        doktorPage.requestATestBox.click();
    }

    @And("doktor acilan sayfanin Test Items sayfasi oldugunu gorur")
    public void doktorAcilanSayfaninTestItemsSayfasiOldugunuGorur() {
        Assert.assertTrue(doktorPage.testItemText.isDisplayed());
    }

    @And("doktor {string} testlerini gorur")
    public void doktorTestleriniGorur(String arg0) {

    }

    @And("doktor kendi isminin oldugu yeri gorur ve tiklar daha sonra da Sign out butonuna tiklar")
    public void doktorKendiIsmininOlduguYeriGorurveTiklarDahaSonraDaSignOutButonunaTiklar() {
        Assert.assertTrue(doktorPage.doktorName.isDisplayed());
        doktorPage.doktorName.click();
        waitFor(1);
        doktorPage.signOutButton.click();
        waitFor(1);
        Assert.assertTrue(doktorPage.thankYouText.isDisplayed());
    }
    @And("doktor Test Items sayfasinda tum test isimlerinin listesini gorur")
    public void doktorTestItemsSayfasindaTumTestIsimlerininListesiniGorur() {
        // 1. String test isimlerini kayit etmek icin bos bir List olusturulur
        testNameListStr= new ArrayList<>(); // class seviyesinde bu listeyi astik her seferinde liste olusturmadan zaman kazanalim diye

        // 2. foreach ile tablodan gelen Test isimlerini yukaridaki List'e ekledik
        for (WebElement each: doktorPage.listOfTestName
        ) {testNameListStr.add(each.getText());
        }
        System.out.println("Test isimleri Listesi: "+testNameListStr);

    }
    @And("Doktor test secenekleri arasinda {string} gorur ve secebilir")
    public void doktorTestSecenekleriArasindaGorurVeSecebilir(String istenenTest) {
        // 3. Doktor tarafindan istenen Test tablo'da varmi onu Assert ettik
        Assert.assertTrue(testNameListStr.contains(istenenTest));

        // 4. istedigimiz Test'in tabloda hangi index'te oldugunu bulduk
        int testNameIndexNo=-3; // 0 yazmadik cunku eger bulamazsa bize 0 index donmesin diye
        for (int i = 0; i <testNameListStr.size() ; i++) {
            if (testNameListStr.get(i).equals(istenenTest)) {
                testNameIndexNo=i+1;
                break; // ilk buldugu isimde loop ve if sona ersin cunku ayni isimde varsa sorun yasanabilir
            }
        }System.out.println("testNameIndexNo = " + testNameIndexNo);

        // 5. Istedigimiz test'e ait ID numarasini bulmak icin asagidaki islemleri uyguladik. ID bize ilgili kutucuga tiklamak icin lazim
        List <String> testIdListStr= new ArrayList<>();
        for (WebElement each: doktorPage.listOfTestId
        ) {testIdListStr.add(each.getText());
        }System.out.println("testId = " + testIdListStr.get(testNameIndexNo - 1)); // ID numarasini aldik

        // 6. Id numarasi sayesinde tiklanacak kutucuk bulunacak ve onun WebElement'i olusturulur
        String testIdStr= testIdListStr.get(testNameIndexNo - 1);
        WebElement kutucukWebElementi = Driver.getDriver().findElement(By.xpath("//td[9]//input[@name='"+testIdStr+"']"));

        // 7. Sayfada yaklasik 800 civari test oldugundan sayfanin ilgili yerine varmak icin
        // JavascriptExecuter Class'indan faydalanildi ve bu sayede ilgili elemente tiklandi.
        JavascriptExecutor jse =(JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",kutucukWebElementi);
        waitFor(1);
        jse.executeScript("arguments[0].click();",kutucukWebElementi);
    }


}
