package stepDefinitions.apiSteps;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Appointments;
import utilities.Authentication;
import static io.restassured.RestAssured.given;


public class US007 extends Authentication {
    Appointments expectedData,actualData;
    Response response;


    @Given("K6 Kullanicisi {string} nolu Randevuya Get Request yapar")
    public void KullanicisiIdAitRandevuyaAitGetRequestYapar( String id) {
        response = given().header("Authorization", "Bearer " + generateToken())
                .when().get("https://medunna.com/api/appointments/" + id);
        // response.prettyPrint();
    }


    @Then("K6 {string} id nolu ve kullanici isimli randevu objesi olusturur")
    public void APIIleIdNoluRandevuyuSorgular( String id) {
        int id_donustur= Integer.parseInt(id);
        expectedData = new Appointments("zehrasen",id_donustur);
    }


    @Then("K6 Bilgileri Dogrular")
    public void BilgileriDogrular() {
        actualData = response.as(Appointments.class);

        Assert.assertEquals(expectedData.getCreatedBy(),actualData.getCreatedBy());
        Assert.assertEquals(expectedData.getId(),actualData.getId());

        //  System.out.println("actualData = " + actualData);
        //  System.out.println("expectedData = " + expectedData);
    }
}