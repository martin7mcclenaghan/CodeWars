package com.martinmcclenaghan;

//Details of challenge can be found here: https://www.codewars.com/kata/count-the-digit/java

public class CountTheDigitMain {

    public static void main(String[] args) {

        System.out.println(nbDig(12224, 8));


    }

    public static int nbDig(int n, int d) {

        //square all the numbers between 0 and n inclusive
        //convert to String and store in String []
        String[] strings = new String[n + 1];
        for (int i = 0; i <= n; i++) {

            strings[i] = Integer.toString((int) Math.pow(i, 2));
        }

        //use count and charAt on each String in the Array to determine number of times d occurs
        //introduce count and convert d to char so can search for it
        int count = 0;
        char ch = Integer.toString(d).charAt(0);

        //Cycle through each String element
        for (String str : strings) {

            //then for each string element count occurrences of d
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == ch) {
                    count++;
                }
            }
        }

        return count;

    }


}