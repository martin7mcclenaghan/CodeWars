package com.martinmcclenaghan;

//https://www.codewars.com/kata/5547cc7dcad755e480000004/train/java

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // take number
        //product should be equal to 1 - n omitting 2 numbers a and b
        // return the possible a and b given n for which the above is true

        //below is k permutations

        int n = 26;
        int nSum = 0;

        //sum 1 - n
        for (int i = 1; i <= n; i++) {

            nSum += i;
        }

        System.out.println("Sum of 1 - N equals " + nSum);

        int count = 0;

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();


        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {

                if (i != j) {

                    count++;

                    results.add(new ArrayList<Integer>(Arrays.asList(i, j, i + j, nSum - (i + j))));

                }
            }
        }

        System.out.println("Count equals " + count);
        ArrayList<ArrayList<Integer>> last = new ArrayList<>();



        for (ArrayList<Integer> list : results) {

            int aTimesb = list.get(0) * list.get(1);
            int sumMinusAB = nSum - (list.get(0) + list.get(1));

            if (aTimesb == sumMinusAB) {

                last.add(new ArrayList<Integer>(Arrays.asList(list.get(0), list.get(1))));

            }
        }

        System.out.println(last);


    }


}

