package stepDefinitions.dbSteps;

import io.cucumber.java.en.*;
import utilities.DatabaseUtility;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class US018 {
    List<Object> actualData;
    long expectedId;

    @Given("K10 Kullanici medunna Data Base'e baglanir")
    public void k10_kullanici_medunna_data_base_e_baglanir() {
        DatabaseUtility.createConnection();
    }
    @Given("K10 Tum Physian bilgilerini getirir {string} ve {string}")
    public void k10_tum_physian_bilgilerini_getirir (String query,String columnData){
       actualData = DatabaseUtility.getColumnData(query,columnData);
    }
    @Then("K10 Physician id {string} dogrular")
    public void k10_physician_id_dogrular(String id) {
        expectedId = Long.parseLong(id);
        assertTrue("Id eslesmedi.",actualData.contains(expectedId));
    }

}
