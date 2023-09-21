package com.nhnacademy.JSON;

import org.json.JSONException;
import org.json.JSONObject;

public class Quiz01 {
    
    public static void main(String[] args) {

                   
            try {
                JSONObject object = new JSONObject();
                JSONObject object2 = new JSONObject();
                
                object.put("code", 12345);
                object.put("city", "경남 김해");
                object2.put("address",object);
                object2.put("name", "nhn");

                
                System.out.println(object);
                
            } catch (JSONException e) {
            System.err.println(e);
            } 
        
    }


}
