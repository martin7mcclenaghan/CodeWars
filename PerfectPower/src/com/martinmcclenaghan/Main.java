package com.martinmcclenaghan;

//https://www.codewars.com/kata/whats-a-perfect-power-anyway/java

import java.util.*;

public class Main {

    public static void main(String[] args) {




    }

    //method to find all factors of a given number
    // 1 and n purposefully ignored as do not help with PP calculations

    public static List<Integer> allFactors (int n){

        ArrayList<Integer> factors = new ArrayList<>();
        int count = 0;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);
                count++;
                if ((n / i) > Math.sqrt(n)) {
                    factors.add(n/i);
                    count++;
                }
            }
        }
        //System.out.println(n + " should have " + count + " factors");
        Collections.sort(factors);
        return factors;
    }

    public static int[] isPefectPower (int n){

        //will return first answer found or null
        //change return type to ArrayList to record all answers
        int[] answers = new int[2];
        double logLim = Math.log(n)/Math.log(2);
        boolean flag = false;

        for(int i : allFactors(n)){

            for(int j = 2; j <= logLim; j++){
                if(Math.pow(i,j) == n){

                    answers[0] = i;
                    answers[1] = j;
                    flag = true;
                    System.out.println(i + " to the power of " + j);
                }
            }

        }

        if(flag){
            return answers;
        } else{
            return null;
        }
    }
}
