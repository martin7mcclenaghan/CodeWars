package com.martinmcclenaghan;

import java.util.Arrays;

public class IsHandFlushMain {

// https://www.codewars.com/kata/determine-if-the-poker-hand-is-flush/train/java - Is the poker hand a flush?

    public static void main(String[] args) {

        String [] strings = new String[]{"AD", "4S", "10H", "KC", "5S"};
        System.out.println(checkIfFlush(strings));

        strings = new String[]{"AS", "3S", "9S", "KS", "4S"};
        System.out.println(checkIfFlush(strings));
    }

    public static boolean checkIfFlush (String[] cards){

        String string = Arrays.toString(cards);

        String noFace = string.replaceAll("J", "11").replaceAll("Q", "12")
                .replaceAll("K", "13").replaceAll("A", "14");

        char[] suits = noFace.replaceAll("[^A-Z]","" ).toCharArray();

        boolean flag = true;

        for(int i = 0; i < suits.length -1; i++){

            if(suits[i] != suits[i+1]){
                flag = false;
            }
        }

        if(flag){
            return true;
        } else{
            return false;
        }

    }
}
