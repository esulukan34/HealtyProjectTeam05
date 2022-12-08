package stepDefinitions.apiSteps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Country;
import utilities.ConfigReader;
import java.util.HashMap;

import static base_url.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;
import static utilities.DatabaseUtility.country;

public class US028 {
    Response response;
    static HashMap<String,String> expectedData1;
    Country expectedData2;
    static int countryId;


    @Given("K3 Admin ulke icin {string}e gider")
    public void k3AdminUlkeIcinEGider(String endpoint) {
        switch (endpoint) {
            case "initial":
                spec.pathParams("1.", "api", "2.", "countries","3.","initial");
                break;
            case "id":
                spec.pathParams("1.", "api", "2.", "countries","3.",countryId);
                break;
            case "countries":
                spec.pathParams("1.", "api", "2.", "countries");
                break;
            case "E2E_id":
                spec.pathParams("1.", "api", "2.", "countries","3.",country.getId());
                break;
        }
    }

    @When("K3 Admin ulke icin {string} gonderir ve yaniti alir")
    public void k3AdminUlkeIcinGonderirVeYanitiAlir(String request) {

        switch (request) {
            case "POST":
                expectedData1 = new HashMap<>();
                expectedData1.put("name", ConfigReader.getProperty("K3Ulke"));
                System.out.println("countryPost = " + expectedData1);
                response = given().spec(spec)
                        .headers("Authorization", "Bearer " + generateToken())
                        .contentType(ContentType.JSON)
                        .body(expectedData1)
                        .when()
                        .post("/{1.}/{2.}/{3.}");
                response.prettyPeek();
                break;
            case "GET":
                response = given().spec(spec)
                        .headers("Authorization", "Bearer " + generateToken())
                        .contentType(ContentType.JSON)
                        .when()
                        .get("/{1.}/{2.}/{3.}");
                response.prettyPeek();
                break;
            case "PUT":
                expectedData2=new Country(countryId,"Beyceli");
                response = given().spec(spec)
                        .headers("Authorization", "Bearer " + generateToken())
                        .contentType(ContentType.JSON)
                        .body(expectedData2)
                        .when()
                        .put("/{1.}/{2.}");
                break;
            case "DELETE":
                response = given().spec(spec)
                        .headers("Authorization", "Bearer " + generateToken())
                        .contentType(ContentType.JSON)
                        .when()
                        .delete("/{1.}/{2.}/{3.}");
                response.prettyPeek();
                break;

        }
    }

    @Then("K3 Admin ulke icin Status {string} alir")
    public void k3AdminUlkeIcinStatusAlir(String statusCode) {
        assertEquals(Integer.parseInt(statusCode),response.getStatusCode());
    }

    @And("K3 Admin ulke icin yaniti {string} yapar")
    public void k3AdminUlkeIcinYanitiYapar(String verify) {

        switch (verify) {
            case "Create": {
                Country actualData = response.as(Country.class);
                countryId = actualData.getId();
                System.out.println("countryId = " + countryId);
                assertEquals(expectedData1.get("name"), actualData.getName());
                break;
            }
            case "Read":{
                Country actualData = response.as(Country.class);
                assertEquals(expectedData1.get("name"),actualData.getName());
                break;
            }
            case "Update": {
                Country actualData = response.as(Country.class);
                assertEquals(expectedData2.getId(),actualData.getId());
                assertEquals(expectedData2.getName(),actualData.getName());
                break;
            }
            case "Delete":{
                assertEquals(204,response.getStatusCode());
                break;
            }
            case "E2E_Read":{
                Country actualData=response.as(Country.class);
                System.out.println("actualData = " + actualData);
                assertEquals(country.getName(),actualData.getName());
                assertEquals(country.getId(),actualData.getId());
                break;
            }
        }

    }
}
