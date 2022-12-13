package stepDefinitions.apiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.Patient;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;

public class US025 {
/*
{
    "createdBy": "adurmus",
    "createdDate": "2022-12-04T19:13:32.036205Z",
    "id": 370147,
    "firstName": "Emre",
    "lastName": "Sulukan",
    "birthDate": null,
    "phone": "555-555-6060",
    "gender": null,
    "bloodGroup": null,
    "adress": null,
    "email": "esulukan@gmail.com",
    "description": null,
    "user": {
        "createdBy": "anonymousUser",
        "createdDate": "2022-12-02T21:02:45.977614Z",
        "id": 365175,
        "login": "adurmus",
        "firstName": "Emre",
        "lastName": "Sulukan",
        "email": "esulukan@gmail.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null,
        "ssn": "123-54-6060"
    },
    "appointments": null,
    "inPatients": null,
    "country": null,
    "cstate": null
}
 */
    Patient actualData;
    Response response;
    Patient expectedData;
    @Given("K4 {int} id numarali hastanin tum bilgilerine get request gonderir")
    public void k4_id_numarali_hastanin_tum_bilgilerine_get_request_gonderir(Integer id) {
        response = given().headers("Authorization", "Bearer " + generateToken()).when().get("https://medunna.com/api/patients/"+ id);
        response.prettyPrint();
        actualData = response.as(Patient.class);

    }
    @Then("K4 Status code {int} oldugu kontrol edilir")
    public void k4_status_code_oldugu_kontrol_edilir(int Statuscode) {
        assertEquals(Statuscode,response.getStatusCode());

    }

    @Then("K4 response kayitlarini dogrular")
    public void k4_response_kayitlarini_dogrular() {
        expectedData =  new Patient(370147,"Emre","Sulukan","555-555-6060","esulukan@gmail.com");

        assertEquals(expectedData.getId(),actualData.getId());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getPhone(), actualData.getPhone());
        assertEquals(expectedData.getEmail(), actualData.getEmail());



    }

}

