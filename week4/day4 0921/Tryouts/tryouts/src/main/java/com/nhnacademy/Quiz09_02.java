package com.nhnacademy;

import org.apache.commons.cli.Options;

public class Quiz09_02 {
    

    public static void main(String[] args) {
        

        Options options= new Options();

        String ac = "ac"; 

        options.addOption("ac", "acception", false, "상태");
        options.addOption("p", "path", false, "경로");
        options.addOption("t", ac, false, ac)

    }
}
