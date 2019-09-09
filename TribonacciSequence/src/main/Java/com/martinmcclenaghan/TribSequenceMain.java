package com.martinmcclenaghan;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TribSequenceMain {

    //Details of this challenge can be found here: https://www.codewars.com/kata/tribonacci-sequence/java

    public static void main(String[] args) {

        double[] start = {1, 1, 1};

        double[] end = tribonacciSimple(start, 10);

        System.out.println(Arrays.toString(end));


    }


    public static double[] tribonacciStream(double[] s, int n) {

        if (n == 0) {
            return new double[0];
        }

        List<Double> trib = Arrays.stream(s).boxed().collect(Collectors.toList());

        for (int i = 3; i < n; i++) {

            trib.add(trib.get(i - 3) + trib.get(i - 2) + trib.get(i - 1));
        }

        Double[] wrapArray = trib.toArray(new Double[0]);
        double[] primArray = Arrays.stream(wrapArray).mapToDouble(Double::doubleValue).toArray();

        if (n == 1) {
            double[] small = new double[1];
            small[0] = primArray[0];
            return small;

        } else if (n == 2) {
            double[] small = new double[2];
            small[0] = primArray[0];
            small[1] = primArray[1];
            return small;

        } else {
            return primArray;
        }


    }

    public static double[] tribonacciSimple(double[] s, int n) {

        // need a new array of max size so do not have to resize
        double[] tribArray = Arrays.copyOf(s, n);

        //if n <= 3 just return array
        if (n <= 3) {
            return tribArray;
        } else {
            // add elements as necessary
            for (int i = 3; i < tribArray.length; i++) {

                tribArray[i] = tribArray[i - 1] + tribArray[i - 2] + tribArray[i - 3];
            }

            return tribArray;
        }


    }

}
