package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestXc01 {



    // @Test
    // public void givenText_whenSimpleRegexMatches_thenCorrect(){
    // Pattern pattern = Pattern.compile("foo");
    // MatchResult matcher = pattern.matcher("foo");
    // System.out.println(matcher.find());

    // }


    public static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }


    @Test
    public void whenStudyMethodsWork_thenCorrect() {
        Pattern pattern = Pattern.compile("dog");
        Matcher matcher = pattern.matcher("dogs are friendly");

        assertTrue(matcher.lookingAt());
        assertFalse(matcher.matches());
    }


    public static void main(String[] args) {
        System.out.println(runTest("[1-3][7-9]", "1238"));
        System.out.println(runTest("\\d", "8"));



    }
}
