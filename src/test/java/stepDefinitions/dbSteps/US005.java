
package stepDefinitions.dbSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DatabaseUtility.*;

public class US005 {

    List<Object> actualData;

    @Given("md Database'e baglan")
    public void md_database_e_baglan() {
        createConnection();

    }

    @When("md Tablodan appointment bilgilerini getir")
    public void md_tablodan_appointment_bilgilerini_getir() {

        actualData = getColumnData("select * from appointment", "id");
        System.out.println("actualData = " + actualData);
    }

    @Then("md Sorgu sonuclarini dogrula")
    public void md_sorgu_sonuclarini_dogrula() {

        List<String> actualDataString = new ArrayList<>();
        for (Object w : actualData) {
            actualDataString.add(String.valueOf(w));
        }

        //System.out.println("actualDataString = " + actualDataString);

        assertTrue("APPOINTMRNT ID ESLESMEDI", actualDataString.contains("308698"));
        assertTrue("APPOINTMRNT ID ESLESMEDI", actualDataString.contains("309616"));

        closeConnection();

    }
}


