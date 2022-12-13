package stepDefinitions.apiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.junit.Assert;

import pojos.TestPojos;
import pojos.TestPojos2;

import static base_url.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;

public class US017 {

    Response response;
    static TestPojos expectedData;
    static TestPojos2 expectedData2;

    /*
   {
    "createdBy": "string",
    "createdDate": "2022-12-10T10:05:12.791Z",
    "defaultValMax": "string",
    "defaultValMin": "string",
    "description": "string",
    "id": 0,
    "name": "string",
    "price": 0
    }
     */

    //********************POST******************************
    String url;
    String url2;

    static int testItemId;

    @Given("AdminNevcan sets the URL")
    public void adminnevcanSetsTheURL() {
        //spec.pathParams("first", "c-test-items");

        url = "https://medunna.com/api/c-test-items";
    }

    @And("AdminNevcan sets the expected data")
    public void adminnevcanSetsTheExpectedData() {
        expectedData = new TestPojos("Nevcan Collins Sen", "blood", 45.0, "20", "80");
        System.out.println("expectedData = " + expectedData);
    }

    @Then("AdminNevcan sends the Post Request and gets the Response")
    public void adminnevcanSendsThePostRequestAndGetsTheResponse() {

        response = given().headers("Authorization", "Bearer " + generateToken()
                ,  "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON)
                //.spec(spec)
                .contentType(ContentType.JSON)
                .body(expectedData)
                .when()
                //.post("/{first}")
                .post(url);

        response.prettyPrint();

    }

    @And("AdminNevcan does Assertion")
    public void adminnevcanDoesAssertion() {

        TestPojos2 actualData= response.as(TestPojos2.class);

        response.then().assertThat().statusCode(200);

        /*
        response.then().assertThat().
                body("setName", equalTo(expectedData.getName())).
                body("setDescription", equalTo(expectedData.getDescription())).
                body("setPrice", equalTo(expectedData.getPrice())).
                body("setDefaultValMin", equalTo(expectedData.getDefaultValMin())).
                body("setDefaultValMax", equalTo(expectedData.getDefaultValMax()));
         */

        Assert.assertEquals(expectedData.getName(), actualData.getName());
        Assert.assertEquals(expectedData.getPrice(), actualData.getPrice());
        Assert.assertEquals(expectedData.getDescription(), actualData.getDescription());
        Assert.assertEquals(expectedData.getDefaultValMin(), actualData.getDefaultValMin());
        Assert.assertEquals(expectedData.getDefaultValMax(), actualData.getDefaultValMax());

        testItemId = actualData.getId();

    }

    //************************GET*******************************
    @Given("AdminNevcan sets the Get URL")
    public void adminnevcanSetsTheGetURL() {
        spec.pathParams("first", "c-test-items" +testItemId);


        //url2= "https://medunna.com/api/c-test-items/406501";
    }

    @Then("AdminNevcan sends the Get Request and gets the Response")
    public void adminnevcanSendsTheGetRequestAndGetsTheResponse() {

        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON)
                .spec(spec).contentType(ContentType.JSON).when().get("/{first}"+ testItemId);

        response.prettyPrint();

    }

    @And("AdminNevcan does Get Assertion")
    public void adminnevcanDoesGetAssertion() {

        response.
                then().
                statusCode(201).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");
    }


    //***********************PUT********************************

    @Given("AdminNevcan sets the Put URL")
    public void adminnevcanSetsThePutURL() {

        spec.pathParams("first", "c-test-items");

        //url = "https://medunna.com/api/c-test-items";
    }

    @And("AdminNevcan sets the Put expected data")
    public void adminnevcanSetsThePutExpectedData() {

        expectedData2 = new TestPojos2(testItemId, "Nevcan Collins Sen", "urea", 50.0, "10", "90");
        System.out.println("expectedData2 = " + expectedData2);
    }

    @Then("AdminNevcan sends the Put Request and gets the Response")
    public void adminnevcanSendsThePutRequestAndGetsTheResponse() {

        response = given()
                .headers("Authorization", "Bearer " + generateToken())
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(expectedData2)
                .when()
                .put("/{first}");

        response.prettyPrint();

    }

    @And("AdminNevcan does Put Assertion")
    public void adminnevcanDoesPutAssertion() {

        response.then().assertThat().statusCode(201);

        TestPojos actualData = response.as(TestPojos.class);
        assertEquals(expectedData2.getName(),actualData.getName());
        assertEquals(expectedData2.getPrice(),actualData.getPrice());
        assertEquals(expectedData2.getDescription(),actualData.getDescription());
        assertEquals(expectedData2.getDefaultValMin(),actualData.getDefaultValMin());
        assertEquals(expectedData2.getDefaultValMax(),actualData.getDefaultValMax());

    }


    //***********************DELETE********************************

    @Given("AdminNevcan sets the Delete URL")
    public void adminnevcanSetsTheDeleteURL() {

        spec.pathParams("first", "c-test-items" +testItemId);

        //url2= "https://medunna.com/api/c-test-items/406501";

    }


    @Then("AdminNevcan sends the Delete Request and gets the Response")
    public void adminnevcanSendsTheDeleteRequestAndGetsTheResponse() {


        response = given()
                .headers("Authorization", "Bearer " + generateToken())
                .spec(spec).contentType(ContentType.JSON)
                .when()
                .delete("/{first}"+ testItemId);

        response.prettyPrint();

    }

    @And("AdminNevcan does Delete Assertion")
    public void adminnevcanDoesDeleteAssertion() {
        assertEquals(204,response.getStatusCode());

    }

    //*****************************THE END****************************

}
