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

        printList(removeNB(26));


    }

    public static List<long[]> removeNB (long n){

        long nSum = 0; // sum of elements 1 -> n

        for (int i = 1; i <= n; i++) {

            nSum += i;
        }

        //store results in ArrayList of ArrayLists
        //currently stores a k-permutations for P(26,2)

        ArrayList<ArrayList<Long>> results = new ArrayList<>();


        for (long i = 1; i <= n; i++) {

            for (long j = 1; j <= n; j++) {

                if (i != j) {

                   results.add(new ArrayList<Long>(Arrays.asList(i, j, i + j, nSum - (i + j))));

                }
            }
        }

        //ArrayList to store results that matter - this needs to be an ArrayList of long []
        ArrayList<long[]> last = new ArrayList<>();
        boolean flag = false;

        for (ArrayList<Long> list : results) {

            long aTimesb = list.get(0) * list.get(1);
            long sumMinusAB = nSum - (list.get(0) + list.get(1));

            if (aTimesb == sumMinusAB) {

                last.add(new long[] {list.get(0), list.get(1)});
                flag = true;

            }


        }


        if(flag){

            return last;
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

