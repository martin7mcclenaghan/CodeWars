package com.martinmcclenaghan;
//https://www.codewars.com/kata/55f4e56315a375c1ed000159 Numbers that are a power sum of their digits

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Output first 20 numbers in the sequence

        for(int i = 1; i <=20; i++){
            System.out.println("Term " + i + " in sequence is " + powerSumDigTerm(i));
        }




    }

    public static long powerSumDigTerm(int n) {

        List<Long> results = new ArrayList<>();
        long number = 0;

        for (double i = 2; i <= 100; i++) {
            for (double j = 2; j <= 50; j++) {

                number = (long) Math.pow(i, j);
                if (digitSum(number) == i) {
                    results.add(number);
                }

            }
        }

        Collections.sort(results);

        if (n <= results.size()) {

            return results.get(n - 1);

        } else {

            return -1;
        }


    }

    public static long digitSum(long number) {

        long sum = 0;

        while (number > 0) {
            sum = sum + (number % 10);
            number /= 10;

        }

        return sum;


    }


}

