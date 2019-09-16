package com.martinmcclenaghan;

import java.util.*;

public class Dictionary {

    private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

    public String findMostSimilar(String input) {

        //Each edit distance will have its own array of words with that distance.
        //This deals with the situation where there may be more than one answer and multiple words with the same
        //edit distance. The question has been set so there is only ever one answer and the method must return a String
        //so method returns the only entry with the lowest edit distance.

        int[] resultArray = new int[words.length];

        Map<Integer, ArrayList<String>> distancePairs = new HashMap<>();

        for (int i = 0; i < words.length; i++) {

            int editDistance = editDistance(input, words[i]);
            resultArray[i] = editDistance;

            if (!distancePairs.containsKey(editDistance)) {

                distancePairs.put(editDistance, new ArrayList<>());
                distancePairs.get(editDistance).add(words[i]);

            } else {

                distancePairs.get(editDistance).add(words[i]);
            }

        }

        Arrays.sort(resultArray);
        return distancePairs.get(resultArray[0]).get(0);

    }

 /*   Below is my implementation of the Wagner-Fischer Algorithm which can be found below:
    https://en.wikipedia.org/wiki/Wagner%E2%80%93Fischer_algorithm
    It may also be useful to consider https://en.wikipedia.org/wiki/Levenshtein_distance
    */

    private int editDistance(String str1, String str2) {
        /*
        For all i and j, d[i,j] will hold the Levenshtein distance between
        the first i characters of str1 and the first j characters of str2.
        Note that d has (str1.length() + 1) x (str2.length() + 1) values as empty Strings are also accounted for.*/

        int[][] subProblems = new int[str1.length() + 1][str2.length() + 1];

        //Deals with comparison of either String to an empty String.
        for (int i = 0; i <= str1.length(); i++) {

            subProblems[i][0] = i;
        }

        for (int j = 0; j <= str2.length(); j++) {

            subProblems[0][j] = j;
        }

        for (int j = 1; j <= str2.length(); j++) {

            for (int i = 1; i <= str1.length(); i++) {

                //if last characters in Strings are equal then no operation required
                //subtract one as String.charAt() is zero indexed yet we have started i at 1.
                //This is to allow space for comparison to an empty String above.
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    subProblems[i][j] = subProblems[i - 1][j - 1];

                } else {

                    int[] findMinOf = new int[3];
                    findMinOf[0] = (subProblems[i - 1][j]) + 1; //delete operation
                    findMinOf[1] = (subProblems[i][j - 1]) + 1; //insertion operation
                    findMinOf[2] = (subProblems[i - 1][j - 1]) + 1; //substitution operation

                    Arrays.sort(findMinOf);
                    subProblems[i][j] = findMinOf[0];
                }
            }
        }
        return subProblems[str1.length()][str2.length()];
    }
}
