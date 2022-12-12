package stepDefinitions.apiSteps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Room;
import pojos.RoomPost;
import utilities.ConfigReader;
import utilities.JsonUtil;

import static base_url.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;
import static utilities.DatabaseUtility.room;

public class US016 {
    Response response;

    static RoomPost expectedData1;
    static Room expectedData2;
    Room roomactualData;
    static int roomId;


    @Given("K3 Admin oda icin {string}e gider")
    public void k3AdminOdaIcinEGider(String endpoint) {
        switch (endpoint) {
            case "rooms":
                spec.pathParams("1.", "api", "2.", "rooms");
                break;
            case "id":
                spec.pathParams("1.", "api", "2.", "rooms", "3.", roomId);
                break;
            case"E2E_id":

                spec.pathParams("1.", "api", "2.", "rooms", "3.", room.getId());
                System.out.println("room.getId() = " + room.getId());
                break;

        }
    }

    @When("K3 Admin oda icin {string} gonderir ve yaniti alir")
    public void k3AdminOdaIcinGonderirVeYanitiAlir(String request) {
        switch (request) {
            case "POST":
                expectedData1 = new RoomPost(ConfigReader.getProperty("K3Twin"), 100, 8210709, "TWIN", true);
                response = given().spec(spec)
                        .headers("Authorization", "Bearer " + generateToken())
                        .contentType(ContentType.JSON)
                        .body(expectedData1)
                        .when()
                        .post("/{1.}/{2.}");
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
                expectedData2 = new Room(ConfigReader.getProperty("K3Deluxe"), 150, 8210710, "DELUXE", true, roomId);
                System.out.println("expectedData2 = " + expectedData2);
                response = given().spec(spec)
                        .headers("Authorization", "Bearer " + generateToken())
                        .contentType(ContentType.JSON)
                        .body(expectedData2)
                        .when()
                        .put("/{1.}/{2.}");
                response.prettyPeek();
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

    @Then("K3 Admin oda icin Status {string} alir")
    public void k3AdminOdaIcinStatusAlir(String statusCode) {
        assertEquals(Integer.parseInt(statusCode),response.getStatusCode());
    }

    @And("K3 Admin oda icin yaniti {string} yapar")
    public void k3AdminOdaIcinYanitiYapar(String verify) {
        switch (verify) {
            case "Create":
            case "Read":
                roomactualData = JsonUtil.convertJsonToJava(response.asString(), Room.class);
                System.out.println("actualData = " + roomactualData);
                roomId = roomactualData.getId();
                assertEquals(expectedData1.getRoomNumber(), roomactualData.getRoomNumber());
                assertEquals(expectedData1.getRoomType(), roomactualData.getRoomType());
                assertEquals(expectedData1.getPrice(), roomactualData.getPrice());
                assertEquals(expectedData1.getDescription(), roomactualData.getDescription());
                break;
            case "Update":
                roomactualData = JsonUtil.convertJsonToJava(response.asString(), Room.class);
                System.out.println("actualData = " + roomactualData);
                assertEquals(expectedData2.getRoomNumber(), roomactualData.getRoomNumber());
                assertEquals(expectedData2.getRoomType(), roomactualData.getRoomType());
                assertEquals(expectedData2.getPrice(), roomactualData.getPrice());
                assertEquals(expectedData2.getDescription(), roomactualData.getDescription());
                assertEquals(expectedData2.getId(), roomactualData.getId());
                break;
            case "Delete":
                assertEquals(204, response.getStatusCode());
                break;
            case "E2E_Read":
                roomactualData=response.as(Room.class);
                System.out.println("actualData = " + roomactualData);
                assertEquals(room.getRoomNumber(), roomactualData.getRoomNumber());
                assertEquals(room.getRoomType(), roomactualData.getRoomType());
                assertEquals(room.getPrice(), roomactualData.getPrice());
                assertEquals(room.getDescription(), roomactualData.getDescription());
                assertEquals(room.getId(), roomactualData.getId());

        }

    }
}
