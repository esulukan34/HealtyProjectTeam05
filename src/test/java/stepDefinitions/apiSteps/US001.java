package stepDefinitions.apiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Registrant;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class US001 {
    Registrant expectedData;
    Response response;

    @Given("K4 yeni kisiler olusturmak icin tum register bilgilerini girer {string}, {string}, {string}, {string}, {string}, {string}")
    public void k4_yeni_kisiler_olusturmak_icin_tum_register_bilgilerini_girer(String SSN, String firstname, String lastname, String login, String email, String password) {

        expectedData = new Registrant(firstname,lastname,SSN,login,password,email);

    }
    @Then("K4 girdigi bilgileri POST yapar")
    public void k4_girdigi_bilgileri_post_yapar() {

        response = given().contentType(ContentType.JSON).body(expectedData).when().post("https://medunna.com/api/register");

        response.prettyPrint();
    }
    @Then("K4 olusturdugu kisi bilgilerini dogrular")
    public void k4_olusturdugu_kisi_bilgilerini_dogrular() {

        Registrant actualData = response.as(Registrant.class);
        assertEquals(expectedData.getFirstName(),actualData.getFirstName());
        assertEquals(expectedData.getLastName(),actualData.getLastName());
        assertEquals(expectedData.getLogin(),actualData.getLogin());
        assertEquals(expectedData.getSsn(),actualData.getSsn());
        assertEquals(expectedData.getEmail(),actualData.getEmail());
    }

}
