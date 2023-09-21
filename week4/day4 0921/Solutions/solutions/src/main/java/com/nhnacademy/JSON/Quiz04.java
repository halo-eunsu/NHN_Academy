// 타 클래스로 오브젝트 생성


package com.nhnacademy.JSON;


import org.json.JSONException;
import org.json.JSONObject;

public class Quiz04 {
    
    public static void main(String[] args) {

        Person person = new Person("아카데미", new Address(12345, "김해"));

        JSONObject object = new JSONObject(person);
        object.put("age", 10);
        System.out.println(object);

        Object addressObject = object.get("address");
        System.out.println((JSONObject)addressObject);


    }


}
