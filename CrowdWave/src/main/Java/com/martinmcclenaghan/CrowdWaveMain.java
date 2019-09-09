package com.martinmcclenaghan;

//Details of challenge can be found here: https://www.codewars.com/kata/mexican-wave/train/java

import java.util.ArrayList;
import java.util.Arrays;

public class CrowdWaveMain {

    public static void main(String[] args) {

        String start = "two words";
        System.out.println(Arrays.toString(wave(start)));

    }

    public static String[] wave(String str) {

        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {

            StringBuilder sb1 = new StringBuilder(str);
            //isolate character from String and convert to upper case
            char ch1 = str.toUpperCase().charAt(i);
            //set that character to upper case in the StringBuilder
            sb1.setCharAt(i, ch1);

            //if not an empty space add to the ArrayList of results
            if (ch1 != ' ') {
                //create String from StringBuilder
                String s2 = sb1.toString();
                strings.add(s2);
            }
        }

        //convert ArrayList to Array of Strings and return
        return strings.toArray(new String[0]);



    }

}