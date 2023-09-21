// 타 클래스로 오브젝트 생성


package com.nhnacademy.JSON;

import org.json.JSONException;
import org.json.JSONObject;

public class Quiz02 {
    
    public static void main(String[] args) {

                   
            try {
                JSONObject object = new JSONObject();
                JSONObject object2 = new JSONObject();
                
                object.put("code", 12345);
                object.put("city", "경남 김해");
                object2.put("address",object);
                object2.put("name", "nhn");

                Person person = new Person("아카데미");
                object.put("별명", person.getName());

                
                System.out.println(object);
                
            } catch (JSONException e) {
            System.err.println(e);
            } 
        
    }


}
