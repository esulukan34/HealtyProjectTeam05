package stepDefinitions.dbSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.DatabaseUtility;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.*;

public class US017 {

    List<Object> actualData;

    @Given("AdminNevcan MedunnaDB ile connection kurar")
    public void adminnevcanMedunnaDBIleConnectionKurar() {
        createConnection(ConfigReader.getProperty("database_url"),
                ConfigReader.getProperty("database_username"),
                ConfigReader.getProperty("database_password"));
    }

    @And("AdminNevcan MedunnaDBden test item bilgilerini alir")
    public void adminnevcanMedunnaDBdenTestItemBilgileriniAlir() {

        String query = "select * from \"public\".c_test_item";
        actualData = getColumnData(query, "id");
        System.out.println(actualData);

    }

    @And("AdminNevcan DB ile test item olustugunu dogrular")
    public void adminnevcanDBIleTestItemOlustugunuDogrular() {
        Assert.assertTrue(actualData.contains(393796));
    }
}

