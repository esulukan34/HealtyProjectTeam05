package stepDefinitions.apiSteps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Physician;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;

public class US018 {

    Physician expected;
    Response response;
    Physician actualData;

    @Given("K10 {int} Id numarali doktorun tum bilgileri icin get request gonderir")
    public void k10_id_numarali_hastanin_tum_bilgilerin_icin_get_request_gonderir(Integer id) {
        response = given().headers("Authorization","Bearer " + generateToken()).when().get("https://medunna.com/api/physicians/"+id);
        response.prettyPrint();
        actualData = response.as(Physician.class);
    }
    @Then("K10 Status code {int} oldugu dogrulanir")
    public void k10_status_code_oldugu_dogrulanir(Integer statusCode) {
        //Assert.assertEquals(response.statusCode(),status);
        response.then().assertThat().statusCode(statusCode);
    }
    @Then("K10 response ile dogrulanir")
    public void k10_response_ile_dogrulanir() {
     expected= new Physician("z.y.","2022-12-12T10:56:18.230229Z",399601,"Adam","Adam+","2000-12-11T22:00:00Z","555-333-1111");
     assertEquals(expected.getCreatedBy(),actualData.getCreatedBy());
     assertEquals(expected.getCreatedDate(),actualData.getCreatedDate());
     assertEquals(expected.getId(),actualData.getId());
     assertEquals(expected.getFirstName(),actualData.getFirstName());
     assertEquals(expected.getLastName(),actualData.getLastName());
     assertEquals(expected.getBirthDate(),actualData.getBirthDate());
     assertEquals(expected.getPhone(),actualData.getPhone());



    }
}
/*
{
        "createdBy": "z.y.",
        "createdDate": "2022-12-12T10:56:18.230229Z",
        "id": 399601,
        "firstName": "Adam",
        "lastName": "Adam+",
        "birthDate": "2000-12-11T22:00:00Z",
        "phone": "555-333-1111",
        "gender": "MALE",
        "bloodGroup": "Apositive",
        "adress": "",
        "description": "",
        "user": {
        "createdBy": "anonymousUser",
        "createdDate": "2022-12-07T10:00:45.600112Z",
        "id": 380875,
        "login": "dr.adam",
        "firstName": "Adam",
        "lastName": "Adam+",
        "email": "dr.adam@gmail.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null,
        "ssn": "081-05-0035"
        },
        "speciality": "ALLERGY_IMMUNOLOGY",
        "appointments": null,
        "country": null,
        "cstate": null,
        "examFee": 500.00,
        "image": "",
        "imageContentType": null
        }
  */