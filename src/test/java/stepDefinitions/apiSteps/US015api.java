package stepDefinitions.apiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.Page_05;
import pojos.patientPojo.Patient;
import stepDefinitions.uiSteps.US015;
import utilities.*;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class US015api {

    Page_05 page = new Page_05();

    public static String idApi;

    Patient expectedData;
    Patient actualData;
    String url;
    Response response;

    @Then("FA admin Api ve DB Test icin ID alir")
    public String faAdminApiVeDBTestIcinIDAlir() {

        ReusableMethods.waitFor(3);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(2);
        ReusableMethods.jsScrollClick(page.idTitle);
        ReusableMethods.waitFor(2);
        idApi = page.idListPatient.get(0).getText();

        System.out.println("idApi = " + idApi);

        return idApi;
    }

    @Given("FA URL {string} {string}")
    public void faURL(String pathParams, String id) {

        // https://medunna.com/api/patients/id
        id = idApi;
        url = ConfigReader.getProperty("baseUrl") + pathParams + id;
        System.out.println("url = " + url);


        expectedData = new Patient(Integer.parseInt(id), US015.firstname, US015.lastname);
        System.out.println("expectedData = " + expectedData);
    }

    @When("FA admin send GET Request")
    public void faAdminSendGETRequest() {

        response = given().
                contentType(ContentType.JSON).
                headers("Authorization", "Bearer " + generateToken()).when().get(url);
        response.prettyPrint();
    }

    @Then("FA admin Status code is {int}")
    public void faAdminStatusCodeIs(int statusCode) {

        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @And("FA admin assert id, firstName, lastName")
    public void faAdminAssertIdFirstNameLastName() {

        actualData = JsonUtil.convertJsonToJava(response.asString(), Patient.class);
        System.out.println("actualData = " + actualData);

        Assert.assertEquals(expectedData.getId(), actualData.getId());
        Assert.assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        Assert.assertEquals(expectedData.getLastName(), actualData.getLastName());
    }
}
