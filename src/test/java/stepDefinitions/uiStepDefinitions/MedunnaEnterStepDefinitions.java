package stepDefinitions.uiStepDefinitions;

import io.cucumber.java.en.Given;
import utilities.Methods;

public class MedunnaEnterStepDefinitions {

    @Given("kullanici admin olarak giris yapar")
    public void kullanici_admin_olarak_giris_yapar() {
        Methods.adminGiris();
    }
    @Given("kullanici Staff olarak giris yapar")
    public void kullanici_staff_olarak_giris_yapar() {
        Methods.staffGiris();
    }
    @Given("kullanici Patient olarak giris yapar")
    public void kullanici_patient_olarak_giris_yapar() {
        Methods.patientGiris();
    }
    @Given("kullanici Physician olarak giris yapar")
    public void kullanici_physician_olarak_giris_yapar() {
        Methods.physicianGiris();
    }
    @Given("kullanici User olarak giris yapar")
    public void kullanici_user_olarak_giris_yapar() {
        Methods.userGiris();
    }
}
