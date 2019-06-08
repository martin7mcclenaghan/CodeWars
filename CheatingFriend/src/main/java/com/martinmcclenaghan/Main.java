package com.martinmcclenaghan;

// See here for full challenge details: https://www.codewars.com/kata/5547cc7dcad755e480000004/train/java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // method returns a List of long []
        // added simple method to print results
        // when n = 26 the method should return all answers so {[15,21], [21,15]} in this case
        // In the event there are no answers an empty list is returned

        //The great thing about this challenge is that brute force won't work so I had to find an
        //algebraic solution. The first time I have had to do this in programming and certainly something
        // I will think of more often thanks to g964 who wrote this kata!

        List<long[]> result = remove(26);
        printList(result);


    }


    public static List<long[]> remove (long n){

        //When solved algebraically ab = (n*(n+1)/2) - (a+b). Where n is known you can rearrange to get an
        // expression for b in terms of a. This is then used in the for loop.
        // If n is 26 the above can be rearranged for b = (351-a)/(a+1)

        // The only values that fit our description will be whole numbers where both are
        // less than n - meaning they are inside the sequence.

        double nSum = (n * (n + 1)) / 2;

        ArrayList<long[]> results = new ArrayList<>();
        boolean flag = false;

        for (int a = 1; a <= n; a++) {

            double b = ((nSum - a) / (a + 1));

            if (b - Math.floor(b) == 0 && b < n) {

                results.add(new long[]{a, (long)b});
                flag = true;

            }
        }

        if(flag){

            return results;
        } else {

            return new ArrayList<>();
        }

    }

    public static void printList (List<long[]> list){

        for(int i = 0; i < list.size(); i++){

            System.out.println(Arrays.toString(list.get(i)));
        }
    }


}

