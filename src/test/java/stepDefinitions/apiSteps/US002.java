package stepDefinitions.apiSteps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import pojos.Registrant;
import utilities.ConfigReader;

import static base_url.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;

public class US002 {
    Response response;


    @Given("K3 Kullanici {string} icin endpointe gider")
    public void k3KullaniciIcinEndpointeGider(String username) {
        spec.pathParams("1.","api","2.","users","3.", ConfigReader.getProperty(username));
    }

    @When("K3 Kullanici {string} gonderir ve yaniti alir")
    public void k3KullaniciIstekGonderirVeYanitiAlir(String request) {
        if (request.equals("GET")) {
            response = given()
                    .spec(spec)
                    .headers("Authorization", "Bearer " + generateToken())
                    .when().get("/{1.}/{2.}/{3.}");
            response.prettyPeek();
        } else if (request.equals("DELETE")) {
            response = given()
                    .spec(spec)
                    .headers("Authorization", "Bearer " + generateToken())
                    .when().delete("/{1.}/{2.}/{3.}");
            response.prettyPeek();

        }
    }
    @Then("K3 Kullanici Status {string} alir")
    public void k3KullaniciStatusCodeAlir(String statusCode) {
        assertEquals(Integer.parseInt(statusCode),response.getStatusCode());
    }

    @Then("K3 Kullanici yaniti {string} yapar")
    public void k3KullaniciYanitiYapaar(String verify) {
        if (verify.equals("okuma")) {
            Registrant expectedData = new Registrant(ConfigReader.getProperty("K3Username")
                    , ConfigReader.getProperty("K3Firstname")
                    , ConfigReader.getProperty("K3Lastname")
                    , ConfigReader.getProperty("K3Email")
                    , ConfigReader.getProperty("K3Password")
                    , ConfigReader.getProperty("K3SSN"));
            System.out.println("expectedData = " + expectedData);

            Registrant actualData = response.as(Registrant.class);
            System.out.println("actualData = " + actualData);
            assertEquals("username API'de bulunamadi", expectedData.getLogin(), actualData.getLogin());
            assertEquals("firstname API'de bulunamadi", expectedData.getFirstName(), actualData.getFirstName());
            assertEquals("lastname API'de bulunamadi", expectedData.getLastName(), actualData.getLastName());
            assertEquals("email API'de bulunamadi", expectedData.getEmail(), actualData.getEmail());
            assertEquals("SSN API'de bulunamadi", expectedData.getSsn(), actualData.getSsn());
        } else if (verify.equals("silme")) {
            assertEquals(204,response.getStatusCode());

        }

    }
}
