package stepDefinitions.apiSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.ContactPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;

public class US027 {

    Response responsePost;
    Response responseGet;
    ContactPojo expectedDataPost;
    ContactPojo actualDataPost;
    ContactPojo expectedDataGet;
    ContactPojo actualDataGet;

    @Given("md Kullanici token alip ileti olusturmak icin POST REQUEST yapar ve response alir")
    public void md_kullanici_token_alip_ileti_olusturmak_icin_post_request_yapar_ve_response_alir() {

        /*"email": "deneme2@deneme.com",
        "message": "TestNG daha stabil calisiyor2",
        "name": "testNG22",
        "subject": "Hangi framework2"
         */
        expectedDataPost = new ContactPojo("deneme2@deneme.com","TestNG daha stabil calisiyor2","testNG22","Hangi framework2");
        System.out.println("expectedData = " + expectedDataPost);

        String url = "https://medunna.com/api/c-messages";
        responsePost = given().headers("Authorization", "Bearer " + generateToken()).
                contentType(ContentType.JSON).body(expectedDataPost).when().post(url);
        responsePost.prettyPrint();


    }
    @Then("md Respons'larin dogrulamasini yapar")
    public void md_respons_larin_dogrulamasini_yapar() {

        actualDataPost = responsePost.as(ContactPojo.class);
        System.out.println("actualData = " + actualDataPost);
        assertEquals(201, responsePost.getStatusCode());
        assertEquals(expectedDataPost.getEmail(),actualDataPost.getEmail());
        assertEquals(expectedDataPost.getMessage(),actualDataPost.getMessage());
        assertEquals(expectedDataPost.getName(),actualDataPost.getName());
        assertEquals(expectedDataPost.getSubject(),actualDataPost.getSubject());

    }

    @Given("md Kullanici token alip ileti getirmek icin GET REQUEST yapar ve response alir\"")
    public void md_kullanici_token_alip_ileti_getirmek_icin_get_request_yapar_ve_response_alir() {
        /*
        {"id": 364775,
        "name": "testNG22",
        "email": "deneme2@deneme.com",
        "subject": "Hangi framework222",
        "message": "TestNG daha stabil calisiyor222"

        {
    "id": 364775,
    "name": "testNG22",
    "email": "deneme2@deneme.com",
    "subject": "Hangi framework222",
    "message": "TestNG daha stabil calisiyor222"
}

}     */
        expectedDataGet = new ContactPojo(364775,"testNG22","deneme2@deneme.com","Hangi framework222","TestNG daha stabil calisiyor222");
        System.out.println("expecteddataGet = " + expectedDataGet);

        String url = "https://medunna.com/api/c-messages/364775";
        responseGet = given().headers("Authorization", "Bearer " + generateToken()).when().get(url);
        responseGet.prettyPrint();

    }
    @Then("md Respons'larin dogrulamasini yapar\\(getRequest)")
    public void md_respons_larin_dogrulamasini_yapar_get_request() {
        actualDataGet = responseGet.as(ContactPojo.class);
        System.out.println("actualData = " + actualDataGet);
        assertEquals(200,responseGet.getStatusCode());
        assertEquals(expectedDataGet.getId(), actualDataGet.getId());
        assertEquals(expectedDataGet.getName(), actualDataGet.getName());
        assertEquals(expectedDataGet.getEmail(), actualDataGet.getEmail());
        assertEquals(expectedDataGet.getSubject(), actualDataGet.getSubject());
        assertEquals(expectedDataGet.getMessage(), actualDataGet.getMessage());


    }

}
