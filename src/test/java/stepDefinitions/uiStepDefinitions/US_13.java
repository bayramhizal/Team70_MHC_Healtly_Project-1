package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import pages.DoktorPage;
import utilities.Driver;

public class US_13 {
    DoktorPage doktorPage = new DoktorPage();


    @Then("doktor Show Test Results butonuna tiklar")
    public void doktor_show_test_results_butonuna_tiklar() throws InterruptedException {
        Thread.sleep(5000);
        doktorPage.showTestResultButton.click();
        Thread.sleep(5000);
    }
    @Then("doktor View Results butonuna tiklar")
    public void doktor_view_results_butonuna_tiklar() throws InterruptedException {
        Thread.sleep(5000);
        doktorPage.viewResultButton.click();
        Thread.sleep(5000);
    }


    @And("doktor test bilgilerini gorur")
    public void doktorTestBilgileriniGorur() {

        String ActualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(ActualUrl.contains("testresult"));

    }

    @And("doktor request Inpatient tusuna tiklar")
    public void doktorRequestInpatientTusunaTiklar() throws InterruptedException {
        Thread.sleep(5000);
        doktorPage.requestInpatientButton.click();

    }

    @And("doktor Anew In Patient is created with identifier yazisini gorur")
    public void doktorAnewInPatientIsCreatedWithIdentifierYazisiniGorur() throws InterruptedException {
        Thread.sleep(5000);

    }
}
