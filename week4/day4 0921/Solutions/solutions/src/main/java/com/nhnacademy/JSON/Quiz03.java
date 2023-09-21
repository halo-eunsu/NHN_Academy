// 타 클래스로 오브젝트 생성


package com.nhnacademy.JSON;

import org.json.JSONException;
import org.json.JSONObject;

public class Quiz03 {
    
    public static void main(String[] args) {

                   
            try {
                
                

                //object.put("name", classObject);
                // 실행 결과 : {"code":12345,"city":"경남 김해","별명":"아카데미","name":{"name":"아카데미"}}
                //object.put("name",classObject);
                
                System.out.println(object);
                
            } catch (JSONException e) {
            System.err.println(e);
            } 
        
    }


}
