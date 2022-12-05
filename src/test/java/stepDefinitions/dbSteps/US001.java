package stepDefinitions.dbSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.ConfigReader;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.createConnection;
import static utilities.DatabaseUtility.getColumnData;

public class US001 {

    List<Object> actualData;
    @Given("K44 connection kurar")
    public void k44_connection_kurar() {
       createConnection(ConfigReader.getProperty("database_url"),
               ConfigReader.getProperty("database_username"),
               ConfigReader.getProperty("database_password"));
    }
    @Then("K4 tum yeni kayitli bilgileri ceker {string} ve {string}")
    public void k4_tum_yeni_kayitli_bilgileri_ceker_ve(String query, String columnName) {
        actualData = getColumnData(query,columnName);
    }
    @Then("K4 kullanici bilgilerini dogrular")
    public void k4_kullanici_bilgilerini_dogrular() {

        assertTrue(actualData.contains("123-45-6038"));
        assertTrue(actualData.contains("123-45-6039"));
        assertTrue(actualData.contains("123-45-6040"));
        assertTrue(actualData.contains("123-45-6041"));

        System.out.println("actualData = " + actualData);
    }

}
