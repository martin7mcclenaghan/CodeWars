package com.martinmcclenaghan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighestScoringWordMain {

    //https://www.codewars.com/kata/highest-scoring-word/train/java - 6kyu

    public static void main(String[] args) {


        System.out.println(high("kgba vjrmdgu r jadw rrxnrl eb"));

    }

    public static String high(String s) {

        System.out.println(s);

        String[] wordArray = s.split(" ");
        List<Integer> scores = new ArrayList<>();

        for (String word : wordArray) {

            char[] letters = word.toCharArray();
            int sum = 0;

            for (char c : letters) {

                sum += ((int)c - 96);

            }

            scores.add(sum);
        }

        List<Integer> sortedScores = new ArrayList<>(scores);
        Collections.sort(sortedScores);
        int highScore = sortedScores.get(sortedScores.size()-1);
        int highWordPosition = scores.indexOf(highScore);

        return wordArray[highWordPosition];

    }

}
