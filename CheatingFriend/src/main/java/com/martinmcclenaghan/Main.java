package com.martinmcclenaghan;

// See here for full challenge details: https://www.codewars.com/kata/5547cc7dcad755e480000004/train/java

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
        // sum to n using Faaulhaber's Formula n(n+1) / 2
        int nSum = (n*(n+1))/2;



        System.out.println("Sum of 1 - N equals " + nSum);

        int count = 0;

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();


        for (int i = 1; i <= n; i++) {

            for (int j = i+1; j <= n; j++) {

                if (i != j) {

                    count++;
                    int aTimesb = i*j;
                    int sumMinusAB = nSum - (i+j);

                    if(aTimesb == sumMinusAB) {

                        results.add(new ArrayList<Integer>(Arrays.asList(i, j)));
                        results.add(new ArrayList<Integer>(Arrays.asList(j, i)));

                    }

                }
            }
        }

        System.out.println("Count equals " + count);

        System.out.println(results);

        printList(removeNB(26));

        printList(remove(26));


    }

    public static List<long[]> removeNB (long n){

        // sum to n using Faulhaber's Formula n(n+1) / 2

        long nSum = (n*(n+1))/2;

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

    //Solved algebraically ab = (n*(n+1)/2) - (a+b) to get expression for b in terms of a
    //where n is known
    //AND IT WORKS!!!

    public static List<long[]> remove (long n){

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


}

