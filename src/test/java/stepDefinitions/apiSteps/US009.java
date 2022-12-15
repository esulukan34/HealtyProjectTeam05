package stepDefinitions.apiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.US009DataPojo;
import pojos.US009UserPojo;
import utilities.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;

public class US009 {
    Response response;
    @Given("Kullanici {int} id numarali hastanin tum bilgilerine GET request gonderir")
    public void kullaniciIdNumaraliHastaninTumBilgilerineGETRequestGonderir(int id) {
        // spec.pathParams("first","api","second","patients");
        response = given()
                .headers("Authorization","Bearer "+generateToken()).when().get("https://medunna.com/api/patients/"+id);
        response.prettyPrint();
    }
    @Then("Kullanici status kodunun {int} oldugu gorulur")
    public void kullaniciStatusKodununOlduguGorulur(int expectedStatusCode) {
        assertEquals(expectedStatusCode,response.statusCode());
    }
    @And("Kullanici bilgilerin dogrulugunu kontrol eder")
    public void kullaniciBilgilerinDogrulugunuKontrolEder() {
        US009UserPojo expUser = new US009UserPojo("anonymousUser","2022-04-07T14:00:05.828549Z",55224,"barb.gaylord","Eli","Wuckert","vaughn.donnelly@yahoo.com",true,"en",null,null,"699-50-3044");
        US009DataPojo expData = new US009DataPojo("anonymousUser","2022-04-07T14:00:00.206137Z",55902,"Eli","Wuckert",null,"455-455-5555",null,null,null,"teodoro.olson@yahoo.com", null,expUser,null,null,null,null);

        US009DataPojo actualData = JsonUtil.convertJsonToJava(response.asString(), US009DataPojo.class);
      //  US009DataPojo act=response.as(US009DataPojo.class);
        System.out.println("actualData = " + actualData);
        System.out.println("expData = " + expData);

        assertEquals(expData.getCreatedBy(),actualData.getCreatedBy());
        assertEquals(expData.getCreatedDate(),actualData.getCreatedDate());
        assertEquals(expData.getId(),actualData.getId());
        assertEquals(expData.getLastName(),actualData.getLastName());
        assertEquals(expData.getBirthDate(),actualData.getBirthDate());
        assertEquals(expData.getPhone(),actualData.getPhone());
        assertEquals(expData.getGender(),actualData.getGender());
        assertEquals(expData.getBloodGroup(),actualData.getBloodGroup());
        assertEquals(expData.getAdress(),actualData.getAdress());
        assertEquals(expData.getEmail(),actualData.getEmail());
        assertEquals(expData.getDescription(),actualData.getDescription());
        assertEquals(expUser.getCreatedBy(),actualData.getUser().getCreatedBy());
        assertEquals(expUser.getCreatedDate(),actualData.getUser().getCreatedDate());
        assertEquals(expUser.getId(),actualData.getUser().getId());
        assertEquals(expUser.getLogin(),actualData.getUser().getLogin());
        assertEquals(expUser.getFirstName(),actualData.getUser().getFirstName());
        assertEquals(expUser.getLastName(),actualData.getUser().getLastName());
        assertEquals(expUser.getEmail(),actualData.getUser().getEmail());
        assertEquals(expUser.getActivated(),actualData.getUser().getActivated());
        assertEquals(expUser.getLangKey(),actualData.getUser().getLangKey());
        assertEquals(expUser.getImageUrl(),actualData.getUser().getImageUrl());
        assertEquals(expUser.getResetDate(),actualData.getUser().getResetDate());
        assertEquals(expUser.getSsn(),actualData.getUser().getSsn());
        assertEquals(actualData.getAppointments(),actualData.getAppointments());
        assertEquals(actualData.getInPatients(),actualData.getInPatients());
        assertEquals(actualData.getCountry(),actualData.getCountry());
        assertEquals(actualData.getCstate(),actualData.getCstate());

    }
}
