package stepDefinitions.dbSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DatabaseUtility;

import java.util.ArrayList;
import java.util.List;

public class US010 {

    @Given("K2 Kullanici  db ye baglanir")
    public void k2KullaniciDbYeBaglanir() {

        DatabaseUtility.createConnection();
    }

    @Then("K2 Kullanici select {string} from {string} sorgusu yapar")
    public void k2KullaniciSelectFromSorgusuYapar( String column, String table) {
        String expectedQuery = "Select " + column + " from " + table;
        DatabaseUtility.executeQuery(expectedQuery);
    }

    @And("K2 Kullanici randevulari dogrular")
    public void k2KullaniciRandevulariDogrular() {
        String query="select * from public.appointment where id= 313570";
        List<Object> actualData=DatabaseUtility.getRowList(query);
        System.out.println(actualData);
        List<Object> expData= new ArrayList<>();
        expData.add("313570");
        expData.add("2022-11-19 00:00:00.0");
        expData.add("2022-11-19 01:00:00.0");
        expData.add("PENDING");
        expData.add(null);
        expData.add(null);
        expData.add(null);
        expData.add(null);
        expData.add(null);
        expData.add("2022-11-19 18:57:21.508553");
        expData.add("303222");
        expData.add("313424");
        expData.add("anonymousUser");
        expData.add("staffkamil");
        expData.add("2022-11-19 18:59:15.484624");

        System.out.println("expData = " + expData);

        Assert.assertTrue(actualData.contains(expData));

    }
}
