package com.martinmcclenaghan;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        double[] start = {0, 1, 1};

        double[] end = tribonacci(start, 2);

        System.out.println(Arrays.toString(end));


    }

    
    public static double[] tribonacci(double[] s, int n) {

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

}
