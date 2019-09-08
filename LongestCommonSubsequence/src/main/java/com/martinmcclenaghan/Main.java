package com.martinmcclenaghan;

import java.util.Arrays;

public class Main {

/*
Solution below works for both challenges.
https://www.codewars.com/kata/longest-common-subsequence-performance-version/train/java
https://www.codewars.com/kata/longest-common-subsequence/java

LengthLCS method returns the length of the longest common subsequence and is not needed
to complete the challenges. It is included as it was part of the study that led me to the answer

Consideration of the article here https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
led to the adaption of the pseudocode into Java.
*/

    public static void main(String[] args) {

        System.out.println(lcs("GAC", "AGCAT"));
        System.out.println(lcs("XMJYAUZ", "MZJAWXU"));

//        System.out.println(lengthLCS("GAC", "AGCAT"));
//        System.out.println(lengthLCS("XMJYAUZ", "MZJAWXU"));


    }


    public static String lcs(String s1, String s2) {

        char[] X = new char[s1.length() + 1];
        char[] Y = new char[s2.length() + 1];

        //added terms below so the Arrays X,Y and store of results C
        // has C[X.length][Y.length] dimensions
        //if this is not done I found backtracking confusing to perform
        X[0] = 'o';
        Y[0] = 'o';

        for (int i = 1; i < X.length; i++) {

            X[i] = s1.charAt(i - 1);
        }

        for (int i = 1; i < Y.length; i++) {

            Y[i] = s2.charAt(i - 1);
        }

        //C will be the table of results holding the length of the longest common subsequences for all variations of
        // X and Y
        int[][] C = new int[X.length][Y.length];

        for (int i = 0; i < X.length; i++) {

            C[i][0] = 0;
        }

        for (int j = 0; j < Y.length; j++) {

            C[0][j] = 0;
        }

        for (int i = 1; i < X.length; i++) {

            for (int j = 1; j < Y.length; j++) {

                if (X[i] == Y[j]) {

                    C[i][j] = C[i - 1][j - 1] + 1;

                } else {

                    C[i][j] = Integer.max(C[i][j - 1], C[i - 1][j]);
                }
            }

        }
        return backTrack(C, X, Y, X.length - 1, Y.length - 1);

    }

    /* Using the formal definition of the Longest Common Subsequence derived in the article the backtrack function
    'walks' through the table of results and will read out the first available Longest Common Subsequence as there
     may be multiple.*/
    public static String backTrack(int[][] C, char[] X, char[] Y, int i, int j) {

        if ((i == 0) || (j == 0)) {

            return "";
        }

        if (X[i] == Y[j]) {

            //if the two elements are equal then that element must form part of the LCS so is appended to the String
            // that will be returned and we continue up and left on the table of results.
            return backTrack(C, X, Y, i - 1, j - 1) + X[i];

        }

        if (C[i][j - 1] > C[i - 1][j]) {

            return backTrack(C, X, Y, i, j - 1);
        }

        return backTrack(C, X, Y, i - 1, j);
    }

    public static int lengthLCS(String s1, String s2) {

        char[] X = new char[s1.length() + 1];
        char[] Y = new char[s2.length() + 1];
        X[0] = 'o';
        Y[0] = 'o';

        for (int i = 1; i < X.length; i++) {

            X[i] = s1.charAt(i - 1);
        }

        for (int i = 1; i < Y.length; i++) {

            Y[i] = s2.charAt(i - 1);
        }

        System.out.println(Arrays.toString(X));
        System.out.println(Arrays.toString(Y));

        int[][] C = new int[X.length][Y.length];

        for (int i = 0; i < X.length; i++) {

            C[i][0] = 0;
        }

        for (int j = 0; j < Y.length; j++) {

            C[0][j] = 0;
        }

        for (int i = 1; i < X.length; i++) {

            for (int j = 1; j < Y.length; j++) {

                if (X[i] == Y[j]) {

                    C[i][j] = C[i - 1][j - 1] + 1;

                } else {

                    C[i][j] = Integer.max(C[i][j - 1], C[i - 1][j]);
                }
            }

        }

        for (int[] array : C) {

            System.out.println(Arrays.toString(array));
        }


        System.out.println(backTrack(C, X, Y, X.length - 1, Y.length - 1));
        return C[X.length - 1][Y.length - 1];


    }
}

