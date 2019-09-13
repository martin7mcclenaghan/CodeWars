package com.martinmcclenaghan;

import java.util.*;

public class IsStraightMain {
    // https://www.codewars.com/kata/pokerhand-straight-or-not/train/java - 7th kyu Pokerhand, straight or not?

    public static void main(String[] args) {

        ArrayList<Integer> cards = new ArrayList<>();
        cards.add(6);
        cards.add(5);
        cards.add(14);
        cards.add(7);
        cards.add(4);
        cards.add(8);
        cards.add(4);


        System.out.println(isStraight(cards));


    }

    public static boolean isStraight(List<Integer> cards) {

        //must have at least 5 unique cards
        Set<Integer> unique = new HashSet<>(cards);

        if (unique.size() < 5) {
            return false;
        }

        cards = new ArrayList<>(unique);

        // if ace present adapt for high or low
        // if high add low and vice versa
        if (cards.contains(14) && !cards.contains(1)) {
            cards.add(1);
        } else if (cards.contains(1) && !cards.contains(14)) {
            cards.add(14);
        }

        Collections.sort(cards);
        System.out.println(cards);

        if (cards.size() == 5) {

            return isSequence(cards);

        } else if (cards.size() == 6) {

            return (isSequence(cards.subList(0, 5)) || isSequence(cards.subList(1, 6)));

        } else if (cards.size() == 7) {
            return (isSequence(cards.subList(0, 5)) || isSequence(cards.subList(1, 6)) || isSequence(cards.subList(2, 7)));

        } else {
            return (isSequence(cards.subList(0, 5)) || isSequence(cards.subList(1, 6)) || isSequence(cards.subList(2, 7))
                    || isSequence(cards.subList(3, 8)));
        }
    }

    public static boolean isSequence(List<Integer> cards) {

        List<Integer> subCards = new ArrayList<>(cards);

        for (int i = 0; i < subCards.size() - 1; i++) {

            if (subCards.get(i) + 1 != subCards.get(i + 1)) {

                return false;

            }

        }

        return true;

    }

}

