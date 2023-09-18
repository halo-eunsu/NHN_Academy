package com.nhnacademy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    static String readFirstLineFromFilewithFinallyBlock(String path) throws IOException;
    
    public static void main(String[] args) {
        


        try  {
            FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr);
        } catch (Exception e) {
            return br.readLine();
        }
        finally { 
            br.close();
            fr.close();

        }
    }
}
