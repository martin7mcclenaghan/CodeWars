package com.martinmcclenaghan;

// https://www.codewars.com/kata/simple-fun-number-159-middle-permutation/train/java

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String s1 = "abcdefghi";

        for(int i = 2; i <= s1.length(); i++){

            System.out.println(findMidPerm(s1.substring(0,i)));
        }



    }


    public static String findMidPerm(String s1) {

        List<Character> start = new ArrayList<>();
        List<Character> result = new ArrayList<>();
        int length = s1.length();

        for(char c : s1.toCharArray()){

            start.add(c);
        }

        Collections.sort(start);

        if(length % 2 == 0){

            result.add(start.get((length/2)-1));
            result.add(start.get(length-1));


            for(int i = length-2; i >= 0; i--){

                if(!result.contains(start.get(i))) {

                    result.add(start.get(i));

                }
            }

        } else{

            result.add(start.get(length/2));
            result.add(start.get((length/2) -1 ));

            for(int i = length-1; i >= 0; i--){

                if(!result.contains(start.get(i))) {

                    result.add(start.get(i));

                }
            }



        }

        StringBuilder answer = new StringBuilder();

        for(char c : result){

            answer.append(c);
        }

        return answer.toString();

    }


}
