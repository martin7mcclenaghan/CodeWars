package com.martinmcclenaghan;

public class PrimeFactorDecomposition {

    //returns true if parameter is a prime number
    private static boolean isPrime(int n) {

        for (int i = 2; i <= n / 2; i++) {

            if (n % i == 0) {

                return false;
            }
        }

        return true;
    }

    //method returns prime factor decomposition using the 'ladder method' as a thought framework
    static String ladder(int n) {

        if(n <= 1){

            return "N must be greater than 1";
        }

        if(isPrime(n)){

            return "(" + n + ")";
        }

        StringBuilder result = new StringBuilder();

        for (int factor = 2; factor <= n; factor++) {

            int count = 0;

            while ((n % factor == 0) && (isPrime(factor))) {

                n /= factor;
                count++;

            }

            if (count == 1) {

                result.append("(" + factor + ")");
            } else if(count > 1) {

                result.append("(" + factor + "**" + count + ")");
            }

        }

        return result.toString();


    }
}
