package stepDefinitions.dbSteps;

import io.cucumber.java.en.*;
import utilities.ConfigReader;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.getColumnData;
import static utilities.DatabaseUtility.registrant;

public class US002 {

    List<Object> actualData;


    @And("K3 Kullanici {string} ile {string} sutunundan kayitli bilgileri ceker")
    public void k3KullaniciIleSutunundanKayitliBilgileriCeker(String query, String column) {
        actualData=getColumnData(ConfigReader.getProperty(query),column);

    }

    @Then("K3 Kullanici {string} bilgilerini dogrular")
    public void k3KullaniciBilgileriniDogrular(String email) {
        //System.out.println("actualData = " + actualData);
        assertTrue("email databasede bulunamadi",actualData.contains(ConfigReader.getProperty(email)));

    }

    @Then("K3 Kullanici email bilgilerini E2E icin dogrular")
    public void k3KullaniciEmailBilgileriniE2EIcinDogrular() {
        // System.out.println("actualData = " + actualData);
        assertTrue("email databasede bulunamadi",actualData.contains(registrant.getEmail()));
    }
}
