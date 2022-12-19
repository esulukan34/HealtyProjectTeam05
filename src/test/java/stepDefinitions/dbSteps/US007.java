package stepDefinitions.dbSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DatabaseUtility;
import java.util.HashMap;
import java.util.Map;

public class US007 {
    Long id_donustur;
    Map<String,Object> expectedData,actaulData;


    @Given("K6 Kullanicisi Database baglanir")
    public void KullanicisiDatabaseBaglanir() {
        DatabaseUtility.createConnection();
    }



    @Then("K6 DB ile {string} id nolu randevuyu sorgular")
    public void DBIleIdNoluRandevuyuSorgular( String id) {
        id_donustur= Long.valueOf(id); // DB veri tabanından id Long olarak geri döndüğü için Casting yapıldı.
        String sorgu="select * from public.appointment where id='"+id+"'";

        actaulData= new HashMap<>(DatabaseUtility.getRowMap(sorgu));
    }



    @Then("K6 DB Bilgileri Dogrular")
    public void DBBilgileriDogrular() {
        expectedData= new HashMap<>();
        expectedData.put("created_by","zehrasen");
        expectedData.put("id",id_donustur); // sceniro outline den gelen id Map'a put edildi...

        Assert.assertEquals(expectedData.get("created_by"),actaulData.get("created_by"));
        Assert.assertEquals(expectedData.get("id"),actaulData.get("id"));


        // System.out.println("actaulData = " + actaulData);
        // System.out.println("expectedData = " + expectedData);
    }
}
