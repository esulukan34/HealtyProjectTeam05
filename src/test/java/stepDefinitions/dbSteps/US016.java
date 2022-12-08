package stepDefinitions.dbSteps;

import io.cucumber.java.en.*;
import utilities.ConfigReader;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.getColumnData;
import static utilities.DatabaseUtility.room;

public class US016 {

    List<Object> actualData;



    @When("K3 Admin oda icin {string} ile {string} sutunundan kayitli bilgileri ceker")
    public void k3AdminOdaIcinIleSutunundanKayitliBilgileriCeker(String query, String column) {
        actualData=getColumnData(ConfigReader.getProperty(query),column);
        //System.out.println("actualData = " + actualData);

    }

    @Then("K3 Admin oda icin {string} bilgilerini dogrular")
    public void k3AdminOdaIcinBilgileriniDogrular(String odaNo) {
        assertTrue("oda databasede bulunamadi",actualData.contains(Integer.parseInt(odaNo)));

    }
    @Then("K3 Admin E2E icin oda bilgilerini dogrular")
    public void k3AdminE2EOdaIcinBilgileriniDogrular() {
        assertTrue("oda databasede bulunamadi",actualData.contains(room.getRoomNumber()));
    }
}
