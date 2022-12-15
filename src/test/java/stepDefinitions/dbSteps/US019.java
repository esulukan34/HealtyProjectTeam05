package stepDefinitions.dbSteps;

import io.cucumber.java.en.*;
import pojos.DBMapPojo;
import utilities.DatabaseUtility;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static utilities.DatabaseUtility.closeConnection;
import static utilities.DatabaseUtility.createConnection;

public class US019 {
    Map actualData;
    @Given("K8 Medunna DataBase ile baglanti kurulur")
    public void k8_medunna_data_base_ile_baglanti_kurulur() {
        createConnection();

    }
    @Then("K8 {int} id numaralı staff kullanicisinin Databasedeki verilerine query gonderilir")
    public void k8_id_numaralı_staff_kullanicisinin_databasedeki_verilerine_query_gonderilir(int id) {
                String query="select * from staff where id='366708'";
        actualData = new HashMap(DatabaseUtility.getRowMap(query));
        System.out.println("actualData = " + actualData);
    }
    @Then("K8 Verilerin dogrulugu kontrol edilir")
    public void k8_verilerin_dogrulugu_kontrol_edilir() {
        DBMapPojo obj = new DBMapPojo();
        Map expectedData = obj.expectedMap("MALE",null,"2000-03-03 00:03:00.0","Sparow","denememeeelll","2022-12-03 13:58:32.081062","deneme","admin05","admin05","777-777-8888",317261,"Apositive",366708,"2022-12-03 12:26:00.880524","Jack","77132","deneme@deneme.com");
        assertEquals(expectedData.get("first_name"),actualData.get("first_name"));
        assertEquals(expectedData.get("last_name"),actualData.get("last_name"));
        assertEquals(expectedData.get("id").toString(),actualData.get("id").toString());
        assertEquals(expectedData.get("phone"),actualData.get("phone"));
        assertEquals(expectedData.get("gender"),actualData.get("gender"));
    }

    @And("K8 Database ile baglati kesilir")
    public void k8DatabaseIleBaglatiKesilir() {
        closeConnection();
    }
}
