package stepDefinitions.dbSteps;

import io.cucumber.java.en.*;
import utilities.ConfigReader;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.country;
import static utilities.DatabaseUtility.getColumnData;

public class US028 {

    List<Object> actualData;
    @Given("K3 Admin country icin {string} ile {string} sutunundan kayitli bilgileri ceker")
    public void k3AdminCountryIcinIleSutunundanKayitliBilgileriCeker(String query, String column) {
        actualData=getColumnData(ConfigReader.getProperty(query),column);
    }

    @Then("K3 Admin country icin {string} bilgilerini dogrular")
    public void k3AdminCountryIcinBilgileriniDogrular(String countryName) {
        assertTrue("ulke databasede bulunamadi",actualData.contains(ConfigReader.getProperty(countryName)));
    }
    @Then("K3 Admin E2E country icin bilgileri dogrular")
    public void k3AdminE2ECountryIcinBilgileriDogrular() {
        assertTrue("ulke database de bulunamadi",actualData.contains(country.getName()));
    }
}
