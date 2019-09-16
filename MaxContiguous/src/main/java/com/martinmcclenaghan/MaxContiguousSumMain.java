package com.martinmcclenaghan;

//https://www.codewars.com/kata/maximum-contiguous-sum/train/java

import java.util.Arrays;

public class MaxContiguousSumMain {

    public static void main(String[] args) {

        int[] start = new int[]{-8, -10, -12, -2, -3, 5};

        System.out.println(maxContiguousSum(start));
        System.out.println(maxContiguousSumAddition(start));
    }

    //below is based more heavily on Kadane's alogrithm
    //https://en.wikipedia.org/wiki/Maximum_subarray_problem

    public static int maxContiguousSumAddition(int[] array) {

        for(int i = 1; i < array.length; i++){

            if(array[i-1] > 0){

                array[i] += array[i-1];
            }
        }

        Arrays.sort(array);
        return array[array.length-1];
    }

    //Based on a different implementation of Kadane's algorithm
    //https://medium.com/@rsinghal757/kadanes-algorithm-dynamic-programming-how-and-why-does-it-work-3fd8849ed73d

    public static int maxContiguousSum(int[] array){

        int localMax = 0;
        int tracker = Integer.MIN_VALUE;

        for(int i = 0; i < array.length; i++){

            localMax = Integer.max(array[i], array[i] + localMax);

            if(localMax > tracker){

                tracker = localMax;
            }
        }

        if(tracker > 0){
            return tracker;
        } else{
            return 0;
        }
    }
}
