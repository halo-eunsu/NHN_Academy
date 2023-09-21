//무한루프됨

package com.nhnacademy.JSON;

import org.json.JSONException;
import org.json.JSONObject;

public class Exam04 {
    

        public static void main(String[] args) {
            
            try {
                JSONObject object = new JSONObject();

                object.put("name", "xtra");
                
                System.out.println(object);
                
            } catch (JSONException e) {
            System.err.println(e);
            }


            
        }

}
