package com.nhnacademy;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;



public class Quiz01_02 {
    


    public static void main(String[] args) {
        Options options = new Options();
        boolean booleanFlag = false;
        String version = "1.0.0";
        String id = "nickname";

        // add t option
        options.addOption("f", "flag", false, "상태 출력");
        options.addOption("v", "version", false, "print the version");
        options.addOption("i", "id", true, "식별자");
        
        
        
        //builder pattern으로 선언한 형식
        Option idOption = Option.builder("i")
                          .hasArg()
                          .argName("id")
                          .desc("식별자입니다.").build();

        options.addOption(idOption);

        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine;

        try { 
            commandLine = parser.parse(options, args);
            
            if (commandLine.hasOption("v")){
                System.out.println("Version : " + version); 
                System.exit(0);   
            }
            else if(commandLine.hasOption("f")){
                booleanFlag = true;
                System.out.println("booleanFlag : " + booleanFlag);
            }
            else if(commandLine.hasOption("i")){
                
                System.out.println("id : " + id);
                
            }

        }catch(ParseException e)
        {
            System.err.println("에러 출력");
        }



    }
}
