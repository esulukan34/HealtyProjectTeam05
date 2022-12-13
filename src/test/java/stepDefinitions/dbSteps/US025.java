package stepDefinitions.dbSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigReader;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.createConnection;
import static utilities.DatabaseUtility.getColumnData;

public class US025 {

    List<Object> actualData;

    @Given("K4 connection kurar")
    public void k4_connection_kurar() {
        createConnection(ConfigReader.getProperty("database_url"),
                ConfigReader.getProperty("database_username"),
                ConfigReader.getProperty("database_password"));
    }
    @Then("K4 tum kayitli bilgileri ceker {string} ve {string}")
    public void k4_tum_kayitli_bilgileri_ceker_ve(String query, String columnName) {
        actualData = getColumnData(query,columnName);

    }
    @Then("K4 olusturulan {string} SSN numarali randevuyu dogrular")
    public void k4_olusturulan_ssn_numarali_randevuyu_dogrular(String SSN) {

        assertTrue(actualData.contains(SSN));

    }



}
