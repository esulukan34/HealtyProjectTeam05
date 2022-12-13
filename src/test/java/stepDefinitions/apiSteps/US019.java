package stepDefinitions.apiSteps;

import base_url.MedunnaBaseUrl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.US019StaffStringDataPojo;
import utilities.Authentication;
import utilities.DatabaseUtility;
import utilities.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static base_url.MedunnaBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.DatabaseUtility.createConnection;

public class US019 {
    Response response;
    Map<String,Object> databaseData;
    HashMap responseData;
    String ids;
    @Given("K8 Admin {string} numarali Staff Kullanicisinin bilgilerine GET Request gonderir")
    public void k8AdminNumaraliStaffKullanicisininBilgilerineGETRequestGonderir(String id){
        spec.pathParams("first","staff");
        response=given().spec(spec).headers("Authorization","Bearer "+ Authentication.generateToken()).when().get("/{first}/"+id);
        response.prettyPrint();

        responseData = JsonUtil.convertJsonToJava(response.asString(), HashMap.class);
        //responseData = new ObjectMapper().readValue(response.asString(), HashMap.class);
        ids=id;

    }
    @Then("K8 Ayni {string} numarali staff kullanicisi icin Database'e query gonderir")
    public void k8AyniNumaraliStaffKullanicisiIcinDatabaseEQueryGonderir(String id) {

        createConnection();
        String query= "select * from staff where id="+id;
        databaseData = new HashMap<String,Object>(DatabaseUtility.getRowMap(query));
        //   System.out.println("database  "+expectedData);
    }

    @Then("K8 Status Code'nin {int} oldugu dogrulanir")
    public void k8StatusCodeNinOlduguDogrulanir(int statusCode) {
        assertEquals(statusCode,response.statusCode());
    }
    @And("K8 Response'den donen bilgilerin dogrulugu kontrol edilir")
    public void k8ResponseDenDonenBilgilerinDogruluguKontrolEdilir() {
        US019StaffStringDataPojo obj=new US019StaffStringDataPojo();

        String data= obj.expectedDataInString("Jack","Sparow",366708,"MALE","777-777-8888");;
        Map expectedMap = JsonUtil.convertJsonToJava(data, HashMap.class);
        if (ids.equals("366748")){
            data= obj.expectedDataInString("Boyce","TestKuallanicisi",366748,"FEMALE","777-777-7777");
            expectedMap = JsonUtil.convertJsonToJava(data, HashMap.class);
        }
        assertEquals(expectedMap.get("firstName"),responseData.get("firstName"));
        assertEquals(expectedMap.get("lastName"),responseData.get("lastName"));
        assertEquals(expectedMap.get("id"),responseData.get("id"));
        assertEquals(expectedMap.get("gender"),responseData.get("gender"));
        assertEquals(expectedMap.get("phone"),responseData.get("phone"));
    }
    @And("K8 Response'den donen bilgiler ile databaseden gelen bilgilerin dogrulugu kontrol edilir")
    public void k8ResponseDenDonenBilgilerIleDatabasedenGelenBilgilerinDogruluguKontrolEdilir() {
        // System.out.println("databaseData = "+databaseData);
        // System.out.println("responseData = " + responseData);
        assertEquals(databaseData.get("first_name"), responseData.get("firstName"));
        assertEquals(databaseData.get("last_name"), responseData.get("lastName"));
        assertEquals(databaseData.get("id").toString(), responseData.get("id").toString());
        assertEquals(databaseData.get("gender"), responseData.get("gender"));
        assertEquals(databaseData.get("phone"), responseData.get("phone"));
    }
    @Given("K8 Admin {string} numarali Staff Kullanicisinin bilgilerine DELETE Request gonderir")
    public void k8_admin_numarali_staff_kullanicisinin_bilgilerine_delete_request_gonderir(String id) {
        spec.pathParams("first","staff");
        response=given().spec(spec).headers("Authorization","Bearer "+ Authentication.generateToken()).when().delete("/{first}/"+id);
       // response.prettyPrint();
    }
}
