package stepDefinitions.dbSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pojos.DBMapPojo;
import utilities.DatabaseUtility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utilities.DatabaseUtility.closeConnection;
import static utilities.DatabaseUtility.createConnection;

public class US009 {
    List<Object> hastaListesi;
    @Given("Kullanici medunna database e baglanir")
    public void kullaniciMedunnaDatabaseEBaglanir() {
        createConnection();
    }
    @Then("Kullanici database'den bir hastanin tum bilgilerini alir ve kontrol eder")
    public void kullaniciDatabaseDenBirHastaninTumBilgileriniAlirVeKontrolEder() {
        String query ="select * from patient where id=310845";
        Map<String,Object> actualMap = new HashMap<String,Object>(DatabaseUtility.getRowMap(query));
        System.out.println("actualMap = " + actualMap);

        DBMapPojo obj = new DBMapPojo();
        Map<String,Object> expectedMap = obj.expectedMap("MALE",null,"2022-11-19 13:47:00.0","Ipsum", null, "2022-11-20 13:47:08.260049",null,"permuhammetdoganci","muhammetdoganci","123-456-7890",301122,"Apositive",310845,"2022-11-19 10:34:40.707249","Lorem",null,"loremipsum@gmail.com");
        System.out.println("expectedMap = " + expectedMap);

        Assert.assertEquals(expectedMap.get("gender"),actualMap.get("gender"));
        Assert.assertEquals(expectedMap.get("cstate_id"),actualMap.get("cstate_id"));
        //     Assert.assertEquals(expectedMap.get("birth_date"),actualMap.get("birth_date"));
        Assert.assertEquals(expectedMap.get("last_name"),actualMap.get("last_name"));
        Assert.assertEquals(expectedMap.get("description"),actualMap.get("description"));
        //     Assert.assertEquals(expectedMap.get("last_modified_date"),actualMap.get("last_modified_date"));
        Assert.assertEquals(expectedMap.get("last_modified_by"),actualMap.get("last_modified_by"));
        Assert.assertEquals(expectedMap.get("created_by"),actualMap.get("created_by"));
        Assert.assertEquals(expectedMap.get("phone"),actualMap.get("phone"));
        //     Assert.assertEquals(expectedMap.get("user_id"),actualMap.get("user_id"));
        Assert.assertEquals(expectedMap.get("blood_group"),actualMap.get("blood_group"));
        //    Assert.assertEquals(expectedMap.get("id"),actualMap.get("id"));
        //     Assert.assertEquals(expectedMap.get("created_date"),actualMap.get("created_date"));
        Assert.assertEquals(expectedMap.get("first_name"),actualMap.get("first_name"));
        Assert.assertEquals(expectedMap.get("country_id"),actualMap.get("country_id"));
        Assert.assertEquals(expectedMap.get("email"),actualMap.get("email"));

        closeConnection();
    }
}
