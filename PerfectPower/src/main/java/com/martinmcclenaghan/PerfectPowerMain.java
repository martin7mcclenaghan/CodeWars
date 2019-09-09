package com.martinmcclenaghan;

//https://www.codewars.com/kata/whats-a-perfect-power-anyway/java

import java.util.*;

public class PerfectPowerMain {

    public static void main(String[] args) {
       /* Method below utilises the following way of determining if n is a perfect power.
        For an integer n with factors m,m1,m2.... excluding 1 and n as factors
        If we raise all factors to the power of an integer k where 1 < k < log_2(n)
        If n is a perfect power then one of the results of the above will be equal to n

        More can be read on this method here https://en.wikipedia.org/wiki/Perfect_power

        Time complexity for this solutions can be described by O(a + bc) where;
        a is equal to the sqrt (n)
        b is equal to the number of factors of n excluding 1 and n
        c is equal to log_2(n)
        When n becomes large sqrt(n) is the dominant term so this solution has time complexity of O(sqrt(n))*/

        //Solution below will return the first pair of integers m and k for which m^k = n therefore meaning
        //n is a perfect power. If n is not a perfect power null is returned.

        System.out.println("List of first 20 perfect power numbers");

        int count = 1;
        int i = 0;

        while (count <= 20) {

            int[] answers = isPerfectPower(i);

            if (answers != null) {

                System.out.println(answers[0] + " to the power of " + answers[1] + " equals " + i);
                count++;
            }

            i++;

        }

    }

    //method to find all factors of a given number
    // 1 and n purposefully ignored as do not help with PP calculations
    public static List<Integer> allFactors(int n) {

        ArrayList<Integer> factors = new ArrayList<>();
        int count = 0;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                factors.add(i);
                count++;
                if ((n / i) > Math.sqrt(n)) {
                    factors.add(n / i);
                    count++;
                }
            }
        }

        Collections.sort(factors);
        return factors;
    }

    public static int[] isPerfectPower(int n) {

        if(n < 0){

            System.out.println("Please enter positive integer to test if perfect power");
            return null;
        }

        //will return first answer found or null
        //change return type to ArrayList to record all answers
        int[] answers = new int[2];
        double logLim = Math.log(n) / Math.log(2);
        boolean flag = false;

        for (int i : allFactors(n)) {

            for (int j = 2; j <= logLim; j++) {
                if (Math.pow(i, j) == n) {

                    answers[0] = i;
                    answers[1] = j;
                    flag = true;
                }
            }

        }

        if (flag) {
            return answers;
        } else {
            return null;
        }
    }
}


