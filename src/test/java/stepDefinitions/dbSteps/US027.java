package stepDefinitions.dbSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static utilities.DatabaseUtility.createConnection;
import static utilities.DatabaseUtility.getRowMap;

public class US027 {

    Map<String,Object> actualData;

    @Given("md Database'e baglan\"")
    public void md_database_e_baglan() {
    createConnection();
    }
    @When("md Tablodan ileti bilgilerini getir")
    public void md_tablodan_ileti_bilgilerini_getir() {

    actualData = getRowMap("select * from cmessage where id=364775");
    System.out.println("actualData = " + actualData);


    }
    @Then("md Sorgu \\(Query) sonuclarini dogrula")
    public void md_sorgu_query_sonuclarini_dogrula() {
        /*
        "id: 364775,
        name: testNG22,
        email: deneme2@deneme.com,
        subject: Hangi framework222,
        message: TestNG daha stabil calisiyor222"
         */

    Map<String,Object> expectedData = new HashMap<>();
    expectedData.put("id",(long)364775);
    expectedData.put("name","testNG22");
    expectedData.put("email","deneme2@deneme.com");
    expectedData.put("subject","Hangi framework222");
    expectedData.put("message","TestNG daha stabil calisiyor222");

    System.out.println("expectedData = " + expectedData);


    assertEquals(expectedData.get("id"),actualData.get("id"));
    assertEquals(expectedData.get("name"),actualData.get("name"));
    assertEquals(expectedData.get("email"),actualData.get("email"));
    assertEquals(expectedData.get("subject"),actualData.get("subject"));
    assertEquals(expectedData.get("message"),actualData.get("message"));

    }

}
