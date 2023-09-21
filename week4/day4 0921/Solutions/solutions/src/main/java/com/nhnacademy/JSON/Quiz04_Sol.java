// 타 클래스로 오브젝트 생성


package com.nhnacademy.JSON;


import org.json.JSONException;
import org.json.JSONObject;

public class Quiz04_Sol {
    
    public static void main(String[] args) {

        Person person = new Person("아카데미", new Address(12345, "김해"));

        JSONObject object = new JSONObject(person);
        object.put("age", 10);
        

        Object addressObject = object.get("address");
        ((JSONObject) addressObject).put("city","성남");

        System.out.println(object);


    }


}
