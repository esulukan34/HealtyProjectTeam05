package stepDefinitions.apiSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.*;
import pojos.apiPojos.*;
import utilities.JsonUtil;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.Authentication.generateToken;

public class US010 {
    Response response;
    @Given("K2 Kullanici  {int} numarali randevu bilgileri icin get request gonderir")
    public void k2KullaniciNumaraliRandevuBilgileriIcinGetRequestGonderir(int idd) {
        response=given().headers("Authorization","Bearer "+generateToken()).when().get("www.medunna.com/api/appointments/"+idd);
        response.prettyPrint();
    }

    @Then("K2 Kullanici status kodunun {int} oldugunu gorur")
    public void k2KullaniciStatusKodununOldugunuGorur( int code) {
        assertEquals(code,response.statusCode());
    }

    @And("K2 Kullanici randevu bilgilerini dogrular")
    public void k2KullaniciRandevuBilgileriniDogrular() {
        US010CountryPojo expCountry=new US010CountryPojo(238498,"Amerika");
        US010PhysicianUserPojo expPhysicianUser=new US010PhysicianUserPojo("anonymousUser","2022-11-16T14:42:34.120206Z",303346,"drkimble","Doctor","Kimble","drkimble@gmail.com",true,"en",null,null,"750-35-3535");
        US010PhysicianPojo expPhysician=new US010PhysicianPojo("batch81","2022-11-16T15:04:31.994592Z",303222,"Doctor","Kimble","2002-11-15T22:00:00Z","0542311022","MALE","Opositive","Newyork","",expPhysicianUser,"DERMATOLOGY",expCountry,null,100.00,null,null);
        US010PatientUserPojo expPatientUser = new US010PatientUserPojo("anonymousUser","2022-11-19T18:57:21.507884Z",312298,"user_112233445_56677889991668884241399","hasta","adam","hastaadam@gmail.com",false,null,null,null,"750-35-3542");
        US010PatientPojo expPatient=new US010PatientPojo("anonymousUser","2022-11-19T18:57:21.508292Z",313424,"hasta","adam",null,"0212212152",null,null,null,"hastaadam@gmail.com",null,expPatientUser,null,null,null);
        US010AnaPojo expAna=new US010AnaPojo("anonymousUser","2022-11-19T18:57:21.508553Z",313570,"2022-11-19T00:00:00Z","2022-11-19T01:00:00Z","PENDING",null,null,null,null,null,expPhysician,expPatient,null);

        US010AnaPojo actualData= JsonUtil.convertJsonToJava(response.asString(),US010AnaPojo.class);

        assertEquals(expAna.getCreatedBy(), actualData.getCreatedBy());
        assertEquals(expAna.getCreatedDate(), actualData.getCreatedDate());
        assertEquals(expAna.getId(), actualData.getId());
        assertEquals(expAna.getStartDate(), actualData.getStartDate());
        assertEquals(expAna.getEndDate(), actualData.getEndDate());
        assertEquals(expAna.getStatus(), actualData.getStatus());
        assertEquals(expAna.getAnamnesis(), actualData.getAnamnesis());
        assertEquals(expAna.getTreatment(), actualData.getTreatment());
        assertEquals(expAna.getDiagnosis(), actualData.getDiagnosis());
        assertEquals(expAna.getPrescription(), actualData.getPrescription());
        assertEquals(expAna.getDescription(), actualData.getDescription());
        assertEquals(expAna.getPhysician(), actualData.getPhysician());
        assertEquals(expAna.getPatient(), actualData.getPatient());
        assertEquals(expAna.getCtests(), actualData.getCtests());





    }
}
