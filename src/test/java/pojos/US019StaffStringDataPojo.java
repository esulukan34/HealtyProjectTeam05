package pojos;

public class US019StaffStringDataPojo {
    public String expectedDataInString(String firstName,String lastName,Integer id,String gender,String phone){
        String data="{\n" +
                "    \"createdBy\": \"admin05\",\n" +
                "    \"createdDate\": \"2022-12-03T12:26:00.880524Z\",\n" +
                "    \"id\": "+id+",\n" +
                "    \"firstName\": \""+firstName+"\",\n" +
                "    \"lastName\": \""+lastName+"\",\n" +
                "    \"birthDate\": \"2000-03-03T00:03:00Z\",\n" +
                "    \"phone\": \""+phone+"\",\n" +
                "    \"gender\": \""+gender+"\",\n" +
                "    \"bloodGroup\": \"Apositive\",\n" +
                "    \"adress\": \"deneme\",\n" +
                "    \"description\": \"denememeeelll\",\n" +
                "    \"user\": {\n" +
                "        \"createdBy\": \"anonymousUser\",\n" +
                "        \"createdDate\": \"2022-11-20T20:17:51.042912Z\",\n" +
                "        \"id\": 317261,\n" +
                "        \"login\": \"ibrahimdoktor\",\n" +
                "        \"firstName\": \"ibrahim\",\n" +
                "        \"lastName\": \"doktor\",\n" +
                "        \"email\": \"hdsa@gmail.com\",\n" +
                "        \"activated\": true,\n" +
                "        \"langKey\": \"en\",\n" +
                "        \"imageUrl\": null,\n" +
                "        \"resetDate\": null,\n" +
                "        \"ssn\": \"585-96-9654\"\n" +
                "    },\n" +
                "    \"country\": {\n" +
                "        \"id\": 77132,\n" +
                "        \"name\": \"istanbul1\"\n" +
                "    },\n" +
                "    \"cstate\": null\n" +
                "}";
        return data;
    }
}
