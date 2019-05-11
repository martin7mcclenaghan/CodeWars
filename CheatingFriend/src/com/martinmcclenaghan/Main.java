package com.martinmcclenaghan;

//https://www.codewars.com/kata/5547cc7dcad755e480000004/train/java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                    int aTimesb = i*j;
                    int sumMinusAB = nSum - (i+j);

                    if(aTimesb == sumMinusAB) {

                        results.add(new ArrayList<Integer>(Arrays.asList(i, j)));

                    }

                }
            }
        }

        System.out.println("Count equals " + count);

        System.out.println(results);

        printList(removeNB(26));


    }

    public static List<long[]> removeNB (long n){

        long nSum = 0; // sum of elements 1 -> n

        for (int i = 1; i <= n; i++) {

            nSum += i;
        }

        //store results in ArrayList of long[]
        //currently cycles through k-permutations for P(26,2) only saving results for which
        // a*b = sum to n - a - b.

        ArrayList<long[]> results = new ArrayList<>();
        boolean flag = false;


        for (long i = 1; i <= n; i++) {

            for (long j = 1; j <= n; j++) {

                if (i != j) {

                    long aTimesb = i*j;
                    long sumMinusAB = nSum - (i+j);

                    if(aTimesb == sumMinusAB) {

                        results.add(new long[]{i, j});
                        flag = true;

                    }

                }
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

