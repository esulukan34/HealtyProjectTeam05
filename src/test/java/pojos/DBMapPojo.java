package pojos;

import java.util.HashMap;
import java.util.Map;

public class DBMapPojo {
    public Map<String,Object> expectedMap (String gender,
                                           Object cstate_id,
                                           String birth_date,
                                           String last_name,
                                           Object description,
                                           String last_modified_date,
                                           Object adress,
                                           String last_modified_by,
                                           String created_by,
                                           String phone,
                                           Integer user_id,
                                           String blood_group,
                                           Integer id,
                                           String created_date,
                                           String first_name,
                                           Object country_id,
                                           String email){
        Map<String,Object> temp = new HashMap<>();

        temp.put("gender",gender);
        temp.put("cstate_id",cstate_id);
        temp.put("birth_date",birth_date);
        temp.put("last_name",last_name);
        temp.put("description",description);
        temp.put("last_modified_date",last_modified_date);
        temp.put("adress",adress);
        temp.put("last_modified_by",last_modified_by);
        temp.put("created_by",created_by);
        temp.put("phone",phone);
        temp.put("user_id",user_id);
        temp.put("blood_group",blood_group);
        temp.put("id",id);
        temp.put("created_date",created_date);
        temp.put("first_name",first_name);
        temp.put("country_id",country_id);
        temp.put("email",email);
        return temp;
    }
  /*  {gender=MALE,
            cstate_id=null,
            birth_date=2022-11-19 13:47:00.0,
            last_name=Ipsum,
            description=null,
            last_modified_date=2022-11-20 13:47:08.260049,
            adress=null,
            last_modified_by=permuhammetdoganci,
            created_by=muhammetdoganci,
            phone=123-456-7890,
            user_id=301122,
            blood_group=Apositive,
            id=310845,
            created_date=2022-11-19 10:34:40.707249,
            first_name=Lorem,
            country_id=null,
            email=loremipsum@gmail.com}

            */

}
