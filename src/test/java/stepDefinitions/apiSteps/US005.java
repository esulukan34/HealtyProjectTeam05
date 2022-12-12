package stepDefinitions.apiSteps;

import base_url.MedunnaBaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;

public class US005 extends MedunnaBaseUrl {

    Response response;

    @Given("md Kullanici, {int} id nolu appointment bilgilerini almak icin get request yapar")
    public void md_kullaniciIdNoluAppointmentBilgileriniAlmakIcinGetRequestYapar(int appointmentId) {

        String url = "https://medunna.com/api/appointments/";
        response = given().headers("Authorization", "Bearer " + generateToken()).when().get(url + appointmentId);
        response.prettyPrint();
    }

    @Then("md Satatus Code'nin {int} oldugunu dogrular")
    public void mdSatatusCodeNinOldugunuDogrular(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @And("md Randevu alinirken girilen bilgilerin asertion islemlerini yapar")
    public void mdRandevuAlinirkenGirilenBilgilerinAsertionIslemleriniYapar() {

        response.then().assertThat().
                body("id", equalTo(308698),
                        "patient.firstName", equalTo("Ali"),
                        "patient.lastName", equalTo("Gel"),
                        "patient.user.ssn", equalTo("005-05-1234"),
                        "patient.email", equalTo("aligel02@gmai.com"),
                        "patient.phone", equalTo("666-666-6666"),
                        "startDate", equalTo("2022-12-21T00:00:00Z"),
                        "endDate", equalTo("2022-12-21T01:00:00Z"));

    }
}
