package stepDefinitions.apiStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;

public class US15_api {


    @Given("Admin hasta POST islemi icin endpointi olusturur")
    public void adminHastaPOSTIslemiIcinEndpointiOlusturur() {
    }

    @When("Admin hasta POST islemi icin expected data olusturur")
    public void adminHastaPOSTIslemiIcinExpectedDataOlusturur() {
    }

    @And("Admin POST request islemi yapar ve response alir")
    public void adminPOSTRequestIslemiYaparVeResponseAlir() {
    }

    @Then("Admin status kodunun {int} oldugunu dogrular")
    public void adminStatusKodununOldugunuDogrular(int arg0) {
    }

    @Then("Admin POST expected data ile actual datanin ayni oldugunu dogrular")
    public void adminPOSTExpectedDataIleActualDataninAyniOldugunuDogrular() {
    }

    @Then("Admin ID no ile GET yaparak olusturdugu hastayi gorur ve {int} Status kodunu alir")
    public void adminIDNoIleGETYaparakOlusturduguHastayiGorurVeStatusKodunuAlir(int arg0) {
    }

    @And("Admin ID no ile PUT yaparak olusturdugu hastayi gunceller ve {int} Status kodunu alir")
    public void adminIDNoIlePUTYaparakOlusturduguHastayiGuncellerVeStatusKodunuAlir(int arg0) {
    }

    @And("Admin olusturdugu hastayi siler ve {int} kodu ile silindigini dogrular")
    public void adminOlusturduguHastayiSilerVeKoduIleSilindiginiDogrular(int arg0) {
    }
}
